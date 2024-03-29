package com.Linguine.domain.member.handler;

import com.Linguine.domain.member.Member;
import com.Linguine.domain.member.MemberAdapter;
import com.Linguine.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Component
public class AuthSucessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final MemberRepository memberRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        MemberAdapter memberAdapter = (MemberAdapter) authentication.getPrincipal();

        if (memberAdapter.getMember().getLocked().isLocked()) {
            if (memberAdapter.getMember().getLocked().getPeriod().isAfter(LocalDateTime.now())) {
                throw new DisabledException("This account has been suspended until "+memberAdapter.getMember().getLocked().getPeriod().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            } else {
                memberAdapter.getMember().getLocked().setLocked(false);
            }
        }

        memberRepository.updateMemberLastLogin(authentication.getName(), LocalDateTime.now());
        setDefaultTargetUrl("/");
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
