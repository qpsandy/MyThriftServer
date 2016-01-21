package com.tfs.register.preregister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tfs.register.preregister.service.ShowPreregisters;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication
public class myThriftServerMain implements CommandLineRunner {
	public static final int SERVER_PORT = 18443;	
	
	@Autowired
	private MyThriftServerProxy myThriftServerProxy;	
	@Autowired
	private MyThriftImpl myThriftImpl;
	
//	@Autowired
//	private ShowPreregisters showPreregisters;
			
	@Override
	public void run(String... args) {   
		try {    
			System.out.println("MyThriftServer start...");  
			
			myThriftServerProxy.test();
			
			myThriftServerProxy.setPort(SERVER_PORT);
			myThriftServerProxy.setServiceImplObject(myThriftImpl);
			myThriftServerProxy.setServiceInterface("com.tfs.register.preregister.MyThriftService");
			myThriftServerProxy.start();
			
			System.out.println("MyThriftServer listen on port:" + SERVER_PORT);  
			
			//showPreregisters.showPreregisters();
			
		} catch (Exception e) {    
			System.out.println("Server start error!!!");    
			e.printStackTrace();   
		}  
	}
	
	/**   * @param args   */  
	public static void main(String[] args) {
		System.out.println("MyThriftServer init...");
//		myThriftServerMain server = new myThriftServerMain();
//		server.startServer();
//		SpringApplication.run(new Object[] { myThriftServerMain.class }, args);
		SpringApplication.run(myThriftServerMain.class, args);
	}
}
