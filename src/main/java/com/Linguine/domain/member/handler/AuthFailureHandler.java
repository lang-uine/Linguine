package com.Linguine.domain.member.handler;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String msg = "Invalid Email or Password";

        if (exception instanceof DisabledException) {
            msg = "This account has been suspended";
        } else if (exception instanceof CredentialsExpiredException) {
            msg = "CredentialExpiredException account";
        } else if (exception instanceof BadCredentialsException) {
            msg = "BadCredentialException account";
        }
        setDefaultFailureUrl("/login?error=true&exception=" + msg);
        super.onAuthenticationFailure(request, response, exception);
    }
}
