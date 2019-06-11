package lt.codeacademy.cvbuilder.contact;

import lt.codeacademy.cvbuilder.person.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    private final ContactRepository repository;

    @Autowired
    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    List<ContactView> getContactViews() {
        return repository.findAll()
                .stream()
                .map(this::mapToView)
                .collect(Collectors.toList());
    }

    void updateContact(int id, ContactView updatedContactView) {
        Contact contact = find(id);
        if (updatedContactView.getValue() != null) {
            contact.setValue(updatedContactView.getValue());
        }
        if (updatedContactView.getType() != null) {
            contact.setType(updatedContactView.getType());
        }
        repository.save(contact);
    }

    void addContact(ContactView contactView) {
        repository.save(mapFromView(contactView));
    }

    void deleteContact(int id) {
        repository.deleteById(id);
    }

    private Contact find(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ContactView not found"));
    }

    private ContactView mapToView(Contact contact) {
        return new ContactView(contact.getId(), contact.getValue(), contact.getType());
    }

    private Contact mapFromView(ContactView contactView) {
        return new Contact(contactView.getValue(), contactView.getType());
    }
}
