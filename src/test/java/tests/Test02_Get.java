package tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Test02_Get

{	@Test
	public void test_01() 
	{
		given().
		get("https://reqres.in/api/users?page=2").
		then().
		statusCode(200).
		body("data.id[2]",is(9)).
		body("data.first_name",hasItems("Byron")).
		log().
		all();
	
	
	}

}
