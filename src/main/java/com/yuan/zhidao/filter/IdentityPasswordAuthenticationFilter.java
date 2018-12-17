package com.yuan.zhidao.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuan.zhidao.entity.Identity;
import org.apache.commons.io.IOUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IdentityPasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public IdentityPasswordAuthenticationFilter() {
        super(new AntPathRequestMatcher("/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if(request.getMethod().equals("POST")){
            Identity identity = null;
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                String reqStr = IOUtils.toString(request.getReader());
                identity = objectMapper.readValue(reqStr,Identity.class);

            } catch (IOException e) {
                e.printStackTrace();
            }
            String identityStr = identity.getIdentity();
            String password = identity.getPassword();

        }


        return null;
    }
}
