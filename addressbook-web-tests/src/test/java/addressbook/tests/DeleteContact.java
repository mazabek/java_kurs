package addressbook.tests;

import addressbook.model.ContactGroup;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class DeleteContact extends TestBase{
    @Test
    public void testDeleteContact(){
        List<ContactGroup> before = app.getContactHelper().getContactList();
        if(! app.getContactHelper().isThereAContact()){
            app.getNavigationHelper().goToAddNewContact();
            app.getContactHelper().createContact(new ContactGroup("Name", "Lastname",
                    "Address", "123123123",
                    "456456465", "789789789",
                    "test@test.com", "test1"));
        }
        app.getContactHelper().chooseContact(before.size() -1);
        app.getContactHelper().sumbitContactDeletion();
        app.getContactHelper().confirmDeleteAlert();
        app.getContactHelper().returnToHomePage();
        List<ContactGroup> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() -1);

        before.remove(before.size() -1);
        Assert.assertEquals(before, after);
    }
}
