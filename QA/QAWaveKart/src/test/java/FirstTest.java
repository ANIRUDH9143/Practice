import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class FirstTest {

    private WebDriver webDriver;

    @Test
    public void searchProduct() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anirudhg\\Downloass\\chromedriver_win32(1)\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        webDriver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/Main");
        webDriver.findElement(By.xpath("//input[@name='productSearch']")).sendKeys("Sony CyberShot DSC-W810 Point & Shoot");
        WebElement button = webDriver.findElement(By.xpath("//button[@title='Search']"));
        try {button.sendKeys(Keys.ENTER);}
        catch(Exception e) {button.sendKeys(Keys.ENTER);}
        webDriver.quit();
    }

    @Test(description = "On clicking WaveKart logo, is it redirecting to Home Page or not")
    public void logoRedirect() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anirudhg\\Downloass\\chromedriver_win32(1)\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        webDriver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/Main");
        WebElement button = webDriver.findElement(By.xpath("//a[@name='ProductsPage']"));
        try{button.click();}
        catch(Exception e){webDriver.findElement(By.xpath("//a[@name='ProductsPage']")).click();}
        WebElement logo = webDriver.findElement(By.xpath("//img[@name='AppLogo']"));
        try{logo.click();}
        catch (Exception e){webDriver.findElement(By.xpath("//img[@name='AppLogo']")).click();}
        webDriver.quit();
        }

    @Test(description = "On clicking \"low to high\", are the products are in ascending order or not")
    public void lowToHigh() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anirudhg\\Downloass\\chromedriver_win32(1)\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/Main");
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//a[@name='ProductsPage']")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//a[@title='Price - Low to High']")).click();
        Thread.sleep(2000);
        webDriver.quit();
    }

    @Test(description = "On clicking \"high to low\", are the products are in descending order or not")
    public void highToLow() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anirudhg\\Downloass\\chromedriver_win32(1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/Main");
        WebElement button = driver.findElement(By.xpath("//a[@aria-label='All Products']"));
        try{button.click();}
        catch(org.openqa.selenium.StaleElementReferenceException ex){driver.findElement(By.xpath("//a[@aria-label='All Products']")).click();}
        WebElement button2 = driver.findElement(By.xpath("//a[@title='Price - High to Low']"));
        try{button2.click();}
        catch(org.openqa.selenium.StaleElementReferenceException ex) {driver.findElement(By.xpath("//a[@title='Price - High to Low']")).click();}
        driver.quit();
    }

    @Test(description = "In \"Hot Picks\" section, on clicking a category, are they redirecting or not")
    public void camPhoto() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anirudhg\\Downloass\\chromedriver_win32(1)\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        webDriver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/Main");
        try{webDriver.findElement(By.xpath("//img[@name='picture_Cameras1']")).click();}
        catch(Exception e){webDriver.findElement(By.xpath("//img[@name='picture_Cameras1']")).click();}
        webDriver.quit();
    }
    @Test(description = "On clicking \"include out of stock\" checkbox, is it showing the out of stock products are not ")
    public void outOfStock() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anirudhg\\Downloass\\chromedriver_win32(1)\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        webDriver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/Main");
        WebElement button = webDriver.findElement(By.xpath("//a[@name='ProductsPage']"));
        try{button.click();}
        catch(Exception e){webDriver.findElement(By.xpath("//a[@name='ProductsPage']")).click();}
        WebElement button2 = webDriver.findElement(By.xpath("//span[@class='caption']"));
        try{button2.click();}
        catch(Exception e){button2.click();}
        webDriver.quit();

    }

    @Test(description = "Login credentials check")
    public void loginAdmin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anirudhg\\Downloass\\chromedriver_win32(1)\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        webDriver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/Main");
        WebElement element = webDriver.findElement(By.xpath("//a[@caption='Login']"));
        try{element.click();}
        catch(Exception e){webDriver.findElement(By.xpath("//a[@caption='Login']")).click();}
        webDriver.findElement(By.xpath("//input[@name='j_username']")).sendKeys("admin");
        webDriver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("admin");
        WebElement button = webDriver.findElement(By.xpath("//button[@name='loginbutton']"));
        try{button.click();}
        catch (Exception e){button.click();}
        webDriver.quit();
    }

    @Test(description = "Search by admin")
    public void searchProductAdmin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anirudhg\\Downloass\\chromedriver_win32(1)\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        webDriver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/Main");
        webDriver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/Main");
        WebElement element = webDriver.findElement(By.xpath("//a[@caption='Login']"));
        try{element.click();}
        catch(Exception e){webDriver.findElement(By.xpath("//a[@caption='Login']")).click();}
        webDriver.findElement(By.xpath("//input[@name='j_username']")).sendKeys("admin");
        webDriver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("admin");
        WebElement button = webDriver.findElement(By.xpath("//button[@name='loginbutton']"));
        try{button.click();}
        catch (Exception e){button.click();}
        WebElement button2 = webDriver.findElement(By.xpath("//input[@data-element='dgSearchText']"));
        try{button2.sendKeys("Smartphones");}
        catch (Exception e){webDriver.findElement(By.xpath("//input[@data-element='dgSearchText']")).sendKeys("Smartphones");}

        Select Field= new Select(webDriver.findElement(By.xpath("//select[@name='wm-datatable']")));
        try{Field.selectByVisibleText("Category");}
        catch (Exception e){Field.selectByVisibleText("Category");}

        WebElement button3 = webDriver.findElement(By.xpath("//button[@data-element='dgSearchButton']"));
        try{button3.click();}
        catch (Exception e){webDriver.findElement(By.xpath("//button[@data-element='dgSearchButton']")).click();}
        webDriver.quit();
    }

    @Test(description = "new product added by admin")
    public void newProduct() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anirudhg\\Downloass\\chromedriver_win32(1)\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        webDriver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/Main");
        webDriver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/Main");
        WebElement element = webDriver.findElement(By.xpath("//a[@caption='Login']"));
        try{element.click();}
        catch(Exception e){webDriver.findElement(By.xpath("//a[@caption='Login']")).click();}
        webDriver.findElement(By.xpath("//input[@name='j_username']")).sendKeys("admin");
        webDriver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("admin");
        WebElement button = webDriver.findElement(By.xpath("//button[@name='loginbutton']"));
        try{button.click();}
        catch (Exception e){button.click();}
        WebElement button1 = webDriver.findElement(By.xpath("//div[@class='panel-actions app-datagrid-actions']/button[@title='New']"));
        try{button1.click();}
        catch (Exception e){button1.click();}
        WebElement element1 = webDriver.findElement(By.xpath("//input[@name='productName_formWidget']"));element1.clear();
        element1.sendKeys("Jawa 42");
        WebElement element2=webDriver.findElement(By.xpath("//input[@name='productDescription_formWidget']"));element2.clear();
        element2.sendKeys("It's a nice Bike. You can order right away");
        WebElement element3=webDriver.findElement(By.xpath("//input[@name='category_formWidget']"));element3.clear();
        element3.sendKeys("Bike");
        WebElement element4=webDriver.findElement(By.xpath("//input[@name='imageUrl_formWidget']"));element4.clear();
        element4.sendKeys("https://images.news18.com/ibnlive/uploads/2021/03/1615465552_jawa-42.png?impolicy=website&width=510&height=356");
        WebElement element5 =webDriver.findElement(By.xpath("//input[@name='price_formWidget']"));element5.clear();
        element5.sendKeys("220000");
        WebElement button2 = webDriver.findElement(By.xpath("//button[@class='btn app-button form-save btn-success']"));
        try{button2.click();}
        catch (Exception e){button2.click();}
        webDriver.quit();
    }

    @Test(description = "order by a user")
    public void order() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anirudhg\\Downloass\\chromedriver_win32(1)\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        webDriver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/Main");
        webDriver.findElement(By.xpath("//input[@name='productSearch']")).sendKeys("Moto G (Black, with 8 GB)");
        WebElement button = webDriver.findElement(By.xpath("//span[@aria-label='search icon']"));
        try{button.click();}
        catch (Exception e){webDriver.findElement(By.xpath("//span[@aria-label='search icon']")).click();}
        webDriver.findElement(By.xpath("//button[@name='AddToCart']")).click();
        webDriver.findElement(By.xpath("//input[@name='j_username']")).sendKeys("user");
        webDriver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("user");
        webDriver.findElement(By.xpath("//button[@name='loginbutton']")).click();
        webDriver.findElement(By.xpath("//button[@widget-id='widget-id302']")).click();
        webDriver.findElement(By.xpath("//button[@name='nextBtn_wizard_payment']")).click();
        webDriver.findElement(By.xpath("//div[@widget-id='widget-id431']")).click();
        webDriver.findElement(By.xpath("//button[@name='nextBtn_wizard_payment']")).click();
        webDriver.findElement(By.xpath("//i[@class='app-icon wi wi-chevron-right']")).click();
        webDriver.findElement(By.xpath("//button[@name='doneBtn_wizard_payment']")).click();
        webDriver.quit();
    }
}
