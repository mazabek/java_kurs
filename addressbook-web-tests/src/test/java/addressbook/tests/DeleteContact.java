package addressbook.tests;

import org.testng.annotations.Test;

public class DeleteContact extends TestBase{
    @Test
    public void testDeleteContact(){
        app.getContactHelper().chooseContact();
        app.getContactHelper().sumbitContactDeletion();
        app.getContactHelper().confirmDeleteAlert();

    }
}
