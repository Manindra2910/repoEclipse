package gitProj;

import java.util.List;
import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class gitClass {//https://freelance-learn-automation.vercel.app/login

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		
		Locator allLocators = page.locator("//div[@class='container-child']//a");
		
		for(int l=0;l<allLocators.count();l++) {
			allLocators.nth(l).click();
		}
		
		List<Page> allPages = context.pages();
		
		for(Page p:allPages) {
			if(p.title().equalsIgnoreCase("Facebook")) {
				p.bringToFront();
				p.locator(null);
			}
		}
		
		
		
		
		
		
		
		
		
		//Actual wait & Pause
		//page.waitForTimeout(3000);
		//page.pause();
		
//		//Navigate		
//		page.navigate("https://practice.expandtesting.com/dropdown");
//		
//		//Handling drop downs
//		page.locator("#dropdown").selectOption("Option2");
//		page.locator("#elementsPerPageSelect").selectOption("100");
//		
//		//Assertions
//		page.navigate("https://www.google.com/");
//		
//		//page level assertion
//		PlaywrightAssertions.assertThat(page).hasTitle("Google");
//		
//		//webElement level assertion
//		PlaywrightAssertions.assertThat(page.locator("a[aria-label='Gmail ']")).containsText("Gmail");
		
		page.navigate("https://www.google.com");
		page.locator("#APjFqb").fill("Mukesh Otwani");
		
		Locator locator = page.locator("//div[@class='erkvQe']//ul[@role='listbox']/li");
		
		int lCnt = locator.count();
		
		for(int i=0;i<lCnt;i++) {
			String listEle = locator.nth(i).innerText();
			if(listEle.equalsIgnoreCase("playwright"))
				locator.nth(i).click();
		}
		
		
		
		
	}

}
