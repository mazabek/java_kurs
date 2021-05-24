package addressbook.tests;

import addressbook.model.ContactGroup;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Comparator;
import java.util.List;

public class CreateContact extends TestBase {

  @Test
  public void testCreateContact() {
    List<ContactGroup> before = app.contact().list();
    app.goTo().goToAddNewContact();
    ContactGroup group = new ContactGroup("Name", "Lastname",
            "Address", "123123123",
            "456456465", "789789789",
            "test@test.com", "test1");
    app.contact().create(group);
    //app.logOut();
    List<ContactGroup> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() +1);

    before.add(group);
    Comparator<? super ContactGroup> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
