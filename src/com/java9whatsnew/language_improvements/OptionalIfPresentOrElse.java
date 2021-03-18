package com.java9whatsnew.language_improvements;

import java.util.Optional;

public class OptionalIfPresentOrElse {

	public static void main(String[] args) {
		
		// antes
		Optional<Book> presentBook = Optional.of(Book.getBook());
		
		presentBook.ifPresent(System.out::println);
		
		if (!presentBook.isPresent()) {
			System.out.println("Nothing here!");
		}
		
		// com o novo metodo ifPresentOrElse
		
		presentBook.ifPresentOrElse(System.out::println, 
				() -> System.out.println("Nothing here"));
		
		Optional<Book> emptyBook = Optional.empty();
		
		emptyBook.ifPresentOrElse(System.out::println, 
				() -> System.out.println("Nothing here"));
		
		
	}
	
}
