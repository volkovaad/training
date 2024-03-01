package homework;

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
}
