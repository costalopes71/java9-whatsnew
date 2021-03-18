package com.java9whatsnew.language_improvements;

import static java.util.stream.Collectors.toSet;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class OptionalStreamMethod {

	public static void main(String[] args) {
		
		// interoperabilidade entre Stream e Optional usando o novo metodo
		// Optional.stream()		
		Set<String> authors = Book.getDiferentBooks()
		 	.map(book -> book.getAuthors().stream().findFirst())
		 	.flatMap(Optional::stream)
		 	.collect(toSet());
		 	
		System.out.println(authors);
		
		System.out.println("===================================");
		
		// outro exemplo
		Stream<Optional<Integer>> streamOfIntegers = 
				Stream.of(Optional.of(1), Optional.empty(), Optional.of(3));
		
		Stream<Integer> integers = streamOfIntegers
			.flatMap(Optional::stream);
		
		integers.forEach(System.out::println);
	}
	
}
