package nl.novi.initializer;

import nl.novi.model.Car;
import nl.novi.model.Person;
import nl.novi.repository.AddressRepository;
import nl.novi.repository.CarRepository;
import nl.novi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CarRepository carRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Car car = new Car("Renault", "Megane stationwagon III Bose diesel ", "2013");
        Person person = new Person("Peter Anema");
        person.addCar(car);
        personRepository.save(person);
    }

}