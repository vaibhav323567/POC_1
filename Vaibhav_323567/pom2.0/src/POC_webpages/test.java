package POC_webpages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver dr;
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_v75.exe");
		   dr=new ChromeDriver();
		dr.get("http://examples.codecharge.com/Store/Products.php?category_id=2");
		
		ArrayList<String> name=new ArrayList<String>();
		name.add(dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td/table[2]/tbody/tr[1]/td[2]/b/a")).getText());
		name.add(dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td/table[2]/tbody/tr[3]/td[2]/b/a")).getText());
		name.add(dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td/table[2]/tbody/tr[5]/td[2]/b/a")).getText());
		name.add(dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/b/a")).getText());
		name.add(dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td/table[2]/tbody/tr[9]/td[2]/b/a")).getText());
		
		System.out.println(name.get(2));

	}

}
