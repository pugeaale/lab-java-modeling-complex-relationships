package com.ironhack.task1.service;

import com.ironhack.task1.model.Member;
import com.ironhack.task1.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member save(Member member) {
        log.info("Saving member {}", member);
        return memberRepository.save(member);
    }
}
