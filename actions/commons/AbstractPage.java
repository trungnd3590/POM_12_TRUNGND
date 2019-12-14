package commons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;
import pageUIs.AbstactPageUI;

public class AbstractPage {

	Select select;
	Actions actions;
	protected WebDriver driver;
	WebElement element;
	long shortTimeOut = 5;
	long longTimeOut = 30;
	List<WebElement> elements;
	WebDriverWait waitExplicit;
	JavascriptExecutor jsExecutor;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		waitExplicit = new WebDriverWait(driver, longTimeOut);
		actions = new Actions(driver);
	}

	public void openUrl(String url) {
		driver.get(url);
	}

	public String getPageTitle() {
		return driver.getTitle().toString();
	}

	public String getPageCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageSourceCode() {
		return driver.getPageSource();
	}

	public void backToPage() {
		driver.navigate().back();
	}

	public void forwardToPage() {
		driver.navigate().forward();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void waitForAlertPresence() {
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert() {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert() {
		return driver.switchTo().alert().getText();
	}

	public void sendkeysAlert(String keyVal) {
		driver.switchTo().alert().sendKeys(keyVal);
	}
	
	public void clickToElement(String locator,String...textVal) {
		element = driver.findElement(byXpath(locator, textVal));
		element.click();
	}
	
	public void sendkeysToElement(String keyVal,String locator,String...textVal) {
		element = driver.findElement(byXpath(locator,textVal));
		element.clear();
		element.sendKeys(keyVal);
	}
	
	public void selectItemInDropdown(String itemVal, String locator,String...textVal) {
		element = driver.findElement(byXpath(locator,textVal));
		select = new Select(element);
		select.selectByVisibleText(itemVal);
	}
	
	public String getItemValueInDropdown(String locator,String...textVal) {
		element = driver.findElement(byXpath(locator,textVal));
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	
	public void selectItemInCustomDropdown(String partenLocator,String parentTextVal, String allItemLocator,String allItemTextVal, String expectedItem) throws Exception {

		WebElement parentDropdown = driver.findElement(byXpath(partenLocator,parentTextVal));
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", parentDropdown);
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].click();", parentDropdown);
		sleepInSecond(1);
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXpath(allItemLocator,allItemTextVal)));
		elements = driver.findElements(byXpath(allItemLocator,allItemTextVal));
		for (WebElement item : elements) {
			if (item.getText().equals(expectedItem)) {
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				System.out.println("Item cần click : " + item.getText());
				item.click();
				sleepInSecond(2);
				break;
			}
		}
	}

	public void sleepInSecond(long numberInSecond) {
		try {
			Thread.sleep(numberInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getAttributeValue(String attributeName,String locator,String...textVal) {
		element = driver.findElement(byXpath(locator, textVal));
		return element.getAttribute(attributeName);
	}

	public String getTextElement(String locator,String...textVal) {
		element = driver.findElement(byXpath(locator, textVal));
		return element.getText();
	}
	
	public String getCapitalizeTextElement(String locator,String...textVal) {
		element = driver.findElement(byXpath(locator, textVal));
		return capitalizeString(element.getText());
	}
	
	public int countElementNumber(String locator,String...textVal) {
		elements = driver.findElements(byXpath(locator, textVal));
		return elements.size();
	}
	
	public void checkToCheckbox(String locator,String...textVal) {
		element = driver.findElement(byXpath(locator, textVal));
		if (element.isSelected() == false) {
			element.click();
		} 
	}

	public void unCheckToCheckbox(String locator,String...textVal) {
		element = driver.findElement(byXpath(locator, textVal));
		if (element.isSelected() == true) {
			element.click();
		} 
	}
	
	public void overrideGlobalTimeOut(long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
    
    public boolean elementIsDisplayed(String locator,String...textVal) {
    	overrideGlobalTimeOut(shortTimeOut);
        try {
        	element = driver.findElement(byXpath(locator, textVal));
        	overrideGlobalTimeOut(longTimeOut);
    		return element.isDisplayed();
        } catch (NoSuchElementException e) {
        	overrideGlobalTimeOut(longTimeOut);
          return false;
        } catch (StaleElementReferenceException e) {
        	overrideGlobalTimeOut(longTimeOut);
          return false;
        }
      }

	public boolean elementIsSelected(String locator,String...textVal) {
		element = driver.findElement(byXpath(locator, textVal));
		return element.isSelected();
	}

	public boolean elementIsEnable(String locator,String...textVal) {
		element = driver.findElement(byXpath(locator, textVal));
		return element.isEnabled();
	}

	public void switchToChildWindowsByID(String parentID) {
		Set<String> allWindowsID = driver.getWindowHandles();
		for (String currentWindowID : allWindowsID) {
			if (!currentWindowID.equals(parentID)) {
				driver.switchTo().window(currentWindowID);
				break;
			}
		}
	}

	public void switchToWindowByTitle(String targerTitle) {
		Set<String> allWindowsID = driver.getWindowHandles();
		for (String currentWWindowID : allWindowsID) {
			driver.switchTo().window(currentWWindowID);
			String currentTitle = driver.getTitle();
			if (targerTitle.equals(currentTitle)) {
				break;
			}
		}
	}

	public boolean closeAllWindowsExceptParentWindows(String parentWindowsID) {
		Set<String> allWindowsID = driver.getWindowHandles();
		for (String currentWWindowID : allWindowsID) {
			if (!parentWindowsID.equals(currentWWindowID)) {
				driver.switchTo().window(currentWWindowID);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindowsID);
		if (driver.getWindowHandles().size() == 1) {
			return true;
		} else {
			return false;
		}
	}

	public void switchToFrameOrIframe(String locator,String...textVal) {
		element = driver.findElement(byXpath(locator, textVal));
		driver.switchTo().frame(element);
	}

	public void switchToParentPage() {
		driver.switchTo().defaultContent();
	}

	public void doubleClickToElement(String locator,String...textVal) {
		element = driver.findElement(byXpath(locator, textVal));
		actions.doubleClick(element).perform();
	}

	public void hoverMouseToElement(String locator,String...textVal) {
		element = driver.findElement(byXpath(locator, textVal));
		actions.moveToElement(element).perform();
	}
	
	public void hoverMouseToElementAndClick(String locator,String...textVal) {
		element = driver.findElement(byXpath(locator, textVal));
		actions.moveToElement(element).perform();
	}
	
	public void rightClick(String locator,String...textVal) {
		element = driver.findElement(byXpath(locator, textVal));
		actions.contextClick(element).perform();
	}

	public void dragAnđrop(String locatorFromX, String locatorToX) {
		WebElement from = driver.findElement(byXpath(locatorFromX));
		WebElement to = driver.findElement(byXpath(locatorToX));
		actions.dragAndDrop(from, to).build().perform();
	}

	public void sendKeyBoardToElement(String locator, Keys keysToSend,String...textVal) {
		element = driver.findElement(byXpath(locator, textVal));
		actions.sendKeys(element, keysToSend).perform();
	}

	public void clickAndHoldElement(String locator, int from, int to,String...textVal) {
		elements = driver.findElements(byXpath(locator, textVal));
		actions.clickAndHold(elements.get(from)).moveToElement(elements.get(to)).release().perform();
	}

	public void clickAndSelectElement(int elementLocator,String locator,String...textVal) {
		elements = driver.findElements(byXpath(locator, textVal));
		actions.keyDown(Keys.CONTROL).perform();
		elements.get(elementLocator).click();
		actions.keyUp(Keys.CONTROL).perform();
	}

	public void uploadFileBySenkeyCommands(String filePath,String locator,String...textVal) {
		element = driver.findElement(byXpath(locator, textVal));
		element.sendKeys(filePath);
	}

	public void clickStartToUploadFile(String locator,String...textVal) {
		elements = driver.findElements(byXpath(locator, textVal));
		for (WebElement startBtn : elements) {
			startBtn.click();
			sleepInSecond(2);
		}
	}

	public void refreshBrowserByJS() {
		jsExecutor.executeScript("history.go(0)");
	}

	public void navigateToPage(String pageUrl) {
		jsExecutor.executeScript("window.location = \'" + pageUrl + "\'");
	}

	public boolean verifyTextInInnerText(String textExpected) {
		String textActual = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		System.out.println("Text actual = " + textActual);
		return textActual.equals(textExpected);
	}

	public String getPageTitleByJS() {
		return jsExecutor.executeScript("return document.title").toString();
	}

	public String getPageUrlByJS() {
		return jsExecutor.executeScript("return document.URL").toString();
	}

	public String getPageDomainByJS() {
		return jsExecutor.executeScript("return document.domain").toString();
	}

	public void scrollToPixelByJS(int range) {
		jsExecutor.executeScript("window.scrollBy(0," + range + ")");
	}

	public void scrollToBottomPageByJS() {
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight");
	}

	public void scrollToDownPageByJS(int range) {
		jsExecutor.executeScript("window.scrollBy(0," + range + ")", "");
	}

	public void clickToElementByJS(String locator,String...textVal) {
		element = driver.findElement(byXpath(locator, textVal));
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	public void highlightToElement(String locator,String...textVal) {
		element = driver.findElement(byXpath(locator, textVal));
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
				element);
	}

	public void scrollToElementByJS(String locator,String...textVal) {
		element = driver.findElement(byXpath(locator, textVal));
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void removeAttributeInDOMByJS(String attributeRemove,String locator,String...textVal) {
		element = driver.findElement(byXpath(locator, textVal));
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}

	public void sendkeyToElementByJS(String value,String locator,String...textVal) {
		element = driver.findElement(byXpath(locator, textVal));
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	public boolean checkAnyImageLoaded(String locator,String...textVal) {
		element = driver.findElement(byXpath(locator, textVal));
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				element);
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	public void waitForElementVisible(String locator, String...textVal) {
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byXpath(locator, textVal)));
	}
	
	public void waitForAllElementsVisible(String locator,String...textVal) {
		waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byXpath(locator, textVal)));
	}

	public void waitForElementInvisible(String locator,String...textVal) {
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(locator, textVal)));
	}
	

	public void waitForElementPresense(String locator,String...textVal) {
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byXpath(locator, textVal)));
	}
	
	public void waitForAllElementsPresense(String locator,String...textVal) {
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXpath(locator, textVal)));
	}

	public void waitForElementClickable(String locator,String...textVal) {
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byXpath(locator, textVal)));
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}
	
	public boolean compareStringFromElementsText(String expTextVal,String locator,String...textVal) {
		
		boolean result = false;
		elements = driver.findElements(byXpath(locator, textVal));
		ArrayList<String> allTextElement = new ArrayList<String>();
		for (WebElement element : elements) {
			allTextElement.add(element.getText());
		}
		if(allTextElement.contains(expTextVal)) {
			result = true;
		}
		return result;
	}
	
	public boolean compareStringFromElementText(String expTextVal,String locator,String...textVal) {
		
		boolean result = false;
		element = driver.findElement(byXpath(locator, textVal));
		if(element.getText().contains(expTextVal)) {
			result = true;
		}
		return result;
	}
	
	public boolean sortDataAcending(String locator,String...textVal) {
		
		boolean compare = false;
		
		List<String> allItemData = new ArrayList<String>();
		
		elements = driver.findElements(byXpath(locator, textVal));
		for (WebElement element : elements) {
			allItemData.add(element.getText());
		}
		
		List<String> sortDataAcending = new ArrayList<String>();
		 for(String data : allItemData) {
			 sortDataAcending.add(data);
		  } 
		Collections.sort(sortDataAcending);
		compare = allItemData.equals(sortDataAcending);
		
		return compare;
	}
	
	public boolean sortDataDecending(String locator,String...textVal) {
		
		boolean compare = false;
		
		List<String> allItemData = new ArrayList<String>();
		
		elements = driver.findElements(byXpath(locator, textVal));
		for (WebElement element : elements) {
			allItemData.add(element.getText());
		}
		
		List<String> sortDataDecending = new ArrayList<String>();
		 for(String data : allItemData) {
			 sortDataDecending.add(data);
		  } 
		Collections.sort(sortDataDecending,Collections.reverseOrder());
		compare = allItemData.equals(sortDataDecending);
		
		return compare;
	}
	
	public boolean compareNumberOfItem(int expVal,String locator,String...textVal) {
		
		boolean compare = false;
		
		if(countElementNumber(locator, textVal) <= expVal) {
			compare = true;
		}
		return compare;
	}
	
	public By byXpath(String locator, String...textVal) {
		By byXpath;
		if(textVal.length ==0) {
			byXpath = By.xpath(locator);
		}else {
			locator = String.format(locator, (Object[])textVal);
			byXpath = By.xpath(locator);
		}
		return byXpath;
	}
	
	public String getNumberFromElementText(String locator, String...textVal) {
		return getTextElement(locator, textVal).replaceAll("\\D+","");
	}
	
	public String capitalizeString(String string) {
		  char[] chars = string.toLowerCase().toCharArray();
		  boolean found = false;
		  for (int i = 0; i < chars.length; i++) {
		    if (!found && Character.isLetter(chars[i])) {
		      chars[i] = Character.toUpperCase(chars[i]);
		      found = true;
		    } else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i]=='\'') { // You can add other chars here
		      found = false;
		    }
		  }
		  return String.valueOf(chars);
		}
	
	public void hoverToMenuBarName(String locatorName) {
		waitForElementVisible(AbstactPageUI.A_CONTAINS_TEXT_MENUBAR_DYNAMIC,locatorName);
		hoverMouseToElement(AbstactPageUI.A_CONTAINS_TEXT_MENUBAR_DYNAMIC,locatorName);
	}
	
	
	public void hoverToHeaderShoppingCart() {
		waitForElementVisible(AbstactPageUI.SPAN_CLASS_DYNAMIC, AbstactPageUI.SPAN_CLASS_HEADER_SHOPPING_CART);
		hoverMouseToElement(AbstactPageUI.SPAN_CLASS_DYNAMIC, AbstactPageUI.SPAN_CLASS_HEADER_SHOPPING_CART);
	}
	
	public boolean isMiniShoppingCartDisplayed() {
		waitForElementVisible(AbstactPageUI.DIV_CLASS_DYNAMIC,AbstactPageUI.DIV_CLASS_MINI_SHOPPING_CART);
		return elementIsDisplayed(AbstactPageUI.DIV_CLASS_DYNAMIC,AbstactPageUI.DIV_CLASS_MINI_SHOPPING_CART);
	}
	
	public String getMiniShoppingCartByValue(String dynamicLocator , String relLocator) {
		waitForElementVisible(dynamicLocator, relLocator);
		return getTextElement(dynamicLocator, relLocator);
	}
	
	public void openHeaderDynamicPage(String...textVal) {
		waitForElementVisible(AbstactPageUI.A_CLASS_DYNAMIC,textVal);
		clickToElement(AbstactPageUI.A_CLASS_DYNAMIC,textVal);
	}
	
	public void openMenuBarDynamicPage(String...textVal) {
		waitForElementVisible(AbstactPageUI.A_CONTAINS_TEXT_MENUBAR_DYNAMIC,textVal);
		clickToElement(AbstactPageUI.A_CONTAINS_TEXT_MENUBAR_DYNAMIC,textVal);
	}
	
	public void openDynamicPage(String...textVal) {
		waitForElementVisible(AbstactPageUI.A_CONTAINS_TEXT_DYNAMIC,textVal);
		clickToElementByJS(AbstactPageUI.A_CONTAINS_TEXT_DYNAMIC,textVal);
	}
	
	public void openDetailDynamicPage(String...textVal) {
		waitForElementVisible(AbstactPageUI.A_CONTAINS_TEXT_PRODUCT_TITLE_DYNAMIC,textVal);
		clickToElement(AbstactPageUI.A_CONTAINS_TEXT_PRODUCT_TITLE_DYNAMIC,textVal);
	}
	
	public void openFooterDynamicPage(String...textVal) {
		waitForElementVisible(AbstactPageUI.A_CONTAINS_TEXT_DYNAMIC_FOOTER,textVal);
		clickToElement(AbstactPageUI.A_CONTAINS_TEXT_DYNAMIC_FOOTER,textVal);
	}
	
	public HomePageObject clickToLogoutLink() {
		waitForElementVisible(AbstactPageUI.A_CLASS_DYNAMIC,AbstactPageUI.A_CLASS_HEADER_LOGOUT_LINK);
		clickToElement(AbstactPageUI.A_CLASS_DYNAMIC,AbstactPageUI.A_CLASS_HEADER_LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
	
	public LoginPageObject openLoginPage() {
		waitForElementVisible(AbstactPageUI.A_CLASS_DYNAMIC,AbstactPageUI.A_CLASS_HEADER_LOGIN_LINK);
		clickToElement(AbstactPageUI.A_CLASS_DYNAMIC,AbstactPageUI.A_CLASS_HEADER_LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}
	
	public HomePageObject clickHomePageIcon() {
		waitForElementVisible(AbstactPageUI.HOME_PAGE_LOGO);
		clickToElement(AbstactPageUI.HOME_PAGE_LOGO);
		return PageGeneratorManager.getHomePage(driver);
	}
	
	public RegisterPageObject openRegisterPage() {
		waitForElementVisible(AbstactPageUI.A_CLASS_DYNAMIC,AbstactPageUI.A_CLASS_HEADER_REGISTER_LINK);
		clickToElement(AbstactPageUI.A_CLASS_DYNAMIC,AbstactPageUI.A_CLASS_HEADER_REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}
}
