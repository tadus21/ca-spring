package lt.codeacademy.cvbuilder.contact;

import lt.codeacademy.cvbuilder.employer.ActivityView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ContactRepository contactRepository;

    @Before
    public void beforeEach() {
        contactRepository.deleteAll();
    }

    @Test
    public void testContactController_getContacts() {
        contactRepository.save(new Contact("value", ContactType.FaEnvelope, "url"));

        final ResponseEntity<List<ActivityView>> result = restTemplate.exchange(createURLWithPort("/api/contacts"),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ActivityView>>() {
                });

        assertNotNull(result.getBody());
        assertEquals(1, result.getBody().size());
    }

    @Test
    public void testContactController_addContact() {
        final ResponseEntity<ContactView> result = restTemplate.postForEntity(
                createURLWithPort("/api/contacts/add"),
                new ContactView(0, "value", ContactType.FaEnvelope, "url"),
                ContactView.class);

        assertNotNull(result.getBody());
        assertEquals("value", result.getBody().getValue());
        assertEquals(1, contactRepository.findAll().size());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}