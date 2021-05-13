package addressbook.tests;

import addressbook.model.ContactGroup;
import org.testng.annotations.*;

public class CreateContact extends TestBase {

  @Test
  public void testCreateContact() {
    app.getNavigationHelper().goToAddNewContact();
    app.getContactHelper().fillNewContact(
            new ContactGroup("Name", "Lastname",
                    "Address", "123123123",
                    "456456465", "789789789",
                    "test@test.com", "test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    app.logOut();
  }

}
