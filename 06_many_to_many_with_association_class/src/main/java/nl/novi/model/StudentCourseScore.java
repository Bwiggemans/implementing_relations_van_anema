package nl.novi.model;

import javax.persistence.*;

@Entity
@Table(name = "student_course_scores")
public class StudentCourseScore {

    // attributes

    @EmbeddedId
    private StudentCourseKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    private int score;

    // constructor(s)

    public StudentCourseScore() {
    }

    public StudentCourseScore(Student student, Course course, int score) {
        this.id = new StudentCourseKey(student.getId(), course.getId());
        this.student = student;
        this.course = course;
        this.score = score;
    }

    // getters and setters

    public StudentCourseKey getId() {
        return id;
    }

    public void setId(StudentCourseKey id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
