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
        app.contact().returnToHomePage();
        if(! app.contact().isThereAContact()){
            app.goTo().goToAddNewContact();
            app.contact().create(new ContactGroup().withFirstname("Name").withLastname("Lastname").withAddress("Address")
                    .withTelhome("123123123").withTelmobile("456456456").withTelwork("789798798")
                    .withEmail("test@test.com").withEmail2("test2@test.com").withEmail3("test3@test.com").withGroup("test1"));
        }
    }
    @Test
    public void testModifyContact(){
        Contacts before = app.db().contacts();
        ContactGroup modifiedContact = before.iterator().next();
        app.contact().initContactModification();
        ContactGroup groupContact = new ContactGroup().withId(modifiedContact.getId()).withFirstname("Name").withLastname("Lastname").withAddress("Address")
                .withTelhome("123123123").withTelmobile("456456456").withTelwork("789798798")
                .withEmail("test@test.com").withEmail2("test2@test.com").withEmail3("test3@test.com").withGroup("test1");
        app.contact().modify(groupContact);
        Contacts after = app.db().contacts();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.withoutAdded(modifiedContact).withAdded(groupContact)));
    }
}