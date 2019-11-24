package com.studentapp.junit.studentidinfo;

import com.studentapp.studentinfo.GetStudentsMethod;
import com.studentapp.testbase.TestBase;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;

/**
 * Created by Jay Vaghani on 30-Jun-2019
 */
//@RunWith(SerenityRunner.class)
public class StudentsGetTest1 extends TestBase {

    @Steps
    GetStudentsMethod steps;

    @Title("This method will get all students information")
    @Test
    public void getAllStudent() {
        steps.getAllStudents().statusCode(200);
    }

    @Title("This method will get all students information by ID")
    @Test
    public void test01() {
        steps.getStudentById(1).statusCode(200);
    }

}
