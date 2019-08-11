package POC_webpages;

//import java.util.ArrayList;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;


public class homepage {
WebDriver dr;
//Logger log;

Logger log=Logger.getLogger("devpinoyLogger");


public  homepage(WebDriver dr)
{
	
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

public String searchtable()
{
	String tablename=dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td[1]/form/table[1]/tbody/tr/th")).getText();
	return tablename;
}

public String categories()
{
	String categories=dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td[1]/table[1]/tbody/tr/th")).getText().trim();
	return categories;
}

}	
