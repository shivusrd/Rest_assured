	package tests;
import java.net.HttpURLConnection;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class Test01_GET 

{	@Test
	void test01()
	{
		
		Response resp = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(resp.getBody().asString());
		System.out.println(resp.asString());
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getStatusLine());
		System.out.println(resp.getHeader("content type"));
		System.out.println(resp.getTime());
		
		int statuscode = resp.getStatusCode();
		Assert.assertEquals(statuscode, HttpURLConnection.HTTP_OK);
	}

	
	@Test
	void test02() 
	
	{
		RestAssured.given().
		get("https://reqres.in/api/users?page=2").
		then().
		statusCode(200).
		log().all();
		System.out.println("TEst");
		
	}
	
	@Test
	void test03()
	{
		
		RestAssured.given().
		get("https://httpbin.org/").
		then().
		statusCode(200).
		log().all();
		
	}
	
	
}
