package lt.codeacademy.cvbuilder.employer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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

    @PostMapping(path = "/new-employer")
    public void addEmployer(@RequestBody EmployerView employer) {
        repository.save(mapToEmployer(employer));
    }

    private Employer mapToEmployer(EmployerView employerView) {
        return new Employer(employerView.getName(),
                employerView.getStartDate(),
                employerView.getEndDate(),
                Collections.emptyList());
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
