package nl.novi.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    // attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    List<StudentCourseScore> scores = new ArrayList<>();

    // constructor

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    // getters and setters

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    // methodes

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                '}';
    }
}