package me.scape.ti.security.utils;

import me.scape.ti.security.model.UserDetailsImpl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class ContextUtil {

    public static SecurityContext getSecurityContext() {
        return SecurityContextHolder.getContext();
    }

    public static UserDetailsImpl getUserDetail() {
        Authentication authentication = getSecurityContext().getAuthentication();
        if (null != authentication) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetailsImpl) {
                return (UserDetailsImpl) principal;
            }
        }
        return null;
    }

    public static int getUserId() {
        UserDetailsImpl userDetails = getUserDetail();

        return null != userDetails ? userDetails.getManagerId() : 0;
    }
}
