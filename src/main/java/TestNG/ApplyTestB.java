package TestNG;

import org.testng.annotations.Test;

import com.SMS.genericutils.BaseClass;

public class ApplyTestB extends BaseClass {
	@Test(groups="smoke")
	public void applyB() {
		System.out.println("------applyB-------");
	}
	@Test
	
	
	public void submit() {
		
		System.out.println("---success-----");
	}
	
	@Test
	
	public void Success() {
		System.out.println("----pass----");
	}
}
