package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	
	public static Properties prop;
	
	public TestBase() {
		
		prop = new Properties();
		String strPath = System.getProperty("user.dir")+
				"//src//test//resources//configFiles//config.properties";
		
		FileInputStream fin;
		try {
			fin = new FileInputStream(strPath);
			prop.load(fin);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initialize() {
		String strBrowser = prop.getProperty("browser");
		if(strBrowser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			  driver = new EdgeDriver();
		}else {
			WebDriverManager.chromedriver().setup();
			  driver = new ChromeDriver();
		}
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		  driver.manage().deleteAllCookies();
		  driver.get(prop.getProperty("url"));
	}

}
