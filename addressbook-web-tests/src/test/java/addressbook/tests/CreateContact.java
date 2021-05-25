package addressbook.tests;

import addressbook.model.ContactGroup;
import addressbook.model.Contacts;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateContact extends TestBase {

  @Test
  public void testCreateContact() {
    Contacts before = app.contact().all();
    app.goTo().goToAddNewContact();
    ContactGroup group = new ContactGroup()
            .withFirstname("Name").withLastname("Lastname").withAddress("Address")
            .withTelhome("123123123").withTelmobile("456456456").withTelwork("789798798")
            .withEmail("test@test.com").withGroup("test1");
    app.contact().create(group);
    //app.logOut();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() +1));
    assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
  }

}
