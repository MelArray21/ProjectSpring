package PackageApplication.Classroom;

import PackageApplication.User.UserJava;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassroomRepository extends JpaRepository<ClassroomJAva, Integer> {

    List<ClassroomJAva> findAll();


}
