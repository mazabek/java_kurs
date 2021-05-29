package addressbook.model;

import java.io.File;
import java.util.Objects;

public class ContactGroup {
    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String lastname;
    private String address;
    private String telhome;
    private String telmobile;
    private String telwork;
    private String allPhones;
    private String allEmails;
    private String email;
    private String email2;
    private String email3;
    private String group;
    private String information;
    private File photo;

     public int getId() {
        return id;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactGroup withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public ContactGroup withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }
    public ContactGroup withAllInformation(String information) {
        this.information = information;
        return this;
    }
    public String getAllInformation() {
        return information;
    }

    public File getPhoto() {
        return photo;
    }

    public ContactGroup withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactGroup that = (ContactGroup) o;
        return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }

    public ContactGroup withId(int id) {
        this.id = id;
        return this;
    }

    public ContactGroup withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactGroup withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactGroup withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactGroup withTelhome(String telhome) {
        this.telhome = telhome;
        return this;
    }

    public ContactGroup withTelmobile(String telmobile) {
        this.telmobile = telmobile;
        return this;
    }

    public ContactGroup withTelwork(String telwork) {
        this.telwork = telwork;
        return this;
    }

    public ContactGroup withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactGroup withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactGroup withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactGroup withGroup(String group) {
        this.group = group;
        return this;
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

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
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
