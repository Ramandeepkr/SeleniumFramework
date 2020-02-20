package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Lib implements IAutoConstant {
	public static Workbook wb;

	public static String getProperty(String key) {
		String property = "";
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(CONFIG_PATH));
			property = prop.getProperty(key);

		} catch (Exception e) {

		}

		return property;

	}

	public static int getRowCount(String sheet) {
		int rowCount = 0;
		try {
			wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			rowCount = wb.getSheet(sheet).getLastRowNum();

		} catch (Exception e) {
		}

		return rowCount;

	}

	public static String getCellValue(String sheet, int row, int column) {

		String value = "";
		try {
			wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			value = wb.getSheet(sheet).getRow(row).getCell(column).toString();

		} catch (Exception e) {
		}

		return value;

	}

	public void takeScreenshot(WebDriver driver, String testname) {

		String currentDate = new Date().toString().replaceAll(":", "-");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\screenshot\\" + currentDate + "\\" + testname + ".png");
		try {
			Files.copy(scr, dest);
		} catch (IOException e) {
			e.printStackTrace();

		}

	}
}
