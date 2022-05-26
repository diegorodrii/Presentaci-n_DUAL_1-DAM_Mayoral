import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class EntraMoodle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Beep Informatica\\Desktop\\Automatización\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://iescampanillas.com/aulavirtual/login/index.php"); 
		
		driver.findElement(By.id("username")).sendKeys("prueba");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("erroneo");
		Thread.sleep(1000);
		driver.findElement(By.id("loginbtn")).click();
		
		boolean existeElemento = driver.findElements(By.id("loginerrormessage")).size() != 0;
		
		if (existeElemento) {
			System.out.println("Usuario Erróneo");
				registraUsuario(driver);
				vuelveLogin(driver);
				
			} else {
				System.out.println("Usuario Correcto");
				
		}
		
	}
	
	public static void registraUsuario (WebDriver driver) throws InterruptedException{
		Thread.sleep(500);

		driver.findElement(By.xpath("//*[text()='Crear nueva cuenta']")).click();
		Thread.sleep(500);
		driver.findElement(By.id("id_username")).sendKeys("diegorodri");
		Thread.sleep(500);
		driver.findElement(By.id("id_password")).sendKeys("oafokajfjhahii");
		Thread.sleep(500);
		driver.findElement(By.id("id_email")).sendKeys("diego.rodriguez.fp@iescampanillas.com");
		Thread.sleep(500);
		driver.findElement(By.id("id_email2")).sendKeys("diego.rodriguez.fp@iescampanillas.com");
		Thread.sleep(500);
		driver.findElement(By.id("id_firstname")).sendKeys("Diego");
		Thread.sleep(500);
		driver.findElement(By.id("id_lastname")).sendKeys("Rodríguez Barcos");
		Thread.sleep(500);
		driver.findElement(By.id("id_city")).sendKeys("Córdoba");
		Thread.sleep(500);
		driver.findElement(By.xpath("//option[contains(text(),'España')]")).click();
		Thread.sleep(500); 
		
		System.out.println("Usuario Creado");
	}
	
	public static void vuelveLogin (WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("id_cancel")).click();
		driver.findElement(By.id("username")).sendKeys("diegorodri");
		Thread.sleep(500);
		driver.findElement(By.id("password")).sendKeys("@Prueba12345");
		Thread.sleep(500);
		driver.findElement(By.id("loginbtn")).click();
		
		System.out.println("Usuario Correcto");

		
	}

}
