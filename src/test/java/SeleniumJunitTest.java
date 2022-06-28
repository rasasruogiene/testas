import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SeleniumJunitTest {

    public WebDriver driver;

    public void invokeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://kitm.epizy.com/filmai.php?i=1");

    }
        //Testas:sekmingas nujo iraso kurimas
    @Test
    public void getCorrectInput() throws InterruptedException {
        invokeDriver();

        driver.findElement(By.xpath("//body[1]/div[1]/form[1]/input[2]")).sendKeys("Titanikas");
        driver.findElement(By.xpath("//body[1]/div[1]/form[1]/input[3]")).sendKeys("Drama");
        driver.findElement(By.xpath("//body[1]/div[1]/form[1]/input[4]")).sendKeys("L.Dicaprio");
        driver.findElement(By.xpath("//body[1]/div[1]/form[1]/input[5]")).sendKeys("J.Cameronas");
        driver.findElement(By.xpath("//body[1]/div[1]/form[1]/input[6]")).sendKeys("200");
        driver.findElement(By.xpath("//button[contains(text(),'Siųsti')]")).click();
        Thread.sleep(1000);

        String greenMessage = driver.findElement(By.xpath("//div[contains(text(),'Duomenys įrašyti sėkmingai')]")).getText();

        if (greenMessage.contains("sėkmingai")){
            System.out.println(" Test passed,input is correct " + greenMessage);
        }else {
            System.out.println("Test failed,input is incorrect");
        }
        driver.quit();
    }
        //Testas:nesekmingo iraso kurimas
    @Test
    public void getIncorrectInput() throws InterruptedException {
        invokeDriver();

        driver.findElement(By.xpath("//body[1]/div[1]/form[1]/input[2]")).sendKeys("Titanikas");
        driver.findElement(By.xpath("//body[1]/div[1]/form[1]/input[3]")).sendKeys("Drama");
        driver.findElement(By.xpath("//body[1]/div[1]/form[1]/input[4]")).sendKeys("L.Dicaprio");
        driver.findElement(By.xpath("//body[1]/div[1]/form[1]/input[5]")).sendKeys("200");
        driver.findElement(By.xpath("//body[1]/div[1]/form[1]/input[6]")).sendKeys("200");
        driver.findElement(By.xpath("//button[contains(text(),'Siųsti')]")).click();
        Thread.sleep(1000);

        String errorMessage = driver.findElement(By.className("msg-bad")).getText();

        if (errorMessage.contains("klaida")){
            System.out.println("Test passed,does not process with incorrect data");
        }else {
            System.out.println("Test failed,proceed with incorrect data");
        }
        driver.quit();

    }
        //Testas:iraso trynimas
    @Test
    public void correctInputDelete() throws InterruptedException {
        invokeDriver();

        driver.findElement(By.xpath("//body[1]/div[1]/form[1]/input[1]")).sendKeys("959");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Trinti')]")).click();
        Thread.sleep(2000);

        String greenMessage = driver.findElement(By.xpath("//div[contains(text(),'Įrašas ištrintas sėkmingai')]")).getText();

        if (greenMessage.contains("sėkmingai")){
            System.out.println(" Test passed,data deleted successfully ");
        }else {
            System.out.println("Test failed,input is not deleted");
        }

        driver.quit();

    }
        //Testas:sekmingas iraso koregavimas
    @Test
    public void getCorrectEdit() throws InterruptedException {
        invokeDriver();

        driver.findElement(By.xpath("//body[1]/div[1]/form[1]/input[1]")).sendKeys("978");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body[1]/div[1]/form[1]/input[2]")).sendKeys("Spiderman");
        Thread.sleep(100);
        driver.findElement(By.xpath("//body[1]/div[1]/form[1]/input[3]")).sendKeys("Action");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body[1]/div[1]/form[1]/input[4]")).sendKeys("T.Holand");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body[1]/div[1]/form[1]/input[5]")).sendKeys("S.Raimi");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body[1]/div[1]/form[1]/input[6]")).sendKeys("130");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Redaguoti')]")).click();

        String greenMessage = driver.findElement(By.xpath("//div[contains(text(),'Įrašas paredaguotas sėkmingai')]")).getText();
        if(greenMessage.contains("sėkmingai")) {
            System.out.println("Test passed,data edited successfully");
        }else {
            System.out.println("Test failed,data edited unsuccessfully");
        }
        driver.quit();
    }
    //Testas:nesekmingas iraso koregavimas
    @Test
    public void getIncorrectEdit() throws InterruptedException {
        invokeDriver();

        driver.findElement(By.xpath("//body[1]/div[1]/form[1]/input[1]")).sendKeys("500");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body[1]/div[1]/form[1]/input[2]")).sendKeys("Spiderman");
        Thread.sleep(100);
        driver.findElement(By.xpath("//body[1]/div[1]/form[1]/input[3]")).sendKeys("Action");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body[1]/div[1]/form[1]/input[4]")).sendKeys("T.Holand");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body[1]/div[1]/form[1]/input[5]")).sendKeys("130");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body[1]/div[1]/form[1]/input[6]")).sendKeys("130");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Redaguoti')]")).click();
        Thread.sleep(1000);

        String errorMessage = driver.findElement(By.className("msg-bad")).getText();

        if (errorMessage.contains("klaida")){
            System.out.println("Test passed,does not process with incorrect data");
        }else {
            System.out.println("Test failed,proceed with incorrect data");
        }
        driver.quit();

    }
}