package romenska.olha.noteservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import romenska.olha.noteservice.domain.Note;
import romenska.olha.noteservice.repository.NoteRepository;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteRepository noteRepository;

    @PostMapping
    public Note createNote(@RequestBody Note note){
        return noteRepository.save(note);
    }


    @GetMapping
    public List<Note> getNoteByPersonalId(@RequestParam Long personId){
        return  noteRepository.findAllByPersonId(personId);
    }
}
