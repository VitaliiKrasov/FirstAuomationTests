package com.example.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExchangeRate {
    public static void main(String[] args) {
        String property = System.getProperty("user.dir") + "/driver/chromedriver";
        System.setProperty("webdriver.chrome.driver", property);
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://bank.gov.ua/control/uk/curmetal/detail/currency?period=daily");

            String usd = driver.findElement(By.xpath("//*[text()='Долар США']/following-sibling::*")).getText();
            String eur = driver.findElement(By.xpath("//*[text()='Євро']/following-sibling::*")).getText();
            String date = driver.findElement(By.cssSelector("div.title_info b")).getText();

            System.out.println("100 usd = " + usd + " uah");
            System.out.println("100 eur = " + eur + " uah");
            System.out.println(date.substring(3) + " bank.gov.ua");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

//        try {
//            driver.get("https://finance.ua/#");
//            driver.findElement(By.cssSelector("div.b-table-currency a[data-target='#table-currency-tab3']")).click();
//            String text = driver.findElement(By.cssSelector("div.b-table-currency")).getText();
//            System.out.println(text);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            driver.quit();
//        }
    }
}
