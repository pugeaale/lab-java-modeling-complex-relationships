package com.ironhack.task1.dataloader;

import com.ironhack.task1.model.Member;
import com.ironhack.task1.model.MemberStatus;
import com.ironhack.task1.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final MemberService memberService;

    @Override
    public void run(String... args) throws Exception {
        Member member = new Member("salvatore",
                ZonedDateTime.now(),
                MemberStatus.ACTIVE);
        Member memberSaved = memberService.save(member);
        System.out.println(memberSaved);


    }
}
