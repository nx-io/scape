package me.scape.ti.security.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import me.scape.ti.dao.ManagerDAO;
import me.scape.ti.dao.RoleDAO;
import me.scape.ti.dataobject.ManagerDO;
import me.scape.ti.dataobject.RoleDO;
import me.scape.ti.security.model.UserDetailsImpl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public final class UserDetailsServiceImpl implements UserDetailsService {

    private ManagerDAO managerDAO;

    private RoleDAO roleDAO;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        ManagerDO user = managerDAO.getByEmail(username);
        if (null == user || user.getStatus().equals(ManagerDO.INACTIVE)) {
            throw new UsernameNotFoundException("error_no_user");
        }

        Integer roleId = user.getRole_id();
        UserDetailsImpl details = new UserDetailsImpl(username, user.getPassword(), true, true, true, true,
                getAuthorities(roleId));
        details.setManagerId(user.getId());
        details.setName(user.getName());
        details.setEmail(user.getEmail());
        details.setSalt(user.getSalt());

        RoleDO role = roleDAO.get(roleId);
        details.setRoleId(roleId);
        details.setRoleName(role.getName());

        return details;
    }

    public Collection<GrantedAuthority> getAuthorities(final Integer userRoleId) {
        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();

        RoleDO role = roleDAO.get(userRoleId);
        result.add(new SimpleGrantedAuthority(role.getCode()));

        return result;
    }

    public ManagerDAO getManagerDAO() {
        return managerDAO;
    }

    public void setManagerDAO(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

}
