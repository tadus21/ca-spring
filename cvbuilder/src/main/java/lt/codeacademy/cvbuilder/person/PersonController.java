package lt.codeacademy.cvbuilder.person;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/info")
    public Person getPersonInfo() {
        return personService.getPerson();
    }

    @PostMapping(path = "/create-info")
    public void createPersonInfo(@RequestBody Person person) {
        this.personService.setPerson(person);
    }

    @PutMapping(path = "/update-info")
    public void updatePersonInfo(@RequestBody Person person) {
        this.personService.updatePerson(person);
    }
}
