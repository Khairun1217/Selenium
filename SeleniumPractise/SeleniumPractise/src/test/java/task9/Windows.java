package task9;



	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	// import org.openqa.selenium.firefox.FirefoxDriver;
	// import org.openqa.selenium.safari.SafariDriver;

	public class Windows {
	    public static void main(String[] args) {
	        

	        // 1. Initialize the WebDriver (choose your browser)
	        WebDriver driver = new ChromeDriver();
	        

	        try {
	           
	            driver.get("https://the-internet.herokuapp.com/windows");

	            // 3. Store original window handle
	            String originalWindow = driver.getWindowHandle();

	            // Click the "Click Here" link to open a new window
	            WebElement link = driver.findElement(By.linkText("Click Here"));
	            link.click();

	            // 4. Get all window handles and switch to the new one (without using import java.util.Set)
	            java.util.Iterator<String> windowIterator = driver.getWindowHandles().iterator();
	            String firstWindow = windowIterator.next();
	            String secondWindow = firstWindow;

	            if (windowIterator.hasNext()) {
	                secondWindow = windowIterator.next();
	                driver.switchTo().window(secondWindow);
	            }

	            // 5. Verify that the text "New Window" is present
	            String bodyText = driver.findElement(By.tagName("body")).getText();
	            if (bodyText.contains("New Window")) {
	                System.out.println("Verified: 'New Window' text is present.");
	            } else {
	                System.out.println("Verification failed: 'New Window' text not found.");
	            }

	            // 6. Close the new window
	            driver.close();

	            // 7. Switch back to original window
	            driver.switchTo().window(originalWindow);
	            if (driver.getTitle().contains("The Internet")) {
	                System.out.println("Returned to original window.");
	            }

	        } finally {
	        	
	            driver.quit();
	        }
	    }
	}
