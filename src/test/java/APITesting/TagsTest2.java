package APITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TagsTest2 {
  @Test
  public void getAllTags() {
	  
	  RestAssured.baseURI= "https://conduit-realworld-example-app.fly.dev";
	  
	  Response response= RestAssured.get("/api/tags");
	  
	  int statusCode= response.getStatusCode();
	  
	  Assert.assertEquals(statusCode,200);
	  Assert.assertEquals(response.getContentType(),"application/json; charset=utf-8");
	  
	  //Retrieve the Body of Response 
	  
	  ResponseBody body=response.getBody();
	  
	  String bodyAsString=body.asString();
	  
	  System.out.println(bodyAsString);
  }
  
 
}
