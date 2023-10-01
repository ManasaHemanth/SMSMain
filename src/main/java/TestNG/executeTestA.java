package TestNG;

import org.testng.annotations.Test;

import com.SMS.genericutils.BaseClass;

public class executeTestA extends BaseClass {
	
@Test(groups="smoke")
public void create() {
	System.out.println("------Execute A------");
}
}
