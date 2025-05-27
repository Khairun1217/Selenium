package task9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium2 {
    public static void main(String[] args) throws InterruptedException {
        

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Maximize window
        driver.manage().window().maximize();

        // Navigate to Wikipedia
        driver.get("https://www.wikipedia.org/");

        // Search for "Artificial Intelligence"
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        searchInput.sendKeys("Artificial Intelligence");

        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        searchButton.click();

        // Wait for page to load
        Thread.sleep(2000);

        // Click on "History" section in the article table of contents
        WebElement historyLink = driver.findElement(By.cssSelector("a[href='#History']"));
        historyLink.click();

        // Wait for scroll
        Thread.sleep(1000);

        // Get the "History" section heading text
        WebElement historyHeading = driver.findElement(By.id("History"));
        System.out.println("Section Heading: " + historyHeading.getText());

        // Close the browser
        driver.quit();
    }
}
