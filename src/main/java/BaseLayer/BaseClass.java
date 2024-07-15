package BaseLayer;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {
	protected static Properties prop;

	public static String Filepath = System.getProperty("user.dir")
			+ "/src/main/java/ConfigurationLayer/config.properties";

	private static ThreadLocal<WebDriver> td = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return td.get();
	}

	public static void intialization(String browsername) {

		if (browsername.equalsIgnoreCase("Chrome")) {
			td.set(new ChromeDriver());
		} else if (browsername.equalsIgnoreCase("Edge")) {
			td.set(new EdgeDriver());
		} else if (browsername.equalsIgnoreCase("incognito")) {
			td.set(new ChromeDriver(new ChromeOptions().addArguments("--incognito")));
		} else if (browsername.equalsIgnoreCase("headless")) {
			td.set(new ChromeDriver(new ChromeOptions().addArguments("--headless")));
		} else {
			System.err.println("Please mention valid browsername");
		}

		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30)).pageLoadTimeout(Duration.ofSeconds(30));
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		String url = prop.getProperty("url");
		getDriver().get(url);
	}

	public BaseClass() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(Filepath);
			prop.load(fis);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
