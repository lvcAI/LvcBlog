package party.pjc.blog.log;

import org.apache.log4j.Logger;
import org.junit.Test;

public class LogTest {

	private static Logger _log = Logger.getLogger(LogTest.class);
	
	
	@Test
	public void tets(){
		
	System.out.println(System.getProperty("os.name"));
	}
}
