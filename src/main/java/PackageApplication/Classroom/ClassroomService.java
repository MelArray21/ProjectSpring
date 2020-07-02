package PackageApplication.Classroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {

    @Autowired ClassroomRepository classroomRepository;


 public List<ClassroomJAva> getAllClasroom(){
    return classroomRepository.findAll();
 }



 public ClassroomJAva insertClass(ClassroomJAva classroom){
     return classroomRepository.save(classroom);
 }


}
