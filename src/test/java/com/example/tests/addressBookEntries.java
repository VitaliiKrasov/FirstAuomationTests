package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".dropdown-toggle[title='My Account']")).click();
        driver.findElement(By.cssSelector("a[href*='route=account/login']")).click();

        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(LOGIN);
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector("input.btn.btn-primary[type='submit']")).click();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void addAndDeliteTest() {
        final String FIRSTNAME = "Eva";
        final String LASTNAME = "Pupkina";
        final String ADDRESS = "New street";
        final String CITY = "Big city";
        final String POSTCODE = "222";
        final String ZONE = "Angus"; //"Angus" value=3516
        final String COUNTRY = "United Kingdom"; //"United Kingdom" value=222

        driver.findElement(By.cssSelector(".list-group a[href*='route=account/address']")).click();
        driver.findElement(By.cssSelector(".pull-right a[href*='route=account/address']")).click();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("body.account-address-add"));
        driver.findElement(By.cssSelector("input#input-firstname.form-control")).click();
        driver.findElement(By.cssSelector("input#input-firstname.form-control")).clear();
        driver.findElement(By.cssSelector("input#input-firstname.form-control")).sendKeys(FIRSTNAME);

        driver.findElement(By.cssSelector("input#input-lastname.form-control")).click();
        driver.findElement(By.cssSelector("input#input-lastname.form-control")).clear();
        driver.findElement(By.cssSelector("input#input-lastname.form-control")).sendKeys(LASTNAME);

        driver.findElement(By.cssSelector("input#input-address-1.form-control")).click();
        driver.findElement(By.cssSelector("input#input-address-1.form-control")).clear();
        driver.findElement(By.cssSelector("input#input-address-1.form-control")).sendKeys(ADDRESS);

        driver.findElement(By.cssSelector("input#input-city.form-control")).click();
        driver.findElement(By.cssSelector("input#input-city.form-control")).clear();
        driver.findElement(By.cssSelector("input#input-city.form-control")).sendKeys(CITY);

        driver.findElement(By.cssSelector("input#input-postcode.form-control")).click();
        driver.findElement(By.cssSelector("input#input-postcode.form-control")).clear();
        driver.findElement(By.cssSelector("input#input-postcode.form-control")).sendKeys(POSTCODE);

        driver.findElement(By.cssSelector("select#input-country.form-control")).click();
        driver.findElement(By.cssSelector("select#input-country.form-control option[value='222']")).click();

        driver.findElement(By.cssSelector("select#input-zone.form-control")).click();
        driver.findElement(By.cssSelector("select#input-zone.form-control option[value='3516']")).click();

        driver.findElement(By.cssSelector("div.pull-right input.btn.btn-primary[type='submit']")).click();

        driver.findElement(By.cssSelector("div.alert.alert-success"));

        final String ACTUAL;
        ACTUAL = driver.findElement(By.cssSelector("#content .table-responsive tr:last-child td.text-left")).getText();

        final String EXPECTED;
        EXPECTED = String.format("%s %s\n%s\n%s %s\n%s\n%s", FIRSTNAME, LASTNAME, ADDRESS, CITY, POSTCODE, ZONE, COUNTRY);

        Assert.assertEquals(ACTUAL, EXPECTED);

        driver.navigate().refresh();
        driver.findElement(By.cssSelector("#content .table-responsive tr:last-child td.text-right a.btn.btn-danger[href*='route=account/address/delete']")).click();
    }

    @AfterMethod
    public void logout() {
        driver.findElement(By.cssSelector(".dropdown-toggle[title='My Account']")).click();
        driver.findElement(By.cssSelector("a[href*='route=account/logout']")).click();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
