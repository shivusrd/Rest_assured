package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class Test03_GET {
	
	@Test
     void Test03() {
		
		
		//specify base URI
		
		RestAssured.baseURI= "https://reqres.in/api/users";
		 
		
		//request object
		RequestSpecification httpRequest=RestAssured.given();
		
	    //respone object
		 
		Response resp=httpRequest.request(Method.GET,"/2");
		
		//print respone in console window
		
		String response=resp.getBody().asString();
		System.out.println("Response body id:"+response);
		
		//status code validation
		int statuscode=resp.getStatusCode();
		System.out.println("status code is:"+statuscode);
		Assert.assertEquals(statuscode, 200);
		
		//status line verification
		String statusline=resp.getStatusLine();
		System.out.println(statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
		
	 //validating headers
		String contentType=resp.header("Content-Type");
		System.out.println("contenttype is"+contentType);
	}
	
	
}
