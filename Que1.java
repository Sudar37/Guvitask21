package Guvitask21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Que1 {

	public static void main(String[] args) {

		// Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        try {
            // Navigate to the URL
            driver.get("https://the-internet.herokuapp.com/iframe");

            // Switch to the iframe using CSS Selector
            WebElement iframe = driver.findElement(By.cssSelector("iframe#mce_0_ifr"));
            driver.switchTo().frame(iframe);

            // Locate the "p" tag 
            WebElement pTag = driver.findElement(By.tagName("p"));
            pTag.clear(); // Clear any existing text
            pTag.sendKeys("Hello People"); // Enter the desired text

            driver.switchTo().defaultContent();

            String enteredText = pTag.getText();
            if (enteredText.equals("Hello People")) {
                System.out.println("Text entered successfully: " + enteredText);
            } else {
                System.out.println("Text entry failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            //driver.quit();
        }
	}

}
