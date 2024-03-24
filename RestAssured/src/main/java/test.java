import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.github.javafaker.Faker;

public class test {
	
	public static void main(String [] args) {
		 
		RestAssured.baseURI="https://simple-books-api.glitch.me";
		
		//Get books status
		given().log().all().
		when().get("/status").then().assertThat().statusCode(200)
		.body("status", equalTo("OK"))
		.log().all();
		
		//get all book information.
		String bookInfo= given().log().all().
		when().get("/books").then().assertThat().statusCode(200).log().all().extract().asString();
		
		JsonPath js=new JsonPath(bookInfo);
		String id=js.getString("id[0]");
		System.out.println("the id of the first book is: "+js);
		
		//Get a single book
	   given().pathParam("bookId","1").when().get("/books/{bookId}").
		then().assertThat().statusCode(200).log().all();
	   
	   //Get accessToken.
	     Faker faker=new Faker();
	     String clientName=faker.name().firstName();
	     String clientname=faker.name().lastName();
	   
	  String Token= given().header("Content-Type","application/json").
	   body("{\r\n"
	   		+ "   \"clientName\": \""+clientName+"\",\r\n"
	   		+ "   \"clientEmail\": \""+clientname+"@example.com\"\r\n"
	   		+ "}").post("/api-clients").then().extract().asString();
	       System.out.println(Token);
	  
	     JsonPath tokenJS=new JsonPath(Token);
	     String AccessToken=tokenJS.getString("accessToken");
	    
	     //get orders.
	     String orders= given().headers("Authorization", "Bearer "+AccessToken).when()
	     .get("/orders").then().assertThat().statusCode(200).extract().asString();
	     
	     System.out.println(orders);
	     
	     // get orders by order id.
	     /*given().headers("Authorization", "Bearer "+AccessToken).queryParam("orderid", "1")
	     .when().get("/orders").then().assertThat().statusCode(200).log().all();*/
	     
	     
	}
}
