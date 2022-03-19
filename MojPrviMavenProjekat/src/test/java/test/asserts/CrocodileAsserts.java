package test.asserts;

import data.models.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CrocodileAsserts {

    public SoftAssert softAssert = new SoftAssert();


    public void assertCreateNewCrocodile(CreateCrocodileResponse createCrocodileResponse, CreateCrocodileRequest createCrocodileRequest) {
        softAssert.assertEquals(createCrocodileResponse.getName(), createCrocodileRequest.getName(), "Name didn't match");
        softAssert.assertEquals(createCrocodileResponse.getDateOfBirth(), createCrocodileRequest.getDateOfBirth(), "date of birth didn't match");
        softAssert.assertEquals(createCrocodileResponse.getSex(), createCrocodileRequest.getSex(), "Sex didn't match");
        softAssert.assertAll();
    }

    public void assertListOfCrocodiles(CrocodileResponse[] getCrocodileResponse) {
        for (CrocodileResponse crocodileResponse : getCrocodileResponse) {
            softAssert.assertFalse(crocodileResponse.getName().isEmpty(), "Name is not empty");
        }
        softAssert.assertAll();
    }

    public void assertASingleCrocodile(GetASinglePublicCrocodileResponse getASinglePublicCrocodileResponse) {
        softAssert.assertAll();
    }

    public void assertASingleCrocodile(CrocodileResponse getCrocodileResponse) {
        softAssert.assertFalse(getCrocodileResponse.getName().isEmpty(), "Name is not empty");
        softAssert.assertAll();
    }

    public void assertRegisterANewUser(RegisterANewUserResponse registerANewUserResponse, RegisterANewUserRequest registerANewUserRequest) {
        softAssert.assertEquals(registerANewUserResponse.getUsername(), registerANewUserRequest.getUsername(), "Username didn't match");
        softAssert.assertEquals(registerANewUserResponse.getFirstName(), registerANewUserRequest.getFirstName(), "First name didn't match");
        softAssert.assertEquals(registerANewUserResponse.getLastName(), registerANewUserRequest.getLastName(), "Last name didn't match");
        softAssert.assertEquals(registerANewUserResponse.getEmail(), registerANewUserRequest.getEmail(), "Email didn't match");
        softAssert.assertAll();
    }

    public void assertDeleteSingleCrocodile(CrocodileResponse crocodileResponse){
        Assert.assertNull(crocodileResponse, "Delete crocodile contains data");
    }


    public void assertupdateMyCrocodilePut(CrocodileResponse crocodileResponsePut, CrocodileResponse crocodileResponse) {
        softAssert.assertEquals(crocodileResponsePut.getName(), crocodileResponse.getName(), "Name didn't match");
        softAssert.assertEquals(crocodileResponsePut.getAge(), crocodileResponse.getAge(), "Age didn't match");
        softAssert.assertEquals(crocodileResponsePut.getDateOfBirth(), crocodileResponse.getDateOfBirth(), "Date of birth didn't match");
        softAssert.assertEquals(crocodileResponsePut.getSex(), crocodileResponse.getSex(), "Sex didn't match");
        softAssert.assertAll();
    }

    public void assertUpdateMyCrocodilePatch(CrocodileResponse crocodileResponsePatch, CrocodileResponse crocodileResponse) {
        softAssert.assertEquals(crocodileResponsePatch.getName(), crocodileResponse.getName(), "Name didn't match");
        softAssert.assertAll();
    }
}