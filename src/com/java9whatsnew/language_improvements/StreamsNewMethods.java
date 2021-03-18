package com.java9whatsnew.language_improvements;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import java.util.Map;
import java.util.Set;

public class StreamsNewMethods {

	public static void main(String[] args) {
	
		// new filtering method on Stream api
		Map<Set<String>, Set<Book>> booksByAuthors = Book.getDiferentBooks()
			.collect(
				groupingBy(Book::getAuthors, 
					filtering(
						book -> book.getPrice() > 10.0, 
						toSet())
				)
			);
		
		System.out.println(booksByAuthors);
		
		// new flatMapping method on Stream api
		Map<Double, Set<String>> authorsSellingForPrice = Book.getDiferentBooks()
			.collect(
				groupingBy(Book::getPrice, 
					flatMapping(book -> book.getAuthors().stream(), 
							toSet()
					)
				)
			);
		
		System.out.println(authorsSellingForPrice);
	}
	
}
