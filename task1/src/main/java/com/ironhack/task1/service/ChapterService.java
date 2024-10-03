package com.ironhack.task1.service;

import com.ironhack.task1.model.Chapter;
import com.ironhack.task1.repository.ChapterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChapterService {

    private final ChapterRepository chapterRepository;

    public Chapter save(Chapter chapter) {
        log.info("Saving chapter: {}", chapter);
        return chapterRepository.save(chapter);
    }
}
