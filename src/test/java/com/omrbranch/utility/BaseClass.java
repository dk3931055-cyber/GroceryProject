package com.omrbranch.utility;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
	RequestSpecification reqSpec;

	Response response;



	public void initRestAssured() {

	reqSpec = RestAssured.given();

	}



	public void addHeader(String key, String value) {

	reqSpec = reqSpec.header(key, value);

	}



	public void addBasicAuth(String userId, String password) {

	reqSpec = reqSpec.auth().preemptive().basic(userId, password);

	}



	public void addPayload(String body) {

	reqSpec = reqSpec.body(body);

	}



	public Response sendRequest(String type, String endpoint) {

	switch (type) {

	case "GET":

	response = reqSpec.get(endpoint);

	break;

	case "POST":

	response = reqSpec.post(endpoint);

	break;

	case "PUT":

	response = reqSpec.put(endpoint);

	break;

	case "PATCH":

	response = reqSpec.patch(endpoint);

	break;

	case "DELETE":

	response = reqSpec.delete(endpoint);

	break;



	default:

	break;

	}

	return response;



	}



	public int getStatusCode(Response response) {

	int statusCode = response.getStatusCode();

	return statusCode;

	}



	public String getResBody(Response response) {

	String asPrettyString = response.asPrettyString();

	return asPrettyString;

	}



	public Object jsonPath(Response response, String exp) {

	Object object = response.jsonPath().get(exp);

	return object;

	}
	
	public void addHeaders(Headers headers) {

		reqSpec = reqSpec.headers(headers);

		}



		public void addPayload(Object body) {

		reqSpec = reqSpec.body(body);

		}


}
