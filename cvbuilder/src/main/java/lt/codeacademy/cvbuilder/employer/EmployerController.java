package lt.codeacademy.cvbuilder.employer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/employer")
public class EmployerController {

    private final EmployerRepository repository;

    @Autowired
    public EmployerController(EmployerRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public List<Employer> getEmployers() {
        return repository.findAll();
    }
}
