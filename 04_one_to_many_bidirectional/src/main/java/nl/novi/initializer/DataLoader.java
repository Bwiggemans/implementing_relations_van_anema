package nl.novi.initializer;

import nl.novi.OneToManyBiDirectionalApplication;
import nl.novi.model.Car;
import nl.novi.model.Person;
import nl.novi.repository.CarRepository;
import nl.novi.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataLoader implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(OneToManyBiDirectionalApplication.class);

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CarRepository carRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Person person = new Person("Peter Anema");

        Car car1 = new Car("Renault", "Megane stationwagon III Bose diesel", "2013");
        car1.setOwner(person);
        person.addCar(car1);

        Car car2 = new Car("Opel", "Astra GTC", "2006");
        car2.setOwner(person);
        person.addCar(car2);

        personRepository.save(person);

        Optional<Person> optionalPerson = personRepository.findById(1L);
        Optional<Car> optionalCar = carRepository.findById(1L);

        if (optionalPerson.isPresent() && optionalCar.isPresent()) {
            Person p = optionalPerson.get();
            log.info(p + " has " + p.getCars().size() + " cars.");
            Car c = optionalCar.get();
            log.info(c + " is owned by " + c.getOwner());
        }
    }

}