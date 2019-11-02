package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		System.out.println("Drive ID for Abstract : "+driver);
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

	public void clickToElement(By by) {
		element = driver.findElement(by);
		element.click();
	}

	public void sendkeysToElement(By by, String keyVal) {
		element = driver.findElement(by);
		element.clear();
		element.sendKeys(keyVal);
	}

	public void selectItemInDropdown(By by, String itemVal) {
		element = driver.findElement(by);
		select = new Select(element);
		select.selectByVisibleText(itemVal);
	}

	public String getItemValueInDropdown(By by) {
		element = driver.findElement(by);
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public void selectItemInCustomDropdown(By parentXpath, By allItemXpath, String expectedItem) throws Exception {

		WebElement parentDropdown = driver.findElement(parentXpath);
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", parentDropdown);
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].click();", parentDropdown);
		sleepInSecond(1);
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(allItemXpath));
		elements = driver.findElements(allItemXpath);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getAttributeValue(By by, String attributeName) {
		element = driver.findElement(by);
		return element.getAttribute(attributeName);
	}

	public String getTextElement(By by) {
		element = driver.findElement(by);
		return element.getText();
	}

	public int countElementNumber(By by) {
		elements = driver.findElements(by);
		return elements.size();
	}

	public void checkToCheckbox(By by) {
		element = driver.findElement(by);
		if (element.isSelected() == false) {
			element.click();
		}
	}

	public void unCheckToCheckbox(By by) {
		element = driver.findElement(by);
		if (element.isSelected() == true) {
			element.click();
		}
	}

	public boolean elementIsDisplayed(By by) {
		element = driver.findElement(by);
		return element.isDisplayed();
	}

	public boolean elementIsSelected(By by) {
		element = driver.findElement(by);
		return element.isSelected();
	}

	public boolean elementIsEnable(By by) {
		element = driver.findElement(by);
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

	public void switchToFrameOrIframe(By by) {
		element = driver.findElement(by);
		driver.switchTo().frame(element);
	}

	public void switchToParentPage(By by) {
		driver.switchTo().defaultContent();
	}

	public void doubleClickToElement(By by) {
		element = driver.findElement(by);
		actions.doubleClick(element).perform();
	}

	public void hoverMouseToElement(By by) {
		element = driver.findElement(by);
		actions.moveToElement(element).perform();
	}

	public void rightClick(By by) {
		element = driver.findElement(by);
		actions.contextClick(element).perform();
	}

	public void dragAnđrop(By fromX, By toX) {
		WebElement from = driver.findElement(fromX);
		WebElement to = driver.findElement(toX);
		actions.dragAndDrop(from, to).build().perform();
	}

	public void sendKeyBoardToElement(By by, Keys keysToSend) {
		element = driver.findElement(by);
		actions.sendKeys(element, keysToSend).perform();
	}

	public void clickAndHoldElement(By by, int from, int to) {
		elements = driver.findElements(by);
		actions.clickAndHold(elements.get(from)).moveToElement(elements.get(to)).release().perform();
	}

	public void clickAndSelectElement(By by, int elementLocator) {
		elements = driver.findElements(by);
		actions.keyDown(Keys.CONTROL).perform();
		elements.get(elementLocator).click();
		actions.keyUp(Keys.CONTROL).perform();
	}

	public void uploadFileBySenkeyCommands(By by, String filePath) {
		element = driver.findElement(by);
		element.sendKeys(filePath);
	}

	public void clickStartToUploadFile(By by) {
		elements = driver.findElements(by);
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

	public void clickToElementByJS(By by) {
		element = driver.findElement(by);
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	public void highlightToElement(By by) {
		element = driver.findElement(by);
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
				element);
	}

	public void scrollToElementByJS(By by) {
		element = driver.findElement(by);
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void removeAttributeInDOMByJS(By by, String attributeRemove) {
		element = driver.findElement(by);
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}

	public void sendkeyToElementByJS(By by, String value) {
		element = driver.findElement(by);
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	public boolean checkAnyImageLoaded(By by) {
		element = driver.findElement(by);
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				element);
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisible(By by) {
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitForElementInvisible(By by) {
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public void waitForElementPresense(By by) {
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void waitForElementClickable(By by) {
		waitExplicit.until(ExpectedConditions.elementToBeClickable(by));
	}
}
