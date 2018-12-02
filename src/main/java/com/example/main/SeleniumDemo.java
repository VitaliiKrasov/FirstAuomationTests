package com.example.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo {
    public static void main(String[] args) throws InterruptedException {
//        String property = System.getProperty("user.dir") + "/driver/geckodriver";
//        System.setProperty("webdriver.gecko.driver", property);
//        WebDriver driver = new FirefoxDriver();
        String property = System.getProperty("user.dir") + "/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", property);
        WebDriver driver = new ChromeDriver();
        WebDriver.Options manage = driver.manage();
//        driver.manage().timeouts().setScriptTimeout(75, TimeUnit.SECONDS)

        driver.get("http://taqc-opencart.epizy.com/");
//        driver.get("https://www.bing.com/");
        By by = By.name("Add to Cart");
        WebElement element = driver.findElement(by);
        System.out.println(element.getText());;
//        firefoxDriver.close();
        driver.quit();

    }
}
