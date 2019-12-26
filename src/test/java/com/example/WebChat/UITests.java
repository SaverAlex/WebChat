package com.example.WebChat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UITests extends Settings {

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
    public void messageButtonIsDisplayed() throws InterruptedException {
        driver.get(baseURL+"login");
        WebElement login = driver.findElement(By.id("username"));
        login.sendKeys("admin");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("admin");
        WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(), 'Sign In')]"));
        signInButton.click();
        WebElement mainLink = driver.findElement(By.xpath("//a[contains(@href,'main')]"));
        mainLink.click();
        WebElement messageInput = driver.findElement(By.xpath("//input[contains(@id,'message')]"));
        messageInput.sendKeys("hey guys!!");
        Assert.assertTrue(messageInput.isDisplayed());
    }

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
    public void signOutButtonIsDisplayed() throws InterruptedException {
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
    public void userExistIsDisplayed() throws InterruptedException {
        driver.get(baseURL+"login");
        WebElement signUpButton = driver.findElement(By.xpath("//a[contains(@href, 'registration')]"));
        signUpButton.click();
        WebElement login = driver.findElement(By.id("username"));
        login.sendKeys("admin");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("admin");
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]"));
        submitButton.click();
        WebElement error = driver.findElement(By.xpath("//div[contains(@class, 'error-block')]"));
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Assert.assertTrue(error.isDisplayed());
    }

    @Test()
    public void signIn() throws InterruptedException {
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
    public void signUp() throws InterruptedException {
        driver.get(baseURL+"login");
        WebElement signUpButton = driver.findElement(By.xpath("//a[contains(@href, 'registration')]"));
        signUpButton.click();
        WebElement login = driver.findElement(By.id("username"));
        login.sendKeys("test3");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("test3");
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]"));
        submitButton.click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8080/registration");
    }

    @Test()
    public void signOut() throws InterruptedException {
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

    @Test()
    public void sendMessage() throws InterruptedException {
        driver.get(baseURL+"login");
        WebElement login = driver.findElement(By.id("username"));
        login.sendKeys("admin");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("admin");
        WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(), 'Sign In')]"));
        signInButton.click();
        WebElement mainLink = driver.findElement(By.xpath("//a[contains(@href,'main')]"));
        mainLink.click();
        WebElement messageInput = driver.findElement(By.xpath("//input[contains(@id,'message')]"));
        messageInput.sendKeys("hey guys!!");
        WebElement sendButton = driver.findElement(By.xpath("//button[contains(text(),'Send')]"));
        sendButton.click();
        WebElement messageText = driver.findElement(By.xpath("//span[contains(text(),'hey guys!!')]"));
        Assert.assertTrue(messageText.isDisplayed());
    }
}


//WebDriverWait wait = new WebDriverWait(driver,5);
//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'hey guys!!')]")));
