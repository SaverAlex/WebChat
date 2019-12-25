package com.example.WebChat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class UITests extends Settings {

    @Test()
    public void loginFormIsDisplayed() throws InterruptedException {
        driver.get(baseURL+"login");
        WebElement loginForm = driver.findElement(By.xpath("//form[contains(@action,'login')]"));
        Assert.assertTrue(loginForm.isDisplayed());
    }

    @Test()
    public void loginHeaderIsDisplayed() throws InterruptedException {
        driver.get(baseURL+"login");
        WebElement loginHeader = driver.findElement(By.xpath("//h3[contains(@class,'sign-in')]"));
        Assert.assertTrue(loginHeader.isDisplayed());
    }

    @Test()
    public void signInButtonIsDisplayed() throws InterruptedException {
        driver.get(baseURL+"login");
        WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(), 'Sign In')]"));
        Assert.assertTrue(signInButton.isDisplayed());
    }

    @Test()
    public void regButtonIsDisplayed() throws InterruptedException {
        driver.get(baseURL+"login");
        WebElement regButton = driver.findElement(By.xpath("//button//a[contains(@href,'registration')]"));
        Assert.assertTrue(regButton.isDisplayed());
    }

    @Test()
    public void login() throws InterruptedException {
        driver.get(baseURL+"login");
        WebElement login = driver.findElement(By.id("username"));
        login.sendKeys("admin");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("admin");
        WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(), 'Sign In')]"));
        signInButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8080/");
    }

    @Test()
    public void goToMainPage() throws InterruptedException {
        driver.get(baseURL+"login");
        WebElement login = driver.findElement(By.id("username"));
        login.sendKeys("admin");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("admin");
        WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(), 'Sign In')]"));
        signInButton.click();
        WebElement mainLink = driver.findElement(By.xpath("//a[contains(@href,'main')]"));
        mainLink.click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8080/main");
    }

    @Test()
    public void logoutButtonIsDisplayed() throws InterruptedException {
        driver.get(baseURL+"login");
        WebElement login = driver.findElement(By.id("username"));
        login.sendKeys("admin");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("admin");
        WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(), 'Sign In')]"));
        signInButton.click();
        WebElement mainLink = driver.findElement(By.xpath("//a[contains(@href,'main')]"));
        mainLink.click();
        WebElement logOutButton = driver.findElement(By.xpath("//button[contains(text(), 'LogOut')]"));
        Assert.assertTrue(logOutButton.isDisplayed());

    }

    @Test()
    public void logout() throws InterruptedException {
        driver.get(baseURL+"login");
        WebElement login = driver.findElement(By.id("username"));
        login.sendKeys("admin");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("admin");
        WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(), 'Sign In')]"));
        signInButton.click();
        WebElement mainLink = driver.findElement(By.xpath("//a[contains(@href,'main')]"));
        mainLink.click();
        WebElement logOutButton = driver.findElement(By.xpath("//button[contains(text(), 'LogOut')]"));
        logOutButton.click();
        WebElement loginHeader = driver.findElement(By.xpath("//h3[contains(@class,'sign-in')]"));
        Assert.assertTrue(loginHeader.isDisplayed());
    }

}
