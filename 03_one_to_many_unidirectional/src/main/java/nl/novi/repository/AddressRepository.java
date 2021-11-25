package nl.novi.repository;

import nl.novi.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository  extends CrudRepository<Car, Integer> {
}
