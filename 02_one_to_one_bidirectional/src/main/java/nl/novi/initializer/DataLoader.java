package nl.novi.initializer;

import nl.novi.model.Address;
import nl.novi.model.Person;
import nl.novi.repository.AddressRepository;
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
    private AddressRepository addressRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Address address = new Address("Lhee", "57", "Dwingeloo", "7991PH");
        Person person = new Person("Peter Anema", address);
        personRepository.save(person);
    }

}