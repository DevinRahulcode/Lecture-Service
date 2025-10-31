package com.sits.lecturer_service.dto.response;


import lombok.Data;

@Data
public class LecturerResponseDTO {

    private String id;
    private String lecturer_id;
    private String name;
    private String faculty;
    private String email;

}
