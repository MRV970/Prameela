//package Dupliacte;
//import java.time.Duration;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//public class FOM_POM {
////WebDriver driver;
////
////@FindBy(id = "groupNode_order_management")
////private WebElement OrgManagementlnk;
////
////@FindBy(xpath = "//a[text()='Order Management' and contains(@class,'app-nav')] ")
////private WebElement OrgManagementIcon;
////
////@FindBy(xpath = "//div[@aria-label='Tasks']")
////private WebElement Task;
////
////@FindBy(xpath = "//table/tbody/tr/td[text()='Manage Orders']")
////private WebElement manageOrders;
////
////@FindBy(xpath = "// input[@aria-label=\" Order\"]")
////private WebElement orderSearchBox;
////
////@FindBy(xpath = "//button[@accesskey='r']")
////private WebElement searchBtn;
////
////@FindBy(xpath = "//a[text()='4331']")
////private WebElement orderNumLink;
////
////@FindBy(xpath = "//div[@aria-label='Actions']")
////private WebElement actionsBtn;
////
////@FindBy(xpath = "//table/tbody/tr/td[text()='Switch to Fulfillment View']")
////private WebElement switchToFulfillmentView;
////
////// expand fulfilmentlines
////@FindBy(xpath = "//a[@title='Collapse']")
////private List<WebElement> ExpandFulfillmentlines;
////
////@FindBy(xpath = "//a[text()='300001713210580']")
////private List<WebElement> OrchestrationProcessNumber;
////
////@FindBy(xpath = "//a[@role=\"button\" and contains(@onclick,\"this.focus();return false\") and @accesskey=\"o\"]")
////private WebElement doneBtn;
////
////@FindBy(xpath = "//a[@title='Order Management']")
////private WebElement OrderMgmt;
////
////
////// constroctor
////WebDriverWait wait;
////JavascriptExecutor js;
////Actions action;
////By FULFILLMENT_LINE_ROWS=By.xpath("//table[@summary='Manage Fulfillment Line Exceptions']/tbody/tr");
////public FOM_POM(WebDriver driver) {
////this.driver = driver;
////wait = new WebDriverWait(driver, Duration.ofSeconds(60));
////js = (JavascriptExecutor) driver;
////action = new Actions(driver);
////
////PageFactory.initElements(driver, this);
////
////}
////public void clicknavigation() {
////	driver.findElement(By.xpath("//a[@title='Navigator']")).click();
////	}
////public void ClickOrderManagement() {
////	driver.findElement(By.xpath("//div[@title='Order Management']")).click();
////	
////}
////public void ClickOrderMgmt() {
////	OrderMgmt.click();
////}
////
////public void openTasks(String Tab) {
////   driver.findElement(By.xpath("//div[@aria-label='"+Tab+"']")).click();
////   }
////
////public void clickOrderManagers(String SubMenu) {
////    driver.findElement(By.xpath("//td[text()='"+SubMenu+"']")).click();
////}
//
//public void enterOrderNumber(String number) {
//    
//   driver.findElement(By.xpath("//input[@aria-label=' Order']")).sendKeys(number);
//}
//
//public void clickSearch() {
//    driver.findElement(By.xpath("//button[text()='Sea']")).click();
//}
//
//public void clickOrderLink() {
//	 driver.findElement(By.xpath("//table[@summary='Search Results']//td//a[@class='xmx']")).click();
//}
//
//public void openActionsMenu(String Tab) {
//	openTasks(Tab);
//}
//
//public void switchToFulfillmentView(String SubMenu) {
//	clickOrderManagers(SubMenu);
//}
//public void validateHeaderFieldsWithValues(Map<String, String> expectedFields) {
//    for (Map.Entry<String, String> entry : expectedFields.entrySet()) {
//        String label = entry.getKey();
//        String expectedValue = entry.getValue();
//
//        String[] xpaths = {
//            "//label[text()='" + label + "']/parent::td/following-sibling::td[@class='x18w xk7']",
//            "//label[text()='" + label + "']/parent::td/following-sibling::td/span"
//      
//        };
//
//        String actualValue = null;
//        boolean found = false;
//
//        for (String xpath : xpaths) {
//            try {
//                WebElement valueElement = driver.findElement(By.xpath(xpath));
//                actualValue = valueElement.getText().trim();
//                actualValue = actualValue.replaceAll("\\s*\\(.*?\\)", "").trim();
//                found = true;
//                break;
//            } catch (Exception e) {
//                // try next xpath
//            }
//        }
//
//        if (!found) {
//            Assert.fail("Could not locate value element for label: " + label);
//        }
//
//        Assert.assertEquals(actualValue, expectedValue, "Mismatch for field: " + label);
//        System.out.println(" " + label + " matches expected value: " + actualValue);
//    }
//}
//
//
//public void verifyHeaderFieldsDisplayed(List<String> fieldLabels) {
//	
//	for (String label : fieldLabels) {
//	WebElement Label = driver
//	.findElement(By.xpath("//label[text()='" + label + "']/parent::td/following-sibling::td"));
//	String LabelText = Label.getText().trim();
//	Assert.assertFalse(LabelText.isEmpty(), Label + "has empty value");
//	
//	}
//}
////
////public void clickLinesTab(String tabname) {
////	 driver.findElement(By.xpath("//div[@class='x1gd']//a[text()='"+tabname+"']")).click();
////}
////By OrderLinesRows = By.xpath("//table[@summary='Order Lines']//td/following-sibling::td/div");
////public void expandAllRowsRecursive(By OrderLinesRows, Set<String> expandedRows) {
////    boolean moreToExpand;
////    do {
////        moreToExpand = false;
////        List<WebElement> rows = driver.findElements(OrderLinesRows);
////
////        for (int i = 0; i < rows.size(); i++) {
////            rows = driver.findElements(OrderLinesRows); // Refresh DOM
////            if (i >= rows.size())
////                break;
////
////            WebElement row = rows.get(i);
////            try {
////                String rowKey = row.getText().trim();
////                if (expandedRows.contains(rowKey))
////                    continue;
////
////                List<WebElement> expandIcons = row.findElements(By.xpath(".//a[contains(@title, 'Expand')]"));
////                if (!expandIcons.isEmpty() && expandIcons.get(0).isDisplayed()) {
////                    expandIcons.get(0).click();
////                    waitForDomUpdate(); // Wait after expand
////                    expandedRows.add(rowKey);
////                    moreToExpand = true;
////                } else {
////                    expandedRows.add(rowKey); // Already expanded or non-expandable
////                }
////            } catch (Exception e) {
////                System.out.println("Error expanding row: " + e.getMessage());
////            }
////        }
////    } while (moreToExpand);
////}
////public void waitForDomUpdate() {
////   try {
////	   Thread.sleep(1000);
////	   
////   }catch(InterruptedException e) {
////	   Thread.currentThread().interrupt();
////   }
////}
////public void verifyOrderLineFieldsDisplayed(List<String> columnNames) {
////    // Expand rows before checking
////    Set<String> expandedRows = new HashSet<>();
////    expandAllRowsRecursive(OrderLinesRows, expandedRows);
////
////    // Get table headers
////    List<WebElement> headers = driver.findElements(By.xpath("//span[@class='af_column_label-text']"));
////    if (headers.isEmpty()) {
////        throw new IllegalStateException("No table headers found with xpath //span[@class='af_column_label-text']");
////    }
////
////    // Map: Header name → Index
////    Map<String, Integer> headerIndexMap = new HashMap<>();
////    for (int i = 0; i < headers.size(); i++) {
////        String headerName = headers.get(i).getText().trim();
////        headerIndexMap.put(headerName, i);
////    }
////
////    System.out.println("Detected Headers: " + headerIndexMap.keySet());
////
////    // Validate all requested columns exist in the table
////    for (String column : columnNames) {
////        if (!headerIndexMap.containsKey(column)) {
////            throw new IllegalArgumentException("Expected column not found in table: " + column);
////        }
////    }
////
////    // Get all visible rows (data rows)
////    List<WebElement> rows = driver.findElements(By.xpath("//tr[@class='xem']"));
////    if (rows.isEmpty()) {
////        throw new IllegalStateException("No data rows found in the table.");
////    }
////
////    for (WebElement row : rows) {
////        // Get all column cells in this row
////        List<WebElement> cells = row.findElements(By.xpath(".//td[@class='xen']/span[@class='x2f0'] | .//td[@class='xer']/span[@class='x2f0']"));
////
////        for (String column : columnNames) {
////            int index = headerIndexMap.get(column);
////
////            if (index >= cells.size()) {
////                throw new IndexOutOfBoundsException("Column index " + index + " is out of bounds for current row. Row has only " + cells.size() + " cells.");
////            }
////
////            WebElement cell = cells.get(index);
////            String text = cell.getText().trim();
////
////            Assert.assertTrue(cell.isDisplayed(), "Column [" + column + "] is not displayed.");
////            Assert.assertFalse(text.isEmpty(), "Column [" + column + "] is empty.");
////            System.out.println(column + " = " + text);
////        }
////    }
////}
////
////
////	By ORDER_LINES_ROWS=By.xpath("//table[@summary=\"Order Lines\"]//td/following-sibling::td/div");
//////	public void verifyOrderLineFieldsDisplayed(List<String> columnNames) {
//////	    // Get header cells (th or td depending on HTML)
//////		Set<String> expandedRows = new HashSet<>();
//////		expandAllRowsRecursive(OrderLinesRows,expandedRows);
//////		
//////		List<WebElement> headers = driver.findElements(By.xpath("//span[@class='af_column_label-text']"));
//////	     Map<String, Integer> headerIndexMap = new HashMap<>();
//////	     for (int i = 0; i < headers.size(); i++) {
//////
//////	         headerIndexMap.put(headers.get(i).getText().trim(), i);
//////
//////	     }
//////	     // Get required column indexes
//////	     int itemIndex = headerIndexMap.get("Ordered Quantity");
//////	     int itemDescriptionIndex = headerIndexMap.get("UOM");
//////	     int OrderQuantityIndex = headerIndexMap.get("Status");
//////
//////	     // Step 2: Iterate through each row and validate
//////
//////	     List<WebElement> rows = driver.findElements(By.xpath("//tr[@class='xem']"));
//////	     for (WebElement row : rows) {
//////	    	 String locator ="//td[@class='xen']/span[@class='x2f0']|//td[@class='xer']/span[@class='x2f0']";
//////
//////	     
//////	         List<WebElement> line = row.findElements(By.xpath(locator));
//////
//////	 
//////
//////	         String lineText = line.get(itemIndex).getText().trim();
//////
//////	         String email = line.get(itemDescriptionIndex).getText().trim();
//////
//////	         String status = line.get(OrderQuantityIndex).getText().trim();
//////
//////	         
//////	             // Get all column cells in this row
//////	             List<WebElement> cells = row.findElements(By.xpath(".//td[@class='xen']/span[@class='x2f0'] | .//td[@class='xer']/span[@class='x2f0']"));
//////
//////	             for (String column : columnNames) {
//////	                 int index = headerIndexMap.get(column);
//////
//////	                 if (index >= cells.size()) {
//////	                     throw new IndexOutOfBoundsException("Column index " + index + " is out of bounds for current row. Row has only " + cells.size() + " cells.");
//////	                 }
//////
//////	                 WebElement cell = cells.get(index);
//////	                 String text = cell.getText().trim();
//////
//////	                 Assert.assertTrue(cell.isDisplayed(), "Column [" + column + "] is not displayed.");
//////	                 Assert.assertFalse(text.isEmpty(), "Column [" + column + "] is empty.");
//////	                 System.out.println(column + " = " + text);
//////	             }
//////	         }
//////	        }
//////	   
//////	
////	public void validateorderlines(Map<String, String> expectedList) {
////		Set<String> expandedRows = new HashSet<>();
////		expandAllRowsRecursive(ORDER_LINES_ROWS, expandedRows);
////		
////		List<WebElement> headers = driver.findElements(By.xpath("//span[@class='af_column_label-text']"));
////
////	     Map<String, Integer> headerIndexMap = new HashMap<>();
////
////	 
////
////	     for (int i = 0; i < headers.size(); i++) {
////
////	         headerIndexMap.put(headers.get(i).getText().trim(), i);
////
////	     }
////
////	 
////
////	     // Get required column indexes
////
////	     int itemIndex = headerIndexMap.get("Item");
////
////	     int itemDescriptionIndex = headerIndexMap.get("Item Description");
////
////	     int OrderQuantityIndex = headerIndexMap.get("Ordered Quantity");
////
////	 
////
////	     // Step 2: Iterate through each row and validate
////
////	     List<WebElement> rows = driver.findElements(By.xpath("//tr[@class='xem']"));
////
////	     for (WebElement row : rows) {
////	    	 String locator="//td[@class='xen']/span[@class='x2f0']|//td[@class='xer']/span[@class='x2f0']";
////
////	     
////
////	         List<WebElement> line = row.findElements(By.xpath(locator));
////
////	 
////
////	         String lineText = line.get(itemIndex).getText().trim();
////
////	         String email = line.get(itemDescriptionIndex).getText().trim();
////
////	         String status = line.get(OrderQuantityIndex).getText().trim();
////		
////	}
////	}
////public void clickFulfillmentLinesTab(String tabname) {
////	clickLinesTab(tabname);
////}
////
////
////public void ExpandAllFulfillmentlinesAndVerifyFields(List<String> columnNames) {
////    Set<String> expandedRows = new HashSet<>();
////	expandAllRowsRecursive(FULFILLMENT_LINE_ROWS, expandedRows);
/////// Get header cells (th or td depending on HTML)
////    List<WebElement> headerCells = driver.findElements(By.xpath("//table[contains(@class,'xiz')]//tr[1]/th"));
////
////    // Fallback if <th> is not used
////    if (headerCells.isEmpty()) {
////        headerCells = driver.findElements(By.xpath("//table[contains(@class,'xiz')]//tr[1]/td"));
////    }
////
////    // Map to store header name -> column index
////    Map<String, Integer> columnIndexMap = new HashMap<>();
////
////    for (int i = 0; i < headerCells.size(); i++) {
////        String headerText = headerCells.get(i).getText().trim();
////        columnIndexMap.put(headerText.toLowerCase(), i + 1); // XPath is 1-indexed
////    }
////
////    // Get all data rows (skip header row)
////    List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'xiz')]//tr[position() > 1]"));
////
////    for (WebElement row : rows) {
////        for (String column : columnNames) {
////            Integer colIndex = columnIndexMap.get(column.toLowerCase());
////
////            if (colIndex == null) {
////                throw new IllegalArgumentException("Column not found in table: " + column);
////            }
////
////            WebElement cell = row.findElement(By.xpath(".//td[" + colIndex + "]"));
////            String cellText = cell.getText().trim();
////
////            Assert.assertTrue(cell.isDisplayed(), column + " is not displayed in row.");
////            Assert.assertFalse(cellText.isEmpty(), column + " is empty in row.");
////        }
////    }
////}
////
////
//public void validateEachFulfillmentLineGeneralTabFields(Map<String, String> expectedFields) {
//	 Set<String> expandedRows = new HashSet<>();
//	expandAllRowsRecursive(FULFILLMENT_LINE_ROWS, expandedRows);
//	List<WebElement> rows = driver.findElements(FULFILLMENT_LINE_ROWS);
//	String actualValue;
//	
//	for(WebElement row:rows) {
//		
//		row.click();
//		for (Map.Entry<String, String> map : expectedFields.entrySet()) {
//            String field = map.getKey();
//            String expectedValue = map.getValue();
//		 WebElement valueElement = row.findElement(By.xpath("//label[contains(text(),'" + field + "')]/following-sibling::*[1]"));
//		 actualValue =  valueElement.getText().trim();
//	     Assert.assertEquals(
//	                "Mismatch in field '" + field + "' → Expected: [" + expectedValue + "], but found: [" + actualValue + "]",
//	                expectedValue,
//	                actualValue
//	            );
//	     
//		}
//	}
//	
//}
////
//
//
//public boolean isAssertManagementCompleted(WebElement Task) {
//	return driver.findElement(By.xpath("//tr[@class='xem p_AFSelected' and contains(.,'Asset Management')]//img[@alt='"+Task+"']")).isDisplayed();
//	
//    
//}
//
//
//public void clickDone() {
//	 driver.findElement(By.xpath("//span[@class='xrm' and text()='D']")).click();
//}
//	    WebDriver driver;
//	    WebDriverWait wait;
//	    JavascriptExecutor js;
//	    Actions action;
//
//	    @FindBy(id = "groupNode_order_management")
//	    private WebElement OrgManagementlnk;
//
//	    @FindBy(xpath = "//a[text()='Order Management' and contains(@class,'app-nav')] ")
//	    private WebElement OrgManagementIcon;
//
//	    @FindBy(xpath = "//div[@aria-label='Tasks']")
//	    private WebElement Task;
//
//	    @FindBy(xpath = "//a[@title='Order Management']")
//	    private WebElement OrderMgmt;
//
//	    By OrderLinesRows = By.xpath("//table[@summary='Order Lines']//td/following-sibling::td/div");
//	    By FULFILLMENT_LINE_ROWS = By.xpath("//table[@summary='Manage Fulfillment Line Exceptions']/tbody/tr");
//
//	    public FOM_POM(WebDriver driver) {
//	        this.driver = driver;
//	        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//	        js = (JavascriptExecutor) driver;
//	        action = new Actions(driver);
//	        PageFactory.initElements(driver, this);
//	    }
//
//	    public void clicknavigation() {
//	        driver.findElement(By.xpath("//a[@title='Navigator']")).click();
//	    }
//
//	    public void ClickOrderManagement() {
//	        driver.findElement(By.xpath("//div[@title='Order Management']")).click();
//	    }
//
//	    public void ClickOrderMgmt() {
//	        OrderMgmt.click();
//	    }
//
//	    public void openTasks(String tab) {
//	        driver.findElement(By.xpath("//div[@aria-label='" + tab + "']")).click();
//	    }
//
//	    public void clickOrderManagers(String subMenu) {
//	        driver.findElement(By.xpath("//td[text()='" + subMenu + "']")).click();
//	    }
//
//	    public void clickLinesTab(String tabname) {
//	        driver.findElement(By.xpath("//div[@class='x1gd']//a[text()='" + tabname + "']")).click();
//	    }
//
//	    public void waitForDomUpdate() {
//	        try {
//	            Thread.sleep(1000);
//	        } catch (InterruptedException e) {
//	            Thread.currentThread().interrupt();
//	        }
//	    }
//
//	    public void expandAllRowsRecursive(By rowLocator, Set<String> expandedRows) {
//	        boolean moreToExpand;
//	        do {
//	            moreToExpand = false;
//	            List<WebElement> rows = driver.findElements(rowLocator);
//	            for (int i = 0; i < rows.size(); i++) {
//	                rows = driver.findElements(rowLocator);
//	                if (i >= rows.size()) break;
//
//	                WebElement row = rows.get(i);
//	                try {
//	                    String rowKey = row.getText().trim();
//	                    if (expandedRows.contains(rowKey)) continue;
//
//	                    List<WebElement> expandIcons = row.findElements(By.xpath(".//a[contains(@title, 'Expand')]"));
//	                    if (!expandIcons.isEmpty() && expandIcons.get(0).isDisplayed()) {
//	                        expandIcons.get(0).click();
//	                        waitForDomUpdate();
//	                        expandedRows.add(rowKey);
//	                        moreToExpand = true;
//	                    } else {
//	                        expandedRows.add(rowKey);
//	                    }
//	                } catch (Exception e) {
//	                    System.out.println("Error expanding row: " + e.getMessage());
//	                }
//	            }
//	        } while (moreToExpand);
//	    }
//
//	    public void verifyOrderLineFieldsDisplayed(List<String> columnNames) {
//	        Set<String> expandedRows = new HashSet<>();
//	        expandAllRowsRecursive(OrderLinesRows, expandedRows);
//
//	        List<WebElement> headers = driver.findElements(By.xpath("//span[@class='af_column_label-text']"));
//	        if (headers.isEmpty()) {
//	            throw new IllegalStateException("No table headers found");
//	        }
//
//	        Map<String, Integer> headerIndexMap = new HashMap<>();
//	        for (int i = 0; i < headers.size(); i++) {
//	            headerIndexMap.put(headers.get(i).getText().trim(), i);
//	        }
//
//	        List<WebElement> rows = driver.findElements(By.xpath("//tr[@class='xem']"));
//	        if (rows.isEmpty()) {
//	            throw new IllegalStateException("No data rows found");
//	        }
//
//	        for (WebElement row : rows) {
//	            List<WebElement> cells = row.findElements(By.xpath(".//td[@class='xen']/span[@class='x2f0'] | .//td[@class='xer']/span[@class='x2f0']"));
//
//	            for (String column : columnNames) {
//	                if (!headerIndexMap.containsKey(column)) {
//	                    throw new IllegalArgumentException("Column not found in header: " + column);
//	                }
//	                int index = headerIndexMap.get(column);
//	                if (index >= cells.size()) {
//	                    System.out.println("Skipping row due to missing cell for column: " + column);
//	                    continue;
//	                }
//	                WebElement cell = cells.get(index);
//	                String text = cell.getText().trim();
//	                Assert.assertTrue(cell.isDisplayed(), "Column [" + column + "] not displayed.");
//	                Assert.assertFalse(text.isEmpty(), "Column [" + column + "] is empty.");
//	                System.out.println(column + " = " + text);
//	            }
//	        }
//	 
//	    }
//	    
//	    public void clickOrchestrationProcess() {
//	    	Set<String> expandedRows = new HashSet<>();
//	    	expandAllRowsRecursive(FULFILLMENT_LINE_ROWS, expandedRows);
//	    	List<WebElement> rows = driver.findElements(FULFILLMENT_LINE_ROWS);
//	    	
//	    	for(WebElement row:rows) {
//	    		row.click();
//	    		WebElement orchestrationlink = row.findElement(By.xpath("//tr[@class='xk6' and contains(.,'Orchestration Process Number')]//a"));
//	    		
//	    		orchestrationlink.click();
//	    		isAssertManagementCompleted(Task);
//	    		isAssertManagementCompleted(Task);
//	    		clickDone();
//	    		
//	    		
//	    	}
////	    				
//	    }
//	    
//	    
//	    
//	    
//	}
//
//
//
//
//
//
//
//
