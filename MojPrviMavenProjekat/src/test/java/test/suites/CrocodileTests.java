package test.suites;

import calls.CrocodilesAPI;
import common.GsonFunctions;
import common.RestAssuredFunctions;
import data.models.*;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.asserts.CrocodileAsserts;
import test.common.TestBase;

public class CrocodileTests extends TestBase {

    public CrocodileAsserts crocodileAsserts = new CrocodileAsserts();

    @Test
    public void loginTest() {
        Assert.assertFalse(accessToken.isEmpty(), "Access token is empty");
    }

    @Test
    @Description("verify crocodile is created")
    public void createCrocodileTest() {
        CreateCrocodileRequest createCrocodileRequest = new CreateCrocodileRequest("New crocodile created1", "M", "2021-03-14");

        CreateCrocodileResponse createCrocodileResponse = CrocodilesAPI.createNewCrocodile(accessToken, createCrocodileRequest);

        crocodileAsserts.assertCreateNewCrocodile(createCrocodileResponse, createCrocodileRequest);
    }

    @Test
    @Description("Register a new user")
    public void registerANewUser() {
        RegisterANewUserRequest registerANewUserRequest = new RegisterANewUserRequest("newUserMajdertester123456", "Mila", "Ajder", "newuser123456.milla.ajder.tester21@gmail.com", "test");
        RegisterANewUserResponse registerANewUserResponse = CrocodilesAPI.registerNewUser(accessToken, registerANewUserRequest);
        crocodileAsserts.assertRegisterANewUser(registerANewUserResponse, registerANewUserRequest);
    }

    @Test
    @Description("Get list of public crocodiles")
    public void getListOfPublicCrocodiles() {
        CrocodileResponse[] getPublicCrocodileResponse = CrocodilesAPI.getPublicCrocodileResponse();
        crocodileAsserts.assertListOfCrocodiles(getPublicCrocodileResponse);
    }


    @Test
    @Description("Get a single public crocodile")
    public void getASingleCrocodile() {
        GetASinglePublicCrocodileResponse getASinglePublicCrocodileResponse = CrocodilesAPI.getASinglePublicCrocodileResponse();
        crocodileAsserts.assertASingleCrocodile(getASinglePublicCrocodileResponse);
    }




    @Test
    @Description("Get my private crocodiles")
    public void getListOfMyCrocodiles() {
        CrocodileResponse[] getCrocodileResponse = CrocodilesAPI.getMyCrocodilesResponses(accessToken);
        crocodileAsserts.assertListOfCrocodiles(getCrocodileResponse);
    }

    @Test
    @Description("Get a single private crocodile")
    public void getMySingleCrocodile() {
        CrocodileResponse getCrocodileResponse = CrocodilesAPI.getMyCrocodileResponse(accessToken);
        crocodileAsserts.assertASingleCrocodile(getCrocodileResponse);
    }

    @Test
    @Description("Delete a single private crocodile")
    public void deleteMyCrocodile() {
        CrocodileResponse crocodileResponse = CrocodilesAPI.deleteMyCrocodileResponse(accessToken);
        crocodileAsserts.assertDeleteSingleCrocodile(crocodileResponse);
    }

    @Test
    @Description("Update a single private crocodile with Patch")
    public void updateMyCrocodileWithPatch() {
        CrocodileResponse crocodileResponse = CrocodilesAPI.getMyCrocodileResponse(accessToken);
        crocodileResponse.setName("Garica");
        CrocodileResponse crocodileResponsePatch = CrocodilesAPI.updateMyCrocodileResponsePatch(accessToken,crocodileResponse);
        crocodileAsserts.assertUpdateMyCrocodilePatch(crocodileResponsePatch, crocodileResponse);
    }


    @Test
    @Description("Update a single private crocodile with Put")
    public void updateMyCrocodileWithPut() {
        CrocodileResponse crocodileResponse = CrocodilesAPI.getMyCrocodileResponse(accessToken);
        crocodileResponse.setName("Mila");
        crocodileResponse.setAge(26);
        crocodileResponse.setDateOfBirth("1995-11-11");
        crocodileResponse.setSex("F");
        CrocodileResponse crocodileResponsePut = CrocodilesAPI.updateMyCrocodileResponsePut(accessToken,crocodileResponse);
        crocodileAsserts.assertupdateMyCrocodilePut(crocodileResponsePut, crocodileResponse);
    }



}







