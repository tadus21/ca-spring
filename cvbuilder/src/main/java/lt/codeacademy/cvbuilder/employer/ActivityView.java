package lt.codeacademy.cvbuilder.employer;

import java.time.LocalDate;
import java.util.Objects;

public class ActivityView {

    private long id;

    private String description;

    private String position;

    private LocalDate startDate;

    private LocalDate endDate;

    public ActivityView(long id, String description, String position, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.description = description;
        this.position = position;
        this.startDate = startDate;
        this.endDate = endDate;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    @Override
    public String toString() {
        return "ActivityView{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", position='" + position + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityView that = (ActivityView) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
