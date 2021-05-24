package addressbook.tests;

import addressbook.model.ContactGroup;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ModifyContact extends TestBase{
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
    public void testModifyContact(){
        List<ContactGroup> before = app.contact().list();
        int index = before.size() -1;
        ContactGroup group = new ContactGroup(before.get(index).getId(),"Name", "Lastname",
                "Address", "123123123",
                "456456465", "789789789",
                "test@test.com", "test1");
        app.contact().initContactModification(index);
        app.contact().modify(group);
        List<ContactGroup> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);
        Comparator<? super ContactGroup> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}