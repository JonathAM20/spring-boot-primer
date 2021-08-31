package com.example.model;

import com.example.service.FirstValidationService;
import com.example.service.SecondValidationService;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_signup_form")
public class SignupForm {

	@Id
    @NotBlank(groups = FirstValidationService.class)
    @Email(groups = SecondValidationService.class)
    private String userId;

    @NotBlank(groups = FirstValidationService.class)
    @Length(min = 4, max = 100, groups = SecondValidationService.class)
    //@Pattern(regexp = "ˆ[a-zA-Z0-9]+$", groups = SecondValidationService.class)
    private String password;

    @NotBlank(groups = FirstValidationService.class)
    private String userName;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(groups = FirstValidationService.class)
    private Date birthday;

    @Min(value = 20, groups = SecondValidationService.class)
    @Max(value = 100, groups = SecondValidationService.class)
    private Integer age;

    @NotNull(groups = FirstValidationService.class)
    private Integer gender;
}