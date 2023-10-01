package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Test2
{
	@DataProvider
	public Object[][] Mobile()
	{
	Object[][] obj=new Object[2][2];
			obj[0][0]="Samasung";
				obj[0][1]=5000;
				return obj;
			
	}
	@DataProvider
	public Object[][]tv()
	{
	Object[][] obj=new Object[2][3];
	obj[0][0]="LG";
	obj[0][1]=50000;
	obj[0][2]="45 inch";
	
	obj[1][0]="Sony Bravia";
	obj[1][1]=80000;
obj[1][2]="43 inch";
	return obj;
}
	@Test(dataProvider = "tv")
	public void ExecuteData(String product,int price,String size)
	{
		System.out.println(product+" "+price+" "+size);
		
	}
	
	
}
	
