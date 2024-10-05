package com.ironhack.task1.service;

import com.ironhack.task1.model.Chapter;
import com.ironhack.task1.repository.ChapterRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChapterService {

    private final ChapterRepository chapterRepository;

    @Transactional
    public Chapter save(Chapter chapter) {
        log.info("Saving chapter: {}", chapter);
        return chapterRepository.save(chapter);
    }

    @Transactional
    public void deleteById(Long id) {
        log.info("Deleting chapter: {}", id);
        chapterRepository.deleteById(id);
    }

    public Optional<Chapter> findById(Long id) {
        log.info("Finding chapter: {}", id);
        return chapterRepository.findById(id);
    }
}
