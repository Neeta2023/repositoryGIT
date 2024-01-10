package apiTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import apiEndpoints.UserEndPoint;
import apiPayload.User;
import io.restassured.response.Response;


//git repository 

// just checking
public class UserTests {
	
	Faker faker;
	User userPayload;
	
	
	@BeforeClass
	public void setupData()
	
	
	{
		faker= new Faker();
		userPayload=new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());	
		
		System.out.println(userPayload.getFirstName());
		System.out.println(userPayload.getUsername());
		System.out.println("*******************");
				
	}
	
	
	@Test(priority=1)
	public void testPOSTUser()
	{
		
		Response res=UserEndPoint.createUSER(userPayload);
		
		res.then().log().all();
		
		//Assert.assertEquals(res.statusCode(), 200);
		
		
	}
	
	
	@Test(priority=2)
	public void testGETUser()
	{
		System.out.println(" **************"+userPayload.getUsername()+"*****************");
		Response res=UserEndPoint.readUSER(userPayload.getUsername());
		res.then().log().all();
		
		
	}
	
	@Test (priority=3)
	public void testUPDATEUser()
	{
		System.out.println("*****************************");
		
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		
		Response res=UserEndPoint.updateUSER(this.userPayload.getUsername(),userPayload);
		res.then().log().body();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		Response res1=UserEndPoint.readUSER(this.userPayload.getUsername());
		res1.then().log().all();
		
		
		
		
		
			
	}
	
	
	@Test (priority=4)
	public void testDELETEuser()
	{
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$  DELETE USER  $$$$$$$$$$$$$$$$$$$$$$$");
		
	    Response res=UserEndPoint.deleteUSER(this.userPayload.getUsername());
	    res.then().log().all();
	    
	    Assert.assertEquals(res.getStatusCode(), 200);
		
	}

}
