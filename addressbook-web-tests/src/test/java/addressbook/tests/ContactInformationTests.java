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
                    .withEmail("test@test.com"));
            //.withGroup("test1")
        }
    }
    @Test
    public void testContactInformation(){
        app.contact().returnToHomePage();
        ContactGroup contact = app.contact().all().iterator().next();
       String information = app.contact().infoFromDetails(contact);

        assertThat(mergeInformation(contact), equalTo(cleanInfo(information)));

    }

    private String mergeInformation(ContactGroup contact) {
        return Arrays.asList(contact.getFirstname(), contact.getLastname(), contact.getAddress(),cleanInfo(contact.getAllPhones()), contact.getAllEmails())
                .stream().filter((s) -> s != null && !s.equals(""))//odfiltrowanie pustych łańcuchów
                .map(ContactInformationTests::cleaned) // funkcja oczyszczania
                .collect(Collectors.joining("\n")); // za pomocą kolektora wybieramy oczyszczony łańcuch
    }
    public static String cleaned(String tableInfo) {
        return tableInfo.replaceAll("[-()]", "");
    }
    public static String cleanInfo(String information) {
        return information.replaceAll("H: ", "").replaceAll("M: ", "")
                .replaceAll("W: ", "").replaceAll("\n\n", "\n");
    }
}
