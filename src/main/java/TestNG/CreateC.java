package TestNG;

import org.testng.annotations.Test;

import com.SMS.genericutils.BaseClass;

public class CreateC extends BaseClass {
	@Test(groups={"smoke","regression"})
public void createC() {
	System.out.println("-----crateC----");
}
}
