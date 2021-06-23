package mantis.tests;

import biz.futureware.mantis.rpc.soap.client.IssueData;
import biz.futureware.mantis.rpc.soap.client.MantisConnectLocator;
import biz.futureware.mantis.rpc.soap.client.MantisConnectPortType;
import mantis.appmanager.ApplicationManager;
import mantis.model.Issue;
import mantis.model.Project;
import org.hamcrest.core.Is;
import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import javax.xml.rpc.ServiceException;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Set;

public class TestBase {
    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    private MantisConnectPortType getMantisConnect() throws ServiceException, MalformedURLException {
        MantisConnectPortType mc = new MantisConnectLocator()
                .getMantisConnectPort(new URL("http://localhost:1000/mantisbt-1.2.20/api/soap/mantisconnect.php"));
        return mc;
    }

    @BeforeSuite
    public boolean isIssueOpen (int issueId) throws MalformedURLException, ServiceException, RemoteException {
        MantisConnectPortType mc = getMantisConnect();
        boolean issues = mc.mc_issue_exists("administrator", "root", BigInteger.valueOf(issueId));
        return issues;
    }

    @BeforeSuite
    public void skipIfNotFixed(int issueId) throws MalformedURLException, ServiceException, RemoteException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
        app.ftp().upload(new File("src/test/resources/config_inc.php"),"config_inc.php", "config_inc.php.bak");
    }

    @AfterSuite (alwaysRun = true)
    public void tearDown() throws IOException {
        app.ftp().restore("config_inc.php.bak", "config_inc.php");
        app.stop();
    }

}
