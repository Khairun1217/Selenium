package task9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

    public static void main(String[] args) {
        // Set the path to your ChromeDriver if it's not in your system PATH
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Launch ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Navigate to the jQuery UI Datepicker page
            driver.get("https://jqueryui.com/datepicker/");

            // Switch to the frame that contains the datepicker
            WebElement iframe = driver.findElement(By.className("demo-frame"));
            driver.switchTo().frame(iframe);

            // Click on the datepicker input field to open the calendar
            WebElement dateInput = driver.findElement(By.id("datepicker"));
            dateInput.click();

            // Click the "Next" button to go to the next month
            WebElement nextButton = driver.findElement(By.xpath("//a[@title='Next']"));
            nextButton.click();

            // Select the date "22" from the calendar
            WebElement date = driver.findElement(By.xpath("//a[text()='22']"));
            date.click();

            // Get the selected date from the input field
            String selectedDate = dateInput.getAttribute("value");
            System.out.println("Selected Date: " + selectedDate);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser and quit the WebDriver instance
            driver.quit();
        }
    }
}
