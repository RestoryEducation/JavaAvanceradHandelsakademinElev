package com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    static WebDriver driver;
    public static void main(String[] args) {
        //SETUP OF TEST
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\moogl\\OneDrive\\Skrivbord\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://automation-playground.blogspot.com");

        //PERFORMANCE OF TEST
        boolean result;

        try{
            result = performTest();
        } catch (Exception e) {
            result = false;
        } finally {
            System.out.println(driver.getCurrentUrl());
            driver.close();
        }

        System.out.println("Test was "+
                        (result ? "Successful!" : "a failure!")
                );
    }

    public static boolean performTest(){
        return driver.getTitle().equalsIgnoreCase("Automation Playground");
    }
}
