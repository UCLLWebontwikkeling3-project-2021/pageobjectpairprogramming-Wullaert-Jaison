import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{
    /**
     * @Author Yarne Vandenplas
     * @Author Jaison Wullaert
     */

    @FindBy(id="login")
    private WebElement loginField;

    @FindBy(id="password")
    private WebElement passwordField;

    @FindBy(id="logInButton")
    private WebElement button;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver.get(getPath());
    }

    public void inputUsername(String username){
        loginField.sendKeys(username);
    }

    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }

    public LoginPage submitButton(){
        button.click();
        return this;
    }

    public void login(String username, String password){
        inputUsername(username);
        inputPassword(password);
        submitButton();
    }

}
