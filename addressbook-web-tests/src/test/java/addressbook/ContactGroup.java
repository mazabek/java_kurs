package addressbook;

public class ContactGroup {
    private final String firstname;
    private final String lastname;
    private final String address;
    private final String telhome;
    private final String telmobile;
    private final String telwork;
    private final String email;

    public ContactGroup(String firstname, String lastname, String address, String telhome, String telmobile, String telwork, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.telhome = telhome;
        this.telmobile = telmobile;
        this.telwork = telwork;
        this.email = email;
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
}
