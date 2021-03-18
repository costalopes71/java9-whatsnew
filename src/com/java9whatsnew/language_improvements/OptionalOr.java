package com.java9whatsnew.language_improvements;

import java.util.Optional;

public class OptionalOr {

	public static void main(String[] args) {
		
		// antes, no java 8
		Optional<Book> localFallback = Optional.of(Book.getBook());
		
		Book bestBookBefore = getBestOffer()
				.orElse(getExternalOffer().orElse(localFallback.get())); // .get eh RUIM
		// .get eh ruim pois nao sabemos se um livro vai ser realmente retornado
		// tambem precisamos ficar concatenando chamadas orElse
		
		System.out.println(bestBookBefore);
		
		System.out.println("====================================");
		
		// java 9 metodo or
		Optional<Book> bestBookAfter = getBestOffer()
			.or(() -> getExternalOffer()) // como essa chamada retorna um optional com valor, o proximo elo (or) nao sera chamado
			.or(() -> localFallback);
		
		System.out.println(bestBookAfter);
	}

	private static Optional<Book> getExternalOffer() {
		return Optional.of(Book.getBook("External Book", "Bruxao", 10.50));
	}
	
	private static Optional<Book> getBestOffer() {
		return Optional.empty();
	}
	
}
