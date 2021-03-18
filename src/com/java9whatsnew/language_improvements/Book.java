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
	
	public static Book getBook(String title, String author, double price) {
		return new Book(title, Set.of(author), price);	
	}
	
	public static Stream<Book> getBooks() {
		return Stream.of(getBook(), getBook());
	}
	
	public static Stream<Book> getDiferentBooks() {
		return Stream.of(getBook(), 
				getBook("Livro 1", "Joao", 10.0),
				getBook("Livro 2", "Paulo", 9.0),
				getBook("Livro 3", "Ricardo", 20.50));
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

	@Override
	public String toString() {
		return "[Book: " + title + ", author: " + authors + ", price: " + price + "]";
	}
	
}