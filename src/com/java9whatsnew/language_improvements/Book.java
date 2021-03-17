package com.java9whatsnew.language_improvements;

import java.util.Set;
import java.util.stream.Stream;

public class Book {

	private final String title;
	private final Set<String> authors;
	private final double price;
	
	public Book(String title, Set<String> authors, double price) {
		this.title = title;
		this.authors = authors;
		this.price = price;
	}

	public static Book getBook() {
		return new Book("Banana de Pijamas", Set.of("B1", "B2"), 20.50);	
	}
	
	public static Stream<Book> getBooks() {
		return Stream.of(getBook(), getBook());
	}
	
	public String getTitle() {
		return title;
	}

	public Set<String> getAuthors() {
		return authors;
	}

	public double getPrice() {
		return price;
	}

}
