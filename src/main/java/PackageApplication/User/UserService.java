package PackageApplication.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userrepository;



    public List<UserJava> getAllUser() {
        return userrepository.findAll();
    }

    public UserJava insertUser(UserJava user) {
        return userrepository.save(user);
    }

    public UserJava login(String username, String password) {
        return userrepository.findByUsernameAndPsw(username, password);
    }

   public UserJava updateUser ( UserJava user ,int id){
       UserJava userFRomDb= userrepository.findById(id);
       if(userFRomDb==null){
            return null;
       }
       if(!userFRomDb.getNome().equals(user.getNome())){
           userFRomDb.setNome(user.getNome());
       }
       if(!userFRomDb.getCognome().equals(user.getCognome())){
           userFRomDb.setCognome(user.getCognome());
       }
       if(!userFRomDb.getUsername().equals(user.getUsername())){
           userFRomDb.setUsername(user.getUsername());
       }
       if(!userFRomDb.getPsw().equals(user.getPsw())){
           userFRomDb.setPsw(user.getPsw());
       }
      return userrepository.saveAndFlush(userFRomDb);
   }

    void deleteUser(Integer id){
         userrepository.deleteById(id);

    }



}
