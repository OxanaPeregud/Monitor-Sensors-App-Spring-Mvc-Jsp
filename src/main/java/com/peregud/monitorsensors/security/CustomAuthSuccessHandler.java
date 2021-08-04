package com.peregud.monitorsensors.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

import static com.peregud.monitorsensors.AppConstants.*;

@Component
public class CustomAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        Set<String> authorities = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (authorities.contains(ATTR_USER)) {
            getRedirectStrategy().sendRedirect(request, response, PAGE_SENSORS_LIST);
        } else if (authorities.contains(ATTR_ADMIN)) {
            getRedirectStrategy().sendRedirect(request, response, PAGE_SENSORS_LIST);
        }
    }
}
