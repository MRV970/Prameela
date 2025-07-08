package StepFiles;

import java.time.Duration;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import POM.POM;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	
public WebDriver driver;
   POM pom = new POM(driver);

   @Given("application url {string} is launched")
	public void application_url_is_launched(String url) {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   driver.get(url);
	   pom = new POM(driver);
	}

	@When("Enter {string} in RMCS User ID field")
	public void enter_in_rmcs_user_id_field(String userid) {
	   driver.findElement(By.id("userid")).sendKeys(userid);
	   
	}

	@When("Enter {string} in RMCS Password field")
	public void enter_in_rmcs_password_field(String password) {
	    driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("Click on RMCS Login button")
	public void click_on_rmcs_login_button() {
		driver.findElement(By.xpath("//button[text()='Sign In ']")).click();
		   
	}
    @Then("RMCS home page should be displayed")
    public void home_page_displayed() {
        // Optional assertion can be added
    }

    @When("Click NavigationIcon")
    public void click_navigation_icon() {
        pom.clickNavigationIcon();
    }

    @When("Click {string} link from Navigator")
    public void click_link_from_navigator(String linkText) {
        pom.clickLink(linkText);
        pom.ClickOrderMgmt();
    }

    @And("Open {string}")
    public void open_tasks(String tabName) {
        pom.openTasks();
    }

    @And("Click  {string}")
    public void click_manage_orders(String option) {
        pom.clickOrderManagers(option);
    }

    @And("Enter {string} in Order Number input Field")
    public void enter_order_number(String number) {
        pom.enterOrderNumber(number);
    }

    @And("click  Search")
    public void click_search() {
        pom.clickSearch();
    }

    @And("Click  {string} link")
    public void click_order_link(String orderNum) throws InterruptedException {
        pom.clickOrderLink(orderNum);
        Thread.sleep(3000);
        
    }

    @And("open {string}")
    public void open_actions(String actions) {
        pom.openActions();
    }

	@When("Click {string}")
	public void clickSwitchToFulfillment(String SubMenu) {
		pom.clickOrderManagers(SubMenu);
	   
	}

    @Then("Validate Header Fields")
    public void validate_header_fields(DataTable table) {
        Map<String, String> fields = table.asMap(String.class, String.class);
        pom.validateHeaderFieldsWithValues(fields);
    }

    @And("click {string}")
    public void click_tab(String tabName) {
        pom.clickTab(tabName);
    }
    
   
    @Then("Validate each order line All SKUS are displayed")
	public void validate_each_order_line_all_skus_are_displayed(io.cucumber.datatable.DataTable dataTable) {
	    
		List<String> fieldHeaders = dataTable.asList();
	    pom.verifyOrderLineFieldsDisplayed(fieldHeaders);
	    
	    
	}
  

	@Then("Validate Each Item under Fulfillment Line")
	public void validate_each_item_under_fulfillment_line(DataTable dataTable) {
		List<String> fieldHeaders = dataTable.asList();
	    pom.verifyOrderLineFieldsDisplayed(fieldHeaders);
	   
	}
	  @And("click on {string}")
	    public void clickLinesTab(String tabName) {
	        pom.clickTab(tabName);
	    }

	@Then("Validate General Tab fields")
	public void validate_general_tab_fields(DataTable dataTable) {
		 Map<String, String> expectedfields = new LinkedHashMap<>();
		 for(List<String> row : dataTable.asLists()) {
			 expectedfields.put(row.get(0).trim(), row.get(1).trim());
		 }
		 pom.validateEachFulfillmentLineGeneralTabFields(expectedfields);
	   
	}

	@When("Click {string} process Number")
	public void click_process_number(String string) {
		pom.clickOrchestrationProcess();
	   
	}

	

//	@Then("Click Done Button")
//	public void click_done_button() {
//	  pom.clickDone();
//	   
//	}

	@Then("Order Details page should be displayed")
	public void order_details_page_should_be_displayed(String Tab) {
	  pom.clickLinesTab(Tab);
	   
	}
	@Then("Validate Each Order Line Details")
	public void validate_each_order_line_details() {
	    // Example logic: validate table is visible or values are loaded
	    Assert.assertTrue(driver.findElement(By.xpath("//table[@summary='Order Lines']")).isDisplayed(), "Order Lines table not displayed.");
	    System.out.println("Order Line details validated.");
}

	@When("Click Each line under {string}")
	public void click_each_line_under(String section) {
	    // Expand all lines under Fulfillment Lines section
	    if (section.equalsIgnoreCase("Fulfillment Lines")) {
	        Set<String> expandedRows = new HashSet<>();
	        By fulfillmentRows = By.xpath("//table[@summary='Fulfillment Lines']/tbody/tr");
	        pom.expandAllRowsRecursive(fulfillmentRows, expandedRows);
	    }
	}

	@Then("validate Assert Management  task progress should be completed")
	public void validate_assert_management_task_progress_should_be_completed() {
	    WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Assert Management')]/ancestor::tr//span[text()='Completed']"));
	    Assert.assertTrue(element.isDisplayed(), "Assert Management task is not completed.");
	    System.out.println("Assert Management task completed.");
	}

	@Then("Subscription task progress should be completed")
	public void subscription_task_progress_should_be_completed() {
	    WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Subscription')]/ancestor::tr//span[text()='Completed']"));
	    Assert.assertTrue(element.isDisplayed(), "Subscription task is not completed.");
	    System.out.println("Subscription task completed.");
	}
	

	@Then("Click Done Button")
	public void click_done_button() {
	    WebElement doneBtn = driver.findElement(By.xpath("//button[text()='Done']"));
	    Assert.assertTrue(doneBtn.isDisplayed(), "'Done' button not found.");
	    doneBtn.click();
	    System.out.println("Clicked on Done button.");
	}

	@Then("Fulfillment Line Should be displayed")
	public void fulfillment_line_should_be_displayed() {
	    WebElement line = driver.findElement(By.xpath("//a[contains(@title, 'Fulfillment Lines')]"));
	    Assert.assertTrue(line.isDisplayed(), "Fulfillment Line is not displayed.");
	    System.out.println("Fulfillment Line is displayed.");
	}

}


