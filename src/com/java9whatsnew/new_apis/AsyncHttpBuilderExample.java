package com.java9whatsnew.new_apis;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;
import jdk.incubator.http.HttpResponse.BodyHandler;

public class AsyncHttpBuilderExample {

	public static void main(String[] args) throws URISyntaxException {
		
		HttpClient.Builder builder = HttpClient.newBuilder();
		
		HttpClient client = builder.version(HttpClient.Version.HTTP_2)
			.followRedirects(HttpClient.Redirect.ALWAYS)
			.build();
		
		HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.google.com"))
			.header("User-Agent", "Java")
			.timeout(Duration.ofMillis(500))
			.GET()
			.build();
		
		CompletableFuture<HttpResponse<String>> response = 
			client.sendAsync(request, BodyHandler.asString());
		
		response.thenAccept(res -> {
			System.out.println("Version:" + res.version());
			System.out.println(res.body());
		});
		
		response.join();
	}
	
}
