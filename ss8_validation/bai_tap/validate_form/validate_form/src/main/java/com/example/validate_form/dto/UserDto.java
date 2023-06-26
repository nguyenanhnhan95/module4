package com.example.validate_form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    @NotEmpty
    @Size(min = 5, max = 45, message = "Nhập không phù hợp")
    private String firstName;
    @NotEmpty
    @Size(min = 5, max = 45, message = "Nhập không phù hợp")
    private String lastName;
    @Pattern(regexp = "^[0][0-9]{9}$", message = "Nhập số điện hợp không họp lệ:")
    private String phoneNumber;
    @Min(value = 18,message = "Yêu cầu trên 18 tuổi ")
    private int age;

    @Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$", message = "Nhập địa chỉ email không phù hợp :")
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
