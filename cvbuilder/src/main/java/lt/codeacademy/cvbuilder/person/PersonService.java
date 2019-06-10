package lt.codeacademy.cvbuilder.person;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private Person person = null;

    public Person getPerson() {
        if (person == null) {
            throw new NotFoundException("Person info not found");
        }
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void updatePerson(Person updatedPerson) {
        if (updatedPerson.getFirstName() != null) {
            person.setFirstName(updatedPerson.getFirstName());
        }
        if (updatedPerson.getSecondName() != null) {
            person.setSecondName(updatedPerson.getSecondName());
        }
        if (updatedPerson.getAboutMe() != null) {
            person.setAboutMe(updatedPerson.getAboutMe());
        }
    }
}
