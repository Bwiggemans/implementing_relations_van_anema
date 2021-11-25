package nl.novi.initializer;

import nl.novi.ManyToManyWithAssociationClassApplication;
import nl.novi.model.Course;
import nl.novi.model.Student;
import nl.novi.model.StudentCourseScore;
import nl.novi.repository.CourseRepository;
import nl.novi.repository.StudentCourseScoreRepository;
import nl.novi.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataLoader implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(ManyToManyWithAssociationClassApplication.class);

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentCourseScoreRepository studentCourseScoreRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Student student1 = new Student("Albert");
        Student student2 = new Student("Peter Anema");
        Student student3 = new Student("Tessa");

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);

        Course course1 = new Course("Java");
        Course course2 = new Course("Spring Boot");

        courseRepository.save(course1);
        courseRepository.save(course2);

        StudentCourseScore score = new StudentCourseScore(student1, course1, 8);

        student1.addScores(score);
        course1.addScores(score);

        studentCourseScoreRepository.save(score);

        Optional<Student> optionalStudent = studentRepository.findById(1L);
        Optional<Course> optionalCourse = courseRepository.findById(1L);

        if (optionalStudent.isPresent() && optionalCourse.isPresent()) {
            Student s = optionalStudent.get();
            log.info(s + " follows " + s.getScores().size() + " courses.");
            Course c = optionalCourse.get();
            log.info(c + " is attended by " + c.getScores() + " students.");
        }
    }

}