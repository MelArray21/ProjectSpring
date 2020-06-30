package PackageApplication.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<UserJava, Integer> {

    List<UserJava> findAll();//select di tutta la tabella

    UserJava findByUsernameAndPsw(String usn, String psw);//metodo select per username e password

    UserJava findById(int id);

}