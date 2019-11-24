package com.studentapp.studentinfo;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.model.utils.TestUtils;
import com.studentapp.testbase.TestBase;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;
import static org.junit.Assert.assertThat;

/**
 * Created by Jay
 */
//@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentCURDTestWithSteps extends TestBase {

    static String firstName = "SMOKEUSER" + TestUtils.getRandomValue();
    static String lastName = "SMOKEUSER" + TestUtils.getRandomValue();
    static String programme = "ComputerScience";
    static String email = TestUtils.getRandomValue() + "xyz@gmail.com";
    static int studentId;
    @Steps
    StudentSerenitySteps steps;


    @Test
    public void test01() {
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("JAVA");
        courses.add("C++");
        steps.createStudent(firstName, lastName, email, programme, courses)
                .statusCode(201);
    }

    @Test
    public void test02() {
        HashMap<String, Object> value = steps.getStudentInfoByFirstName(firstName);
        assertThat(value, hasValue(firstName));
        studentId = (int) value.get("id");
    }

    @Title("Update the user information and verify the updated information")
    @Test
    public void test03() {
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("JAVA");
        courses.add("C++");

        firstName = firstName + "_Updated";
        steps.updateStudent(studentId, firstName, lastName, email, programme, courses).statusCode(200);

        HashMap<String, Object> value = steps.getStudentInfoByFirstName(firstName);
        assertThat(value, hasValue(firstName));
        System.out.println("The value is: " + value);

    }

    @Title("Delete the student and verify if the student is deleted!")
    @Test
    public void test04() {
        steps.deleteStudent(studentId).statusCode(204);
        steps.getStudentById(studentId).statusCode(404);
    }
}
