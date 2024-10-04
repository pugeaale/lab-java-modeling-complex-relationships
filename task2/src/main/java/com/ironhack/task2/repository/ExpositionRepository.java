package com.ironhack.task2.repository;

import com.ironhack.task2.model.Exposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpositionRepository extends JpaRepository<Exposition,Long> {
}
