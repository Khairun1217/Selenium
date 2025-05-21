package task9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {
    public static void main(String[] args) throws InterruptedException {
        

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the website
        driver.get("https://www.demoblaze.com/");

        // Wait a bit to ensure the page loads fully
        Thread.sleep(2000);

        // Get the page title
        String pageTitle = driver.getTitle();

        // Check if the title matches "STORE"
        if (pageTitle.equals("STORE")) {
            System.out.println("Page landed on correct website");
        } else {
            System.out.println("Page not landed on correct website");
        }

        // Close the browser
        driver.quit();
    }
}

