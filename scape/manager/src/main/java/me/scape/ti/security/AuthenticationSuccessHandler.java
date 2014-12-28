package me.scape.ti.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.scape.ti.dao.ManagerDAO;
import me.scape.ti.dataobject.ManagerDO;
import me.scape.ti.security.utils.ContextUtil;
import me.scape.ti.utils.WebUtils;

import org.springframework.security.core.Authentication;

public final class AuthenticationSuccessHandler implements
        org.springframework.security.web.authentication.AuthenticationSuccessHandler {

    private ManagerDAO managerDAO;

    private String defaultTargetUrl;

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
            final Authentication authentication) throws IOException, ServletException {
        ManagerDO manager = managerDAO.findById(ContextUtil.getUserId());

        Date now = new Date();
        manager.setLast_ip(WebUtils.ipToLng0(WebUtils.getIpAddr(request)));
        manager.setLast_login(now);
        manager.setGmt_modified(now);

        response.sendRedirect(request.getContextPath() + defaultTargetUrl);
    }

    public ManagerDAO getManagerDAO() {
        return managerDAO;
    }

    public void setManagerDAO(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    public String getDefaultTargetUrl() {
        return defaultTargetUrl;
    }

    public void setDefaultTargetUrl(String defaultTargetUrl) {
        this.defaultTargetUrl = defaultTargetUrl;
    }

}
