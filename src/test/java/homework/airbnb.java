package homework;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static homework.SeleniumUtils.*;
import static org.apache.commons.lang3.StringUtils.split;

public class airbnb {
    @Test
    public void test() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.airbnb.com/");
       // driver.findElement(By.xpath("//div[@class='fs7xov7 atm_7l_12u4tyr atm_am_sfpmae atm_e2_x4u3u4 atm_gz_1qdqwt3 atm_ks_15vqwwr atm_mk_h2mmj6 atm_vy_x4u3u4 atm_wq_kb7nvz dir dir-ltr']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Main navigation menu']")).click();
        driver.findElement(By.linkText("Log in")).click();
        Thread.sleep(1000);
       driver.findElement(By.xpath("//div[contains(text(), 'Continue with email')]")).click();
       driver.findElement(By.id("email-login-email")).sendKeys("candali.alina@gmail.com", Keys.ENTER);
       driver.findElement(By.name("user[password]")).sendKeys("p%*KVt9wQEjD!sa", Keys.ENTER);
       WebElement logo = driver.findElement(By.xpath("//img[@class='itu7ddv atm_e2_idpfg4 atm_vy_idpfg4 atm_mk_stnw88 atm_e2_1osqo2v__1lzdix4 atm_vy_1osqo2v__1lzdix4 i1cqnm0r atm_jp_pyzg9w atm_jr_nyqth1 i1de1kle atm_vh_yfq0k3 iqra4ro atm_5j_ofh28v dir dir-ltr']"));
       Assert.assertTrue(logo.isDisplayed());

       //driver.findElement(By.xpath("//button[@aria-label='increase value'][@data-testid='stepper-adults-increase-button']")).click();
       driver.findElement(By.xpath("//input[@placeholder='Search destinations']")).sendKeys("Ibiza, Spain", Keys.ENTER);
       driver.findElement(By.xpath("//td[@class='_wzzdy25'][@aria-label='4, Thursday, April 2024 ']")).click();
       driver.findElement(By.xpath("//td[@aria-label='17, Wednesday, April 2024 ']")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//div[@class='p13ly71q atm_c8_fkimz8 atm_g3_11yl58k atm_fr_4ym3tx atm_cs_atq67q atm_ks_15vqwwr atm_sq_1l2sidv atm_vy_1osqo2v p1hzzo26 atm_7l_1jsbn00 dir dir-ltr'][contains (text(), 'Add guests')]")).click();
       WebElement adults = driver.findElement(By.xpath("//button[@aria-label='increase value'][@data-testid='stepper-adults-increase-button']"));
        adults.click();
        adults.click();

        WebElement kids = driver.findElement(By.xpath("//button[@aria-label='increase value'][@data-testid='stepper-children-increase-button']"));
        kids.click();
        kids.click();

        driver.findElement(By.xpath("//span[@class='t1dqvypu atm_9s_1ulexfb atm_vy_1osqo2v atm_e2_1osqo2v atm_jb_uuw12j atm_2w_1egmwxu atm_k4_idpfg4 atm_uc_kn5pbq atm_2g_ux2fpz atm_k4_kb7nvz_1nos8r atm_uc_yz1f4_csw3t1 atm_k4_idpfg4_csw3t1 atm_tr_kftzq4_csw3t1 dir dir-ltr']")).click();

        driver.findElement(By.xpath("//span[@class='i1fo7oz atm_9s_11p5wf0 atm_fe_1h6ojuz atm_h_1h6ojuz atm_d5_1bp4okc atm_lo_ee9vc4 atm_lk_xvenqj atm_ll_xvenqj atm_cx_logulu dir dir-ltr']")).click();

        WebElement min = driver.findElement(By.id("price_filter_min"));
        min.sendKeys(Keys.chord(Keys.COMMAND, "A"), Keys.BACK_SPACE);
        Thread.sleep(2000);
        min.sendKeys("100", Keys.ENTER);
        WebElement max = driver.findElement(By.id("price_filter_max"));
        Thread.sleep(2000);
        max.sendKeys(Keys.chord(Keys.COMMAND, "A"), Keys.BACK_SPACE);
        max.sendKeys("600", Keys.ENTER);

        driver.findElement(By.xpath("//a[@class='l1ovpqvx atm_1y33qqm_1ggndnn_10saat9 atm_17zvjtw_zk357r_10saat9 atm_w3cb4q_il40rs_10saat9 atm_1cumors_fps5y7_10saat9 atm_52zhnh_1s82m0i_10saat9 atm_jiyzzr_1d07xhn_10saat9 bmx2gr4 atm_9j_tlke0l atm_9s_1o8liyq atm_gi_idpfg4 atm_mk_h2mmj6 atm_r3_1h6ojuz atm_rd_glywfm atm_vy_1wugsn5 atm_tl_1gw4zv3 atm_9j_13gfvf7_1o5j5ji c1ih3c6 atm_bx_1ltc5j7 atm_c8_8ycq01 atm_g3_adnk3f atm_fr_rvubnj atm_cs_qo5vgd atm_5j_9l7fl4 atm_kd_glywfm atm_l8_srw7uq atm_uc_1etn2gc atm_r2_1j28jx2 atm_jb_1fkumsa atm_3f_glywfm atm_26_ljdcfo atm_7l_1dae3rm atm_8w_1t7jgwy atm_uc_glywfm__1rrf6b5 atm_kd_glywfm_1w3cfyq atm_uc_x37zl0_1w3cfyq atm_70_gxu55l_1w3cfyq atm_3f_glywfm_e4a3ld atm_l8_idpfg4_e4a3ld atm_gi_idpfg4_e4a3ld atm_3f_glywfm_1r4qscq atm_kd_glywfm_6y7yyg atm_uc_glywfm_1w3cfyq_1rrf6b5 atm_kd_glywfm_18zk5v0 atm_uc_x37zl0_18zk5v0 atm_70_gxu55l_18zk5v0 atm_3f_glywfm_6mgo84 atm_l8_idpfg4_6mgo84 atm_gi_idpfg4_6mgo84 atm_3f_glywfm_16p4kaz atm_kd_glywfm_17yx6rv atm_uc_glywfm_18zk5v0_1rrf6b5 atm_tr_18md41p_csw3t1 atm_k4_kb7nvz_1o5j5ji atm_3f_glywfm_1nos8r_uv4tnr atm_26_1sutpmb_1nos8r_uv4tnr atm_7l_1dae3rm_1nos8r_uv4tnr atm_3f_glywfm_4fughm_uv4tnr atm_26_q1if7f_4fughm_uv4tnr atm_7l_1dae3rm_4fughm_uv4tnr atm_3f_glywfm_csw3t1 atm_26_1sutpmb_csw3t1 atm_7l_1dae3rm_csw3t1 atm_3f_glywfm_1o5j5ji atm_26_q1if7f_1o5j5ji atm_7l_1dae3rm_1o5j5ji dir dir-ltr']")).click();

        List<WebElement> discountedPrices = driver.findElements(By.xpath("//div[@class='_i5duul']//span[@class='_1y74zjx']"));

        List<WebElement> regularPrices = driver.findElements(By.xpath("//div[@class='_i5duul']//span[@class='_tyxjp1']"));
        Thread.sleep(3000);
        List<Integer> cleanList =new ArrayList<>();
        for(WebElement price : discountedPrices ){
            cleanList.add(Integer.parseInt(price.getText().replace("$", "").replace(" night", "").replace(" per, originally ", "").replace(" ", "")));

        }
        for (WebElement price : regularPrices){
            cleanList.add(Integer.parseInt(price.getText().replace("$", "").replace(" night", "").replace(" per, originally ", "").replace(" ", "")));

        }
        System.out.println(cleanList);

        for(Integer price : cleanList){
            Assert.assertTrue(price > 100 && price <600);
        }

        WebElement firstelement = driver.findElement(By.xpath("//div[@aria-labelledby='title_857181603586151951']"));

        String pricePerNight = driver.findElement(By.xpath("//span[@class='_1y74zjx'][1]")).getText();

        String totalPrice = driver.findElement(By.xpath("//div[@class='_tt122m'][1]")).getText().replace(" total", "");
        String rating = driver.findElement(By.xpath("//span[@class='r4a59j5 atm_h_1h6ojuz atm_9s_1txwivl atm_gy_z1y8gd_n6nuqf dir dir-ltr']//span[@class='r1dxllyb atm_7l_18pqv07 atm_cp_1ts48j8 dir dir-ltr'][1]")).getText().split("\\s")[0];

        firstelement.click();

        System.out.println(pricePerNight +"\n" + totalPrice + "\n" + rating);

        String firstWindowsHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            if(!windowHandle.equals(firstWindowsHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }

        WebElement closew = driver.findElement(By.xpath("//div[@class='c1lbtiq8 atm_mk_stnw88 atm_9s_1txwivl atm_fq_1tcgj5g atm_wq_kb7nvz atm_tk_1tcgj5g dir dir-ltr']//span[@class='i3tjjh1 atm_mk_h2mmj6 dir dir-ltr']"));
        jsClick(driver, closew);

        Thread.sleep(1000);
        String pricePerNightNew = driver.findElement(By.xpath("//div[@class='_1fl88fo']//span[@class='_1y74zjx']")).getText();
        String totalPriceNew = driver.findElement(By.xpath("//div[@class='_3u0me7']//span[@class='_j1kt73']")).getText();
        String ratingNew = driver.findElement(By.xpath("//div[@data-testid='pdp-reviews-highlight-banner-host-rating']//div[@aria-hidden='true']")).getText();

        System.out.println(pricePerNightNew +"\n" + totalPriceNew + "\n" + ratingNew);

        Assert.assertEquals(pricePerNight, pricePerNightNew);
        Assert.assertEquals(totalPrice, totalPriceNew);
        Assert.assertEquals(rating, ratingNew);

        driver.close();

        driver.switchTo().window(firstWindowsHandle);

        driver.findElement(By.xpath("//div[@class='_3hmsj']//div[@class=' dir dir-ltr']")).click();
         driver.findElement(By.xpath("//div[contains (text(), 'Log out')]")).click();

        driver.findElement(By.xpath("//button[@aria-label='Main navigation menu']")).click();
        WebElement logIn = driver.findElement(By.linkText("Log in"));
        Assert.assertTrue(logIn.isDisplayed());



    }
}
