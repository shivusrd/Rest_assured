package tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test04_POST {
	
	
	
	@Test
    void Test04() {

		
		//specify base URI
		
		RestAssured.baseURI= "https://reqres.in/api/users";
		 
		
		//request object
		RequestSpecification httpRequest=RestAssured.given();
		
	    //respone object
		 
		JSONObject requestParams=new JSONObject();
		requestParams.put("name", "morpheus");
		requestParams.put("job", "leader");
		
		httpRequest.header("content-Type","application/json");
		
		Response resp=httpRequest.request(Method.POST,"/users");
		
		//print respone in console window
		
		String response=resp.getBody().asString();
		System.out.println("Response body id:"+response);
		
		//status code validation
		int statuscode=resp.getStatusCode();
		System.out.println("status code is:"+statuscode);
		Assert.assertEquals(statuscode, 201);
		
		
		
		/*success validation
		String successcode=resp.jsonPath().getString("id");
		Assert.assertEquals(successcode, "959");*/
		
		
		//status line verification
		String statusline=resp.getStatusLine();
		System.out.println(statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 201 Created");
	}

}
