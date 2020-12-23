import main.java.domain.model.Contact;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddContactWithPageObjectTest {


    /**
     * @Author Yarne Vandenplas
     * @Author Jaison Wullaert
     */
    public WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\WERK\\WERK\\2020-2021\\WEB3\\chromedriver_win32_v87\\chromedriver.exe");
        driver = new ChromeDriver();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login("AddContactTester","t");
    }

    @After
    public void clean(){
        driver.quit();
    }

    @Test
    public void test_AddContact_AllFieldsFilledInCorrectly(){

        ContactPage contactPage = PageFactory.initElements(driver, ContactPage.class);
        contactPage.setFirstName("Tim");
        contactPage.setLastName("Timmermans");
        contactPage.setDate("11-11-2020");
        contactPage.setGSM("0123456789");
        contactPage.setTime("11:11");
        contactPage.setEmail("tim.timmermans@hotmail.com");
        ContactPage contactPage1 = contactPage.submitButton();
        String title = contactPage1.getTitle();
        assertEquals("Contacts", title);

        assertTrue(contactPage1.containsUserWithName("Tim Timmermans"));
    }

    @Test
    public void test_AddContact_FirstNameNotFilledIn(){
        ContactPage contactPage = PageFactory.initElements(driver, ContactPage.class);
        contactPage.setFirstName("");
        contactPage.setLastName("Timmermans");
        contactPage.setDate("11-11-2020");
        contactPage.setGSM("0123456789");
        contactPage.setTime("11:11");
        contactPage.setEmail("tim.timmermans@hotmail.com");
        ContactPage contactPage1 = contactPage.submitButton();
        String title = contactPage1.getTitle();
        assertEquals("Contacts", title);
        List<String> errors = contactPage1.getErrorList();
        assertTrue(errors.contains("No firstname given"));
    }

    @Test
    public void test_AddContact_LastNameFilledInCorrectly(){

        ContactPage contactPage = PageFactory.initElements(driver, ContactPage.class);
        contactPage.setFirstName("Tim");
        contactPage.setLastName("");
        contactPage.setDate("11-11-2020");
        contactPage.setGSM("0123456789");
        contactPage.setTime("11:11");
        contactPage.setEmail("tim.timmermans@hotmail.com");
        ContactPage contactPage1 = contactPage.submitButton();
        String title = contactPage1.getTitle();
        assertEquals("Contacts", title);
        List<String> errors = contactPage1.getErrorList();
        assertTrue(errors.contains("No lastname given"));

    }
    @Test
    public void test_AddContact_DateNotFilledInCorrectly(){

        ContactPage contactPage = PageFactory.initElements(driver, ContactPage.class);
        contactPage.setFirstName("Tim");
        contactPage.setLastName("Timmermans");
        contactPage.setDate("");
        contactPage.setGSM("0123456789");
        contactPage.setTime("11:11");
        contactPage.setEmail("tim.timmermans@hotmail.com");
        ContactPage contactPage1 = contactPage.submitButton();
        String title = contactPage1.getTitle();
        assertEquals("Contacts", title);

        List<String> errors = contactPage1.getErrorList();
        assertTrue(errors.contains("No valid date"));
    }
    @Test
    public void test_AddContact_TimeNotFilledInCorrectly(){

        ContactPage contactPage = PageFactory.initElements(driver, ContactPage.class);
        contactPage.setFirstName("Tim");
        contactPage.setLastName("Timmermans");
        contactPage.setDate("11-11-2020");
        contactPage.setGSM("0123456789");
        contactPage.setTime("");
        contactPage.setEmail("tim.timmermans@hotmail.com");
        ContactPage contactPage1 = contactPage.submitButton();
        String title = contactPage1.getTitle();
        assertEquals("Contacts", title);

        List<String> errors = contactPage1.getErrorList();
        assertTrue(errors.contains("No valid time"));

    }
    @Test
    public void test_AddContact_EmailNotFilledInCorrectly(){

        ContactPage contactPage = PageFactory.initElements(driver, ContactPage.class);
        contactPage.setFirstName("Tim");
        contactPage.setLastName("Timmermans");
        contactPage.setDate("11-11-2020");
        contactPage.setGSM("0123456789");
        contactPage.setTime("11:11");
        contactPage.setEmail("");
        ContactPage contactPage1 = contactPage.submitButton();
        String title = contactPage1.getTitle();
        assertEquals("Contacts", title);

        List<String> errors = contactPage1.getErrorList();
        assertTrue(errors.contains("No email given"));

    }

    @Test
    public void test_AddContact_GsmNotFilledInCorrectly(){

        ContactPage contactPage = PageFactory.initElements(driver, ContactPage.class);
        contactPage.setFirstName("Tim");
        contactPage.setLastName("Timmermans");
        contactPage.setDate("11-11-2020");
        contactPage.setGSM("");
        contactPage.setTime("11:11");
        contactPage.setEmail("tim.timmermans@hotmail.com");
        ContactPage contactPage1 = contactPage.submitButton();
        String title = contactPage1.getTitle();
        assertEquals("Contacts", title);

        List<String> errors = contactPage1.getErrorList();
        assertTrue(errors.contains("GSM is a 9 digit number"));
    }
}
