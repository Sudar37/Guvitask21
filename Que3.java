package Guvitask21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Que3 {

	public static void main(String[] args) {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
        try {
            // Navigate to the URL
            driver.get("http://the-internet.herokuapp.com/nested_frames");

            // Switch to the top frame
            driver.switchTo().frame("frame-top");

            // Verify the presence of three frames
            WebElement leftFrame = driver.findElement(By.name("frame-left"));
            WebElement middleFrame = driver.findElement(By.name("frame-middle"));
            WebElement rightFrame = driver.findElement(By.name("frame-right"));

            // Switch to the left frame
            driver.switchTo().frame(leftFrame);
            String leftText = driver.findElement(By.tagName("body")).getText();
            System.out.println("Left frame text: " + leftText);

            // Switch back to the top frame
            driver.switchTo().defaultContent();

            // Switch to the middle frame
            driver.switchTo().frame(middleFrame);
            String middleText = driver.findElement(By.tagName("body")).getText();
            System.out.println("Middle frame text: " + middleText);

            // Switch back to the top frame
            driver.switchTo().defaultContent();

            // Switch to the right frame
            driver.switchTo().frame(rightFrame);
            String rightText = driver.findElement(By.tagName("body")).getText();
            System.out.println("Right frame text: " + rightText);

            // Switch back to the top frame
            driver.switchTo().defaultContent();

            // Switch to the bottom frame
            driver.switchTo().frame("frame-bottom");
            String bottomText = driver.findElement(By.tagName("body")).getText();
            System.out.println("Bottom frame text: " + bottomText);

            // Verify the page title
            String pageTitle = driver.getTitle();
            if (pageTitle.equals("Frames")) {
                System.out.println("Page title verification successful: " + pageTitle);
            } else {
                System.out.println("Page title verification failed.");
            }
            } catch (Exception e) {
            e.printStackTrace();
            } finally {
            // Close the browser instance
            driver.quit();
        }
     }
}
