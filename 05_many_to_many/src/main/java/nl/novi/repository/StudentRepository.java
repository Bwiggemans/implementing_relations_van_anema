package nl.novi.repository;

import nl.novi.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository  extends CrudRepository<Student, Long> {
}
