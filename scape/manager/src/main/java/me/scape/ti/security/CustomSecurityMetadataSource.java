package me.scape.ti.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import me.scape.ti.dao.ResourceDAO;
import me.scape.ti.dao.RoleDAO;
import me.scape.ti.dataobject.ResourceDO;
import me.scape.ti.dataobject.RoleDO;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;

public class CustomSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    public CustomSecurityMetadataSource(ResourceDAO resourceDAO, RoleDAO roleDAO) {
        this.resourceDAO = resourceDAO;
        this.roleDAO = roleDAO;
        initResources();
    }

    private ResourceDAO resourceDAO;

    private RoleDAO roleDAO;

    private HashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap = new HashMap<RequestMatcher, Collection<ConfigAttribute>>();
    private Collection<ConfigAttribute> allAttribute = new HashSet<ConfigAttribute>();

    /**
     * 初始化所有的资源,这个会在容器运行的时候的构造方法里调用
     */
    private void initResources() {

        // 读取所有角色
        List<RoleDO> roles = roleDAO.getAllRoles();
        for (RoleDO role : roles) {
            SecurityConfig attrConfig = new SecurityConfig(role.getCode());
            allAttribute.add(attrConfig);
        }

        // 读取所有资源
        List<ResourceDO> resources = resourceDAO.getAllResources();
        for (ResourceDO resource : resources) {
            // 按照资源查询和资源相关的角色
            List<RoleDO> relatedRoles = roleDAO.getRolesByResourceId(resource.getId());

            // 把url资源转化为请求匹配器类
            String resourceUrl = resource.getUrl();
            RequestMatcher matcher = new AntPathRequestMatcher(resourceUrl);

            // 循环权限 定义一个权限的集合,和此资源对应起来,添加到HashMap里
            Collection<ConfigAttribute> array = new ArrayList<ConfigAttribute>(relatedRoles.size());
            for (RoleDO role : relatedRoles) {
                SecurityConfig securityConfig = new SecurityConfig(role.getCode());
                array.add(securityConfig);
            }

            requestMap.put(matcher, array);
        }
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        final HttpServletRequest request = ((FilterInvocation) object).getRequest();
        // 循环整个Map 看看有没有可以匹配的,如果有匹配的就立刻返回
        Collection<ConfigAttribute> attrHashMap = new HashSet<ConfigAttribute>();
        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
            if (entry.getKey().matches(request)) {
                attrHashMap.addAll(entry.getValue());
            }
        }

        if (attrHashMap.size() > 0) {
            Collection<ConfigAttribute> attr = new ArrayList<ConfigAttribute>(attrHashMap);
            return attr;
        }
        return Collections.emptyList();
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return this.allAttribute;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    public ResourceDAO getResourceDAO() {
        return resourceDAO;
    }

    public void setResourceDAO(ResourceDAO resourceDAO) {
        this.resourceDAO = resourceDAO;
    }

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

}
