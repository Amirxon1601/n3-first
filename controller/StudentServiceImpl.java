package uz.nt.firstspring.controller;
import uz.nt.firstspring.dto.ResponseDto;
import uz.nt.firstspring.dto.StudentDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;


import java.util.concurrent.CopyOnWriteArrayList;

@Service

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
        this.studentRepository = studentRepository;

    private List<StudentDto> students = new ArrayList<>();

    @Override
    public List<StudentDto> getStudentBy() {
        return students;
    }

    @Override
    public ResponseDto addStudent(StudentDto studentDto) {
        students.add(studentDto);

        return ResponseDto.builder().
                code(0).
                success(true).
                message("Successfully saved").build();
    }

    @Override
    public ResponseDto updateStudent(StudentDto studentDto) {
        for (StudentDto s : students) {
            if (s.getId().equals(studentDto.getId())) {
                if (studentDto.getName() != null) s.setName(studentDto.getName());
                if (studentDto.getAge() != null) s.setAge(studentDto.getAge());
                if (studentDto.getBirthDate() != null) s.setBirthDate(studentDto.getBirthDate());
                if (studentDto.getCourse() != null) s.setCourse(studentDto.getCourse());

                return ResponseDto.builder().code(0).success(true).message("Successfully updated").build();
            }
        }
        return ResponseDto.builder().code(-1).success(false).message("Not Found").build();
    }

    @Override
    public ResponseDto deleteStudent(Integer id) {
        CopyOnWriteArrayList<StudentDto> cs = new CopyOnWriteArrayList<>(students);

        for (StudentDto s : students) {
            if (s.getId().equals(id)) {
                students.remove(s);
                return ResponseDto.builder().code(0).success(true).message("Successfully deleted").build();
            }
        }
        return ResponseDto.builder().code(-1).success(false).message("Not Found").build();
    }
}