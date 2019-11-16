package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Jay
 */
@RunWith(SerenityRunner.class)
public class FirstSerenityTest extends TestBase {


    @Test
    public void getAllStudents(){
        SerenityRest.rest().given()
                .when()
                .get("/list")
                .then()
                .statusCode(200).log().all();
    }

}
