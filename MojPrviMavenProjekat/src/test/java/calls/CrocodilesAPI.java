package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import data.models.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CrocodilesAPI {

    public static LoginResponse login(LoginRequest loginRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("auth/token/login/", loginRequest), LoginResponse.class);
    }

    public static CreateCrocodileResponse createNewCrocodile(String accessToken, CreateCrocodileRequest createCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("my/crocodiles/", accessToken, createCrocodileRequest), CreateCrocodileResponse.class);
    }

    public static RegisterANewUserResponse registerNewUser(String accessToken, RegisterANewUserRequest registerANewUserRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("user/register/", accessToken, registerANewUserRequest), RegisterANewUserResponse.class);
    }

    public static CrocodileResponse[] getPublicCrocodileResponse() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("public/crocodiles/"), CrocodileResponse[].class);
    }

    public static GetASinglePublicCrocodileResponse getASinglePublicCrocodileResponse(){
        return  GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("/public/crocodiles/1/"),  GetASinglePublicCrocodileResponse.class);
    }

    public static CrocodileResponse[] getMyCrocodilesResponses(String accessToken){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("/my/crocodiles/", accessToken), CrocodileResponse[].class);
    }

    public static CrocodileResponse getMyCrocodileResponse(String accessToken){
        return  GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("/my/crocodiles/" + GetId(accessToken),accessToken),  CrocodileResponse.class);
    }

    public static String GetId(String accessToken) {
        Response responseAllCrocodiles = RestAssuredFunctions.get("my/crocodiles/" , accessToken);
        String responseAsString = responseAllCrocodiles.body().asString();
        return responseAsString.substring(responseAsString.indexOf("{\"id\":") + 6, responseAsString.indexOf(",\""));
    }

    public static CrocodileResponse deleteMyCrocodileResponse(String accessToken) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete("/my/crocodiles/" + GetId(accessToken) + "/",accessToken),  CrocodileResponse.class);
    }

    public static CrocodileResponse updateMyCrocodileResponsePatch(String accessToken, Object requestBody) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.patch("my/crocodiles/" + GetId(accessToken) +"/", accessToken, requestBody), CrocodileResponse.class);
    }

    public static CrocodileResponse updateMyCrocodileResponsePut(String accessToken, Object requestBody) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put("my/crocodiles/" + GetId(accessToken) +"/", accessToken, requestBody), CrocodileResponse.class);
    }
}
