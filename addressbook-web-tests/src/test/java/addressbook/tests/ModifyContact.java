package addressbook.tests;

import addressbook.model.ContactGroup;
import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ModifyContact extends TestBase{
    @Test
    public void testModifyContact(){
        if(! app.getContactHelper().isThereAContact()){
            app.getNavigationHelper().goToAddNewContact();
            app.getContactHelper().createContact(new ContactGroup("Name", "Lastname",
                    "Address", "123123123",
                    "456456465", "789789789",
                    "test@test.com", "test1"));
        }
        List<ContactGroup> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactModification(before.size() -1);
        ContactGroup group = new ContactGroup(before.get(before.size() -1).getId(),"Name", "Lastname",
                "Address", "123123123",
                "456456465", "789789789",
                "test@test.com", "test1");
        app.getContactHelper().fillNewContact(group,false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        List<ContactGroup> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() -1);
        before.add(group);
        Comparator<? super ContactGroup> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}