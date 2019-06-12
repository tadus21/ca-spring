package lt.codeacademy.cvbuilder.employer;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployerView {

    private long id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private List<ActivityView> activities = new ArrayList<>();

    public EmployerView(long id, String name, LocalDate startDate, LocalDate endDate, List<ActivityView> activities) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.activities = activities;
    }

    public EmployerView() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<ActivityView> getActivities() {
        return activities;
    }

    public void setActivities(List<ActivityView> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "EmployerView{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployerView that = (EmployerView) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
