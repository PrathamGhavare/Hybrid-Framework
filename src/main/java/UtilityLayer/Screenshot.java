package UtilityLayer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BaseLayer.BaseClass;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Screenshot extends BaseClass {

	public static String takeScreenshot(String screenshotname, String foldername) {
		String destinationPath = System.getProperty("user.dir") + "//" + foldername + "//"
				+ DateAndTime.captureCurrentYear() + "//" + DateAndTime.captureCurrentMonthAndYear() + "//"
				+ screenshotname + DateAndTime.captureDateAndTime() + ".png";
		try {
			File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, (new File(destinationPath)));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return destinationPath;
	}

	public static String fullscreenshot(String foldername, String screenshotname) throws IOException {
		String destinationPath = System.getProperty("user.dir") + "//" + foldername + "//"
				+ DateAndTime.captureCurrentYear() + "//" + DateAndTime.captureCurrentMonthAndYear() + "//"
				+ screenshotname + DateAndTime.captureDateAndTime() + ".png";

		BufferedImage src = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(getDriver()).getImage();
		ImageIO.write(src, "png", new File(destinationPath));

		return destinationPath;
	}
}
