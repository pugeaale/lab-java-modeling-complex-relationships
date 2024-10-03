package com.ironhack.task1.dataloader;

import com.ironhack.task1.model.Chapter;
import com.ironhack.task1.model.Member;
import com.ironhack.task1.model.MemberStatus;
import com.ironhack.task1.service.ChapterService;
import com.ironhack.task1.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final MemberService memberService;

    private final ChapterService chapterService;

    @Override
    public void run(String... args) throws Exception {
        Chapter chapter = new Chapter("bronx","one");

        Member president = new Member("joseph",
                ZonedDateTime.now(),
                MemberStatus.ACTIVE);

        chapter.setPresident(president);
        chapterService.save(chapter);

        Member member = new Member("salvatore",
                ZonedDateTime.now(),
                MemberStatus.ACTIVE);
        memberService.save(member);
    }
}
