package me.scape.ti.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;

public final class AuthenticationFailureHandler implements
        org.springframework.security.web.authentication.AuthenticationFailureHandler {

    private String defaultFailureUrl;

    @Override
    public void onAuthenticationFailure(final HttpServletRequest request, final HttpServletResponse response,
            final AuthenticationException exception) throws IOException, ServletException {
        String redirectPath = request.getContextPath() + defaultFailureUrl;

        request.getSession().setAttribute("SPRING_SECURITY_LAST_EXCEPTION", exception.getMessage());
        response.sendRedirect(redirectPath);
    }

    public String getDefaultFailureUrl() {
        return defaultFailureUrl;
    }

    public void setDefaultFailureUrl(final String defaultFailureUrl) {
        this.defaultFailureUrl = defaultFailureUrl;
    }

}
