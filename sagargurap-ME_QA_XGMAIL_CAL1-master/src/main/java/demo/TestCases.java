package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.INFO);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Connect to the chrome-window running on debugging port
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        //driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01()throws InterruptedException {
        System.out.println("Start Test case: testCase01");
        driver.get("https://calendar.google.com/");
        Thread.sleep(10000);
        String url = driver.getCurrentUrl();
        if(url.contains("calendar.")){
            System.out.println("The URL of the Calendar homepage contains 'calendar'.");
        }
        else{
            System.out.println("The URL of the Calendar homepage does not contains 'calendar'.");
        }
        System.out.println("end Test case: testCase01");
    }

    public  void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        driver.get("https://calendar.google.com/");
        Thread.sleep(5000);
        WebElement viewButton = driver.findElement(By.xpath("//button[@jsname='jnPWCc']"));
        viewButton.click();
        Thread.sleep(10000);
        WebElement monthView = driver.findElement(By.xpath("//li[@data-accelerator='M']"));
        monthView.click();
        WebElement checkview = driver.findElement(By.xpath("(//button/span[@class='VfPpkd-vQzf8d'])[5]"));
        String value = checkview.getText();
        Thread.sleep(3000);
        if(value.contains("Month")){
            System.out.println("The calendar is in the month view");
        }
        else{
            System.out.println("The calendar is not in the month view");
        }
        WebElement datereq = driver.findElement(By.xpath("//div[@data-datekey='27802']"));
        datereq.click();
        Thread.sleep(5000);
        WebElement taskTab = driver.findElement(By.xpath("//button[@class='nUt0vb zmrbhe']"));
        taskTab.click();
        WebElement title = driver.findElement(By.xpath("//input[@placeholder='Add title and time']"));
        title.sendKeys("Crio INTV Task Automation");
        WebElement description = driver.findElement(By.xpath("//textarea[@placeholder='Add description']"));
        description.click();
        description.sendKeys("Crio INTV Calendar Task Automation");
        Thread.sleep(5000);
        WebElement save = driver.findElement(By.xpath("//button[@jsname='x8hlje']"));
        save.click();


        System.out.println("end Test case: testCase02");
        Thread.sleep(10000);
    }
  
   
    public  void testCase03()throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        driver.get("https://calendar.google.com/");
        Thread.sleep(10000);
        WebElement task = driver.findElement(By.xpath("//div [@class='KF4T6b jKgTF QGRmIf']"));
        task.click();
        Thread.sleep(5000);
        WebElement editTask = driver.findElement(By.xpath("//button[@aria-label='Edit task']"));
        editTask.click();

        WebElement description = driver.findElement(By.xpath("//textarea[@placeholder='Add description']"));
        description.click();
        description.clear();
        description.sendKeys("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");
        WebElement save = driver.findElement(By.xpath("//span[text()='Save']"));
        save.click();
        Thread.sleep(10000);
        WebElement tasks = driver.findElement(By.xpath("//div [@class='KF4T6b jKgTF QGRmIf']"));
        tasks.click();
        Thread.sleep(5000);
        WebElement desCheck = driver.findElement(By.xpath("//div[@class='toUqff D29CYb']"));
        String checkdata = desCheck.getText();
        System.out.println(checkdata);
        if(checkdata.contains("Crio INTV Task Automation is a test suite designed")){
            System.out.println("The task description is successfully updated and displayed.");
        }
        else{
           System.out.println("The task description is not successfully updated and displayed."); 
        }

        System.out.println("end Test case: testCase03");
    }

    public  void testCase04()throws InterruptedException{
        System.out.println("Start Test case: testCase04");
        driver.get("https://calendar.google.com/");
        Thread.sleep(10000);
        WebElement task = driver.findElement(By.xpath("//div [@class='KF4T6b jKgTF QGRmIf']"));
        task.click();
        Thread.sleep(5000);
        WebElement title = driver.findElement(By.xpath("//span[@id='rAECCd']"));
        String titleTxt = title.getText();
        System.out.println(titleTxt);
        if(titleTxt.contains("Crio INTV Task Automation")){
            System.out.println("Title of the task verified");
        }
        else{
            System.out.println("Title of the task is unverified");
        }
        WebElement delTask = driver.findElement(By.xpath("//button[@aria-label='Delete task']"));
        delTask.click();
        WebElement alertMessage = driver.findElement(By.xpath("//div[@class='VYTiVb']"));
            if (alertMessage.isDisplayed()) {
                if (alertMessage.getText().equals("Task deleted")) {
            
            System.out.println("The task is successfully deleted, and the confirmation message indicates 'Task deleted'");
        
        }
    }
        System.out.println("end Test case: testCase04");

}
}