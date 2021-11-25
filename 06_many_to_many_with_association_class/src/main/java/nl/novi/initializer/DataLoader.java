package nl.novi.initializer;

import nl.novi.ManyToManyBiDirectionalApplication;
import nl.novi.model.Course;
import nl.novi.model.Student;
import nl.novi.repository.CourseRepository;
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

    private static final Logger log = LoggerFactory.getLogger(ManyToManyBiDirectionalApplication.class);

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    private static void attendCourse(Student student, Course course) {
        student.addCourse(course);
        course.addStudents(student);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Student student1 = new Student("Albert");
        Student student2 = new Student("Peter Anema");
        Student student3 = new Student("Tessa");

        Course course1 = new Course("Java");
        Course course2 = new Course("Spring Boot");

        attendCourse(student1, course1);
        attendCourse(student2, course1);
        attendCourse(student2, course2);
        attendCourse(student3, course1);

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);

        courseRepository.save(course1);
        courseRepository.save(course2);

        Optional<Student> optionalStudent = studentRepository.findById(1L);
        Optional<Course> optionalCourse = courseRepository.findById(1L);

        if (optionalStudent.isPresent() && optionalCourse.isPresent()) {
            Student s = optionalStudent.get();
            log.info(s + " follows " + s.getCourses().size() + " courses.");
            Course c = optionalCourse.get();
            log.info(c + " is attended by " + c.getStudents() + " students.");
        }
    }

}