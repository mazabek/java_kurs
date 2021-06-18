package addressbook.tests;

import addressbook.model.ContactGroup;
import addressbook.model.Contacts;
import addressbook.model.GroupData;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class DeleteContact extends TestBase{
    @BeforeMethod
    public void ensurePreconditions(){
        if(app.db().contacts().size()==0){
            app.goTo().goToAddNewContact();
            app.contact().create(new ContactGroup().withFirstname("Name").withLastname("Lastname").withAddress("Address")
                    .withTelhome("123123123").withTelmobile("456456456").withTelwork("789798798")
                    .withEmail("test@test.com").withGroup("test1"));
        }
    }
    @Test()
    public void testDeleteContact(){
        Contacts before = app.db().contacts();
        ContactGroup deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Contacts after = app.db().contacts();
        assertEquals(after.size(), before.size() -1);

        app.contact().returnToHomePage();
        assertThat(after, equalTo(before.withoutAdded(deletedContact)));
    }
}
