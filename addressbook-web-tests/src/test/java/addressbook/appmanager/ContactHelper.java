package addressbook.appmanager;

import addressbook.model.ContactGroup;
import addressbook.model.GroupData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        wd.findElement(By.linkText("home")).click();
        // click(By.linkText("home"));
    }

    public void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillNewContact(ContactGroup contactGroup, boolean creation) {
        type(By.name("firstname"), contactGroup.getFirstname());
        type(By.name("lastname"), contactGroup.getLastname());
        type(By.name("address"), contactGroup.getAddress());
        type(By.name("home"), contactGroup.getTelhome());
        type(By.name("mobile"), contactGroup.getTelmobile());
        type(By.name("work"), contactGroup.getTelwork());
        type(By.name("email"), contactGroup.getEmail());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactGroup.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void initContactModification(int index) {
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    public void submitContactModification() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void chooseContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void sumbitContactDeletion() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void confirmDeleteAlert() {
        wd.switchTo().alert().accept();
    }

    public void createContact(ContactGroup contact) {
        fillNewContact(contact, true);
        submitContactCreation();
        returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactGroup> getContactList() {
        List<ContactGroup> contacts = new ArrayList<ContactGroup>();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement element : rows) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String firstname = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactGroup contact = new ContactGroup(id, firstname, lastname , null, null,
                    null, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
