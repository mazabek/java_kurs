package addressbook.tests;

import addressbook.model.ContactGroup;
import addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DeleteContact extends TestBase{
    @BeforeMethod
    public void ensurePreconditions(){
        if(! app.contact().isThereAContact()){
            app.goTo().goToAddNewContact();
            app.contact().create(new ContactGroup("Name", "Lastname",
                    "Address", "123123123",
                    "456456465", "789789789",
                    "test@test.com", "test1"));
        }
    }
    @Test
    public void testDeleteContact(){
        List<ContactGroup> before = app.contact().list();
        app.contact().delete(before);
        List<ContactGroup> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() -1);

        before.remove(before.size() -1);
        Assert.assertEquals(before, after);
    }
}
