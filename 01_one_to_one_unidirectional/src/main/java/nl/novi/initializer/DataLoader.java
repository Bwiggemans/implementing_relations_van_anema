package nl.novi.initializer;

import nl.novi.OneToOneUniDirectional;
import nl.novi.model.Address;
import nl.novi.model.Person;
import nl.novi.repository.AddressRepository;
import nl.novi.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(OneToOneUniDirectional.class);

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Address address = new Address("Lhee", "57", "Dwingeloo", "7991PH");
        Person person = new Person("Peter Anema", address);
        personRepository.save(person);
        log.info("Database seeded");
    }

}