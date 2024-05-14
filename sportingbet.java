package Practiceprograms.test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class sportingbet {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sindh\\IdeaProjects\\NIT-730AM-Oct2023\\chromedriver.exe");

        // Create a new instance of ChromeDriver
        ChromeDriver driver = new ChromeDriver();

        try {
            driver.get("https://sports.sportingbet.com/en/sports");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            Wait wait = new WebDriverWait(driver, 100);
//            Testcase to accept cookies
            WebElement acceptCookiesButton = driver.findElement(By.xpath("//button[contains(text(),'Accept All Cookies')]"));
            if (acceptCookiesButton.isDisplayed()) {
                acceptCookiesButton.click();
            } else {
                System.out.println("No cookies found");
            }
//            Testcase to validate the navigation to casino tab
            WebElement casino = driver.findElement(By.xpath("//a[contains(@href, 'casino.sportingbet.com')]"));
            wait.until(ExpectedConditions.elementToBeClickable(casino));
            casino.click();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the input URL: ");
            String inp = sc.nextLine();
            printcatlist(driver, inp);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    public static void printcatlist(WebDriver driver, String url) throws InterruptedException {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Wait wait = new WebDriverWait(driver, 100);

        Thread.sleep(5000);
        //Test case to validate the lazy loading instance by scrolling to end of the page
        Actions actions = new Actions(driver);
        for (int i = 0; i < 8; i++) {
            actions.sendKeys(Keys.END).perform();
            Thread.sleep(2000);
        }
        //Test case to identify and print the list of categories in casino tab web page
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("title-uk")));
        List<WebElement> categorylist = driver.findElements(By.className("title-uk"));
        System.out.println("List of categories in current page: ");

        for (WebElement categories : categorylist) {
            System.out.println(categories.getText());
        }
        //Testcase to verify the playhere button status
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        List<WebElement> playhere = driver.findElements(By.xpath("//div[@class = 'casino-game-cls casino-livecasino-api-enabled']"));
        System.out.println("The Play Her button display status: ");
        Actions actions1 = new Actions(driver);
        for (WebElement playherebutton : playhere) {
//                System.out.println(playherebutton);
            actions1.moveToElement(playherebutton).perform();
            if (playherebutton.isDisplayed()) {
                System.out.println("Play here text is displayed");
            } else {
                System.out.println("Test Failed");
            }
        }
    }
}

