package addressbook.tests;

import addressbook.model.ContactGroup;
import addressbook.model.Contacts;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ModifyContact extends TestBase{
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
    public void testModifyContact(){
        Contacts before = app.contact().all();
        ContactGroup modifiedContact = before.iterator().next();
        ContactGroup groupContact = new ContactGroup().withId(modifiedContact.getId()).withFirstname("Name").withLastname("Lastname").withAddress("Address")
                .withTelhome("123123123").withTelmobile("456456456").withTelwork("789798798")
                .withEmail("test@test.com").withGroup("test1");
        app.contact().initContactModification();
        app.contact().modify(groupContact);
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.withoutAdded(modifiedContact).withAdded(groupContact)));
    }
}