package tests;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Given;
import com.google.gson.JsonObject;

import io.restassured.http.ContentType;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Test02_POST

{

	@Test
	public void test01_post() {

//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		
//		map.put("name", "shivam");
//		map.put("job", "QA");
//		System.out.println(map);
//		
		JSONObject req = new JSONObject();

		req.put("name", "shivam");
		req.put("job", "QA");
		System.out.println(req);
		System.out.println(req.toJSONString());

		given().
		header("Content-Type","aplication/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(req.toJSONString()).
		when().post("https://reqres.in/api/users").then().statusCode(201).log().all();

	}
	
	

		@Test
		public void test02_put() 
		{


			JSONObject req = new JSONObject();

			req.put("name", "shivam");
			req.put("job", "QA");
			System.out.println(req);
			System.out.println(req.toJSONString());

			given().
			header("Content-Type","aplication/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
			when().put("https://reqres.in/api/users/2").then().statusCode(200).log().all();

		}
		
		@Test
		public void test03_patch() 
		{


			JSONObject req = new JSONObject();

			req.put("name", "shivam");
			req.put("job", "QA");
			System.out.println(req);
			System.out.println(req.toJSONString());

			given().
			header("Content-Type","aplication/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
			when().patch("https://reqres.in/api/users/2").then().statusCode(200).log().all();

		}
		
		@Test
		public void test04_patch() 
		{


			
			when().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();

		}
		
		

}
