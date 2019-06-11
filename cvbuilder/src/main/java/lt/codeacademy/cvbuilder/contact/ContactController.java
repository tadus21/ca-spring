package lt.codeacademy.cvbuilder.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/contacts")
public class ContactController {

    private final ContactService service;

    @Autowired
    public ContactController(ContactService service) {
        this.service = service;
    }

    @GetMapping
    public List<ContactView> getContacts() {
        return service.getContactViews();
    }

    @PostMapping(path = "/add")
    public void addContact(@RequestBody ContactView contactView) {
        service.addContact(contactView);
    }

    @PutMapping(path = "/update/{id}")
    public void updateContact(@PathVariable("id") int id, @RequestBody ContactView contactView) {
        service.updateContact(id, contactView);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteContact(@PathVariable("id") int id) {
        service.deleteContact(id);
    }
}
