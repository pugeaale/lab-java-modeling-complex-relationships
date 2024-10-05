package com.ironhack.task1.service;

import com.ironhack.task1.model.Chapter;
import com.ironhack.task1.model.Member;
import com.ironhack.task1.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Transactional
    public void deleteById(Long id) {
        log.info("Deleting member: {}", id);
        memberRepository.deleteById(id);
    }

    public Optional<Member> findById(Long id) {
        log.info("Finding member: {}", id);
        return memberRepository.findById(id);
    }
}
