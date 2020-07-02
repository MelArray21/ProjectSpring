package PackageApplication.Classroom;


import PackageApplication.User.UserJava;
import Util.Crypto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@CrossOrigin(origins = "*", allowCredentials = "true")
@Controller
public class ClassroomController {
    @Autowired
    private ClassroomService classroomservice;
    @Autowired
    private ClassroomRepository classroomrepository;

    @GetMapping("/clasrooms")
    public ResponseEntity<List<ClassroomJAva>> getAllClassroom(){
            return ResponseEntity.ok(classroomservice.getAllClasroom());
      }


    @PostMapping(value = "/insertclass", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <ClassroomJAva> insertclass (@RequestBody ClassroomJAva classroom) {

        ClassroomJAva classinsert = classroomservice.insertClass(classroom);
        return ResponseEntity.ok(classinsert);
    }

    }
