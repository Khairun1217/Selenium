package task9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Dragdrop {

    public static void main(String[] args) {

        // Set up WebDriver (Chrome)
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Set implicit wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Navigate to the jQuery UI droppable demo page
            driver.get("https://jqueryui.com/droppable/");

            // Switch to the iframe that contains the draggable and droppable elements
            WebElement frame = driver.findElement(By.className("demo-frame"));
            driver.switchTo().frame(frame);

            // Locate source ("Drag me to my target") and target ("Drop here") elements
            WebElement source = driver.findElement(By.id("draggable"));
            WebElement target = driver.findElement(By.id("droppable"));

            // Perform drag-and-drop operation
            Actions actions = new Actions(driver);
            actions.dragAndDrop(source, target).perform();

            // Get the text of the target element after drop
            String targetText = target.getText();
            if (targetText.equals("Dropped!")) {
                System.out.println("✅ Text successfully changed to 'Dropped!'");
            } else {
                System.out.println("❌ Text did not change correctly. Found: " + targetText);
            }

            // Get the background color of the target element
            String bgColor = target.getCssValue("background-color");
            System.out.println("Target background color after drop: " + bgColor);

            // Basic check if the color changed (exact value may vary by browser)
            if (!bgColor.equals("rgba(0, 0, 0, 0)") && !bgColor.isEmpty()) {
                System.out.println("✅ Background color indicates successful drop.");
            } else {
                System.out.println("❌ Background color did not change.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser and quit WebDriver
            driver.quit();
        }
    }
}

