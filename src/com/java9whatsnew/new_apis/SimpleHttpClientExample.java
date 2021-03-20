package com.java9whatsnew.new_apis;

import java.io.IOException;
import java.net.URI;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

public class SimpleHttpClientExample {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("https://www.pluralsight.com"))
			.GET()
			.build();
		
		HttpResponse<String> response = 
			httpClient.send(httpRequest, HttpResponse.BodyHandler.asString());
		
		if (response.statusCode() == 200)
			System.out.println(response.headers().map());
		
	}
	
}