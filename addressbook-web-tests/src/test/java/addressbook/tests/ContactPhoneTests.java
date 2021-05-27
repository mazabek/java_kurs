package addressbook.tests;

import addressbook.model.ContactGroup;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions(){
        if(! app.contact().isThereAContact()){
            app.goTo().goToAddNewContact();
            app.contact().create(new ContactGroup().withFirstname("Name").withLastname("Lastname").withAddress("Address")
                    .withTelhome("123123123").withTelmobile("456456456").withTelwork("789798798")
                    .withEmail("test@test.com").withGroup("test1"));
        }
    }
    @Test
    public void testContactPhones(){
        app.contact().returnToHomePage();
        ContactGroup contact = app.contact().all().iterator().next();
        ContactGroup contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getTelhome(), equalTo(cleaned(contactInfoFromEditForm.getTelhome())));
        assertThat(contact.getTelmobile(), equalTo(cleaned(contactInfoFromEditForm.getTelmobile())));
        assertThat(contact.getTelwork(), equalTo(cleaned(contactInfoFromEditForm.getTelwork())));
    }
    public String cleaned(String phone){
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }
}
