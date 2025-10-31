package com.sits.lecturer_service.service.impl;


import com.sits.lecturer_service.dto.request.LecturerRequestDTO;
import com.sits.lecturer_service.dto.response.LecturerResponseDTO;
import com.sits.lecturer_service.entity.Lecturer;
import com.sits.lecturer_service.mapper.LecturerMapper;
import com.sits.lecturer_service.repository.LectureRepository;
import com.sits.lecturer_service.service.LectureService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LectureServiceImpl implements LectureService {


    private LectureRepository lectureRepository;

    public LectureServiceImpl(LectureRepository lectureRepository){
        this.lectureRepository = lectureRepository;
    }

    public List<LecturerResponseDTO> getAllLecturers(){
        List<Lecturer> lecturers = lectureRepository.findAll();
        List<LecturerResponseDTO> lecturerResponseDTOS = lecturers
                .stream().map(lecturer -> LecturerMapper.toDTO(lecturer)).toList();
        return lecturerResponseDTOS;
    }

    public LecturerResponseDTO getStudentByID(UUID id){
        Lecturer lecturer = lectureRepository.findById(id).orElseThrow(()-> new RuntimeException("A Lecture with this Id dose not exists" +id));
        return LecturerMapper.toDTO(lecturer);
    }

    public LecturerResponseDTO createLecture(LecturerRequestDTO lecturerRequestDTO){
        Lecturer newLecture = lectureRepository.save(LecturerMapper.toModel(lecturerRequestDTO));
        return LecturerMapper.toDTO(newLecture);
    }

    public LecturerResponseDTO updateLecture(UUID id, LecturerRequestDTO lecturerRequestDTO ){
        Lecturer lecturer = lectureRepository.findById(id).orElseThrow(()-> new RuntimeException("A Lecture with that ID Dose not exists" +id));

        lecturer.setLecture_id(lecturerRequestDTO.getLecturer_id());
        lecturer.setName(lecturerRequestDTO.getName());
        lecturer.setFaculty(lecturerRequestDTO.getFaculty());
        lecturer.setEmail(lecturerRequestDTO.getEmail());

        Lecturer updateLecture = lectureRepository.save(LecturerMapper.toModel(lecturerRequestDTO));
        return LecturerMapper.toDTO(updateLecture);
    }

    public void deleteLecture(UUID id){
        lectureRepository.deleteById(id);
    }
}
