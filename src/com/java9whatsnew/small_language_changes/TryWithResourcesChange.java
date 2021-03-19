package com.java9whatsnew.small_language_changes;

import java.io.FileInputStream;

public class TryWithResourcesChange {

	public void beforeTryWithResource(FileInputStream fis) {
		try (FileInputStream fis2 = fis) {
			
		} catch (Exception e) { }
	}
	
	public void java9TryWithResource(FileInputStream fis) {
		try (fis) {
			// para tanto a variavel deve ser efetivamente final 
			// (ou seja, nao deve ser atribuida em nenhum momento (como nos lambdas)
		} catch (Exception e) { }
	}
	
}