package br.com.mpontoc.mpontoc_rest_test;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.CoreMatchers.*;

import static io.restassured.RestAssured.*;

public class ValidaStatusCode {
	
	@Test
	public void validaStatusCodeAquino() {
		
		Response response = RestAssured.request(Method.GET,"http://restapi.wcaquino.me/ola/");
		
		System.out.println(response.getStatusCode());
		
		System.out.println(response.getBody().asString());
		
		ValidatableResponse validacao  = response.then();
		validacao.statusCode(200);

	}

}
