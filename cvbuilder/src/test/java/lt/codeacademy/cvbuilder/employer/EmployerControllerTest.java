package lt.codeacademy.cvbuilder.employer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

import static java.util.Collections.*;
import static java.util.Collections.emptyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployerRepository employerRepository;

    @MockBean
    private ActivityRepository activityRepository;

    @Test
    public void testGetEmployers() throws Exception {
        employerRepository.save(new Employer("Code Academy", LocalDate.now(), null, emptyList()));
        this.mockMvc.perform(get("/api/employer")).andExpect(status().is2xxSuccessful())
                .andExpect(content().json("[{\"id\":1,\"name\":\"Code Academy\",\"startDate\":\"2019-07-02\",\"endDate\":null,\"activities\":[]}]"));
    }

    @Test
    public void testGetActivities() throws Exception {
        when(activityRepository.findAll()).thenReturn(singletonList(new Activity("Activity", "position", LocalDate.now().minusYears(1), null)));

        this.mockMvc.perform(get("/api/employer/activities")).andDo(print()).andExpect(status().is2xxSuccessful())
                .andExpect(content().json("[{\"id\":0,\"description\":\"Activity\",\"position\":\"position\",\"startDate\":\"2018-07-02\",\"endDate\":null}]"));
    }

}