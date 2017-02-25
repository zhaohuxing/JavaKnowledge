/*package com.sprint;

import java.io.File;
import javax.servlet.ServletException;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.core.StandardServer;
public class Main {
	public static void main(String[] args) {
		EmbeddedTomcat tomcat = new EmbeddedTomcat(8080);
		tomcat.startUpTomcat();
	}

	public static class EmbeddedTomcat {

		private Tomcat tomcat;
		private int port;
		private static final String tempDir= "src"+File.separatorChar+"main"+File.separatorChar+"webapp";
		
		public EmbeddedTomcat(int port){
			tomcat = new Tomcat();
			this.port = port;
		}
		
		public void startUpTomcat(){
			tomcat.setPort(port);
			try {
				tomcat.addWebapp("/springmvc-gradle-xml", System.getProperty("user.dir")+File.separatorChar+tempDir);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				StandardServer server = (StandardServer)tomcat.getServer();  
	            AprLifecycleListener listener = new AprLifecycleListener();  
	            server.addLifecycleListener(listener); 
				tomcat.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
			tomcat.getServer().await();
		}
	
		public void shutDownTomcat(){
			try {
				tomcat.stop();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}*/
