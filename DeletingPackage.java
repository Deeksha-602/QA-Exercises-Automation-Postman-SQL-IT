package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeletingPackage {
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

        // Wait for the Package Types page to load
        // You can wait for the page to load here if needed

        // Click on the recent package
        WebElement recentPackage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//mat-card/div")));
        recentPackage.click();

        // Click on the delete button
        WebElement deleteButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//mat-icon[contains(.,'delete')]")));
        deleteButton.click();

        // Confirm the deletion
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,'Delete Package Type')]")));
        confirmButton.click();

        // More Button (Hover and click)
        WebElement moreButtonHover = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'more_vert')]")));
        moreButtonHover.click();

        // Verify that the package is deleted successfully
        // Add your verification logic here (e.g., checking for success message or absence of the deleted package)

        // Logout of the application
        WebElement logoutLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'power_settings_new Logout')]")));
        logoutLink.click();

        // Close the WebDriver instance
        driver.quit();
    }
}
