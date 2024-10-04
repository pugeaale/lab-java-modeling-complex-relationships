package com.ironhack.task1.dataloader;

import com.ironhack.task1.model.Chapter;
import com.ironhack.task1.model.Member;
import com.ironhack.task1.model.MemberStatus;
import com.ironhack.task1.service.ChapterService;
import com.ironhack.task1.service.MemberService;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
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
        Faker faker = new Faker();
        create7chaptersWithPresidents();
        Member member = new Member(
                faker.name().femaleFirstName(),
                ZonedDateTime.now(),
                MemberStatus.ACTIVE);
        memberService.save(member);

    }

    public void create7chaptersWithPresidents() {
        Faker faker = new Faker();
        for(int i = 0; i < 7; i++) {
            Chapter chapter = new Chapter(
                    faker.address().cityName(),
                    faker.funnyName().name());

            Member president = new Member(
                    faker.name().fullName(),
                    ZonedDateTime.now(),
                    MemberStatus.ACTIVE);

            chapter.setPresident(president);
            chapterService.save(chapter);
        }

    }
}
