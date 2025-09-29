package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import common.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmodel.AddReactPage_POM;

public class AddReactpage_Stepdefinitions extends BaseClass {

    AddReactPage_POM addreactpage;
    public static WebDriver driver;

    @Given("User launch the Employee Training url {string}")
    public void user_launch_the_employee_training_url(String string) {
        driver = launchBrowser("chrome");
       addreactpage = new AddReactPage_POM(driver);
        driver.get("http://10.192.190.130:3000/");
    }

    @When("User clicks on Add Training button")
    public void user_clicks_on_add_training_button() {
        addreactpage.clickAddButton();
    }

    @When("Verify user navigated to the Add Training page")
    public void verify_user_navigated_to_the_add_training_page() {
        addreactpage.ProjectEmployeeNameVisible();
        
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
        addreactpage.Employee_Id(employeeid);
}
    @When("User enter the Employee name {string}")
    public void user_enter_the_employee_name(String empname) {
        addreactpage.Employee_name(empname);    
}
    @When("User enter the  Course name {string}")
    public void user_enter_the_course_name(String coursename) {
        addreactpage.Employee_course(coursename);   
}
    @When("User enter the Trainer name {string}")
    public void user_enter_the_trainer_name(String Trainername) {
        addreactpage.Emp_Trainername(Trainername);
    
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
        addreactpage.Emp_startdate(startDate);
}
    @When("User enter the end date {string}")
    public void user_enter_the_end_date(String endDate) {
        addreactpage.Emp_enddate(endDate);
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
    public void user_enter_the_completion_percentage(String percentage)  throws InterruptedException{
         addreactpage.percentcomplete.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
         BaseClass.hold(500);
        addreactpage.percentcomplete.sendKeys(percentage);        
}
    @When("User clicks on Add button")
    public void user_clicks_on_add_button(){
     addreactpage.Emp_Addbtn();   
    }

    @When("User clicks on Add button without Trainer name")
    public void user_clicks_on_add_button_without_trainer_name(){
        addreactpage.Emp_Addbtn();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Text is :"+alertText);
        alert.accept();
    }

    // @When("User can see the error message for empty Employee name {string}")
    // public void user_can_see_the_error_message_for_empty_employee_name(String Expectederrormsg){

    //     try{
    //         addreactpage.Error_msg();
    //         highLightWebElement(addreactpage.Errormsg);
    //         String Actualerrormsg = addreactpage.Errormsg.getText().trim();
        
    //         System.out.println("Expected Error Message: " + Expectederrormsg);
    //         System.out.println("Actual Error Message: " + Actualerrormsg);
    //         // Assertion
    //     Assert.assertTrue(
    //         "Error message mismatch! Expected: " + Expectederrormsg + " but got: " +
    //          Actualerrormsg,Actualerrormsg.contains(Expectederrormsg));
    //     }catch (Exception e) {
    //     Assert.fail("Error message not found: " + e.getMessage());
    // }        
    // throw new io.cucumber.java.PendingException();
    // String Actualerrormsg = addreactpage.Errormsg.getText().trim();
    // Assert.assertTrue(
    //     "❌ Error message mismatch! Expected: " + Expectederrormsg + " but got: " + Actualerrormsg,
    //     Actualerrormsg.contains(Expectederrormsg)
    // );
    // }

    @When("Verify user is on training records projectName, EmployeeName")
    public void Verify_user_is_on_training_records_projectname_employeename(){
        addreactpage.projectNameEmployeeNameVisible();
    }

    @When("click edit on first record")
    public void click_edit_on_first_record(){
        addreactpage.ClickEditButton();
    }

    @When("verify user is on edit training")
    public void verify_user_is_on_edit_training(){
        addreactpage.Verify_EditTraining();
    }

    @When("I change the employeename to {string} and the course to {string}")
    public void i_change_the_employeename_to_and_the_course_to(String employeename, String employeecourse){
       addreactpage.editEmployeeName(employeename);
       addreactpage.editCourse(employeecourse);
    }

    @When("click on update button")
    public void click_on_update_button(){
        addreactpage.ClickUpdateButton();
    }

    @Then("User navigated to the Training Summary page")
    public void user_navigated_to_the_training_summary_page() {
        System.out.println("Navigate to another window");
}    

}

