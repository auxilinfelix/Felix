package common;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.io.FileHandler;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class BaseClass {

	public static String userID = "";
    public static WebDriverWait wait;
   public static WebDriver driver;
   public static WebElement element;

   public static WebDriver launchBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.silentOutput", "true");
				WebDriverManager.chromedriver().setup();
				ChromeOptions chromeOptions =new ChromeOptions();
				chromeOptions.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(chromeOptions);
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.firefox.silentOutput", "true");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if (browserName.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.silentOutput", "true");
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.silentOutput", "true");
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
          // driver.manage().window().maximize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver;

	}

    public static WebDriver headless(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				ChromeDriverManager cmd = new ChromeDriverManager();
				cmd.setup();
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--headless");
				chromeOptions.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(chromeOptions);
			} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions firefox = new FirefoxOptions();
				firefox.addArguments("--headless");
				driver = new FirefoxDriver(firefox);

			} else if (browserName.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.silentOutput", "true");
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				EdgeOptions edgeOptions = new EdgeOptions();
				edgeOptions.addArguments("--headless");
				driver = new EdgeDriver(edgeOptions);
			}
            driver.manage().window().maximize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver;
	}

    public static void getUrl(String Url) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			driver.get(Url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void pageLoadWait(int waitTime) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));

	}

    public static void highLightWebElement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].style.border='2px solid blue'", element);
	}

	public String getPageText(WebElement e) {
		String txt = null;
		try {
			txt = e.getText();
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		return txt;
	}

	public String getAttributeValue(WebElement e) {
		String value = null;
		try {
			value = e.getAttribute("value");
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
		return value;
	}

     public String waitinputText(Object elementOrLocator, String value, int num) {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(num));
       WebElement element = null;
      if (elementOrLocator instanceof WebElement) {
         element = (WebElement)wait.until(ExpectedConditions.visibilityOf((WebElement)elementOrLocator));
      } else if (elementOrLocator instanceof By) {
         element = (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated((By)elementOrLocator));
      }

      element.sendKeys(new CharSequence[]{value});
      return value;
   }

   public static void sendKeys(WebElement element, String data) {
        element.sendKeys(data);
    }
   
   public static void wait_Sendkeys(WebElement element, String value, int num) {
		try {
			WebDriverWait wait_sendkeys = new WebDriverWait(driver, Duration.ofSeconds(num));
			wait_sendkeys.until(ExpectedConditions.visibilityOf(element)).sendKeys(value);
			hold(0500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public static void hold(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

    public static void wait_SelectByText(WebElement element, String Value) {
		try {
			WebDriverWait waitclick = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement until = waitclick.until(ExpectedConditions.visibilityOf(element));
			Select s = new Select(until);
			s.selectByVisibleText(Value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void wait_SelectByIndex(WebElement element, int index) {
		try {
			WebDriverWait waitclick = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement until = waitclick.until(ExpectedConditions.visibilityOf(element));
			Select s = new Select(until);
			s.selectByIndex(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void wait_SelectByValue(WebElement element, String Value) {
		try {
			WebDriverWait waitclick = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement until = waitclick.until(ExpectedConditions.visibilityOf(element));
			Select s = new Select(until);
			s.selectByValue(Value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void click(WebElement element) {
        element.click();
    }

	// ✅ Replaced Robot with WebDriver Keys
    public static void pressEnter() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public static void pressDown(int count) throws InterruptedException {
        Actions actions = new Actions(driver);
        for (int i = 0; i < count; i++) {
            actions.sendKeys(Keys.DOWN).perform();
            Thread.sleep(500); // slight wait to simulate user interaction
        }
    }

	public static void pressUp(int count) throws InterruptedException {
        Actions actions = new Actions(driver);
        for (int i = 0; i < count; i++) {
            actions.sendKeys(Keys.UP).perform();
            Thread.sleep(500); // slight wait to simulate user interaction
        }
    }

	public void dropDowns(WebElement element, String type, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement until = wait.until(ExpectedConditions.visibilityOf(element));

		Select s = new Select(until);
		switch (type) {
		case "value":
			s.selectByValue(value);
			break;
		case "text":
			s.selectByVisibleText(value);
			break;
		case "index":
			s.selectByIndex(Integer.parseInt(value));
			break;
		}
	}

	public void wait_ScrollDown(WebElement e) {
		try {
			WebDriverWait waitclick = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement until = waitclick.until(ExpectedConditions.visibilityOf(e));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", until);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public static boolean enabled(WebElement button) {
		boolean enabled = false;
		try {
			enabled = button.isEnabled();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return enabled;
	}

	public boolean selected(WebElement text) {
		boolean selected = false;
		try {
			selected = text.isSelected();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return selected;

	}

    public static boolean displayed(WebElement button) {
		boolean displayed = false;
		try {
			displayed = button.isDisplayed();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return displayed;
	}

	public static void btnClick(WebElement element) {
		try {
			if (enabled(element) && displayed(element)) {
				element.click();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void wait_BtnClick(WebElement element) {
		WebDriverWait waitclick = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement until = waitclick.until(ExpectedConditions.visibilityOf(element));
		try {
			if (enabled(until) && displayed(until)) {
				until.click();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static WebDriver.TargetLocator switchToTargetElement() {
		WebDriver.TargetLocator switchTo = null;
		try {
			switchTo = driver.switchTo();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return switchTo;
	}

    public static Alert switchToAlert() {
		Alert al = null;
		try {
			al = switchToTargetElement().alert();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return al;
	}

	public void acceptAlert() {
		try {
			Alert al = switchToAlert();
			al.accept();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void mouseOver(WebElement e) {
		try {
			Actions ac = new Actions(driver);
			ac.moveToElement(e).perform();
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
	}

	public void dragAndDropAction(WebElement src, WebElement dest) {
		try {
			Actions ac = new Actions(driver);
			ac.dragAndDrop(src, dest).perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void rightClick(WebElement gmail) {
		try {
			Actions ac = new Actions(driver);
			ac.contextClick(gmail).perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void doubleClick(WebElement page) {
		try {
			Actions ac = new Actions(driver);
			ac.doubleClick(page).perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	protected WebElement visible(Object elementOrLocator, int value) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(value));
		if (elementOrLocator instanceof WebElement) {
			element = wait.until(ExpectedConditions.visibilityOf((WebElement) elementOrLocator));
		} else if (elementOrLocator instanceof By) {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementOrLocator));
		}
		return element;
	}

	    public static int randomNumber(int num) {
        Random random = new Random();
        int randomNum = random.nextInt(num);
        return randomNum;

    }

	public int getResponseCode(String url) {
    int responseCode = -1;
    try {
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");  // or "POST" if needed
        connection.connect();
        responseCode = connection.getResponseCode();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return responseCode;
}

	public static String randomString(int n) {
        String rand = RandomStringUtils.randomAlphabetic(n);
        return rand;
    }

	public static void takesScreenshot() throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File path = new File("C:\\Users\\aarulfrancis\\Desktop\\Screenshots\\React_Application\\Screenshots\\image.jpg");
        FileHandler.copy(src, path);
    }

    public static void takesScreenshot1() throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File path = new File("C:\\Users\\aarulfrancis\\Desktop\\Screenshots\\React_Application\\Screenshots\\name.png");
        FileHandler.copy(src, path);
    }

	public String getDataFromExcel(String sheet, int row, int cell) throws IOException {
		String value = null;
		try {
			File excelLoc = new File(
					"C:\\Users\\aarulfrancis\\React_Application\\Excel\\Felix.xlsx");
			FileInputStream stream = new FileInputStream(excelLoc);
			XSSFWorkbook w = new XSSFWorkbook(stream);
			XSSFSheet s = w.getSheet(sheet);
			Row r = s.getRow(row);
			Cell c = r.getCell(cell);
			int type = c.getCellType();
			if (type == 1) {
				value = c.getStringCellValue();
			}
			if (type == 0) {
				boolean b = DateUtil.isCellDateFormatted(c);
				if (b) {
					Date d = c.getDateCellValue();
					SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
					value = sim.format(d);
				} else {
					double d = c.getNumericCellValue();
					long l = (long) d;
					value = String.valueOf(l);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
	}    
}
