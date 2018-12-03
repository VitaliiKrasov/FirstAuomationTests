package com.soft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static com.soft.Secret.Login;

public class Schedule {
    public static void main(String[] args) {
        String property = System.getProperty("user.dir") + "/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", property);
        WebDriver driver = new ChromeDriver();

        driver.get("https://softserve.academy/");
        driver.findElement(By.cssSelector("a[href*='login']")).click();
        Login(driver);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }
}
