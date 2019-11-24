package com.studentapp.studentinfo;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Jay
 */
//@Concurrent(threads = "4x")
//@UseTestDataFrom("src\\test\\java\\resources\\testdata\\studentinfo.csv")
//@RunWith(SerenityParameterizedRunner.class)
public class CreateStudentDataDrivenTest {

    private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private String course;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Steps
    StudentSerenitySteps steps;

    @Title("DataDriven Test for adding multiple students to the Student App.")
    @Test
    public void createMultipleStudents(){
        ArrayList<String> courses = new ArrayList<>();
        courses.add(course);
        steps.createStudent(firstName, lastName, email, programme, courses);

    }
}
