package romenska.olha.personservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import romenska.olha.personservice.domain.Person;
import romenska.olha.personservice.dto.PersonDto;
import romenska.olha.personservice.repository.PersonRepository;
import romenska.olha.personservice.service.PersonService;

import java.util.List;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor

public class PersonController {

    @Value("${eureka.instance.instance-id}")
    private String id;

    private final PersonService personService;
    private final PersonRepository personRepository;

    @PostMapping
    public Person createPerson(@RequestBody Person person){
        return personRepository.save(person);
    }

    @GetMapping
    public List<Person> getAll(){
        return personRepository.findAll();
    }

    @GetMapping("/{personId}")
    public PersonDto getPersonWithNotes(@PathVariable Long personId){
        return personService.getWithNotesById(personId);
    }

    @GetMapping("/test")
    public String getTest(){
     return id;
    }
}
