package perform_test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.perform.svs.annotation_test.At_InjectTest;
import com.perform.svs.annotation_test.AnnotationBind;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/config/*.xml"})
public class Perform_Test {
	
	@Before
	public void brfore(){
		
	}
	
	
	@Test
	public void test() throws Exception{
		// Main Test Code
	}
	
	@After
	public void after(){
	}
}