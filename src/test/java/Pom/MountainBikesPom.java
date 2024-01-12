package Pom;

import StepDefinitions.BaseMethods;
import lombok.Data;
import org.openqa.selenium.By;
@Data
public  class MountainBikesPom {
    private final By loginBtn = By.className("k-button");
    private final By categoriesBtn = By.xpath("//*[@id='HeaderMenu']/li[1]/span/span[1]");
    private final By bikesBtn = By.linkText("Bikes");
    private final By mountainBikesBtn = By.linkText("Mountain Bikes");
    private final By mountainBikesItems = By.xpath("//*[@class = 'k-checkbox-item']");
    private final By itemTexts = By.className("card-title");
    private final By dropdownBtn = By.xpath("/html/body/main/div/div/div[2]/div[4]/span[1]/span");
    private final By dropdown48Btn = By.xpath("/html/body/div[4]/div/div/div[2]/ul/li[4]/span");
    private final By ratingText = By.className("rating-text");
    private final By fiveStarBtn = By.cssSelector("[value = '5']");
    private final By fourStarBtn = By.cssSelector("[value = '4']");
    private final By threeStarBtn = By.cssSelector("[value = '3']");
    private final By itemPrice = By.className("card-price");
    private final By twoStarBtn = By.xpath("/html/body/main/div/div/div[1]/div/div[7]/ul/li[4]/input");
    private final By oneStarBtn = By.xpath("/html/body/main/div/div/div[1]/div/div[7]/ul/li[5]/input");
    private final By dropdownSortByBtn = By.xpath("/html/body/main/div/div/div[2]/div[1]/div[2]/span");
    private final By lowToHighBtn = By.xpath("/html/body/div[3]/div/div/div[3]/ul/li[1]/span");
    private final By highToLowBtn = By.xpath("/html/body/div[3]/div/div/div[3]/ul/li[2]/span");
    private final By aToZBtn = By.xpath("/html/body/div[3]/div/div/div[3]/ul/li[3]/span");
    private final By zToABtn = By.xpath("/html/body/div[3]/div/div/div[3]/ul/li[4]/span");
    private final String ratingCheckbox = "//*[@id = 'ratingPicker']//input[@value = 'rate']";
    private final String price = "//*[@title = 'price']";
    private final By circle = By.xpath("/html/body/main/div/div/div[1]/div/div[8]/div[2]/div/div[1]/span[1]");
    private final By circle2 = By.xpath("/html/body/main/div/div/div[1]/div/div[8]/div[2]/div/div[1]/span[2]");

    private MountainBikesPom(){

    }

    private static MountainBikesPom Instance;

    public static MountainBikesPom getInstance(){
        if (Instance == null){
            Instance = new MountainBikesPom();
            return Instance;
        }
        return Instance;
    }
}
