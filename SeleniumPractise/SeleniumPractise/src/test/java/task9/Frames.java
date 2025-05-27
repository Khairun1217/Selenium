package task9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.safari.SafariDriver;

public class Frames {

    public static void main(String[] args) {
        

        // Launch browser
        WebDriver driver = new ChromeDriver();
        

        try {
            // Open the URL
            driver.get("http://the-internet.herokuapp.com/nested_frames");

            // 1. Switch to the top frame (frame-top using CSS selector)
            driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));

            // 2. Verify there are 3 frames inside the top frame
            int topFramesCount = driver.findElements(By.xpath("//frame")).size();
            if (topFramesCount == 3) {
                System.out.println("Verified: 3 frames present in the top frame.");
            } else {
                System.out.println("Verification failed: Expected 3 frames, found " + topFramesCount);
            }

            // 3. Switch to the left frame
            driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-left']")));
            String leftText = driver.findElement(By.xpath("//body")).getText();
            if (leftText.equals("LEFT")) {
                System.out.println("Verified: Left frame contains text 'LEFT'.");
            }

            // 4. Switch back to top frame
            driver.switchTo().parentFrame();

            // 5. Switch to the middle frame
            driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));
            String middleText = driver.findElement(By.xpath("//div")).getText();
            if (middleText.equals("MIDDLE")) {
                System.out.println("Verified: Middle frame contains text 'MIDDLE'.");
            }

            // 6. Switch back to top frame
            driver.switchTo().parentFrame();

            // 7. Switch to the right frame
            driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-right']")));
            String rightText = driver.findElement(By.xpath("//body")).getText();
            if (rightText.equals("RIGHT")) {
                System.out.println("Verified: Right frame contains text 'RIGHT'.");
            }

            // 8. Switch back to the main page
            driver.switchTo().defaultContent();

            // 9. Switch to the bottom frame
            driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-bottom']")));
            String bottomText = driver.findElement(By.xpath("//body")).getText();
            if (bottomText.equals("BOTTOM")) {
                System.out.println("Verified: Bottom frame contains text 'BOTTOM'.");
            }

            // 10. Switch back to main page
            driver.switchTo().defaultContent();

            // 11. Verify the page title
            String pageTitle = driver.getTitle();
            if (pageTitle.equals("Frames")) {
                System.out.println("Verified: Page title is 'Frames'.");
            } else {
                System.out.println("Verification failed: Page title is '" + pageTitle + "'");
            }

        } finally {
            // Close browser
            driver.quit();
        }
    }
}

