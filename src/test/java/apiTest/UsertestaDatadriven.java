package apiTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import apiEndpoints.UserEndPoint;
import apiPayload.User;
import apiUtilities.dataproviders;
import io.restassured.response.Response;

public class UsertestaDatadriven {
	
			
	
	
	@Test(priority=1,dataProvider="alldata",dataProviderClass=dataproviders.class)
	public void testUserPOSTtest(String uID,String uName,String fName, String lName,String email, String password, String phone )
	{
		User userPayload=new User();
		/*
		 * try { userPayload.setId(Integer.parseInt(uID)); } catch(NumberFormatException
		 * e) { System.out.println("number format exception"); }
		 */
		
		userPayload.setId(Integer.parseInt(uID));
		userPayload.setUsername(uName);
		userPayload.setFirstName(fName);
		userPayload.setLastName(lName);
		userPayload.setEmail(email);
		userPayload.setPassword(password);
		userPayload.setPhone(phone);
		
		Response res=UserEndPoint.createUSER(userPayload);
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
		
	}
	
	
	@Test(priority=2,dataProvider="usernames",dataProviderClass=dataproviders.class)
	public void testGETtest(String username)
	{
		
		Response res=UserEndPoint.readUSER(username);
		res.then().log().all();
		
		Assert.assertEquals(res.statusCode(), 200);
	}

}
