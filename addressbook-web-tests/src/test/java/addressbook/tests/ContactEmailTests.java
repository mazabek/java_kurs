package addressbook.tests;

import addressbook.model.ContactGroup;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions(){
        if(! app.contact().isThereAContact()){
            app.goTo().goToAddNewContact();
            app.contact().create(new ContactGroup().withFirstname("Name").withLastname("Lastname").withAddress("ul. Wesoła 1/11,\n" +
                    "11-111 Warszawa")
                    .withTelhome("123123123").withTelmobile("456456456").withTelwork("789798798")
                    .withEmail("test@test.com") .withEmail2("test2@test.com") .withEmail3("test3@test.com").withGroup("test1"));
        }
    }
    @Test
    public void testContactEmails(){
        app.contact().returnToHomePage();
        ContactGroup contact = app.contact().all().iterator().next();
        ContactGroup contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getEmail(),equalTo(contactInfoFromEditForm.getEmail()));
        assertThat(contact.getEmail2(),equalTo(contactInfoFromEditForm.getEmail2()));
        assertThat(contact.getEmail3(),equalTo(contactInfoFromEditForm.getEmail3()));
    }
//    public String cleaned(String email){
//
//        return email.replaceAll("\\s","");
//    }
}
