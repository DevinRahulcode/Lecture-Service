package com.sits.lecturer_service.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LecturerRequestDTO {

    @NotNull
    @Size(max = 4, message = "The ID should not exceed 4 characters")
    private String lecturer_id;

    @NotNull
    @Size(max = 150, message = "The name should not exceed 150")
    private String name;

    @NotNull
    private String faculty;

    @NotNull
    @Email(message = "The email should be valid")
    private String email;

}
