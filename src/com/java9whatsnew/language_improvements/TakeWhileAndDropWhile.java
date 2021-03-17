package com.java9whatsnew.language_improvements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TakeWhileAndDropWhile {

	public static void main(String[] args) throws IOException {
		
		Files.lines(Paths.get("resources/conflict.txt"))
			.dropWhile(line -> !line.startsWith("<<<<<<<<<<"))
			.skip(1)
			.takeWhile(line -> !line.startsWith(">>>>>>>>>>"))
			.forEach(System.out::println);;
		
		
	}
	
}
