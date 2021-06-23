package addressbook.tests;

import addressbook.model.ContactGroup;
import addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;

public class AddAndRemoveContactInGroup extends TestBase{



    @BeforeMethod
    public void ensurePreconditions(){
        if(! app.contact().isThereAContact()){
            app.goTo().goToAddNewContact();
            app.contact().create(new ContactGroup().withFirstname("Name").withLastname("Lastname").withAddress("Address")
                    .withTelhome("123123123").withTelmobile("456456456").withTelwork("789798798")
                    .withEmail("test@test.com"));
        }
    }

    @Test
    public void addContactToGroup(){

        if(app.group().isThereAGroup()) {
            app.contact().returnToHomePage();
            app.contact().chooseContactById(193);
            app.contact().initAddToGroup();
            app.contact().returnToHomePage();
            verifyGroupListInUI();

        }
    }
    @Test
    public void removeContactToGroup(){

        if (app.group().isThereAGroup()){
        app.contact().returnToHomePage();
        app.contact().chooseContactById(193);
        app.contact().initAddToGroup();
        app.contact().goToGroupContactPage();
        verifyGroupListInUI();
        }
    }
}
