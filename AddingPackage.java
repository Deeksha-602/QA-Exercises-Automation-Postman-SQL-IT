package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class AddingPackage {
    public static void main(String[] args) {
        // Set path to your ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");

        // Initialize WebDriver instance
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize browser window

        // Navigate to the application URL
        driver.get("https://ecs-qa.kloudship.com");

        WebDriverWait wait = new WebDriverWait(driver, 30);

        // Login to the application
        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-email")));
        usernameField.sendKeys("kloudship.qa.automation@mailinator.com");

        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password")));
        passwordField.sendKeys("Password1");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        loginButton.click();

        // Wait for the home page to load
        wait.until(ExpectedConditions.urlContains("home"));

        // Navigate to the Package Types page
        WebElement packageTypesLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//mat-card[8]/p[3]")));
        packageTypesLink.click();

        // Click the "Add Manually" button
        WebElement addManuallyButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[2]/span/mat-icon")));
        addManuallyButton.click();

        // Generate random package dimensions
        Random random = new Random();
        int length = random.nextInt(9) + 1;
        int width = random.nextInt(9) + 1;
        int height = random.nextInt(9) + 1;

        // Enter package details
        WebElement nameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mat-input-1")));
        nameField.sendKeys("Shubham_Singh");

        WebElement lengthField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mat-input-2")));
        lengthField.sendKeys(String.valueOf(length));

        WebElement widthField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mat-input-3")));
        widthField.sendKeys(String.valueOf(width));

        WebElement heightField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mat-input-4")));
        heightField.sendKeys(String.valueOf(height));

        // Submit the form
        WebElement checkButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-icon[contains(.,'check')]")));
        checkButton.click();

        // More Button (Hover and click)
        WebElement moreButtonHover = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'more_vert')]")));
        moreButtonHover.click();

        // Verify that the package is added successfully
        // You can add your verification logic here, for example:
        // WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("your success message XPath")));
        // assert successMessage.isDisplayed();

        // Logout of the application
        WebElement logoutLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'power_settings_new Logout')]")));
        logoutLink.click();

        // Close the WebDriver instance
        driver.quit();
    }
}
