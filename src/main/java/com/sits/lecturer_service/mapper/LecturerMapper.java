package com.sits.lecturer_service.mapper;

import com.sits.lecturer_service.dto.request.LecturerRequestDTO;
import com.sits.lecturer_service.dto.response.LecturerResponseDTO;
import com.sits.lecturer_service.entity.Lecturer;

public class LecturerMapper {

    public static LecturerResponseDTO toDTO(Lecturer lecturer){
        LecturerResponseDTO lecturerResponseDTO = new LecturerResponseDTO();

        lecturerResponseDTO.setId(lecturer.getId().toString());
        lecturerResponseDTO.setLecturer_id(lecturer.getLecture_id());
        lecturerResponseDTO.setName(lecturer.getName());
        lecturerResponseDTO.setFaculty(lecturer.getFaculty());
        lecturerResponseDTO.setEmail(lecturer.getEmail());

        return lecturerResponseDTO;
    }

    public static Lecturer toModel(LecturerRequestDTO lecturerRequestDTO){
        Lecturer lecturer = new Lecturer();

        lecturer.setLecture_id(lecturerRequestDTO.getLecturer_id());
        lecturer.setName(lecturerRequestDTO.getName());
        lecturer.setFaculty(lecturerRequestDTO.getFaculty());
        lecturer.setEmail(lecturerRequestDTO.getEmail());

        return lecturer;
    }
}
