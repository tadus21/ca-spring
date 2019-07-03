package lt.codeacademy.cvbuilder.employer;

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

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployerControllerRestTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private EmployerRepository employerRepository;

    @Test
    public void testEmployerController_addNewEmployer_shouldReturnAddedEmployer() {
        String requestUrl = "http://localhost:" + port + "/api/employer/new-employer";
        EmployerView newEmployer = new EmployerView(0, "test-employer",
                LocalDate.now().minusYears(3),
                null,
                Collections.emptyList());

        ResponseEntity<EmployerView> response =
                restTemplate.postForEntity(requestUrl, newEmployer, EmployerView.class);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("test-employer", response.getBody().getName());
        assertEquals(1, employerRepository.findAll().size());
    }



    @Test
    public void testEmployerController_getEmployers_shouldReturnAllEmployers() {
        String requestUrl = "http://localhost:" + port + "/api/employer";

        ParameterizedTypeReference<List<ActivityView>> typeReference =
                new ParameterizedTypeReference<List<ActivityView>>() {
        };

        ResponseEntity<List<ActivityView>> responseEntity =
                restTemplate.exchange(requestUrl,
                        HttpMethod.GET, null, typeReference);

        assertEquals(0, responseEntity.getBody().size());
    }

}