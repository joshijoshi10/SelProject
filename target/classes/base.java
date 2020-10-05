package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.common.io.Files;

public class base {

	public static WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws Exception {
		
				prop = new Properties();
				FileInputStream fis = new FileInputStream("C:\\Users\\Dell\\SelProject\\src\\main\\java\\resources\\data.properties");
				prop.load(fis);
				
				String browserName = prop.getProperty("browser");
				if(browserName.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
					driver = new ChromeDriver();

				}else if(browserName.equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.gecko.driver", "C:\\webdrivers\\geckodriver.exe");
					driver = new FirefoxDriver();

				}else if(browserName.equalsIgnoreCase("ie")) {
					System.setProperty("webdriver.ie.driver", "C:\\webdrivers\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();

				}
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				return driver;
	}
	
	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C://test//"+result+"screenshot.png");
		Files.move(src, dest);
	}
	
}
