package com.grocery.steps;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.*;
public class ApiSteps {
  Response response;
  @Given("user hits grocery products API")
  public void hitProducts(){ response = RestAssured.get("https://jsonplaceholder.typicode.com/posts"); }
  @Given("user requests product with id {int}")
  public void getById(int id){ response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/"+id); }
  @Given("user creates a new product with title {string}")
  public void create(String t){ response = RestAssured.given().header("Content-type","application/json").body("{\"title\":\""+t+"\",\"body\":\"grocery\",\"userId\":1}").post("https://jsonplaceholder.typicode.com/posts"); }
  @Given("user updates product {int} with title {string}")
  public void update(int id,String t){ response = RestAssured.given().header("Content-type","application/json").body("{\"title\":\""+t+"\"}").put("https://jsonplaceholder.typicode.com/posts/"+id); }
  @Given("user deletes product {int}")
  public void delete(int id){ response = RestAssured.delete("https://jsonplaceholder.typicode.com/posts/"+id); }
  @Then("status code should be {int}")
  public void status(int c){ assertEquals(c, response.getStatusCode()); }
  @Then("response should contain products")
  public void contains(){ assertTrue(response.asString().length()>10); }
  @Then("product title should not be empty")
  public void title(){ assertNotNull(response.jsonPath().getString("title")); assertFalse(response.jsonPath().getString("title").isEmpty()); }
  @Then("created product id should be present")
  public void idPresent(){ assertNotNull(response.jsonPath().get("id")); }
}
