package romenska.olha.personservice.dto;

import java.util.List;

public record PersonDto(String firstName, String lastName, List<NoteDto> notes ) {
}
