package lt.codeacademy.cvbuilder.contact;

import java.util.Objects;

public class ContactView {

    private int id;
    private String value;
    private ContactType type;

    public ContactView(int id, String value, ContactType type) {
        this.id = id;
        this.value = value;
        this.type = type;
    }

    public ContactView() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ContactView{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactView contactView = (ContactView) o;
        return id == contactView.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
