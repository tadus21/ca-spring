package lt.codeacademy.cvbuilder.contact;

import lt.codeacademy.cvbuilder.person.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    private final List<Contact> contacts = new ArrayList<>();

    List<Contact> getContacts() {
        return new ArrayList<>(contacts);
    }

    void updateContact(int id, Contact updatedContact) {
        Contact contact = find(id);
        if (updatedContact.getValue() != null) {
            contact.setValue(updatedContact.getValue());
        }
        if (updatedContact.getType() != null) {
            contact.setType(updatedContact.getType());
        }
    }

    private Contact find(int id) {
        return contacts.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Contact not found"));
    }

    void addContact(Contact contact) {
        contacts.add(contact);
    }

    void deleteContact(int id) {
        contacts.removeIf(c -> c.getId() == id);
    }
}
