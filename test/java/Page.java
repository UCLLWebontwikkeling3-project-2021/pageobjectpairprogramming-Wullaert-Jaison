import org.openqa.selenium.*;

import java.security.PublicKey;

public abstract class Page {
    /**
     * @Author Yarne Vandenplas
     * @Author Jaison Wullaert
     */


    WebDriver driver;
    String path ="http://localhost:8090/Web3Project_war/Controller";

    public Page (WebDriver driver){
        this.driver=driver;
    }
    public WebDriver getDriver(){
        return driver;
    }
    public String getPath() {
        return path;
    }

    public String getTitle () {
        return driver.getTitle();
    }

}
