package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.utils.TestUtils;
import com.studentapp.testbase.TestBase;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
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
public class StudentCURDTest extends TestBase {

    static String firstName = "SMOKEUSER" + TestUtils.getRandomValue();
    static String lastName = "SMOKEUSER" + TestUtils.getRandomValue();
    static String programme = "ComputerScience";
    static String email = TestUtils.getRandomValue() + "xyz@gmail.com";
    static int studentId;


    @Test
    public void test01() {
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("JAVA");
        courses.add("C++");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName(firstName);
        studentPojo.setLastName(lastName);
        studentPojo.setEmail(email);
        studentPojo.setProgramme(programme);
        studentPojo.setCourses(courses);
        SerenityRest.rest().given()
                .contentType(ContentType.JSON).log().all()
                .when()
                .body(studentPojo)
                .post()
                .then().log().all().statusCode(201);

    }

    @Test
    public void test02() {
        String p1 = "findAll{it.firstName=='";
        String p2 = "'}.get(0)";
        HashMap<String, Object> value = SerenityRest.rest().given()
                .when()
                .get("/list")
                .then()
                .statusCode(200)
                .extract()
                .path(p1+firstName+p2);

        studentId = (int) value.get("id");
        assertThat(value, hasValue(firstName));

    }

    @Title("Update the user information and verify the updated information")
    @Test
    public void test03() {
        ArrayList<String> courses = new ArrayList<String>();
        courses.add("JAVA");
        courses.add("C++");

        firstName = firstName + "_Updated";

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName(firstName);
        studentPojo.setLastName(lastName);
        studentPojo.setEmail(email);
        studentPojo.setProgramme(programme);
        studentPojo.setCourses(courses);

        SerenityRest.rest().given()
                .contentType(ContentType.JSON).log().all()
                .when().body(studentPojo).put("/" + studentId).then();

        String p1 = "findAll{it.firstName=='";
        String p2 = "'}.get(0)";

        HashMap<String, Object> value = SerenityRest.rest().given()
                .when()
                .get("/list")
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + firstName + p2);
        assertThat(value, hasValue(firstName));
        System.out.println("The value is: " + value);

    }
    @Title("Delete the student and verify if the student is deleted!")
    @Test
    public void test04() {
        SerenityRest
                .rest()
                .given()
                .when()
                .delete("/" + studentId)
                .then().statusCode(204);

        SerenityRest
                .rest()
                .given()
                .when()
                .get("/" + studentId).then().statusCode(404);
    }
    }
