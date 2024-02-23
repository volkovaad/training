package homework;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class assignment2 {
    @Test
    public void testCase001() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://open.spotify.com/");
        driver.findElement(By.xpath("//span[@class='ButtonInner-sc-14ud5tc-0 bzuYkS encore-inverted-light-set']")).click();

        //demo123454@gmail.com
        //Q!!FNb$.4bPUXVH
        driver.findElement(By.id("login-username")).sendKeys("demo123454@gmail.com", Keys.TAB);
        driver.findElement(By.id("login-password")).sendKeys("Q!!FNb$.4bPUXVH",Keys.ENTER);

        WebElement logoelement = driver.findElement(By.xpath("//button[@data-testid='user-widget-link']"));
        Assert.assertTrue(logoelement.isDisplayed());

        driver.findElement(By.xpath("//a[@class='link-subtle UYeKN11KAw61rZoyjcgZ']")).click();
        driver.findElement(By.xpath("//input[@data-testid='search-input']")).sendKeys("Adele Hello", Keys.ENTER);

        WebElement element = driver.findElement(By.xpath("//button[@data-testid='play-button'][1]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , element );

        String songPlayingName = driver.findElement(By.xpath("//div[@class='Text__TextElement-sc-if376j-0 cZUJSD encore-text-title-medium nk6UgB4GUYNoAcPtAQaG']")).getText();
        String songPlayingArtist = driver.findElement(By.xpath("//span[@class='Text__TextElement-sc-if376j-0 gYdBJW encore-text-body-small EOodiXpqS_o1Q6E7R6V7']")).getText();
        String songPlaying = songPlayingName + "\n" + songPlayingArtist;
        String songOntheBottom = driver.findElement(By.xpath("//div[@class='JG5J9NWJkaUO9fiKECMA']//div[@data-testid='now-playing-widget']")).getText();

        Assert.assertEquals(songOntheBottom, songPlaying);

        driver.findElement(By.xpath("//button[@data-testid='user-widget-link']")).click();
        WebElement dropElement = driver.findElement(By.xpath("//span[.='Log out']"));
        dropElement.click();

        Assert.assertTrue(driver.getPageSource().contains("Log in"));
    }
}
