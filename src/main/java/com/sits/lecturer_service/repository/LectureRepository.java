package com.sits.lecturer_service.repository;

import com.sits.lecturer_service.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LectureRepository extends JpaRepository<Lecturer, UUID> {
}
