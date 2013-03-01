import org.junit.*;


public class TestHack {

	@Test
	public void test() {
		String master = "/C:/Users/Bob/workspaces/gitclones/spring-social-googleplus/spring-social-googleplus-webtest/target/classes/";
		String module = "/spring-social-googleplus-module";
		
		String rmaster = master;
		//rmaster = rmaster.replaceAll("/target/classes.$", "");
		
		String pparts[] = rmaster.split("/");
		if(pparts != null && pparts.length > 2) {
			String modulepart = pparts[pparts.length - 3];
			rmaster = rmaster.replaceAll("/" + modulepart, module);
			
		}
		
		System.out.println(rmaster);
	}
	
}
