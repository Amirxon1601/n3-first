package uz.nt.firstspring.controller;


import uz.nt.firstspring.dto.ResponseDto;
import uz.nt.firstspring.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {
    List<StudentDto> getStudentBy();
    ResponseDto addStudent (StudentDto studentDto);
    ResponseDto updateStudent(StudentDto studentDto);
    ResponseDto deleteStudent(Integer id);
}