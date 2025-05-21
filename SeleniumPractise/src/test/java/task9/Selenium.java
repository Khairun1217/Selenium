package task9;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
    public static void main(String[] args) {
       

        // Initialize the chrome driver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to Google
        driver.get("http://google.com");

        // Print the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Reload the page
        driver.navigate().refresh();

       

        // Close the browser
        driver.close();
    }
}
