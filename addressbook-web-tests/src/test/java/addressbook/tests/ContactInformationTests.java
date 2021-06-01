package addressbook.tests;

import addressbook.model.ContactGroup;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactInformationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        if(! app.contact().isThereAContact()){
            app.goTo().goToAddNewContact();
            app.contact().create(new ContactGroup().withFirstname("Name").withLastname("Lastname").withAddress("Address")
                    .withTelhome("123123123").withTelmobile("456456456").withTelwork("789798798")
                    .withEmail("test@test.com").withGroup("test1"));
        }
    }
    @Test (enabled = false)
    public void testContactInformation(){
        app.contact().returnToHomePage();
        ContactGroup contact = app.contact().all().iterator().next();
        ContactGroup information = app.contact().infoFromDetails(contact);

        assertThat(mergeInformation(contact), equalTo(information));

    }

    private String mergeInformation(ContactGroup contact) {
        return Arrays.asList(contact.getFirstname(), contact.getLastname(), contact.getAddress(),
                contact.getEmail(), contact.getEmail2(),contact.getEmail3(),
                contact.getTelhome(), contact.getTelmobile(), contact.getTelwork())
                .stream().filter((s) -> s != null && !s.equals(""))//odfiltrowanie pustych łańcuchów
                .map(ContactInformationTests::cleaned) // funkcja oczyszczania
                .collect(Collectors.joining("\n")); // za pomocą kolektora wybieramy oczyszczony łańcuch
    }
    public static String cleaned(String tableInfo) {
        return tableInfo.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

}
