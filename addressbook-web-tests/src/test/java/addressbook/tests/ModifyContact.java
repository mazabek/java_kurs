package addressbook.tests;

import addressbook.model.ContactGroup;
import org.testng.annotations.Test;

public class ModifyContact extends TestBase{
    @Test
    public void testModifyContact(){
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillNewContact(new ContactGroup("test","test","test","test","test","test","test"));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }
}
