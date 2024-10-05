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
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final MemberService memberService;

    private final ChapterService chapterService;

    private Faker faker = new Faker();

    @Override
    public void run(String... args) throws Exception {
        testCreateChapterWithoutPresident();
        testFindChapterById();
        testDeleteChapterById();

        testCreateMemberWithoutChapter();
        testFindMemberById();
        testDeleteMemberById();

        testCreateMemberWithChapter();
        testCreateChapterWithPresident();
    }

    private void testDeleteMemberById() {
        memberService.deleteById(1L);
        Optional<Member> opt = memberService.findById(1L);
        System.out.println(opt.isEmpty());
    }

    private void testFindMemberById() {
        Optional<Member> opt = memberService.findById(1L);
        System.out.println(opt.isPresent());
    }

    private void testDeleteChapterById() {
        chapterService.deleteById(1L);
        Optional<Chapter> opt = chapterService.findById(1L);
        System.out.println(opt.isEmpty());
    }

    private void testFindChapterById() {
        Optional<Chapter> opt = chapterService.findById(1L);
        System.out.println(opt.isPresent());
    }

    public void testCreateChapterWithoutPresident() {
        Chapter chapter = new Chapter(
                faker.address().city(),
                faker.name().fullName());
        Chapter chapterSaved = chapterService.save(chapter);
        System.out.println(chapterSaved.getName().equals(chapter.getName()));
    }

    public void testCreateMemberWithoutChapter() {
        Member member = new Member(
                faker.name().fullName(),
                ZonedDateTime.now(),
                MemberStatus.ACTIVE);
        Member memberSaved = memberService.save(member);
        System.out.println(memberSaved.getName().equals(member.getName()));

    }

    public void testCreateMemberWithChapter() {
        Member member = new Member(
                faker.name().fullName(),
                ZonedDateTime.now(),
                MemberStatus.ACTIVE);
        Chapter chapter = new Chapter(
                faker.address().city(),
                faker.name().fullName());
        member.setChapter(chapter);
        Member memberSaved = memberService.save(member);
        System.out.println("testCreateMemberWithChapter : " +
                memberSaved.getName().equals(member.getName()) + " - " +
                memberSaved.getChapter().getName().equals(chapter.getName())
        );

    }

    public void testCreateChapterWithPresident() {
        Chapter chapter = new Chapter(
                faker.address().city(),
                faker.name().fullName());
        Member president = new Member(
                faker.name().fullName(),
                ZonedDateTime.now(),
                MemberStatus.ACTIVE);
        chapter.setPresident(president);
        Chapter chapterSaved = chapterService.save(chapter);
        System.out.println("testCreateChapterWithPresident : " +
                chapterSaved.getName().equals(chapter.getName()) + " - " +
                chapterSaved.getPresident().getName().equals(president.getName())
        );
    }

    public void create7chaptersWithPresidents() {

        for(int i = 0; i < 1; i++) {
            Chapter chapter = new Chapter(
                    faker.address().cityName(),
                    faker.funnyName().name());

            Member president = new Member(
                    faker.name().fullName(),
                    ZonedDateTime.now(),
                    MemberStatus.ACTIVE);

            chapter.setPresident(president);

            Member member = new Member(
                    faker.name().femaleFirstName(),
                    ZonedDateTime.now(),
                    MemberStatus.ACTIVE);
            chapter.addMember(member);

            chapterService.save(chapter);
        }

    }
}
