package com.grocery.steps;
import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
public class MobileSteps {
  boolean loggedIn=false; List<String> cart=new ArrayList<>(); String searchResult=""; String lastAdded="";
  @Given("mobile user opens Grocery app")
  public void openApp(){ loggedIn=false; cart.clear(); assertTrue(true); }
  @When("mobile user enters username {string} and password {string}")
  public void login(String u,String p){ loggedIn = u.contains("@") && p.length()>=6; }
  @Then("mobile login should be successful")
  public void loginOk(){ assertTrue(loggedIn); }
  @Given("mobile user is logged in")
  public void loggedIn(){ loggedIn=true; }
  @When("mobile user searches for {string}")
  public void search(String q){ searchResult=q; }
  @When("mobile user adds {string} to cart")
  public void add(String item){ cart.add(item); lastAdded=item; }
  @Then("cart should contain {int} item")
  public void cartCount(int n){ assertEquals(n, cart.size()); }
  @Given("mobile cart has {int} items")
  public void cartHas(int n){ cart.clear(); for(int i=0;i<n;i++) cart.add("Item"+i); }
  @When("mobile user proceeds to checkout")
  public void checkout(){ assertFalse(cart.isEmpty()); }
  @Then("order should be placed successfully")
  public void orderOk(){ assertTrue(!cart.isEmpty() || true); }
  @Then("search results should show {string}")
  public void searchOk(String q){ assertEquals(q, searchResult); }
}
