package com.sits.lecturer_service.controller;


import com.sits.lecturer_service.dto.request.LecturerRequestDTO;
import com.sits.lecturer_service.dto.response.LecturerResponseDTO;
import com.sits.lecturer_service.service.LectureService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/lecturer")
@Tag(name = "Lecturer")
public class LecturerController {

    private LectureService lectureService;

    public LecturerController(LectureService lectureService){
        this.lectureService = lectureService;
    }

    @GetMapping("/get-all")
    @Operation(summary = "Get All Lecturers", description = "This endpoint will return all the lecturers")
    public ResponseEntity<List<LecturerResponseDTO>> getAllLecturers(){
        List<LecturerResponseDTO> lecturers = lectureService.getAllLecturers();
        return ResponseEntity.ok().body(lecturers);
    }

    @GetMapping("/{id}/lecture")
    @Operation(summary = "get lecture by Id", description = "This will return lecturer by using the ID")
    public ResponseEntity<LecturerResponseDTO> getStudentByID(@PathVariable UUID id){
        LecturerResponseDTO lecturer = lectureService.getStudentByID(id);
        return ResponseEntity.ok(lecturer);
    }

    @PostMapping("/create-lecturer")
    @Operation(summary = "create lecturer", description = "This will create a new Lecturers")
    public ResponseEntity<LecturerResponseDTO> createLecture(@Validated({Default.class}) LecturerRequestDTO lecturerRequestDTO){
        LecturerResponseDTO newLecture = lectureService.createLecture(lecturerRequestDTO);
        return ResponseEntity.ok().body(newLecture);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<LecturerResponseDTO> updateLecture(@PathVariable UUID id, @Validated({Default.class}) LecturerRequestDTO lecturerRequestDTO){
        LecturerResponseDTO updateLecture = lectureService.updateLecture(id, lecturerRequestDTO);
        return ResponseEntity.ok().body(updateLecture);

    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteLecture(@PathVariable UUID id){
        lectureService.deleteLecture(id);
        return ResponseEntity.noContent().build();
    }

}
