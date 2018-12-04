import helper.Dictionary;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MarathonTests {

    @Test
    @Parameters({"Language"})
    public void negativeLogin(@Optional String lan) {
        System.setProperty("webdriver.chrome.driver","d:\\Андрюха\\automation\\test1\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // driver.manage().window().maximize();
        if (lan ==null){
            lan="en";
        }

        String url = "https://www.marathonbet.com/" + lan + "/";


        driver.get(url);

        driver.findElement(By.id("auth_login")).sendKeys("Hellojh");
        driver.findElement(By.id("auth_login")).sendKeys(Keys.TAB);
        driver.findElement(By.id("auth_login_password")).sendKeys("hi");
        driver.findElement(By.className("login-pass")).findElement(By.className("btn-login")).click();

        String actualMessage = driver.findElement(By.id("any_message")).findElement(By.tagName("p")).getText();
//        Dictionary dictionary = new Dictionary();
//        String realMessage = dictionary.getTransaltionForDoesntMeetReq(lan);
        String realMessage = Dictionary.getTransaltionForDoesntMeetReq(lan);

//        Assert.assertEquals(actualMessage, "The password does not meet the requirements");
        String infoMessage = String.format("The message should be '%s'", realMessage);
        Assert.assertEquals(actualMessage, realMessage, infoMessage);

        driver.quit();

    }
}
