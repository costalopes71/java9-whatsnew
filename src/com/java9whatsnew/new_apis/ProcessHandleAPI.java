package com.java9whatsnew.new_apis;

import java.io.IOException;
import java.lang.ProcessHandle.Info;
import java.lang.management.ManagementFactory;

public class ProcessHandleAPI {

	// antes do java 9 foi criada a classe java.lang.Process
	// essa classe representa um processo criado pelo processo java
	public static Process getProcessCreatedByJavaBeforeJav9() {
		return null;
	}
	
	// ProcessHandle eh uma classe criada no java 9 e representa qualquer processo do SO
	public static void main(String... args) throws InterruptedException {
		
		System.out.printf("Current process PID: %d", ProcessHandle.current().pid());
		
		try {
			// antes do java 9 (apenas processos criados pelo java)
			// para pegar o pid do meu processo
			long currentProcessPid = Long.parseLong(ManagementFactory.getRuntimeMXBean()
				.getName()
				.split("@")[0]);
			
			System.out.println("\nEalier way to get current process pid: " + currentProcessPid);
				
			// depois java 9 (com ProcessHandle.of consigo manipular qualquer processo do SO)
			// para pegar o pid do meu processo ficou mto mais facil
			long processPid = ProcessHandle.current().pid();
			System.out.println("New way to get process pid: " + processPid);
			
			ProcessHandle bashProcess2 = new ProcessBuilder("bash")
					.start()
					.toHandle();
			
			System.out.println("Bash process 2 PID: " + bashProcess2.pid());
			
			Info bashProcessInfo = bashProcess2.info();
			System.out.println("Command executed: " + bashProcessInfo.command().orElse(null));
			System.out.println("User: " + bashProcessInfo.user().orElse(null));
			System.out.println("Start instant: " + bashProcessInfo.startInstant().orElse(null));
			System.out.println("CPU time duration: " + bashProcessInfo.totalCpuDuration().orElse(null));
			
			Thread.sleep(30000);
			
			bashProcess2.destroyForcibly();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
