package addressbook.appmanager;

import addressbook.model.ContactGroup;
import addressbook.model.Contacts;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        //wd.findElement(By.linkText("home")).click();
        click(By.linkText("home"));
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
        type(By.name("email2"), contactGroup.getEmail2());
        type(By.name("email3"), contactGroup.getEmail3());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactGroup.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void initContactModification() {
        wd.findElement(By.xpath("//img[@alt='Edit']")).click();
    }

    public void submitContactModification() {
        wd.findElement(By.xpath("(//input[@name='update'])[2]")).click();
    }

    public void chooseContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void sumbitContactDeletion() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void confirmDeleteAlert() {
        wd.switchTo().alert().accept();
    }

    public void create(ContactGroup contact) {
        fillNewContact(contact, true);
        submitContactCreation();
        returnToHomePage();
    }

    public void modify(ContactGroup group) {
        fillNewContact(group, false);
        submitContactModification();
        returnToHomePage();
    }

    public void delete(ContactGroup group) {
        chooseContactById(group.getId());
        sumbitContactDeletion();
        confirmDeleteAlert();
        returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement element : rows) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String firstname = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            String allPhones = cells.get(5).getText();
            String address = cells.get(3).getText();
            String allEmails = cells.get(4).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactGroup contact = new ContactGroup().withId(id).withFirstname(firstname).withLastname(lastname)
                    .withAllPhones(allPhones).withAddress(address).withAllEmails(allEmails);
            contacts.add(contact);
        }
        wd.findElement(By.linkText("home")).click();
        return contacts;

    }

    public ContactGroup infoFromEditForm(ContactGroup contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String telhome = wd.findElement(By.name("home")).getAttribute("value");
        String telmobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String telwork = wd.findElement(By.name("work")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String email= wd.findElement(By.name("email")).getAttribute("value");
        String email2= wd.findElement(By.name("email2")).getAttribute("value");
        String email3= wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactGroup().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withTelhome(telhome).withTelmobile(telmobile).withTelwork(telwork).withAddress(address)
                .withEmail(email).withEmail2(email2).withEmail3(email3);
    }

    private void initContactModificationById(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    }
}
