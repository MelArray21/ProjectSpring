package PackageApplication.User;

import Util.Crypto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.validation.constraints.Null;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", allowCredentials = "true")
@Controller
public class UserController {
@Autowired
private UserService userservice;
@Autowired
private UserRepository userrepository;


    @GetMapping("/users")
    public ResponseEntity< List<UserJava>  >GetAllUsers (){
        return ResponseEntity.ok(userservice.getAllUser());


    }


    @PostMapping(value = "/insertuser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <UserJava> insertUser (@RequestBody UserJava user) throws NoSuchAlgorithmException {
        user.setPsw(Crypto.toHexString(Crypto.getSHA(user.getPsw())));
        UserJava userok = userservice.insertUser(user);
        if (userok == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return ResponseEntity.ok(userok);

    }

    @PostMapping (value= "/loginuser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserJava> loginUser (@RequestBody UserJava user ) throws NoSuchAlgorithmException {
   UserJava userfind= userservice.login(user.getUsername(), Crypto.toHexString(Crypto.getSHA( user.getPsw())));
   if(userfind != null){
       return ResponseEntity.ok(userfind);
   }else{
       return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
   }
    }

    @PutMapping(value = "/updateuser/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserJava> updateResource(@RequestBody UserJava user,@PathVariable("id") int id) {
         UserJava userFRomDb=userservice.updateUser(user, id);
         return ResponseEntity.ok(userFRomDb);


    }


    @DeleteMapping(value = "/deleteuser/{id}")
    void deleteUser( @PathVariable ("id") int id) {
        userservice.deleteUser(id);
    }

}