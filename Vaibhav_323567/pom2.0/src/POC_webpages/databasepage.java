package POC_webpages;

import java.util.ArrayList;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class databasepage {
WebDriver dr;
Logger log=Logger.getLogger("devpinoyLogger");




public  databasepage(WebDriver dr)
{
	super();
	this.dr=dr;
	
	   
	
}
public void create_log(String meth_name, String exp_res, String act_res, String test_res)
{
	if(test_res.equalsIgnoreCase("PASS"))
	{
		if(exp_res=="")
			log.info("Method "+ meth_name+" executed \n");
		else
			log.info("Method "+ meth_name+" executed \n"+"Expected Result: "+exp_res+"\n Actual Result: "+act_res+"\n Test Result: "+test_res);

	}
	else {
		if(exp_res=="")
			log.info("Method "+ meth_name+"\n");
		else
			log.info("Method "+ meth_name+"\n"+"Expected Result: "+exp_res+"\n Actual Result: "+act_res+"\n Test Result: "+test_res);
	}
}


	public String verify_Prod_name(int i)
	{
//		ArrayList<String> name=new ArrayList<String>();
		String name = "gm";
				
		if(i==1)
			name = dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td/table[2]/tbody/tr[1]/td[2]/b/a")).getText();
		
		 try {
			if(i==3) 
				name =	dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td/table[2]/tbody/tr[3]/td[2]/b/a")).getText();
			else if(i==5) 
				name =	dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td/table[2]/tbody/tr[5]/td[2]/b/a")).getText();
			else if(i==7) 
				name =	dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/b/a")).getText();
			else if(i==9) 
				name =	dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td/table[2]/tbody/tr[9]/td[2]/b/a")).getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return name;
		
			
	}

	public ArrayList<String> verify_Prod_price()
	{
		 ArrayList <WebElement> al = (ArrayList<WebElement>) dr.findElements(By.xpath("//*[@class='Row']/td[2]"));
		 ArrayList<String> price=new ArrayList<String>();
		 for(WebElement i: al)
		 {
			 int ind=i.getText().indexOf("$");
			
			
			price.add(i.getText().substring(ind+1));
			
		 }
		
		return price;
	}
//
//public String searchtable()
//{
//	String tablename=dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td[1]/form/table[1]/tbody/tr/th")).getText();
//	return tablename;
//}
//
//public String categories()
//{
//	String categories=dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td[1]/table[1]/tbody/tr/th")).getText();
//	return categories;
//}

}	
