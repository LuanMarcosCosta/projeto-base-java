package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RunBase {
    static WebDriver getdriver;

    public enum Browser {CHROME, FIREFOX}

    public static WebDriver getdriver(){
        if (getdriver == null){
            return getdriver(Browser.CHROME);
        }else{
            return getdriver;
        }
    }

    public static WebDriver getdriver(Browser browser){

        if (getdriver != null){
            getdriver.quit();
        }

        switch (browser){
            case CHROME:
                getdriver = new ChromeDriver();
                break;

            case FIREFOX:
                getdriver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Passe um navegador Valido!!");
        }
        return getdriver;
    }
}
