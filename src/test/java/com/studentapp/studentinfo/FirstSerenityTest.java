package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Jay
 */
//@RunWith(SerenityRunner.class)
public class FirstSerenityTest extends TestBase {

    @Test
    public void getAllStudents(){
        SerenityRest.rest().given()
                .when()
                .get("/list")
                .then()
                .statusCode(200);
    }

    @Test
    public void thisIsaFailing(){
        SerenityRest.given()
                .when()
                .get("/list")
                .then()
                .statusCode(500);
    }

    @Pending
    @Test
    public void thisIsAPendingTest(){

    }

    @Ignore
    @Test
    public void thisIsASkippedTest(){

    }

    @Test
    public void thisIsAtestWithError(){
        System.out.println("This is an error"+(5/0));
    }

    @Test
    public void fileDoesNotExist() throws FileNotFoundException {
        File file = new File("E://file.txt");
        FileReader fr = new FileReader(file);
    }

    @Manual
    @Test
    public void thisIsAManualTest() {

    }

    @Title("This test will get the information of all the student fro the Student app")
    @Test
    public void test01(){
        SerenityRest.rest().given()
                .when()
                .get("/list")
                .then()
                .statusCode(200);
    }


}
