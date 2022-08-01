package uz.nt.firstspring.controller;
import org. springframework.web.bind. annotation.*;
import uz.nt.firstspring.dto.ResponseDto;
import uz.nt.firstspring.dto.StudentDto;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/student")

public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping //("/{id}")
    public List<StudentDto> getStudentById() {
        return studentService.getStudentBy();
    }

    @PostMapping
    public ResponseDto addStudent(@RequestBody StudentDto studentDto) {
        return studentService.addStudent(studentDto);
    }

    @PatchMapping
    public ResponseDto updateStudent(@RequestBody StudentDto studentDto) {
        return studentService.updateStudent(studentDto);
    }

    @DeleteMapping //("/{id}")
    public ResponseDto deleteStudent(@RequestParam Integer id) {
        return studentService.deleteStudent(id);
    }
}