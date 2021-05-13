package addressbook.tests;

import addressbook.model.ContactGroup;
import org.testng.annotations.Test;

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
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillNewContact(new ContactGroup("test","test","test","test","test","test","test", null),false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }
}
