package addressbook.tests;

import addressbook.model.ContactGroup;
import addressbook.model.Contacts;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateContact extends TestBase {
  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    try(BufferedReader reader =new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))){
      String json = "";
      String line = reader.readLine();
      while (line != null){
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactGroup> contactGroups = gson.fromJson(json,new TypeToken<List<ContactGroup>>(){}.getType());
      return contactGroups.stream().map((g)->new Object[] {g}).collect(Collectors.toList()).iterator();
    }
  }
  @DataProvider
  public Iterator<Object[]> validContactsFromXml() throws IOException {
    try(BufferedReader reader =new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))){
      String xml = "";
      String line = reader.readLine();
      while (line != null){
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(ContactGroup.class);
      List<ContactGroup> contactGroups =(List<ContactGroup>) xstream.fromXML(xml);
      return contactGroups.stream().map((g)->new Object[] {g}).collect(Collectors.toList()).iterator();
    }
  }

  @Test (dataProvider = "validContactsFromJson")
  public void testCreateContact(ContactGroup contactGroup) {
    Contacts before = app.db().contacts();
      app.goTo().goToAddNewContact();
      app.contact().create(contactGroup);
      Contacts after = app.db().contacts();
      assertThat(after.size(), equalTo(before.size() +1));
      assertThat(after, equalTo(before.withAdded(contactGroup.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
  }
}
