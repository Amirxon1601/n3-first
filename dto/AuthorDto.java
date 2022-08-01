package uz.nt.firstspring.dto;

import lombok.Data;

@Data
public class AuthorDto {
    private Integer id;
    private String first_name;
    private String last_name;
    private String birth_date;
}
