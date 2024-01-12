package StepDefinitions;

import Pom.MountainBikesPom;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class MountainBikesSteps extends BaseMethods{

    MountainBikesPom mountainBikesPom;


    public MountainBikesSteps(){
        mountainBikesPom = MountainBikesPom.getInstance();
    }

    //Case1
    @Given("User is in {string} page")
    public void userIsInPage(String arg0) {
    }

    @When("Click login button")
    public void clickLoginButton() {
        getElement(mountainBikesPom.getLoginBtn()).click();
    }

    @And("Move to categories button")
    public void moveToCategoriesButton() {

        WebElement element = getElement(mountainBikesPom.getCategoriesBtn());
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    @And("Click Bikes button")
    public void clickBikesButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getElement(mountainBikesPom.getBikesBtn()).click();
    }

    @And("Click Mountain Bikes button")
    public void clickMountainBikesButton() {
        getElement(mountainBikesPom.getMountainBikesBtn()).click();
    }


    @And("Click {string} button")
    public void clickButton(String s) throws InterruptedException {
        Thread.sleep(2000);
        String[] array = s.split("&");
        List<WebElement>elements = getElements(mountainBikesPom.getMountainBikesItems());
        for (WebElement element:elements){
            for (int i = 0;i<array.length;i++){
                if (element.getText().toLowerCase().contains(array[i].toLowerCase())){
                    element.findElement(By.tagName("input")).click();
                }
            }
        }
    }


    @Then("User should see items {string} on the page")
    public void userShouldSeeItemsOnThePage(String expectedText) throws InterruptedException {
        Thread.sleep(2000);
        getElement(mountainBikesPom.getDropdownBtn()).click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",getElement(mountainBikesPom.getDropdown48Btn()));
        Thread.sleep(2000);
        String[] array = expectedText.split("&");
        List<WebElement>elements = getElements(mountainBikesPom.getItemTexts());
        for (WebElement element:elements){
            boolean flag = false;
            for (int i = 0;i<array.length;i++){
                if (element.getText().toLowerCase().contains(array[i].toLowerCase())){
                    flag = true;
                }
            }
            Assert.assertTrue(flag);
        }
    }

    @And("Clicks {string} button")
    public void clicksButton(String value) throws InterruptedException {
        Thread.sleep(3000);
        String[] array = value.split("&");
        for (int i = 0;i<array.length;i++){
            String locator = mountainBikesPom.getRatingCheckbox();
            String s = array[i];
            locator = locator.replace("rate",s);
            getElement(By.xpath(locator)).click();
        }

    }

    @Then("Users should see items {string} on the page")
    public void usersShouldSeeItemsOnThePage(String ratingText) throws InterruptedException {
        Thread.sleep(3000);
        String[] array = ratingText.split("&");
        List<WebElement>elements = getElements(mountainBikesPom.getRatingText());
        for (WebElement element:elements){
            boolean flag = false;
            for (int i = 0;i<array.length;i++){
                if (element.getText().toLowerCase().contains(array[i].toLowerCase())){
                    flag = true;
                }
            }
            Assert.assertTrue(flag);
        }


    }

    @Then("User should see nothing  on the page")
    public void userShouldSeeNothingOnThePage() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement>elements = getElements(mountainBikesPom.getRatingText());
        Assert.assertTrue(elements.isEmpty());
    }










//Case11 Bu caselerde problem var hecne ile etmek olmur ne visible text ne index value da yoxdu
    @And("Click Low to High filter")
    public void clickLowToHighFilter() throws InterruptedException {
        Thread.sleep(3000);
        getElement(mountainBikesPom.getDropdownSortByBtn()).click();
        getElement(mountainBikesPom.getLowToHighBtn()).click();

    }

    @Then("Items should be ordered as Low to High price")
    public void itemsShouldBeOrderedAsLowToHighPrice() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement>elements = getElements(mountainBikesPom.getItemPrice());
        List<Double>actualText = new ArrayList<>();
        for (WebElement element:elements){
            String s = element.getText().substring(1);
            double d = Double.parseDouble(s);
            actualText.add(d);
        }
        List<Double>sortedItems = new ArrayList<>();
        sortedItems.addAll(actualText);
        Collections.sort(sortedItems);
        Assert.assertTrue(actualText.equals(sortedItems));
    }
//Case12
    @And("Click High to Low filter")
    public void clickHighToLowFilter() {
        getElement(mountainBikesPom.getDropdownSortByBtn()).click();
        getElement(mountainBikesPom.getHighToLowBtn()).click();

    }

    @Then("Items should be ordered as High to Low price")
    public void itemsShouldBeOrderedAsHighToLowPrice() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement>elements = getElements(mountainBikesPom.getItemPrice());
        List<Double>actualText = new ArrayList<>();
        for (WebElement element:elements){
            String s = element.getText().substring(1).replace(",","");
            double d = Double.parseDouble(s);
            actualText.add(d);
        }
        List<Double>sortedItems = new ArrayList<>();
        sortedItems.addAll(actualText);
        sortedItems.sort(Comparator.reverseOrder());
        Assert.assertTrue(actualText.equals(sortedItems));
    }
//Case13
    @And("Click A to Z filter")
    public void clickAToZFilter() {
        getElement(mountainBikesPom.getDropdownSortByBtn()).click();
        getElement(mountainBikesPom.getAToZBtn()).click();

    }

    @Then("Items should be ordered as A to Z")
    public void itemsShouldBeOrderedAsAToZ() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement>elements = getElements(mountainBikesPom.getItemTexts());
        List<String>actualText = new ArrayList<>();
        for (WebElement element:elements){
            String s = element.getText();
            actualText.add(s);
        }
        List<String>sortedItems = new ArrayList<>();
        sortedItems.addAll(actualText);
        Collections.sort(sortedItems);
        Assert.assertTrue(actualText.equals(sortedItems));
    }
//Case14
    @And("Click Z to A filter")
    public void clickZToAFilter() {
        getElement(mountainBikesPom.getDropdownSortByBtn()).click();
        getElement(mountainBikesPom.getZToABtn()).click();

    }

    @Then("Items should be ordered as Z to A")
    public void itemsShouldBeOrderedAsZToA() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement>elements = getElements(mountainBikesPom.getItemTexts());
        List<String>actualText = new ArrayList<>();
        for (WebElement element:elements){
            String s = element.getText();
            actualText.add(s);
        }
        List<String>sortedItems = new ArrayList<>();
        sortedItems.addAll(actualText);
        sortedItems.sort(Comparator.reverseOrder());
        Assert.assertTrue(actualText.equals(sortedItems));
    }


    @When("User choose price interval {string} {string}")
    public void userChoosePriceInterval(String from, String to ) throws InterruptedException {
        Thread.sleep(5000);
        String locator = mountainBikesPom.getPrice();
        String loc = locator;
        locator = locator.replace("price", "$"+from);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(getElement(mountainBikesPom.getCircle()),getElement(By.xpath(locator))).perform();
        loc = loc.replace("price","$"+to);
        actions.dragAndDrop(getElement(mountainBikesPom.getCircle2()),getElement(By.xpath(loc))).perform();
        Thread.sleep(5000);
    }

    @Then("Items shoul be list according to {string} {string}")
    public void itemsShoulBeListAccordingTo(String from, String to) throws InterruptedException {
        Thread.sleep(5000);
        double fromNum = Double.parseDouble(from);
        double toNum = Double.parseDouble(to.replace(",",""));
        List<WebElement>elements = getElements(mountainBikesPom.getItemPrice());
        for (WebElement element:elements){
            double price = Double.parseDouble(element.getText().replace(",","").replace("$",""));
            Assert.assertTrue(fromNum<=price&&price<=toNum);
        }
    }
}
