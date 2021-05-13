package addressbook.tests;

import addressbook.model.ContactGroup;
import org.testng.annotations.Test;

public class DeleteContact extends TestBase{
    @Test
    public void testDeleteContact(){
        if(! app.getContactHelper().isThereAContact()){
            app.getNavigationHelper().goToAddNewContact();
            app.getContactHelper().createContact(new ContactGroup("Name", "Lastname",
                    "Address", "123123123",
                    "456456465", "789789789",
                    "test@test.com", "test1"));
        }
        app.getContactHelper().chooseContact();
        app.getContactHelper().sumbitContactDeletion();
        app.getContactHelper().confirmDeleteAlert();

    }
}
