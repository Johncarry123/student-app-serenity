package com.studentapp.cucumber.steps;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.model.utils.TestUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasValue;

/**
 * Created by Jay
 */
public class MyStepdefs {

    static String email = null;
    @Steps
    StudentSerenitySteps steps;

    @When("^User sends a GET request to the list endpoint,they must get back a valid status code 200$")
    public void userSendsAGETRequestToTheListEndpointTheyMustGetBackAValidStatusCode() {
        steps.getAllStudentInfo().statusCode(200);
    }

    @When("^I create a new student by providing the information firstName \"([^\"]*)\" lastName \"([^\"]*)\" email \"([^\"]*)\" programme \"([^\"]*)\" courses \"([^\"]*)\"$")
    public void iCreateANewStudentByProvidingTheInformationFirstNameLastNameEmailProgrammeCourses(String firstName, String lastName, String _email, String programme, String course)  {
        List<String> courses = new ArrayList<>();
        courses.add(course);
        email = TestUtils.getRandomValue()+_email;
        steps.createStudent(firstName, lastName, email, programme, courses).statusCode(201);
    }

    @Then("^I verify that the student with \"([^\"]*)\" is created$")
    public void iVerifyThatTheStudentWithIsCreated(String email)  {
        HashMap<String, Object> value = steps.getStudentInfoByEmail(email);
        assertThat(value, hasValue(email));

    }
}
