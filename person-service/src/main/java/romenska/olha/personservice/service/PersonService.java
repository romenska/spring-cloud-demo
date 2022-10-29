package romenska.olha.personservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import romenska.olha.personservice.client.NotesClient;
import romenska.olha.personservice.dto.PersonDto;
import romenska.olha.personservice.repository.PersonRepository;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final NotesClient notesClient;

    public PersonDto getWithNotesById(Long personId){

        var person = personRepository.findById(personId)
                .orElseThrow();

        var notes = notesClient.getNotesByPersonId(personId);

        return new PersonDto(person.getFirstName(), person.getLastName(),notes );

    }
}
