package homework;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class assignment3 {

    @Test
    public void test() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.edmunds.com/");
        driver.findElement(By.xpath("//a[@href='/used-all/']")).click();

        WebElement element =  driver.findElement(By.name("zip"));
        element.sendKeys(Keys.chord(Keys.COMMAND, "A"), Keys.BACK_SPACE);
        element.sendKeys("22031", Keys.ENTER);

        Thread.sleep(5000);
        WebElement checkbox = driver.findElement(By.xpath("//span[@title='Only show local listings']"));
       checkbox.click();

       Thread.sleep(3000);
       WebElement dropdown = driver.findElement(By.xpath("//select[@id='usurp-make-select']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Tesla");

       String actual = driver.findElement(By.xpath("//select[@aria-label='Search by Model']//option[.='Add Model']")).getText();
       String expected = "Add Model";
        Assert.assertEquals(actual, expected);

        Assert.assertEquals(driver.findElement(By.cssSelector("input[aria-label='Min Year value']")).getAttribute("value"), "2012");
        Assert.assertEquals(driver.findElement(By.cssSelector("input[aria-label='Max Year value']")).getAttribute("value"), "2024");

        String actualModel = driver.findElement(By.xpath("//select[@aria-label='Search by Model']")).getText();
        String expectedModel = "Add Model\nModel 3\nModel S\nModel X\nModel Y\nCybertruck\nRoadster";
        Assert.assertEquals(actualModel, expectedModel);

        WebElement dropdownModel = driver.findElement(By.xpath("//select[@id='usurp-model-select']"));
        Select select1 = new Select(dropdownModel);
        select1.selectByVisibleText("Model 3");

        Thread.sleep(2000);
       WebElement modelElement = driver.findElement(By.xpath("//input[@id='min-value-input-Year']"));
               modelElement.click();
               modelElement.sendKeys("2020", Keys.ENTER);

        List<WebElement> list =  driver.findElements(By.xpath("//div[@class='size-16 text-cool-gray-10 font-weight-bold mb-0_5']"));

        // //div[@class='size-16 text-cool-gray-10 font-weight-bold mb-0_5']

        //div[@class='left-section py-0 pl-0 pr-0_5 col-7']
        Assert.assertEquals(list.size(), 21);

            for (WebElement webElement : list) {
            try {
                Assert.assertTrue(webElement.getText().contains("Model 3"));
            } catch (StaleElementReferenceException e) {
                list = driver.findElements(By.xpath("//div[@class='left-section py-0 pl-0 pr-0_5 col-7']"));

                for (WebElement updatedElement : list) {
                    Assert.assertTrue(updatedElement.getText().contains("Model 3"));
                }
            }
        }
            Thread.sleep(2000);
        for (WebElement webElement : list)
            try {
            String text = webElement.getText().substring(0,4);
            Assert.assertTrue(text.matches("^(2020|2021|2022|2023).*"));
        } catch (StaleElementReferenceException e) {
                list = driver.findElements(By.xpath("//div[@class='left-section py-0 pl-0 pr-0_5 col-7']"));
                for (WebElement updatedElement : list) {
                    String text = updatedElement.getText().substring(0,4);
                    Assert.assertTrue(text.matches("^(2020|2021|2022|2023).*"));
                }
                }


        WebElement dropdownSort = driver.findElement(By.xpath("//select[@data-tracking-id='select_sort_by']"));
        Select selectSort = new Select(dropdownSort);
        selectSort.selectByVisibleText("Price: Low to High");

        Thread.sleep(1000);

        List<WebElement> sortedPrices = driver.findElements(By.xpath("//div[@class='pricing-details d-flex flex-column']//span[not(@class='font-weight-bold text-gray-darkest')]"));

        List<Integer> sorted =new ArrayList<>();
        for(WebElement price : sortedPrices ){
            sorted.add(Integer.parseInt(price.getText().replace("$", "").replace(",","")));
        }
        List<Integer> sortedInt = new ArrayList<>(sorted);
        Collections.sort(sortedInt);
        Assert.assertEquals(sorted, sortedInt);
//        System.out.println(sorted);
//        System.out.println(sortedInt);

        selectSort = new Select(dropdownSort);
        selectSort.selectByVisibleText("Price: High to Low");
        Thread.sleep(1000);

        List<WebElement> sortedPrices1 = driver.findElements(By.xpath("//div[@class='pricing-details d-flex flex-column']//span[@class='heading-3']"));

        List<Integer> sortedDes =new ArrayList<>();
        //Thread.sleep(1000);
        for(WebElement prices : sortedPrices1){
            sortedDes.add(Integer.parseInt(prices.getText().replace("$", "").replace(",","")));
        }
        List<Integer> sortedIntDes = new ArrayList<>(sortedDes);
        Collections.sort(sortedIntDes, Comparator.reverseOrder());
        Assert.assertEquals(sortedDes, sortedIntDes);
//        System.out.println(sortedDes);
//        System.out.println(sortedIntDes);

        selectSort = new Select(dropdownSort);
        selectSort.selectByVisibleText("Mileage: Low to High");
        Thread.sleep(1000);

       List<WebElement> listMiles = driver.findElements(By.xpath("//div[@class='text-gray-darker row']//span[@class='text-cool-gray-30'][contains(text(), 'miles')]"));
        List<Integer> sortedMiles =new ArrayList<>();

        Thread.sleep(1000);

        for(WebElement miles : listMiles){
            sortedMiles.add(Integer.parseInt(miles.getText().replace(" miles", "").replace(",", "")));
        }
        // System.out.println(sortedMiles);

        List<Integer> sortedMil = new ArrayList<>(sortedMiles);
        Collections.sort(sortedMil);
        Assert.assertEquals(sortedMiles, sortedMil);
        // System.out.println(sortedMil);

        List<WebElement> searchResults =  driver.findElements(By.xpath("//li[@class='d-flex mb-0_75 mb-md-1_5 col-12 col-md-6']"));
        WebElement lastResult = searchResults.get(searchResults.size()-1);


        String title=lastResult.findElement(By.xpath("(//div[@class='size-16 text-cool-gray-10 font-weight-bold mb-0_5'])[" + searchResults.size() + "]")).getText();
      //  System.out.println(title);
        String price = lastResult.findElement(By.xpath("(//span[@class='heading-3'])[" + searchResults.size() + "]")).getText();
        // System.out.println(price);
        String miles = lastResult.findElement(By.xpath("(//div[@class='text-gray-darker row']//span[@class='text-cool-gray-30'][contains(text(), 'miles')])[" + searchResults.size() + "]")).getText().replace(" miles", "");
        // System.out.println(miles);

        lastResult.click();

        String titleNew = driver.findElement(By.xpath("//h1[@class='d-inline-block mb-0 heading-2 mt-0_25']")).getText();
        String priceNew = driver.findElement(By.xpath("//span[@data-testid='vdp-price-row']")).getText();
        String milesNew = driver.findElement(By.xpath("//div[@class='pr-0 font-weight-bold text-right ml-1 col'][1]")).getText();

        Assert.assertEquals(titleNew, title);
        Assert.assertEquals(priceNew, price);
        Assert.assertEquals(milesNew, miles);

        driver.navigate().back();

      String view =  driver.findElement(By.xpath("//div[@class='bg-white text-gray-darker']")).getText();
      Assert.assertTrue(view.contains("Viewed"));

      Thread.sleep(1000);
      driver.quit();
    }
}

