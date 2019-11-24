package com.studentapp.StudentTest;

import com.studentapp.studentinfo.GetStudentsMethod;
import com.studentapp.testbase.TestBase;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;

/**
 * Created by Jay Vaghani on 30-Jun-2019
 */
//@RunWith(SerenityRunner.class)
public class StudentsGetTest extends TestBase {

    @Steps
    GetStudentsMethod steps;

    @Title("This method will get all students information")
    @Test
    public void getAllStudent() {
        steps.getAllStudents().statusCode(200).log().all();
    }

    @Title("This method will get all students information by ID")
    @Test
    public void test01() {
        steps.getStudentById(1).statusCode(200);
    }

}
