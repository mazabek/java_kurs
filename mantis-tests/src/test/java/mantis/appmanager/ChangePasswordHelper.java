package mantis.appmanager;

import org.openqa.selenium.By;

public class ChangePasswordHelper extends HelperBase{
    public ChangePasswordHelper(ApplicationManager app) {
        super(app);
    }
    public void login(){
        app.getProperty("web.baseUrl");

       // click(By.cssSelector("input[value='Signup']"));
    }
}
