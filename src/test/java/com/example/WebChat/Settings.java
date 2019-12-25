package com.example.WebChat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class Settings {
    public static WebDriver driver;
    public String baseURL = "http://localhost:8080/";
    public static ChromeDriverService service;

    @BeforeClass
    public static void createAndStartService() {
        service = new ChromeDriverService.Builder().usingDriverExecutable(new File("/usr/local/bin/chromedriver"))
                .withSilent(true)
                .withVerbose(false)
                .build();
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        //WebDriverManager.chromedriver().setup();
    }

    @AfterClass
    public static void createAndStopService() {
        service.stop();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        System.out.println(service.getUrl());
        driver = new ChromeDriver();
        System.out.println(driver);
        driver.get(baseURL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    //public static WebDriver getDriver() {
    //    return driver;
    //}
}