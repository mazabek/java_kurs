package addressbook.appmanager;

import addressbook.model.ContactGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillNewContact(ContactGroup contactGroup) {
        type(By.name("firstname"), contactGroup.getFirstname());
        type(By.name("lastname"), contactGroup.getLastname());
        type(By.name("address"), contactGroup.getAddress());
        type(By.name("home"), contactGroup.getTelhome());
        type(By.name("mobile"), contactGroup.getTelmobile());
        type(By.name("work"), contactGroup.getTelwork());
        type(By.name("email"), contactGroup.getEmail());
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactModification() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void chooseContact() {
        click(By.id("3"));
    }

    public void sumbitContactDeletion() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void confirmDeleteAlert() {
        wd.switchTo().alert().accept();
    }
}
