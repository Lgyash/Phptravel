package Tests;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pricing {
public WebDriver driver = null;
	
	@BeforeMethod
	public void Basic() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver","E:\\Work\\chromedriver.exe");
        String baseUrl = "https://phptravels.com/order";
        driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	}
	
	@Test(priority = 1, alwaysRun = true)
	public void ClickOnBuyNowOnPackage() {
		
		
		driver.findElement(By.className("//body/div[@id='PageContainer']/main[@id='Main']/div[@id='android']/div[1]/div[1]/div[2]/a[1]")).click();
		driver.navigate().to("https://www.paypal.com/paypalme/phpwebapp/999"); //Buy with Paypal
		
		driver.findElement(By.className("btn-buy-now")).click();
		
		Iterator<String> handleIterator0 = this.driver.getWindowHandles().iterator();
		while (handleIterator0.hasNext())
	    {
	        String handle = handleIterator0.next();
	        if (!handleIterator0.hasNext())
	        {
	            this.driver.switchTo().window(handle);
	        }
	    }
		
		driver.findElement(By.xpath("//body/div[@id='PageContainer']/main[@id='Main']/div[@id='android']/div[1]/div[1]/div[2]/a[1]")).click();
		
		Iterator<String> handleIterator = this.driver.getWindowHandles().iterator();
		while (handleIterator.hasNext())
	    {
	        String handle = handleIterator.next();
	        if (!handleIterator.hasNext())
	        {
	            this.driver.switchTo().window(handle);
	        }
	    }
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//body/div[@id='PageContainer']/main[@id='Main']/div[@id='android']/div[1]/div[1]/div[2]/a[1]")).sendKeys("xyz@abc.xyz");
		driver.findElement(By.cssSelector("body.modal-open:nth-child(2) div.modal.fade.in:nth-child(10) div.modal-dialog div.modal-content div.modal-body > a.btn.btn-primary.btn-block.card.paddle.android:nth-child(3)")).click();
		
		Iterator<String> handleIterator1 = this.driver.getWindowHandles().iterator();
		while (handleIterator1.hasNext())
	    {
	        String handle = handleIterator1.next();
	        if (!handleIterator1.hasNext())
	        {
	            this.driver.switchTo().window(handle);
	        }
	    }
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.className("sc-dkiSSI")).click();
		driver.findElement(By.cssSelector("body.modal-open:nth-child(2) div.modal.fade.in:nth-child(10) div.modal-dialog div.modal-content div.modal-body > a.btn.btn-primary.btn-block.card.paddle.android:nth-child(3)")).click();
		driver.findElement(By.cssSelector("body.modal-open:nth-child(2) > div.modal-backdrop.fade.in:nth-child(17)")).click();

		Iterator<String> handleIterator4 = this.driver.getWindowHandles().iterator();
		while (handleIterator4.hasNext())
	    {
	        String handle = handleIterator4.next();
	        if (!handleIterator4.hasNext())
	        {
	            this.driver.switchTo().window(handle);
	        }
	    }
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//body/div[6]")).click();
		driver.navigate().forward();
		
		driver.findElement(By.cssSelector("body.modal-open:nth-child(2) > div.modal-backdrop.fade.in:nth-child(17)")).sendKeys("4976350000006891");
		driver.findElement(By.cssSelector("body.modal-open:nth-child(2) > div.modal-backdrop.fade.in:nth-child(17)")).sendKeys("Ali Abdullah");
		driver.findElement(By.cssSelector("body.modal-open:nth-child(2) > div.modal-backdrop.fade.in:nth-child(17)")).sendKeys("12");
		driver.findElement(By.cssSelector("body.modal-open:nth-child(2) > div.modal-backdrop.fade.in:nth-child(17)")).sendKeys("2025");
		driver.findElement(By.cssSelector("body.modal-open:nth-child(2) > div.modal-backdrop.fade.in:nth-child(17)")).sendKeys("341");
		
		driver.findElement(By.cssSelector("body.modal-open:nth-child(2) > div.modal-backdrop.fade.in:nth-child(17)")).click(); 
		//Buy with Paycard
	}
	
	@Test(priority = 2, alwaysRun = true)
	public void ClickOnContactUs() {
		driver.findElement(By.cssSelector("div.app-page-content.v3.headerFixed.bannersnack.container-go-premium.container_big.lang-en:nth-child(13) div.go-premium div.individual-plans.container div.get-started-free.individual.wow.fadeIn.animated div.container.get-started-content div.main-content.individual > a.button.individual.wow.flash.animated:nth-child(3)")).click();
		driver.navigate().to("https://phptravels.com/contact-us");
		boolean box = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/header[1]/div[1]/div[1]/div[1]/h2[1]")).isDisplayed();
		Assert.assertTrue(box);
	}
	
	@Test(priority = 3, alwaysRun = true)
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
