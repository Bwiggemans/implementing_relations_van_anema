package nl.novi.model;

import javax.persistence.*;

@Entity
@Table(name = "students_courses")
public class StudentCourse {

    // attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Student student;
    private Course course;

    private int score;
}
