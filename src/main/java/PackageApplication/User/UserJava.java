package PackageApplication.User;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="utenti")
public class UserJava {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO) //strategia che mi dice che chiave primaria ai
    private Integer id;

    @Column(name="nome")
    private String nome;

    @Column(name="cognome")
    private String cognome;

    @Column(name="username")
    private  String username;

    @Column(name="psw")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//mi permette solo la scrittura
    private String psw;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    @Override
    public String toString() {
        return "PackageApplication.User{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", username='" + username + '\'' +
                ", psw=" + psw +
                '}';
    }
}
