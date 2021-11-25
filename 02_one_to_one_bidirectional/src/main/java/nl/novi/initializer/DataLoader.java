package nl.novi.initializer;

import nl.novi.OneToOneBiDirectional;
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

import java.util.Optional;

@Component
public class DataLoader implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(OneToOneBiDirectional.class);

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Person person = new Person("Peter Anema");
        Person storedPerson = personRepository.save(person);

        Address address = new Address("Lhee", "57", "Dwingeloo", "7991PH");
        address.setPerson(storedPerson);
        addressRepository.save(address);

        Optional<Person> optionalPerson = personRepository.findById(1L);
        Optional<Address> optionalAddress = addressRepository.findById(1L);

        if (optionalPerson.isPresent() && optionalAddress.isPresent()) {
            log.info(optionalPerson.get() + " has address " + optionalAddress.get());
            log.info(optionalAddress.get() + " belongs to " + optionalPerson.get());
        }
    }

}