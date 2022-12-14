package com.Eduzeny.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssExample {

        public static void main(String[] args) {

//        TC #1: NextBaseCRM, locators and getText() practice 1- Open a chrome browser
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

//        2- Go to: https://login1.nextbasecrm.com/
            driver.get("https://login1.nextbasecrm.com/");

//        3- Enter incorrect username: “incorrect”
            //WebElement userName = driver.findElement(By.className("login-inp"));
            WebElement userName = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
            //WebElement userName = driver.findElement(By.cssSelector("input[name='USER_LOGIN']"));
            userName.sendKeys("incorrect");

//        4- Enter incorrect password: “incorrect”
            //WebElement password = driver.findElement(By.name("USER_PASSWORD"));
            WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
            //WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
            password.sendKeys("incorrect");

//        5- Click to login button.
           // WebElement loginBtn = driver.findElement(By.className("login-btn"));
            WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
            //WebElement loginBtn = driver.findElement(By.cssSelector("input[type='submit']"));
            loginBtn.click();

//        6- Verify error message text is as expected:
//        Expected: Incorrect login or password
            //WebElement errorMsg = driver.findElement(By.className("errortext"));
            WebElement errorMsg = driver.findElement(By.xpath("//div[@class='errortext']"));
            //WebElement errorMsg = driver.findElement(By.cssSelector("div[class='errortext']"));

            String expectedText = "Incorrect login or password";

            // getText() method; it will get the content(text) form in between the opening and closing tag
            String actualText =  errorMsg.getText();

            if(actualText.equals(expectedText)){
                System.out.println("Error message verification passed!");
            }else{
                System.out.println("Error message verification failed!");
            }

            driver.quit();
        }
    }
