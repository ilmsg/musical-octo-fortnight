package com.ilmsg.auth01.config;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {

        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> {
                    log.info("getAuthority():" + grantedAuthority.getAuthority());
                    return grantedAuthority.getAuthority().equals("ROLE_ADMIN");
                });

        log.info("isAdmin:" + isAdmin);
        if (isAdmin) {
            setDefaultTargetUrl("/admin/home");
        } else {
            setDefaultTargetUrl("/user/home");
        }

        super.onAuthenticationSuccess(request, response, authentication);
    }

}
