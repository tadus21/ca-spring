package lt.codeacademy.cvbuilder.employer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/employer")
public class EmployerController {

    private final EmployerRepository employerRepository;
    private final ActivityRepository activityRepository;


    @Autowired
    public EmployerController(EmployerRepository employerRepository, ActivityRepository activityRepository) {
        this.employerRepository = employerRepository;
        this.activityRepository = activityRepository;
    }

    @GetMapping()
    public List<EmployerView> getEmployers() {
        return employerRepository.findAll().stream()
                .map(this::mapFromEmployer)
                .collect(Collectors.toList());
    }

    @PostMapping(path = "/new-employer")
    public void addEmployer(@RequestBody EmployerView employer) {
        employerRepository.save(mapToEmployer(employer));
    }

    @PostMapping("/new-activity/{employerId}")
    @Transactional
    public void addActivity(@PathVariable("employerId") long employerId,
                            @RequestBody ActivityView activityView) {

        Activity activity = mapToActivity(activityView);
        Employer employer = employerRepository.findById(employerId)
                .orElseThrow(() -> new IllegalArgumentException("Wrong employer id"));

        employer.addActivity(activity);
        employerRepository.save(employer);
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

    private Activity mapToActivity(ActivityView activityView) {
        return new Activity(activityView.getDescription(),
                activityView.getPosition(),
                activityView.getStartDate(),
                activityView.getEndDate());
    }

    private ActivityView mapFromActivity(Activity activity) {
        return new ActivityView(activity.getId(),
                activity.getDescription(),
                activity.getPosition(),
                activity.getStartDate(),
                activity.getEndDate());
    }
}
