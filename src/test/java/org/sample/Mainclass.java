package org.sample;

import org.openqa.selenium.WebElement;

public class Mainclass extends BaseClass{
	public static void main(String[] args) {
		BaseClass b = new BaseClass();
		b.getDriver("chrome");
		b.getUrl("https://www.facebook.com/");
		WebElement txtuser = b.findLocators("id", "email");
		b.giveSendkeys(txtuser, "gayu");
		WebElement txtpass = b.findLocators("id", "pass");
		b.giveSendkeys(txtpass, "Gayu@1999");
	    WebElement logiN = b.findLocators("name", "login");
	    b.clickOption(logiN);
	    WebElement text = b.findLocators("xpath", "//h2[@class='_8eso']");
	    b.getTextoption(text);
	    b.quitOption();
//	    b.getCurrentUrl(logiN, null);
	    
	
		
		
	}
}
