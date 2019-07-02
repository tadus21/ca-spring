package lt.codeacademy.cvbuilder.employer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ActivityRepositoryTest {
    @Autowired
    private ActivityRepository activityRepository;
    @Test
    public void testCreateActivity() {
        final Activity activity = new Activity("description", "developer", LocalDate.now().minusYears(1), LocalDate.now());
        activityRepository.save(activity);
        final List<Activity> activities = activityRepository.findAll();
        assertEquals(1, activities.size());
        assertEquals("description", activities.get(0).getDescription());
    }
}