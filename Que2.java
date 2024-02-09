package Guvitask21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Que2 {

	public static void main(String[] args) {
		

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
        try {
            // Navigate to the URL
            driver.get("https://the-internet.herokuapp.com/windows");

            // Click the "Click Here" button to open a new window
            WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));
            clickHereButton.click();

            // Switch to the newly opened window
            String originalWindowHandle = driver.getWindowHandle();
            for (String windowHandle : driver.getWindowHandles()) {
                if (!windowHandle.equals(originalWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            // Verify that the text "New Window" is present
            WebElement newWindowText = driver.findElement(By.tagName("h3"));
            String expectedText = "New Window";
            if (newWindowText.getText().equals(expectedText)) {
                System.out.println("Text verification successful: " + expectedText);
            } else {
                System.out.println("Text verification failed.");
            }

            // Close the new window
            driver.close();

            // Switch back to the original window
            driver.switchTo().window(originalWindowHandle);

            // Verify that the original window is active
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals("https://the-internet.herokuapp.com/windows")) {
                System.out.println("Original window is active.");
            } else {
                System.out.println("Original window is not active.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser 
            //driver.quit();
        }
	}

}
