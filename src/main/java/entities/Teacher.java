package entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "teachers")
public class Teacher {
    //non-owning side -> WILL NOT HAVE @JoinColumn

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String email;

//    @OneToOne(mappedBy = "teacher", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private TeacherDetails teacherDetails;


//    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
//    private List<Course> courses = new ArrayList<>();

}
