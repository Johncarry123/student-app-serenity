package com.studentapp.studentinfo;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

/**
 * Created by Jay
 */
public class GetStudentsMethod {

    @Step("Get all student steps")
    public ValidatableResponse getAllStudents() {
        return SerenityRest.rest()
                .given()
                .when()
                .get("/list")
                .then();
    }

    @Step("Get student by ID : {0}")
    public ValidatableResponse getStudentById(int studentId) {
        return SerenityRest.rest()
                .given()
                .when()
                .get("/" + studentId)
                .then();
    }

    public ValidatableResponse searchStudentByProgramme(String programme) {
        return SerenityRest.rest()
                .given()
                .queryParam("programme", programme)
                .when()
                .get("/list")
                .then();
    }

    public ValidatableResponse searchStudentByProgrammeWithLimit(String programme, int limit) {
        return SerenityRest.rest()
                .given()
                .queryParam("programme", programme)
                .queryParam("limit", limit)
                .when()
                .get("/list")
                .then();
    }



        public static float average(int a, int b) {
            return (float)(a + b) / 2;
        }

        public static void main(String[] args) {
            System.out.println(average(2,1));
        }




}
