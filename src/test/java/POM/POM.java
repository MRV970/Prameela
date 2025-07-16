package POM;

	import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

	public class POM {
	    WebDriver driver;
	    WebDriverWait wait;
 
	    
	    @FindBy(id = "groupNode_order_management")
	private WebElement OrgManagementlnk;
	    public POM(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	        PageFactory.initElements(driver, this);
	    }
	    @FindBy(xpath = "//div[@aria-label='Tasks']")
	    private WebElement Task;
	    @FindBy(xpath = "//a[@title='Order Management']")
	    private WebElement OrderMgmt;
	    @FindBy(xpath = "//input[@id='userid']")
	    WebElement userIdField;

	    @FindBy(xpath = "//input[@id='password']")
	    WebElement passwordField;

	    @FindBy(xpath = "//button[text()='Sign In']")
	    WebElement loginBtn;

	    @FindBy(xpath = "//a[@title='Navigator']")
	    WebElement navigatorIcon;
	    
	    @FindBy(xpath="//tr[@class='xk6' and contains(.,'Orchestration Process Number')]//a")
	    WebElement OrchestrationNo;

	    public void launchUrl(String url) {
	        driver.get(url);
	    }

	    public void enterUsername(String username) {
	        userIdField.sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        passwordField.sendKeys(password);
	    }

	    public void clickLogin() {
	        loginBtn.click();
	    }

	    public void clickNavigationIcon() {
	        navigatorIcon.click();
	    }

	    public void clickLink(String linkText) {
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='" + linkText + "']"))).click();
	    }
	public void ClickOrderMgmt() {
	OrderMgmt.click();
}
	    public void openTasks() {
	        driver.findElement(By.xpath("//div[@aria-label='Tasks']")).click();
	    }

	public void clickOrderManagers(String SubMenu) {
    driver.findElement(By.xpath("//td[text()='"+SubMenu+"']")).click();
}

	    public void enterOrderNumber(String number) {
	        driver.findElement(By.xpath("//input[@aria-label=' Order']")).sendKeys(number);
	    }

	    public void clickSearch() {
	        driver.findElement(By.xpath("//button[text()='Sea']")).click();
	    }

	    public void clickOrderLink(String orderNum) {
	        driver.findElement(By.xpath("//a[text()='" + orderNum + "']")).click();
	    }

	    public void openActions() {
	        driver.findElement(By.xpath("//div[@aria-label='Actions']")).click();
	    }

	  public void switchToFulfillmentView(String SubMenu) {
		clickOrderManagers(SubMenu);
	}

	public void validateHeaderFieldsWithValues(Map<String, String> expectedFields) {
    for (Map.Entry<String, String> entry : expectedFields.entrySet()) {
        String label = entry.getKey();
        String expectedValue = entry.getValue();

        String[] xpaths = {
            "//label[text()='" + label + "']/parent::td/following-sibling::td[@class='x18w xk7']",
            "//label[text()='" + label + "']/parent::td/following-sibling::td/span"
      
        };

        String actualValue = null;
        boolean found = false;

        for (String xpath : xpaths) {
            try {
                WebElement valueElement = driver.findElement(By.xpath(xpath));
                actualValue = valueElement.getText().trim();
                actualValue = actualValue.replaceAll("\\s*\\(.*?\\)", "").trim();
                found = true;
                break;
            } catch (Exception e) {
                // try next xpath
            }
        }

        if (!found) {
            Assert.fail("Could not locate value element for label: " + label);
        }

        Assert.assertEquals(actualValue, expectedValue, "Mismatch for field: " + label);
        System.out.println(" " + label + " matches expected value: " + actualValue);
    }
}


public void verifyHeaderFieldsDisplayed(List<String> fieldLabels) {
	
	for (String label : fieldLabels) {
	WebElement Label = driver
	.findElement(By.xpath("//label[text()='" + label + "']/parent::td/following-sibling::td"));
	String LabelText = Label.getText().trim();
	Assert.assertFalse(LabelText.isEmpty(), Label + "has empty value");
	
	}
}
public void expandAllRowsRecursive(By orderLinesRows, Set<String> expandedRows) {
    boolean moreToExpand;

    do {
        moreToExpand = false;
        List<WebElement> rows = driver.findElements(orderLinesRows);

        for (WebElement row : rows) {
            try {
                String rowKey = row.getText().trim();
                if (expandedRows.contains(rowKey)) continue;

                List<WebElement> expandIcons = row.findElements(By.xpath(".//a[contains(@title, 'Expand')]"));
                if (!expandIcons.isEmpty()) {
                    WebElement icon = expandIcons.get(0); // Always first
                    if (icon.isDisplayed()) {
                        icon.click();
                        waitForDomUpdate();
                        expandedRows.add(rowKey);
                        moreToExpand = true;
                    }
                } else {
                    expandedRows.add(rowKey); // Already expanded or no expand icon
                }

            } catch (Exception e) {
                System.err.println("⚠ Error expanding row: " + e.getMessage());
            }
        }
    } while (moreToExpand);
}


By ORDER_LINES_ROWS=By.xpath("//table[@summary=\"Order Lines\"]//td/following-sibling::td/div");
public void verifyOrderLineFieldsDisplayed(List<String> columnNames) {
    Set<String> expandedRows = new HashSet<>();
    expandAllRowsRecursive(ORDER_LINES_ROWS, expandedRows);
    List<WebElement> headers = driver.findElements(By.xpath("//span[@class='af_column_label-text']"));
    Map<String, Integer> headerIndexMap = new HashMap<>();

    for (int i = 0; i < headers.size(); i++) {
        String headerText = headers.get(i).getText();
        String normalizedHeader = headerText.replaceAll("\\s+", " ").trim().toLowerCase(); // ✅ Normalize here
        headerIndexMap.put(normalizedHeader, i);

        System.out.println("DEBUG: Header[" + i + "] = '" + normalizedHeader + "'");
    }

    // Validate header presence
    for (String col : columnNames) {
        if (!headerIndexMap.containsKey(col)) {
            throw new IllegalArgumentException("Missing column header: " + col);
        }
    }

    List<WebElement> rows = driver.findElements(By.xpath("//table[@summary='Order Lines']//tr[contains(@class,'xem')]"));

    for (WebElement row : rows) {
        List<WebElement> cells = row.findElements(By.xpath(".//td[contains(@class,'xe')]//span"));

        if (cells.isEmpty()) {
            System.out.println("⚠ No cells found in row. Skipping...");
            continue;
        }

        // Print cell data
        for (int i = 0; i < cells.size(); i++) {
            System.out.println("Cell[" + i + "] = " + cells.get(i).getText().trim());
        }

        // Check all required columns
        for (String column : columnNames) {
            int columnIndex = headerIndexMap.get(column);

            // Safe index check
            if (columnIndex >= cells.size()) {
                System.out.println("⚠ Not enough cells in row to verify column: " + column);
                continue;
            }

            WebElement cell = cells.get(columnIndex);
            String cellValue = cell.getText().trim();
            System.out.println("Validating column: " + column + ", index: " + cell + ", text: '" + cellValue + "'");
            String text = cell.getAttribute("textContent").trim();
            //String text = cell.getAttribute("textContent").trim();
            Assert.assertTrue(cell.isDisplayed(), "Column [" + column + "] is not displayed.");
            Assert.assertFalse(text.isEmpty(), "Column [" + column + "] is empty.");
            // ⚠ Fix this line — Assertion message was inverted earlier
           // Assert.assertFalse(cellValue.isEmpty(), "Column [" + column + "] is empty.");
            System.out.println(column + " = " + cellValue);
        }
    }
}



public void waitForDomUpdate() {
    try {
        Thread.sleep(1000); // Better: use WebDriverWait for real condition
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
}
public void clickLinesTab(String tabname) {
    driver.findElement(By.xpath("//div[@class='x1gd']//a[text()='" + tabname + "']")).click();
}
public void validateEachFulfillmentLineGeneralTabFields(Map<String, String> expectedFields) {
Set<String> expandedRows = new HashSet<>();
expandAllRowsRecursive(FULFILLMENT_LINE_ROWS, expandedRows);
List<WebElement> rows = driver.findElements(FULFILLMENT_LINE_ROWS);
String actualValue;

for(WebElement row:rows) {
	
	row.click();
	for (Map.Entry<String, String> map : expectedFields.entrySet()) {
       String field = map.getKey();
       String expectedValue = map.getValue();
	 WebElement valueElement = row.findElement(By.xpath("//label[text()='"+field+"']/following::td[1]"));
	 actualValue =  valueElement.getText().trim();
    Assert.assertEquals(
               "Mismatch in field '" + field + "' → Expected: [" + expectedValue + "] but found: [" + actualValue + "]",
               expectedValue,
               actualValue
           );
    
	}
}

}

public void expandAndValidateOrderLines(List<String> columnHeaders) {
    List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@summary,'Order Lines')]/tbody/tr"));

    for (int i = 1; i <= rows.size(); i++) {
        try {
            WebElement expandIcon = driver.findElement(By.xpath("(//table[contains(@summary,'Order Lines')]/tbody/tr)[" + i + "]//a[contains(@title,'Expand')]"));
            expandIcon.click();
            Thread.sleep(1000);
        } catch (Exception e) {
            // No expand icon — skip
        }

        for (String header : columnHeaders) {
            String xpath = "(//table[contains(@summary,'Order Lines')]/tbody/tr)[" + i + "]//td[contains(@headers,'" + header + "')]";
            WebElement cell = driver.findElement(By.xpath(xpath));
            Assert.assertTrue(cell.isDisplayed(), "Missing value for column: " + header);
            System.out.println("Verified " + header + ": " + cell.getText().trim());
        }
    }
}
	    public void clickTab(String tabName) {
	        driver.findElement(By.xpath("//a[text()='" + tabName + "']")).click();
	    }
	    
	    public void validateOrderLineFields(List<String> fields) {
	        for (String field : fields) {
	            WebElement cell = driver.findElement(By.xpath("//span[contains(text(),'" + field + "')]"));
	            Assert.assertTrue(cell.isDisplayed());
	        }
	    }
	    
		public void clickDone() {
			 driver.findElement(By.xpath("//span[text()='D']")).click();
		}
		
		public boolean isAssertManagementCompleted(WebElement Task) {
			return driver.findElement(By.xpath("/(//tr[@class='xem p_AFSelected' and contains(.,'Asset Management')]//img)[1]")).isDisplayed();
			
		    
		}
		
	    By FULFILLMENT_LINE_ROWS = By.xpath("//table[@summary='Manage Fulfillment Line Exceptions']/tbody/tr");
	    public void clickOrchestrationProcess() throws InterruptedException {
    	Set<String> expandedRows = new HashSet<>();
    	expandAllRowsRecursive(FULFILLMENT_LINE_ROWS, expandedRows);
    	List<WebElement> rows = driver.findElements(FULFILLMENT_LINE_ROWS);
    	
    	for(WebElement row:rows) {
    		row.click();
    		By processNumberLocator = By.xpath("//tr[@class='xk6' and contains(.,'Orchestration Process Number')]//a");
              
    	    wait.until(ExpectedConditions.presenceOfElementLocated(processNumberLocator));  // Ensures element is in the DOM

    	    WebElement processElement = driver.findElement(processNumberLocator);

    	    wait.until(ExpectedConditions.elementToBeClickable(processElement));  // Ensures it's clickable now

    	    processElement.click();
    		
//    		WebElement orchestrationlink = OrchestrationNo;
//    		
//    		orchestrationlink.click();
////    		isAssertManagementCompleted(Task);
////    		isAssertManagementCompleted(Task);
////    		clickDone();
    		
    		
    	}
//    				
    }
	 
	}


