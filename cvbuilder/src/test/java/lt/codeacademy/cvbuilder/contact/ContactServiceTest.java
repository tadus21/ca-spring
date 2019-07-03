package lt.codeacademy.cvbuilder.contact;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ContactService.class)
@EnableAutoConfiguration
@DataJpaTest
public class ContactServiceTest {

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ContactService service;

    @Test
    public void testContactService_updateExistingContact_willUpdateProvidedField() {
        Contact initialContact = new Contact("test-value",
                ContactType.FaEnvelope,
                "test-url");
        Contact savedContact = contactRepository.save(initialContact);
        ContactView updatedContact = new ContactView(0,
                "updated-value", null, null);

        service.updateContact(savedContact.getId(), updatedContact);

        Contact actualResult = contactRepository.getOne(savedContact.getId());

        assertEquals("updated-value", actualResult.getValue());
        assertEquals(ContactType.FaEnvelope, actualResult.getType());
        assertEquals("test-url", actualResult.getUrl());
    }

}