package com.java9whatsnew.small_language_changes;

import java.util.ArrayList;
import java.util.List;

public class DiamondOperatorChange {

	@SuppressWarnings({ "unused", "rawtypes", "serial" })
	public void beforeJava9() {
		// diamod operators nao eram aceitos em classes anonimas
		ArrayList lista = new ArrayList() {
			@SuppressWarnings("unchecked")
			@Override
			public boolean add(Object s) {
				return super.add(s);
			}
		};		
	}
	
	@SuppressWarnings({ "serial", "unused" })
	public void afterJava9() {
		// eh possivel usar o diamond operator nas classes anonimas
		List<String> lista = new ArrayList<>() {
			@Override
			public boolean add(String s) {
				System.out.println(s);
				return super.add(s);
			}
		};
	}
	
}