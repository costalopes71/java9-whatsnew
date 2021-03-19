package com.java9whatsnew.new_apis;

import java.lang.ProcessHandle.Info;
import java.time.Instant;
import java.util.Comparator;

public class ListProcesses {

	public static void main(String[] args) {
		
		ProcessHandle.allProcesses()
			.map(ProcessHandle::info)
			.sorted(Comparator.comparing(info -> info.startInstant().orElse(Instant.MAX)))
			.forEach(ListProcesses::printInfo);
		
	}

	private static void printInfo(Info info) {
		if (info.startInstant().isPresent() && info.command().isPresent()) {
			System.out.println("Started at: " + info.startInstant().get() + ", Command: " + info.command().get());
		}
	}
	
}