package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
 * use Xpath
 */
public class CompareMacBookVsIphone3Chrome {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        String property = System.getProperty("user.dir") + "/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", property);
        driver = new ChromeDriver();
    }

    @Test
    public void addAndRemove() {
        driver.get("http://taqc-opencart.epizy.com/");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='caption']/*/*[contains(text(), 'MacBook')]/../../following-sibling::div/button[@data-original-title='Compare this Product']")).click();
        driver.findElement(By.xpath("//div[@class='caption']/*/*[contains(text(), 'iPhone 3')]/../../following-sibling::div/button[@data-original-title='Compare this Product']")).click();

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='alert alert-success']/a[contains(@href,'product/compare')]")).click();

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//td//*[contains(text(), 'MacBook')]/../../following-sibling::td//*[contains(text(), 'iPhone 3')]"));

        driver.findElement(By.xpath("//td//a[@class='btn btn-danger btn-block']/../following-sibling::td//a[@class='btn btn-danger btn-block']")).click();

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@class='btn btn-danger btn-block']")).click();

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='pull-right']/a[contains(@href, 'route=common/home')]"));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}