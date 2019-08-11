package POC_testrunner;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
//import java.util.ArrayList;
//import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POC_webpages.databasepage;
import POC_webpages.homepage;

public class poc_testrunnerclass {
	WebDriver dr;
	int index1=1;
	int index2=0;
	homepage hp;
	Logger log=Logger.getLogger("devpinoyLogger");
  @BeforeClass
  public void f() {
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_v75.exe");
		   dr=new ChromeDriver();
		dr.get("http://examples.codecharge.com/Store/Default.php");
		
	  index1=1;
	  index2=0;
	   }
  
  @DataProvider(name="productprice")
  public Object[][] prod_price()
  {

	  return new Object[][] { { "39.99" }, { "39.99" },{"27.96"},{"39.99"},{"41.99"} };
  }
  
  @DataProvider(name="productname")
  public Object[][] prod_name()
  {
	  return new Object[][] { { "Web Database Development" }, { "MySQL" },{"MySQL and mSQL"},{"Beginning ASP Databases"},{"Oracle8i Web Development"} };
  }
  
  
  @Test(dataProvider="productname",priority=4)
  public void verify_prod_name(String exp_name)
  {
	  
	databasepage db=new  databasepage(dr);
	//  System.out.println(exp_name);
	  String actual_name =db.verify_Prod_name(index1);
	// System.out.println(actual_name);
	 // System.out.println(index1);
	  index1+=2;
	  if(exp_name.compareTo(actual_name)!=0)
		  db.create_log("Verify_prod_name",exp_name, actual_name,"fail");
	  
		
	 Assert.assertEquals(exp_name, actual_name);
	  db.create_log("Verify_prod_name",exp_name, actual_name,"pass"); 
	
  }
  
  @Test(dataProvider="productprice", priority = 5)
  public void verify_prod_price(String exp_price)
  {
	  databasepage db=new  databasepage(dr);
	
	  String actual_price =db.verify_Prod_price().get(index2);
	// System.out.println(actual_price);
	
	  if(exp_price.compareTo(actual_price)!=0)
		  db.create_log("Verify_prod_price",exp_price, actual_price,"fail");
	  Assert.assertEquals(exp_price, actual_price);
	  db.create_log("Verify_prod_price",exp_price, actual_price,"pass");
	  //System.out.println(index2);
	  index2++;
  }
  
  @Test(priority=1)
  public void verifytable1()
  
  {
	 
	  homepage hp=new homepage(dr);
	  String t = hp.searchtable();
	if(t.equals("Search Products"))
	{}
	  else
	  hp.create_log("verifytable1()"," Search Products",hp.searchtable(), "fail");
	  Assert.assertEquals(hp.searchtable(), "Search Products");
	  hp.create_log("verifytable1()"," Search Products", hp.searchtable(), "Pass");
  
  }
  
  @Test(priority=2)
  public void verifytable2()
  {	
	  homepage hp=new homepage(dr);
	  
	  if(hp.categories().equals("Categories"))
	  {}
	  else
		  hp.create_log("verifytable2"," Categories", hp.categories(), "fail");
	  Assert.assertEquals(hp.categories(), "Categories");
	  hp.create_log("verifytable1()","Categories", hp.categories(), "Pass");
	 
  
  }
  
  @Test(priority=3)
  public void changepage()
  {
	  dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td[1]/table[2]/tbody/tr[1]/td/a")).click();
	  
  }
  
  @AfterClass
  public void close()
  {
	  dr.close();
  }
}
