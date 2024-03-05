package homework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SeleniumUtils {

    @Test
    public static List<String> getElementsText(List<WebElement> list){
        List<String> actual =  new ArrayList<>();
        list.forEach( s -> actual.add(s.getText()));
        return actual;
    }

    public static void scrollToWebElement(WebDriver driver, WebElement elementToScroll){
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+elementToScroll.getLocation().getY()+")");
    }

    public static void jsClick(WebDriver driver, WebElement elementToClick ){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , elementToClick );
    }

}
