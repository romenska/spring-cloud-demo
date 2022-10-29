package romenska.olha.personservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import romenska.olha.personservice.domain.Person;

public interface PersonRepository extends JpaRepository<Person,Long> {

}
