package lt.codeacademy.cvbuilder.contact;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ContactControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ContactRepository contactRepository;

    @Before
    public void beforeEach() {
        contactRepository.deleteAll();
        contactRepository.save(new Contact("value", ContactType.FaGithubAlt, "url"));
    }

    @Test
    public void testContactController_addNewContact_shouldReturnAddedContact() throws Exception {
        mockMvc.perform(post("/api/contacts/add")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        .content("{\"value\":\"Linkedin\",\"type\":\"FaLinkedinIn\",\"url\":\"someurl\"}"))
                .andExpect(status().is2xxSuccessful());

       assertEquals(2, contactRepository.findAll().size());
    }

    @Test
    public void testContactController_getAllContacts_shouldReturnContactList() throws Exception {
        mockMvc.perform(get("/api/contacts")).andExpect(status().is2xxSuccessful())
                .andExpect(content()
                        .json("[{\"id\":1,\"value\":\"value\",\"type\":\"FaGithubAlt\",\"url\":\"url\"}]"));
    }

}