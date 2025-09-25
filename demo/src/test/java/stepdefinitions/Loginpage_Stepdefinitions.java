package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmodel.LoginPage_POM;

public class Loginpage_Stepdefinitions extends BaseClass {

    LoginPage_POM loginpage;
    public static WebDriver driver;

    @Given("User launch the Employee Training url {string}")
    public void user_launch_the_employee_training_url(String string) {
        driver = launchBrowser("chrome");
       loginpage = new LoginPage_POM(driver);
        driver.get("http://10.192.190.130:3000/");
}

    @When("User clicks on Add Training button")
    public void user_clicks_on_add_training_button() {
        loginpage.clickAddButton();
    
}
    @When("Verify user navigated to the Add Training page")
    public void verify_user_navigated_to_the_add_training_page() {
        loginpage.ProjectEmployeeNameVisible();
        
}
    @When("Select the project name {string}")
    public void select_the_project_name(String index) throws InterruptedException {
        // int indexstr = Integer.parseInt(index);
        // loginpage.selectByProjectIndex(indexstr); 
        WebElement projectName = driver.findElement(By.xpath("(//div[@tabindex='0'][@role='combobox'])[1]"));
        click(projectName);
        System.out.println("Project name clicked==>");
        int n = Integer.parseInt(index);
        hold(1000);
        pressDown(n);
        hold(1000);
        pressEnter();
        hold(1000);
          
}
    @When("User enter the Employee Id {string}")
    public void user_enter_the_employee_id(String employeeid) {
        loginpage.Employee_Id(employeeid);
}
    @When("User enter the Employee name {string}")
    public void user_enter_the_employee_name(String empname) {
        loginpage.Employee_name(empname);    
}
    @When("User enter the  Course name {string}")
    public void user_enter_the_course_name(String coursename) {
        loginpage.Employee_course(coursename);   
}
    @When("User enter the Trainer name {string}")
    public void user_enter_the_trainer_name(String Trainername) {
        loginpage.Emp_Trainername(Trainername);
    
}
    @When("User select the Training type {string}")
    public void user_select_the_training_type(String Trainingtypedrpdwn) throws InterruptedException {
        //loginpage.Emp_TrainingType(Trainingtype);
        WebElement trainingType = driver.findElement(By.xpath("(//div[@role='combobox'])[2]"));
        click(trainingType);
        System.out.println("Training type clicked==>");
        int drpnum = Integer.parseInt(Trainingtypedrpdwn);
        hold(1000);
        pressDown(drpnum);
        hold(1000);
        pressEnter();
        hold(1000);
    
}
    @When("User enter the start date {string}")
    public void user_enter_the_start_date(String startDate) {
        loginpage.Emp_startdate(startDate);
}
    @When("User enter the end date {string}")
    public void user_enter_the_end_date(String endDate) {
        loginpage.Emp_enddate(endDate);
}
    @When("User select the Status {string}")
    public void user_select_the_status(String Status) throws InterruptedException {
        //loginpage.Emp_status(Status);
         WebElement status = driver.findElement(By.xpath("(//div[@tabindex='0'][@role='combobox'])[3]"));
        click(status);
        System.out.println("Status clicked==");
        int n = Integer.parseInt(Status);
        hold(1000);
        pressUp(n);
        hold(1000);
        pressEnter();
        hold(1000);
}
    @When("User enter the completion percentage {string}")
    public void user_enter_the_completion_percentage(String percentagecompletion) {
        loginpage.Emp_CourseComplt(percentagecompletion);
}
    @When("User clicks on Add button")
    public void user_clicks_on_add_button(){
     loginpage.Emp_Addbtn();   

    }
    @Then("User navigated to the Training Summary page")
    public void user_navigated_to_the_training_summary_page() {
        System.out.println("Navigate to another window");
}

}

