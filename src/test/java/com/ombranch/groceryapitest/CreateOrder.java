package com.ombranch.groceryapitest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.omrbranch.pojo.addAddress.AddNewAddress_Input_Pojo;
import com.omrbranch.pojo.addAddress.AddNewAddress_Output_Pojo;
import com.omrbranch.pojo.addtocart.AddToCartVariation;
import com.omrbranch.pojo.addtocart.AddToCart_Input_Pojo;
import com.omrbranch.pojo.addtocart.AddToCart_Output_Pojo;
import com.omrbranch.pojo.basiclogin.PostmanBasicLogin_Output__Pojo;
import com.omrbranch.pojo.citylist.CityData;
import com.omrbranch.pojo.citylist.CityList_Input_Pojo;
import com.omrbranch.pojo.citylist.CityList_Output_Pojo;
import com.omrbranch.pojo.createorder.CreateOrder_Input_Pojo;
import com.omrbranch.pojo.createorder.Create_Order_Output_Pojo;
import com.omrbranch.pojo.getcartitems.GetCartData;
import com.omrbranch.pojo.getcartitems.GetCartItems_Output_Pojo;
import com.omrbranch.pojo.getcategorylist.CategoryData;
import com.omrbranch.pojo.getcategorylist.CategoryList_Output_Pojo;
import com.omrbranch.pojo.getcategorylist.ChildCatList;
import com.omrbranch.pojo.getsearchresult.GetSearchListData;
import com.omrbranch.pojo.getsearchresult.GetSearchList_Output_Pojo;
import com.omrbranch.pojo.getsearchresult.GetSearchResult_Input_Pojo;
import com.omrbranch.pojo.getsearchresult.Variation;
import com.omrbranch.pojo.produclist.ProductListData;
import com.omrbranch.pojo.produclist.ProductList_Input_Pojo;
import com.omrbranch.pojo.produclist.ProductList_Output_Pojo;
import com.omrbranch.pojo.searchproduct.ProductSearchData;
import com.omrbranch.pojo.searchproduct.SearchProduct_Input_Pojo;
import com.omrbranch.pojo.searchproduct.SearchProduct_Output_Pojo;
import com.omrbranch.pojo.setaddress.SetAddress_Input_Pojo;
import com.omrbranch.pojo.setaddress.SetAddress_Output_Pojo;
import com.omrbranch.pojo.statelist.StateList_Output_Pojo;
import com.omrbranch.pojo.statelist.stateDatas;
import com.omrbranch.utility.BaseClass;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class CreateOrder extends BaseClass {
	String logtoken;
	String categoryId;
	String categoryName;
	String productId;
	String productVariationId;
	String cartId;
	int stateId;
	int cityId;
	String addressId;
	public void groceryLogin() {
		initRestAssured();
		addHeader("accept", "application/json");
		addBasicAuth("dk3931055@gmail.com", "Dinesh@123");
		Response response = sendRequest("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		String resBody = getResBody(response);
		System.out.println(resBody);

		// Read
//		PostmanBasicLogin_Output__Pojo postmanBasicLogin_Output__Pojo = response
//				.as(PostmanBasicLogin_Output__Pojo.class);
		PostmanBasicLogin_Output__Pojo postmanBasicLogin_Output__Pojo = response.as(PostmanBasicLogin_Output__Pojo.class);
		 logtoken = postmanBasicLogin_Output__Pojo.getData().getLogtoken();
		System.out.println(logtoken);

	}
	public void getCategoryList() {
		initRestAssured();
		addHeader("accept", "application/json");
		Response response = sendRequest("GET", "https://www.omrbranch.com/api/categoryList");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		CategoryList_Output_Pojo categoryList_Output_Pojo = response.as(CategoryList_Output_Pojo.class);
		ArrayList<CategoryData> data = categoryList_Output_Pojo.getData();
		System.out.println(data);
//		for (CategoryData categoryData : data) {
//
//			if (categoryData.getChild_cat_list() != null) {
//
//				for (ChildCatList childCatList : categoryData.getChild_cat_list()) {
//
//					if (childCatList.getName().equals("Fruit & Nuts")) {
//                        int id = childCatList.getId();
//                         categoryId = String.valueOf(id);
//                          categoryName = childCatList.getName();
//						System.out.println("Category Name: " + categoryName);
//						System.out.println("Category ID: " + categoryId);
//
//					}
//				}
//			}
//		}
		//Alias Techniques up
		for (CategoryData categoryData : data) {
			
			for (ChildCatList child : categoryData.getChild_cat_list()) {
				if (child.getName().equals("Fruit & Nuts")) {
					int id = child.getId();
                categoryId = String.valueOf(id);
                categoryName = child.getName();
				System.out.println("Category Name: " + categoryName);
				System.out.println("Category ID: " + categoryId);

				}
			}
			
		}
	}

	public void productList() {

		initRestAssured();
		List<Header>  lstHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		lstHeader.add(h1);
		lstHeader.add(h2);
		Headers headers = new Headers(lstHeader);
		addHeaders(headers);
		ProductList_Input_Pojo productList_Input_Pojo = new ProductList_Input_Pojo(categoryId, "0");
		addPayload(productList_Input_Pojo);
		Response response = sendRequest("POST", "https://www.omrbranch.com/api/productList");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		String resBody = getResBody(response);
		//System.out.println(resBody);
		ProductList_Output_Pojo productList_Output_Pojo = response.as(ProductList_Output_Pojo.class);
		ArrayList<ProductListData> productData = productList_Output_Pojo.getData();
		System.out.println(productData);
		for (ProductListData productListData : productData) {
			if (productListData.getName().contains("Tata Sampann")) {
				int id = productListData.getId();
			   productId = String.valueOf(id);
				System.out.println(productListData.getName());
				System.out.println(productListData.getId());
			}
		}

	}
	public void productSearch() {
       initRestAssured();
       List<Header>  lstHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		lstHeader.add(h1);
		lstHeader.add(h2);
		Headers headers = new Headers(lstHeader);
		addHeaders(headers);
		SearchProduct_Input_Pojo searchProduct_Input_Pojo = new SearchProduct_Input_Pojo("Nuts");
		addPayload(searchProduct_Input_Pojo);
		Response response = sendRequest("POST", "https://www.omrbranch.com/api/searchProduct");
		int statusCode = getStatusCode(response);
		String resBody = getResBody(response);
		System.out.println(statusCode);
		//System.out.println(resBody);
		SearchProduct_Output_Pojo searchProduct_Output_Pojo = response.as(SearchProduct_Output_Pojo.class);
		ArrayList<ProductSearchData> data = searchProduct_Output_Pojo.getData();
		for (ProductSearchData productSearchData : data) {
			if (productSearchData.getText().contains("Tata")) {
				System.out.println(productSearchData.getText());
				
				System.out.println("Product Name: " + productSearchData.getText());
		        
			}
		}
       
		
	}
	public void getSearchResult() {
		initRestAssured();
		List<Header>  lstHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		
		lstHeader.add(h1);
		lstHeader.add(h2);
		lstHeader.add(h3);
		Headers headers = new Headers(lstHeader);
		addHeaders(headers);
		GetSearchResult_Input_Pojo getSearchResult_Input_Pojo = new GetSearchResult_Input_Pojo(categoryId, productId, "category");
		addPayload(getSearchResult_Input_Pojo);
		Response response = sendRequest("POST", "https://www.omrbranch.com/api/getSearchResult");
		int statusCode = response.statusCode();
		String resBody = getResBody(response);
		System.out.println(statusCode);
		System.out.println(resBody);
		GetSearchList_Output_Pojo getSearchList_Output_Pojo = response.as(GetSearchList_Output_Pojo.class);
		ArrayList<GetSearchListData> data = getSearchList_Output_Pojo.getData();
		for (GetSearchListData getSearchListData : data) {
			getSearchListData.getVariations();
			if (getSearchListData.getName().contains("Tata")) {
				//int actualProduct_Id = getSearchListData.getId();
				// actualProductId = String.valueOf(actualProduct_Id);
				 int product_variation_id = getSearchListData.getProduct_variation_id();
				// productVariationId = String.valueOf(product_variation_id);
				//System.out.println(productVariationId);
				
			}
			//ArrayList<Variation> variations = getSearchListData.getVariations();
			for (Variation variation : getSearchListData.getVariations()) {
				variation.getSpecifications();
				System.out.println(variation.getId());
				 productVariationId = String.valueOf(variation.getId());
				}
			

		}
		
		
	}
	public void addToCart() {
		initRestAssured();
		List<Header>  lstHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		lstHeader.add(h1);
		lstHeader.add(h2);
		lstHeader.add(h3);
		Headers headers = new Headers(lstHeader);
		addHeaders(headers);
		AddToCart_Input_Pojo addToCart_Input_Pojo = new AddToCart_Input_Pojo(productId, productVariationId, "plus");
		addPayload(addToCart_Input_Pojo);
		Response response = sendRequest("POST", "https://www.omrbranch.com/api/addToCart");
		int statusCode = getStatusCode(response);
		String resBody = getResBody(response);
		System.out.println(statusCode);
		System.out.println(resBody);
		
		AddToCart_Output_Pojo addToCart_Output_Pojo = response.as(AddToCart_Output_Pojo.class);
		ArrayList<AddToCartVariation> variations = addToCart_Output_Pojo.getData().getVariations();
		System.out.println(variations);
		
		

	}
	public void getCartItems() {
		initRestAssured();
		List<Header>  lstHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		//Header h3 = new Header("Content-Type", "application/json");
		lstHeader.add(h1);
		lstHeader.add(h2);
		//lstHeader.add(h3);
		Headers headers = new Headers(lstHeader);
		addHeaders(headers);
		Response response = sendRequest("GET", "https://www.omrbranch.com/api/getCartItems");
		GetCartItems_Output_Pojo getCartItems_Output_Pojo = response.as(GetCartItems_Output_Pojo.class);
		System.out.println(response.asPrettyString());
	    ArrayList<GetCartData> data = getCartItems_Output_Pojo.getData();
	    for (GetCartData getCartData : data) {
			int cart_id = getCartData.getCart_id();
			 cartId = String.valueOf(cart_id);
			System.out.println(cartId);
		}

	}
	public void stateList() {
		initRestAssured();
		addHeader("accept", "application/json");
		Response response = sendRequest("GET", "https://www.omrbranch.com/api/stateList");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		
		String resBody = getResBody(response);
		System.out.println(resBody);
		
		//StateList_Output_Pojo stateList_Output_Pojo = response.as(StateList_Output_Pojo.class);
		//ArrayList<stateDatas> data = stateList_Output_Pojo.getData();
		StateList_Output_Pojo stateList_Output_Pojo = response.as(StateList_Output_Pojo.class);
		ArrayList<stateDatas> data = stateList_Output_Pojo.getData();
		System.out.println(data);
		
		for (stateDatas stateDatas : data) {
			if(stateDatas.getName().equals("Tamil Nadu")) {
				 String  state_Id = String.valueOf(stateDatas.getId());
				  stateId = stateDatas.getId();
				System.out.println("State Name is : "+stateDatas.getName());
				System.out.println("StateId is : "+stateId);
			}
			
		}
        
	}
	public void cityList() {
		initRestAssured();
		List<Header> lstHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
        lstHeader.add(h1);
		lstHeader.add(h2);
		Headers headers = new Headers(lstHeader);
		addHeaders(headers);
		CityList_Input_Pojo cityList_Input_Pojo =  new CityList_Input_Pojo(String.valueOf(stateId));
		addPayload(cityList_Input_Pojo);
		Response response = sendRequest("POST", "https://www.omrbranch.com/api/cityList");
		int statusCode = getStatusCode(response);
		System.out.println("city: "+statusCode);
		String resBody = getResBody(response);
		CityList_Output_Pojo cityList_Output_Pojo = response.as(CityList_Output_Pojo.class);
		ArrayList<CityData> data = cityList_Output_Pojo.getData();
		System.out.println(data);
		
		for (CityData cityData : data) {
			
			String cityName = cityData.getName();
			if (cityName.equals("Tiruchchendur")) {
				String city_Id = String.valueOf(cityData.getId());
				 cityId = cityData.getId();
				System.out.println("City id is: "+cityId);
				System.out.println("City Name is: "+cityName);
			}
			
			
			
		}

	}
	public void addUserAddress() {

		initRestAssured();
		List<Header> lstHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		lstHeader.add(h1);
		lstHeader.add(h2);
		lstHeader.add(h3);
		Headers headers = new Headers(lstHeader);
		addHeaders(headers);
		AddNewAddress_Input_Pojo addNewAddress_Input_Pojo = new AddNewAddress_Input_Pojo("Rishi",
				"Murugan", "9150362186", "Temple", stateId, cityId, 101, "202020",
				"Subramanya Swamy Koil Tiruchendur", "home");
		addPayload(addNewAddress_Input_Pojo);
		Response response = sendRequest("POST", "https://www.omrbranch.com/api/addUserAddress");
		int statusCode = getStatusCode(response);
		String resBody = getResBody(response);
		System.out.println(resBody);
		System.out.println(statusCode);
		AddNewAddress_Output_Pojo addNewAddress_Output_Pojo = response.as(AddNewAddress_Output_Pojo.class);
		int address_id = addNewAddress_Output_Pojo.getAddress_id();
		 addressId = String.valueOf(address_id);
	}
	public void setAddress() {
		initRestAssured();
		List<Header> lstHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		lstHeader.add(h1);
		lstHeader.add(h2);
		lstHeader.add(h3);
		Headers headers = new Headers(lstHeader);
		addHeaders(headers);
		SetAddress_Input_Pojo setAddress_Input_Pojo = new SetAddress_Input_Pojo(addressId, cartId);
		System.out.println(addressId+cartId);
		addPayload(setAddress_Input_Pojo);
		Response response = sendRequest("POST", "https://www.omrbranch.com/api/setAddress");
		int statusCode = getStatusCode(response);
		String resBody = getResBody(response);
		System.out.println(statusCode);
		System.out.println(resBody);
		SetAddress_Output_Pojo setAddress_Output_Pojo = response.as(SetAddress_Output_Pojo.class);
		System.out.println(setAddress_Output_Pojo);
	}
	public void createOrderId() {
		initRestAssured();
		List<Header> lstHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		lstHeader.add(h1);
		lstHeader.add(h2);
		lstHeader.add(h3);
		Headers headers = new Headers(lstHeader);
		addHeaders(headers);
		CreateOrder_Input_Pojo createOrder_Input_Pojo = new CreateOrder_Input_Pojo("debit_card", "5555555555552222", "visa", "2028", "03", "123");
		addPayload(createOrder_Input_Pojo);
	Response response = sendRequest("POST", "https://www.omrbranch.com/api/createOrder");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		String resBody = getResBody(response);
		System.out.println(resBody);
		Create_Order_Output_Pojo create_Order_Output_Pojo = response.as(Create_Order_Output_Pojo.class);
		int order_id = create_Order_Output_Pojo.getOrder_id();
		String message = create_Order_Output_Pojo.getMessage();
		System.out.println("Rishikumar your "+message+"Your order id is: "+order_id+" Use it for Tracking");

	}
	public static void main(String[] args) {
		CreateOrder createOrder = new CreateOrder();
		createOrder.groceryLogin();
		createOrder.getCategoryList();
		createOrder.productList();
		createOrder.productSearch();
		createOrder.getSearchResult();
		createOrder.addToCart();
		createOrder.getCartItems();
		createOrder.stateList();
		createOrder.cityList();
		createOrder.addUserAddress();
		createOrder.setAddress();
		createOrder.createOrderId();
	}

}
