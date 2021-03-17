package com.java9whatsnew.language_improvements;

import java.util.stream.Stream;

public class OfNullable {

	public static void main(String[] args) {

		// ofNullable creates an empty Stream if null
		long zero = Stream.ofNullable(null).count();
		long one = Stream.ofNullable(Book.getBook()).count();

		System.out.printf("zero: %d, one: %d", zero, one);
		
		System.out.println("--------");
		System.out.println("Before ofNullable");
		
		// Before ofNullable
		Book book = getPossiblyNull(false);
		Stream<String> authors = 
				book == null ? Stream.empty() : book.getAuthors().stream();
		authors.forEach(System.out::println);
		
		System.out.println("With ofNullable");
		// With ofNullable
		Stream.ofNullable(getPossiblyNull(false))
			.flatMap(book2 -> book2.getAuthors().stream())
			.forEach(System.out::println);
		
	}

	private static Book getPossiblyNull(boolean isNull) {
		return isNull ? null : Book.getBook();
	}
	
}
