package com.sits.lecturer_service.service;


import com.sits.lecturer_service.dto.request.LecturerRequestDTO;
import com.sits.lecturer_service.dto.response.LecturerResponseDTO;
import com.sits.lecturer_service.repository.LectureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface LectureService {

    List<LecturerResponseDTO> getAllLecturers();
    LecturerResponseDTO getStudentByID(UUID id);
    LecturerResponseDTO createLecture(LecturerRequestDTO lecturerRequestDTO);
    LecturerResponseDTO updateLecture(UUID id, LecturerRequestDTO lecturerRequestDTO );
    void deleteLecture(UUID id);
}
