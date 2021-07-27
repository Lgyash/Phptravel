package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Home {
	
public WebDriver driver = null;
	
	@BeforeMethod
	public void Basic() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver","E:\\Work\\chromedriver.exe");
        String baseUrl = "https://phptravels.com/#";
        driver.get(baseUrl);
	}
	
	@Test(priority = 1, alwaysRun = true)
	public void ClickOnOverviewDemo() {
		driver.findElement(By.xpath("//body/div[@id='PageContainer']/main[@id='Main']/div[1]/div[1]/div[2]/div[1]/div[2]/a[1]")).click();
		driver.navigate().to("https://phptravels.com/demo");
		boolean box = driver.findElement(By.xpath("//a[contains(text(),'Homepage - Front-End')]")).isDisplayed();
		Assert.assertTrue(box);
	}
	
	@Test(priority = 3, alwaysRun = true)
	public void ClickOnReadMore() {
		driver.findElement(By.xpath("//input[@id='address']")).click();
		driver.navigate().to("https://phptravels.com/features");
		boolean read = driver.findElement(By.xpath("//body/div[@id='PageContainer']/main[@id='Main']/section[1]/div[1]/div[1]/div[1]/img[1]")).isDisplayed();
		Assert.assertTrue(read);
	}
	
	@Test(priority = 2, alwaysRun = true)
	public void JoinNewsletterWithValidEmail() {
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("xyz.abc@xyz");
		driver.findElement(By.cssSelector("nav.navbar.navbar-default.foot-nav-holder.mb-0.newsletter:nth-child(6) div.container div.collapse.navbar-collapse div.inp-holder > button.btn")).click();
		driver.switchTo().alert().accept();
	}
	
	@Test(priority = 4, alwaysRun = true)
	public void JoinNewsletterWithInvalidEmail() {
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("xyz.abc");
		driver.findElement(By.cssSelector("nav.navbar.navbar-default.foot-nav-holder.mb-0.newsletter:nth-child(6) div.container div.collapse.navbar-collapse div.inp-holder > button.btn")).click();
		String text =driver.switchTo().alert().getText();
		Assert.assertEquals("Email Incorrect", text);
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
