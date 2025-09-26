package pageobjectmodel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import common.BaseClass;

public class AddReactPage_POM extends BaseClass {    
    WebDriver driver;

    public AddReactPage_POM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ReactAppUrl(String url){
        driver.get(url);
    }

    @FindBy(xpath="//button[@aria-label=\"Add Training\"]")
    public WebElement Add_button;

    @FindBy(xpath = "//label[contains(text(),'Project Name')]")
    public WebElement Projectnamevisible;

    @FindBy(xpath="//div[@id=\"«r27b»\"]")
    public WebElement Projectname_drpdwn;

    @FindBy(xpath="//input[@name=\"empId\"]")
    public WebElement Emp_id;

    @FindBy(xpath="//input[@name=\"employeeName\"]")
    public WebElement Emp_name;

    @FindBy(xpath = "//input[@name=\"course\"]")
    public WebElement course;

    @FindBy(xpath="//input[@name=\"trainerName\"]")
    public WebElement Trainername;

    @FindBy(xpath="(//div[@role='combobox'])[2]")
    public WebElement Trainertype;

    @FindBy(xpath="//input[@name=\"startDate\"]")
    public WebElement startdate;

    @FindBy(xpath="//input[@name=\"endDate\"]")
    public WebElement enddate;

    @FindBy(xpath = "(//div[@role=\"combobox\"])[3]")
    public WebElement status;

    @FindBy(xpath = "//input[@name=\"percentCompleted\"]")
    public WebElement percentcomplete;

    @FindBy(xpath = "//button[contains(text(),'Add')]")
    public WebElement Addbutton;

    @FindBy(xpath = "//div[contains(text(),'Uncaught runtime errors:')]")
    public WebElement Errormsg;

    @FindBy(xpath = "//table//tbody//tr//td[contains(text(),'Felix')][1]")
    public WebElement VerifyEmpname;
    
    @FindBy(xpath = "//table//tr//td[contains(text(),'Jerry')]//following-sibling::td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-alignRight MuiTableCell-sizeMedium css-1vfcyao-MuiTableCell-root']//child::button[@type='button'][1]")
    public WebElement Editbutton;

    @FindBy(xpath = "//h6[contains(text(),'Edit Training')]")
    public WebElement EditTraining;

    @FindBy(xpath = "//button[contains(text(),'Update')]")
    public WebElement updatebutton;

    public void clickAddButton() {
        wait_BtnClick(Add_button);
    }

    public void ProjectEmployeeNameVisible(){
        hold(1000);
        WebElement projectnameelement = driver.findElement(By.xpath("//label[contains(text(),'Project Name')]"));
        visible(projectnameelement, 10);
        hold(1000);
        WebElement Employeenameelement = driver.findElement(By.xpath("//input[@name=\"employeeName\"]"));
        visible(Employeenameelement, 10);
    }

    public void projectNameEmployeeNameVisible(){
    WebElement projectNameElement= driver.findElement(By.xpath("//th[text()='Project Name']"));
    boolean projectNameisVisible=projectNameElement.isDisplayed();
    Assert.assertTrue("Project Name not visible", projectNameisVisible);
    WebElement employeeNameElement= driver.findElement(By.xpath("//th[text()='Employee Name']"));
    boolean employeeNameisVisible=employeeNameElement.isDisplayed();
    Assert.assertTrue("Employee Name not visible", employeeNameisVisible);
}

    public void Proj_dropdown(String Projtname){     
        wait_SelectByText(Projectname_drpdwn, Projtname);
    }

    //to pick the data from feature file
    public void selectByProjectIndex(int index){
        wait_SelectByIndex(Projectname_drpdwn, index);
    }

    public void Employee_Id(String id){
        wait_Sendkeys(Emp_id, id, 10);
    }

    public void Employee_name(String name){
        wait_Sendkeys(Emp_name, name, 10);
    }

    public void Employee_course(String empcourse){
        wait_Sendkeys(course, empcourse, 10);
    }

    public void Emp_Trainername(String emptrnrname){
        wait_Sendkeys(Trainername, emptrnrname, 10);
    }

    public void Emp_TrainingType(String TrainingType){
        wait_SelectByText(Trainertype, TrainingType);
    }

    public void Emp_startdate(String empstartdate){
        wait_Sendkeys(startdate, empstartdate, 10);
    }

    public void Emp_enddate(String empenddate){
        wait_Sendkeys(enddate, empenddate, 10);
    }

    public void Emp_status(String coursestatus){
        wait_SelectByText(status, coursestatus);
    }

    public void Emp_CourseComplt(String coursecompletion){
        wait_Sendkeys(percentcomplete, coursecompletion, 10);
    }

    public void Emp_Addbtn(){
        wait_BtnClick(Addbutton);
    }

    public void Error_msg(){
        visible(Errormsg, 10);
    }

    public void Verify_Empname(){
        wait_ScrollDown(VerifyEmpname);
    }

    public void ClickEditButton(){
        wait_BtnClick(Editbutton);
    }

    public void Verify_EditTraining(){
        boolean editTrainingisVisible=EditTraining.isDisplayed();
        Assert.assertTrue("Edit training not visible", editTrainingisVisible);
        //visible(EditTraining,10);
    }

    public void editEmployeeName(String employeename){
    WebElement editname= driver.findElement(By.name("employeeName"));
    editname.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
     editname.sendKeys(employeename);
    }
    public void editCourse(String course){
    WebElement editcourse= driver.findElement(By.name("course"));
     editcourse.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
    editcourse.sendKeys(course);
    }

    public void ClickUpdateButton(){
        wait_BtnClick(updatebutton);
    }








}
