package nl.novi.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    // attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    List<StudentCourseScore> scores = new ArrayList<>();

    // constructor

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentCourseScore> getScores() {
        return scores;
    }

    public void setScores(List<StudentCourseScore> scores) {
        this.scores = scores;
    }

    public void addScores(StudentCourseScore score) {
        this.scores.add(score);
    }

    public void removeScores(StudentCourseScore score) {
        this.scores.remove(score);
    }

// methods

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

}