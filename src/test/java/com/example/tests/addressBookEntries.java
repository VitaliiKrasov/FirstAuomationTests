package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Address Book Entries, add, edit, delete, etc.
 */
public class addressBookEntries {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        String property = System.getProperty("user.dir") + "/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", property);
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void login() {
        final String LOGIN = "local_part@domain.com";
        final String PASSWORD = "qwerty";
        driver.get("http://taqc-opencart.epizy.com/");
        driver.findElement(By.cssSelector(".dropdown-toggle[title='My Account']")).click();
        driver.findElement(By.cssSelector("a[href*='route=account/login']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(LOGIN);
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-email")).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void addAndRemove() {
        driver.findElement(By.cssSelector(".list-group a[href*='route=account/address']"));
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
