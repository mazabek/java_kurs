package addressbook.tests;

import addressbook.model.ContactGroup;
import addressbook.model.Contacts;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateContact extends TestBase {

  @Test
  public void testCreateContact() {
    Contacts before = app.contact().all();
    app.goTo().goToAddNewContact();
    File photo = new File("src/test/resources/stru.png");
    ContactGroup group = new ContactGroup()
            .withFirstname("Name").withLastname("Lastname").withAddress("Address")
            .withTelhome("123123123").withTelmobile("456456456").withTelwork("789798798")
            .withEmail("test@test.com").withEmail2("test2@test.com").withEmail3("test3@test.com").withGroup("test1").withPhoto(photo);
    app.contact().create(group);
    //app.logOut();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() +1));
    assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
  }
}
