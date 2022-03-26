package com.casabonita.spring.dto;

import com.casabonita.spring.validations.MyOwnPhoneConstraint;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonPropertyOrder({"name", "phone", "email"})
@JsonIgnoreProperties(ignoreUnknown=true)
public class User implements Serializable {

    private String name;
    @MyOwnPhoneConstraint
    private String phone;
    @Nullable
    @Email
    private String email;

}
