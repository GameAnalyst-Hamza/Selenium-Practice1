package myTestProject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class main {

  public static void main(String[] args) throws InterruptedException {
    System.setProperty(
      "webdriver.chrome.driver",
      "C:\\Users\\Hamza\\Desktop\\chromedriver_win32\\chromedriver.exe"
    );
    WebDriver driver = new ChromeDriver();
    Duration timeout = Duration.ofSeconds(10);
    WebDriverWait wait = new WebDriverWait(driver, timeout);

    driver.get("https://cloud.openshot.org/apps/simple-editor/login");

    LoginPage loginPg = new LoginPage(driver, wait);

    loginPg.login();
    String verifyLogin = driver
      .findElement(By.xpath("//*[@id=\"app\"]/header/nav/div/a"))
      .getText();
    if (verifyLogin.contains("Simple Editor")) System.out.println("Logged In");

    loginPg.logout();
    String url = driver.getCurrentUrl();
    if (url.contains("/login")) System.out.println("Logged Out");

    driver.quit();
  }
}