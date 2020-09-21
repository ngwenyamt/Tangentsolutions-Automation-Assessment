package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NationalityPageObject {

    @FindBy(how = How.ID, using = "id_username")
    public WebElement username;

    @FindBy(how = How.ID, using = "id-password")
    public WebElement password;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div[3]/section/div/div/div/div/div[2]/div/form/button")
    public WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//*[@id='navbar-mobile']/ul[1]/li")
    public WebElement toggleClick;

    @FindBy(how = How.LINK_TEXT, using = "Lookups")
    public WebElement lookupClick;

    @FindBy(how = How.LINK_TEXT, using = "Nationalities")
    public WebElement nationalityClick;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div[3]/div/div/div[2]/div[1]/div/div/a/span")
    public WebElement addNationalityClick;

    @FindBy(how = How.NAME, using = "name")
    public WebElement addName;

    @FindBy(how = How.ID, using = "id_description")
    public WebElement addDescription;

    @FindBy(how = How.NAME, using = "save")
    public WebElement saveButton;

    @FindBy(how = How.TAG_NAME, using = "body")
    public WebElement addResult;

    @FindBy(how = How.TAG_NAME, using = "body")
    public WebElement existingNationality;

    @FindBy(how = How.TAG_NAME, using = "body")
    public WebElement viewNationality;

    @FindBy(how = How.LINK_TEXT, using = "Tebogo Test Name fields")
    public WebElement navigateToUpdate;

    @FindBy(how = How.NAME, using = "name")
    public WebElement updateName;

    @FindBy(how = How.XPATH, using = "//*[@id='tabs0']/div/form/div/a[2]")
    public WebElement clickUpdateButton;

    @FindBy(how = How.ID, using = "id_description")
    public WebElement updateDescription;

    @FindBy(how = How.NAME, using = "save")
    public WebElement saveUpdate;

    @FindBy(how = How.XPATH, using = "//*[@id='table-filter-helper-search-link']")
    public WebElement filterRecordsButton;

    @FindBy(how = How.ID, using = "id_name")
    public WebElement searchInput;

    @FindBy(how = How.XPATH, using = "//*[@id='filter_button']")
    public WebElement filter;

    @FindBy(how = How.LINK_TEXT, using = "Test Edit name")
    public WebElement navigateToDelete;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div[3]/div/div/div/div/form/button")
    public WebElement confirmDelete;












}