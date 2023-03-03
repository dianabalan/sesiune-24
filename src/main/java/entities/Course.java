package entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String details;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_teacher", referencedColumnName = "id")
    private Teacher teacher;

    //this is the fix for the table courses_students does not exist problem
    //when we have a @manytomany relationship between two tables,
    //we need the mappedBy attribute in the @ManyToMany annotation
    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    private List<Student> students;

}
