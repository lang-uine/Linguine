package com.Linguine;

import com.Linguine.domain.member.Member;
import com.Linguine.repository.MemberRepository;
import com.Linguine.service.MemberService;
import com.Linguine.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class LinguineApplication {
	public static void main(String[] args) {
		SpringApplication.run(LinguineApplication.class, args);
	}


}
