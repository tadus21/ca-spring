package lt.codeacademy.cvbuilder.contact;

import java.util.Objects;

public class ContactView {

    private int id;
    private String value;
    private ContactType type;
    private String url;

    public ContactView(int id, String value, ContactType type, String url) {
        this.id = id;
        this.value = value;
        this.type = type;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactView that = (ContactView) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ContactView{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", type=" + type +
                ", url='" + url + '\'' +
                '}';
    }
}
