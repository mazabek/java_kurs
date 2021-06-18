package addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.List;
import java.util.Objects;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")

public class ContactGroup {
    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;
    @Expose
    @Column(name = "firstname")
   // @Type(type= "text")
    private String firstname;
    @Expose
    @Column(name = "lastname")
    //@Type(type= "text")
    private String lastname;
    @Expose
    @Column(name = "address")
    @Type(type= "text")
    private String address;
    @Expose
    @Column(name = "home")
    @Type(type= "text")
    private String telhome;
    @Expose
    @Column(name = "mobile")
    @Type(type= "text")
    private String telmobile;
    @Expose
    @Column(name = "work")
    @Type(type= "text")
    private String telwork;
    @Expose
    @Column(name = "email")
    @Type(type= "text")
    private String email;
    @Expose
    @Column(name = "email2")
    @Type(type= "text")
    private String email2;
    @Expose
    @Column(name = "email3")
    @Type(type= "text")
    private String email3;
    @Transient
    private String allPhones;
    @Transient
    private String allEmails;
    @Expose
    @Transient
    private String group;
    @Transient
    private String information;
    @Column(name = "photo")
    @Type(type= "text")
    private String photo;


    @Override
    public String toString() {
        return "ContactGroup{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactGroup that = (ContactGroup) o;
        return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(address, that.address) && Objects.equals(telhome, that.telhome) && Objects.equals(telmobile, that.telmobile) && Objects.equals(telwork, that.telwork) && Objects.equals(email, that.email) && Objects.equals(email2, that.email2) && Objects.equals(email3, that.email3) && Objects.equals(group, that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, address, telhome, telmobile, telwork, email, email2, email3, group);
    }

    public String getAllInformation() {
        return information;
    }

    public File getPhoto() {
        return new File(photo);
    }

    public ContactGroup withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
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


}
