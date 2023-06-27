package com.example.music_information.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.*;
public class SongDto implements Validator {
    private int id;
    @NotBlank(message = "Vui lòng không để trống :")
    @Size(max = 800)
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",message = "Không nhập ký tự đặc biệt :")
    @Column(columnDefinition = "longtext")
    private String nameMusic;
    @NotBlank(message = "Vui lòng không để trống ")
    @Size(max = 300,message = "Nhập dưới 300 ký tự")
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",message = "Không nhập ký tự đặc biệt :")
    @Column(columnDefinition = "longtext")
    private String singer;
    @NotBlank(message = "Vui lòng không để trống ")
    @Size(max = 300,message = "Nhập dưới 300 ký tự")
    @Pattern(regexp = "^[\\w ,]+$",message = "Không nhập ký tự đặc biệt , :")
    private String typeSing;

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTypeSing() {
        return typeSing;
    }

    public void setTypeSing(String typeSing) {
        this.typeSing = typeSing;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
