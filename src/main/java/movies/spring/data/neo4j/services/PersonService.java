package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.domain.Person;
import movies.spring.data.neo4j.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person findByName(String name){
        return personRepository.findByName(name);
    }

    public Person  addNodes( Person p){
        return personRepository.addNodes(p);
    }

    public Person ysadd(Person p){
        return personRepository.save(p);
    }
}
