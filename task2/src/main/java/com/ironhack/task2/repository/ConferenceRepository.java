package com.ironhack.task2.repository;

import com.ironhack.task2.model.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceRepository extends JpaRepository<Conference,Long> {
}
