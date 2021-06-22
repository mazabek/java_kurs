//package mantis.tests;
//
//import mantis.appmanager.ApplicationManager;
//import mantis.appmanager.ChangePasswordHelper;
//import mantis.appmanager.HelperBase;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//
//
//public class ChangePasswordTests extends ChangePasswordHelper {
//
//    public ChangePasswordTests(ApplicationManager app) {
//        super(app);
//    }
//
//    @BeforeMethod
//    public void startMailServer(){
//        app.mail().start();
//    }
//
//    @Test
//    public void testChangePassword() throws IOException {
//        app.newSession().login("administrator", "root");
//
//
//
//    }
//    @AfterMethod(alwaysRun = true)
//    public void stopMailServer(){
//        app.mail().stop();
//    }
//}
