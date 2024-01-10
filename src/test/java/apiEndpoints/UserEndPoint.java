package apiEndpoints;

import static io.restassured.RestAssured.given;

import apiPayload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoint {
	
	
	public static Response createUSER(User payload)
	{
		
		Response res=given()
		                .contentType("application/json")
		                .accept("application/json")
		                .body(payload)
		      
		            .when()
		                .post(Routes.post_url);
		return res;
		
		
	}
	
	public static Response readUSER(String Username)
	{
		
		Response res=given()
				           .pathParam("username", Username)
		      
		     
		      
		            .when()
		                  .get(Routes.get_url);
		
		                     
		return res;
		
		
	}
	
	
	
	public static Response updateUSER(String userName, User payload)
	{
		
		Response res=given()
		      .contentType(ContentType.JSON)
		      .accept(ContentType.JSON)
		      .pathParam("username", userName)
		      .body(payload)
		      
		.when()
		      .put(Routes.update_url);
		return res;
		
		
	}
	
	
	public static Response deleteUSER(String Username)
	{
		
		Response res=given()
				           .pathParam("username", Username)
		      
		     
		      
		            .when()
		                 .delete(Routes.delete_url);
		return res;
		
		
	}
	
	
	
	

}
