//package Dupliacte;
//
//import java.time.Duration;
//
//import java.util.HashSet;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//
//
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class FOM_Step {
//	public WebDriver driver;
//	FOM_POM fp;
//	
//	
//	@Given("application url {string} is launched")
//	public void application_url_is_launched(String url) {
//		driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	   driver.get(url);
//	   fp = new FOM_POM(driver);
//	}
//
//	@When("Enter {string} in RMCS User ID field")
//	public void enter_in_rmcs_user_id_field(String userid) {
//	   driver.findElement(By.id("userid")).sendKeys(userid);
//	   
//	}
//
//	@When("Enter {string} in RMCS Password field")
//	public void enter_in_rmcs_password_field(String password) {
//	    driver.findElement(By.id("password")).sendKeys(password);
//	}
//
//	@When("Click on RMCS Login button")
//	public void click_on_rmcs_login_button() {
//		driver.findElement(By.xpath("//button[text()='Sign In ']")).click();
//		   
//	}
//
//	@Then("RMCS home page should be displayed")
//	public void rmcs_home_page_should_be_displayed() {
//	  driver.findElement(By.xpath("//a[@title='Oracle Logo Home']")).isDisplayed();
//	   
//	}@When("Click NavigationIcon")
//	public void click_navigation_icon() throws InterruptedException {
//		Thread.sleep(1000);
//	  driver.findElement(By.xpath("//a[@class='TabletNavigatorIcon svg-glob xko p_AFIconOnly']")).click();
//	   
//	}
//
//	@When("Click {string} link from Navigator")
//	public void click_link_from_navigator(String string) throws InterruptedException {
//	  fp.ClickOrderManagement();
//	  Thread.sleep(1000);
//	  fp.ClickOrderMgmt();
//	   
//	}
//
//	@When("Open {string}")
//	public void open(String Task) {
//		fp.openTasks(Task);
//	  
//	   
//	}
//
//	@When("Click  {string}")
//	public void click(String SubMenu) {
//		fp.clickOrderManagers(SubMenu);
//	  
//	   
//	}
//
//	@When("Enter {string} in Order Number input Field")
//	public void enter_in_order_number_input_field(String ordernum) {
//		fp.enterOrderNumber(ordernum);
//	  
//	   
//	}
//
//	@When("click  Search")
//	public void click() {
//		fp.clickSearch();
//	  
//	   
//	}
//
//	@When("Click  {string} link")
//	public void click_link(String orderNum) throws InterruptedException {
//		fp.clickOrderLink();
//		Thread.sleep(3000);
//	  
//	   
//	}
//	@When("open {string}")
//	public void openActions(String Tab) throws InterruptedException {
//		
//		fp.openActionsMenu(Tab);
//	    
//	}
//
//	@When("Click {string}")
//	public void clickSwitchToFulfillment(String SubMenu) {
//		fp.clickOrderManagers(SubMenu);
//	   
//	}
//
//	@Then("Validate Header Fields")
//	public void validate_header_fields(DataTable dataTable) {
//	    Map<String, String> expectedFields = new LinkedHashMap<>();
//	    for (List<String> row : dataTable.asLists()) {
//	        expectedFields.put(row.get(0).trim(), row.get(1).trim());
//	    }
//	    fp.validateHeaderFieldsWithValues
//	    (expectedFields);
//	}
//
//	@Then("click {string}")
//	public void clickTab(String tabname) {
//		fp.clickLinesTab(tabname);
//	 
//	}
//
//	@Then("Validate each order line All SKUS are displayed")
//	public void validate_each_order_line_all_skus_are_displayed(io.cucumber.datatable.DataTable dataTable) {
//	    
//		List<String> fieldHeaders = dataTable.asList();
//	    fp.verifyOrderLineFieldsDisplayed(fieldHeaders);
//	    
//	}
//
//
//	@Then("Validate Each Item under Fulfillment Line")
//	public void validate_each_item_under_fulfillment_line(DataTable dataTable) {
//		List<String> fieldHeaders = dataTable.asList();
//	    fp.verifyOrderLineFieldsDisplayed(fieldHeaders);
//	   
//	}
//
//	@Then("Validate General Tab fields")
//	public void validate_general_tab_fields(DataTable dataTable) {
//		 Map<String, String> expectedfields = new LinkedHashMap<>();
//		 for(List<String> row : dataTable.asLists()) {
//			 expectedfields.put(row.get(0).trim(), row.get(1).trim());
//		 }
//		 fp.validateEachFulfillmentLineGeneralTabFields(expectedfields);
//	   
//	}
//
//	@When("Click {string} process Number")
//	public void click_process_number(String string) {
//		fp.clickOrchestrationProcess();
//	   
//	}
//
//	
////
////	@Then("Click Done Button")
////	public void click_done_button() {
////	  fp.clickDone();
////	   
////	}
//
//	@Then("Order Details page should be displayed")
//	public void order_details_page_should_be_displayed() {
//	  
//	   
//	}
//	@Then("Validate Each Order Line Details")
//	public void validate_each_order_line_details() {
//	    // Example logic: validate table is visible or values are loaded
//	    Assert.assertTrue(driver.findElement(By.xpath("//table[@summary='Order Lines']")).isDisplayed(), "Order Lines table not displayed.");
//	    System.out.println("Order Line details validated.");
//}
//
//	@When("Click Each line under {string}")
//	public void click_each_line_under(String section) {
//	    // Expand all lines under Fulfillment Lines section
//	    if (section.equalsIgnoreCase("Fulfillment Lines")) {
//	        Set<String> expandedRows = new HashSet<>();
//	        By fulfillmentRows = By.xpath("//table[@summary='Fulfillment Lines']/tbody/tr");
//	        fp.expandAllRowsRecursive(fulfillmentRows, expandedRows);
//	    }
//	}
//
//	@Then("validate Assert Management  task progress should be completed")
//	public void validate_assert_management_task_progress_should_be_completed() {
//	    WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Assert Management')]/ancestor::tr//span[text()='Completed']"));
//	    Assert.assertTrue(element.isDisplayed(), "Assert Management task is not completed.");
//	    System.out.println("Assert Management task completed.");
//	}
//
//	@Then("Subscription task progress should be completed")
//	public void subscription_task_progress_should_be_completed() {
//	    WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Subscription')]/ancestor::tr//span[text()='Completed']"));
//	    Assert.assertTrue(element.isDisplayed(), "Subscription task is not completed.");
//	    System.out.println("Subscription task completed.");
//	}
//	
//
//	@Then("Click Done Button")
//	public void click_done_button() {
//	    WebElement doneBtn = driver.findElement(By.xpath("//button[text()='Done']"));
//	    Assert.assertTrue(doneBtn.isDisplayed(), "'Done' button not found.");
//	    doneBtn.click();
//	    System.out.println("Clicked on Done button.");
//	}
//
//	@Then("Fulfillment Line Should be displayed")
//	public void fulfillment_line_should_be_displayed() {
//	    WebElement line = driver.findElement(By.xpath("//a[contains(@title, 'Fulfillment Lines')]"));
//	    Assert.assertTrue(line.isDisplayed(), "Fulfillment Line is not displayed.");
//	    System.out.println("Fulfillment Line is displayed.");
//	}
//
//}
