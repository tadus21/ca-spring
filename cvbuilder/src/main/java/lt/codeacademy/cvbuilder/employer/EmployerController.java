package lt.codeacademy.cvbuilder.employer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/employer")
public class EmployerController {

    private final EmployerRepository repository;

    @Autowired
    public EmployerController(EmployerRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public List<EmployerView> getEmployers() {
        return repository.findAll().stream()
                .map(this::mapFromEmployer)
                .collect(Collectors.toList());
    }

    private EmployerView mapFromEmployer(Employer employer) {
        List<ActivityView> activityViews = employer.getActivities().stream()
                .map(this::mapFromActivity)
                .collect(Collectors.toList());

        return new EmployerView(employer.getId(),
                employer.getName(),
                employer.getStartDate(),
                employer.getEndDate(),
                activityViews);
    }

    private ActivityView mapFromActivity(Activity activity) {
        return new ActivityView(activity.getId(),
                activity.getDescription(),
                activity.getPosition(),
                activity.getStartDate(),
                activity.getEndDate());
    }
}
