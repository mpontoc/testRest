package br.com.mpontoc.mpontoc_rest_test;

import static org.hamcrest.CoreMatchers.*;
import static io.restassured.RestAssured.given;

import org.junit.Test;
import org.junit.Assert;


public class TestAPI {
	
	
	@Test
	
	public void validaApiPokemon() {
		
		String name = 
			
			given()
			.log().all()
			.when()
				.get("https://pokeapi.co/api/v2/pokemon-form/25/")
			.then()
			.log().all()
			.body("name" , is("pikachu"))
			.body("name", containsString("pikachu"))
			.statusCode(200)
			.extract()
			.path("name")
	
		;
		
		System.out.println("Este é o " + name);
		
		Assert.assertEquals("pikachu" , name);
		
		
	}
	
	
	@Test
	
	public void validaBodyWebMotors() {
		
		given()
		.when()
			.get("http://desafioonline.webmotors.com.br/api/OnlineChallenge/Vehicles?Page=2")
		.then()
			.log().all()
			.body("ID", hasItem(11))
			.body("Make", hasItem("Mitsubishi"))
			.body("Model", hasItem("Lancer"))
			.body("Version", hasItem("2.0 EVO 4P AUTOMÁTICO"))
			.statusCode(200)
		;
	}

}
