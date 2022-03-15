package tests;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Given;
import com.google.gson.JsonObject;
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

		given().body(req.toJSONString()).
		when().post("https://reqres.in/api/users").then().statusCode(201);

	}

}
