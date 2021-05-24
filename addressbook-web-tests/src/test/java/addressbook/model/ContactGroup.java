package addressbook.model;

import java.util.Objects;

public class ContactGroup {
    private int id;
    private final String firstname;
    private final String lastname;
    private final String address;
    private final String telhome;
    private final String telmobile;
    private final String telwork;
    private final String email;
    private String group;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public ContactGroup(int id, String firstname, String lastname, String address, String telhome, String telmobile, String telwork, String email, String group) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.telhome = telhome;
        this.telmobile = telmobile;
        this.telwork = telwork;
        this.email = email;
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactGroup that = (ContactGroup) o;
        return Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }

    public ContactGroup(String firstname, String lastname, String address, String telhome, String telmobile, String telwork, String email, String group) {
        this.id = Integer.MAX_VALUE;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.telhome = telhome;
        this.telmobile = telmobile;
        this.telwork = telwork;
        this.email = email;
        this.group = group;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getTelhome() {
        return telhome;
    }

    public String getTelmobile() {
        return telmobile;
    }

    public String getTelwork() {
        return telwork;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }


    @Override
    public String toString() {
        return "ContactGroup{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
