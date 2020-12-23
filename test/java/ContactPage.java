import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ContactPage extends Page{
    /**
     * @Author Yarne Vandenplas
     * @Author Jaison Wullaert
    */


    @FindBy(id="firstName")
    private WebElement firstNameField;

    @FindBy(id="lastName")
    private WebElement lastNameField;

    @FindBy(id="date")
    private WebElement dateField;

    @FindBy(id="time")
    private WebElement timeField;

    @FindBy(id="gsm")
    private WebElement gsmField;

    @FindBy(id="email")
    private WebElement emailField;

    @FindBy(id="submitContact")
    private WebElement signUpButton;



    public ContactPage(WebDriver driver){
        super(driver);
        this.driver.get(getPath()+ "?command=Contacts");
    }

    public void setFirstName(String firstname){
        firstNameField.clear();
        firstNameField.sendKeys(firstname);
    }

    public void setLastName(String lastname){
        lastNameField.clear();
        lastNameField.sendKeys(lastname);
    }

    public void setDate(String date){
        dateField.clear();
        dateField.sendKeys(date);
    }

    public void setTime(String time){
        timeField.clear();
        timeField.sendKeys(time);
    }

    public void setEmail(String email){
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void setGSM(String gsm){
        gsmField.clear();
        gsmField.sendKeys(gsm);
    }

    public ContactPage submitButton(){
        WebElement button=driver.findElement(By.id("submitContact"));
        button.click();
        return this;
    }

    public String getTitle(){
        String title= driver.getTitle();
        return title;
    }

    public Boolean containsUserWithName(String name){
        ArrayList<WebElement> listItems=(ArrayList<WebElement>) driver.findElements(By.cssSelector("table tr"));

        boolean found=false;
        for (WebElement listItem:listItems) {
            if (listItem.getText().contains(name)) {
                found=true;
            }
        }
        return found;
    }

    public List<String> getErrorList(){
        List<WebElement> test=driver.findElements(By.cssSelector("div.alert-danger ul li"));
        List<String> errors= new ArrayList<>();
        for(WebElement error  : test){
            errors.add(error.getText());
        }

        return errors;
    }



    public Boolean hasError(String error){
        if(getErrorList().contains(error)){return true;}
        else{return false;}

    }



}
