package com.java9whatsnew.new_apis;

import static java.util.stream.Collectors.toList;

import java.lang.StackWalker.StackFrame;
import java.util.List;

public class StackWalkerAPI {

	public static void main(String[] args) {
		method1();
	}
	
	private static void method4() {

		// walk the stack before java 9
		// esse metodo de andar pela stack tem problemas de performance, tbm nao permite
		// que voce limite a profundidade
		// que voce quer da stack, e nao tem garantia de que voce esta vendo TODOS
		// elementos da stack pq a JVM pode omitir alguns
		@SuppressWarnings("unused")
		StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();

		// metodo java 9: melhor performance, garante que voce vera toda stack
		StackWalker stackWalker = StackWalker.getInstance();

		stackWalker.forEach(System.out::println);

		List<Integer> lines = stackWalker.walk(stackStream -> stackStream.filter(f -> f.getMethodName().startsWith("m"))
				.map(StackFrame::getLineNumber)
				.collect(toList()));

		lines.forEach(System.out::println);
		
	}

	public static void method1() {
		method2();
	}

	private static void method2() {
		method3();
	}

	private static void method3() {
		method4();
	}

}