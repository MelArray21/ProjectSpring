package PackageApplication.Classroom;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Scuole")
public class ClassroomJAva {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(name="nome classe")
    private String nameclassroom;


    @Column(name="piano")
    private int flor;


    @Column(name="nome scuola")
    private String nameschool;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameclassroom() {
        return nameclassroom;
    }

    public void setNameclassroom(String nameclassroom) {
        this.nameclassroom = nameclassroom;
    }

    public int getFlor() {
        return flor;
    }

    public void setFlor(int flor) {
        this.flor = flor;
    }

    public String getNameschool() {
        return nameschool;
    }

    public void setNameschool(String nameschool) {
        this.nameschool = nameschool;
    }


    @Override
    public String toString() {
        return "ClassroomJAva{" +
                "id=" + id +
                ", nameclassroom='" + nameclassroom + '\'' +
                ", flor=" + flor +
                ", nameschool='" + nameschool + '\'' +
                '}';
    }
}
