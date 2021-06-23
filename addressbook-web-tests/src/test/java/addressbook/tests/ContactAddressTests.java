package addressbook.tests;

import addressbook.model.ContactGroup;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions(){
        if(! app.contact().isThereAContact()){
            app.goTo().goToAddNewContact();
            app.contact().create(new ContactGroup().withFirstname("Name").withLastname("Lastname").withAddress("Address")
                    .withTelhome("123123123").withTelmobile("456456456").withTelwork("789798798")
                    .withEmail("test@test.com"));
            //.withGroup("test1")
        }
    }
    @Test
    public void testContactAddress(){
        app.contact().returnToHomePage();
        ContactGroup contact = app.contact().all().iterator().next();
        ContactGroup contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    }
}
