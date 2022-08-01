package uz.nt.firstspring.dto;
import lombok.Data;
@Data
public class StudentDto {
    private Integer id;
    private Integer age;
    private String name;
    private String birthDate;
    private String course;
}