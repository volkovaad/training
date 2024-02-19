package homework;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;

public class assignmentOne {

  @Test
  public void testCase001() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://duotify.us-east-2.elasticbeanstalk.com/register.php");
        String actualTitle = driver.getTitle();
        String supposedtobe = "Welcome to Duotify!";
        Assert.assertEquals(actualTitle, supposedtobe);

        driver.findElement(By.id("hideLogin")).click();
      Faker faker = new Faker();
      String username = faker.name().username();
      String firstName = faker.address().firstName();
      String last = faker.address().lastName();
      String email = faker.internet().emailAddress();
      String password = faker.internet().password();

      driver.findElement(By.id("username")).sendKeys(username, Keys.TAB);
      driver.findElement(By.id("firstName")).sendKeys(firstName, Keys.TAB);
      driver.findElement(By.id("lastName")).sendKeys(last, Keys.TAB);
      driver.findElement(By.id("email")).sendKeys(email, Keys.TAB);
      driver.findElement(By.id("email2")).sendKeys(email, Keys.TAB);
      driver.findElement(By.id("password")).sendKeys(password, Keys.TAB);
      driver.findElement(By.id("password2")).sendKeys(password, Keys.ENTER);

      String currentUrl = driver.getCurrentUrl();
      String neededURL = "http://duotify.us-east-2.elasticbeanstalk.com/browse.php?";
      Assert.assertEquals(currentUrl, neededURL);

     WebElement actualNa = driver.findElement(By.id("nameFirstAndLast"));
      String actualName = actualNa.getText();
      String myName = firstName +" " + last;

      Assert.assertEquals(actualName, myName);

      actualNa.click();
      Thread.sleep(2000);
     String newName = driver.findElement(By.xpath("//div[@class='userInfo']")).getText();
      System.out.println(newName);
      System.out.println(myName);
      Assert.assertEquals(newName,myName);
      WebElement logout = driver.findElement(By.xpath("//button[@id='rafael']"));
      logout.click();

      Thread.sleep(1000);
      String urlcurrrent = driver.getCurrentUrl();
     Assert.assertEquals(urlcurrrent, "http://duotify.us-east-2.elasticbeanstalk.com/register.php");

     Thread.sleep(1000);
      driver.findElement(By.name("loginUsername")).sendKeys(username, Keys.TAB);
      driver.findElement(By.name("loginPassword")).sendKeys(password, Keys.ENTER);

      Thread.sleep(1000);
    Assert.assertTrue(driver.getPageSource().contains("You Might Also Like"));

    driver.findElement(By.id("nameFirstAndLast")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath("//button[@id='rafael']")).click();
      Thread.sleep(1000);
      Assert.assertEquals(driver.getCurrentUrl(), "http://duotify.us-east-2.elasticbeanstalk.com/register.php");

  }
}
