package uz.nt.firstspring.repository;

import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Repository;
import uz.nt.firstspring.dto.StudentDto;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository {
    List<StudentDto> findAllByAge(Integer age);


}
