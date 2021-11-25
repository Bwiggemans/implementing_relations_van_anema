package nl.novi.repository;

import nl.novi.model.StudentCourseKey;
import nl.novi.model.StudentCourseScore;
import org.springframework.data.repository.CrudRepository;

public interface StudentCourseScoreRepository extends CrudRepository<StudentCourseScore, StudentCourseKey> {
}
