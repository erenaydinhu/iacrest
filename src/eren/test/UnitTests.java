package eren.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import eren.service.*;
public class UnitTests {

	@Test
	public void firstTest(){
		
		Double d = RESTServiceTwo.distanceKM(35, 32, 55, 56);
				 
		   assertEquals(d, 2885, 5);	
	}

	@Test
	public void secondTest(){
		
		Double d = RESTServiceTwo.distanceKM(38, 34, 45, 49);
				 
		   assertEquals(d, 1468, 5);	
	}
	 
	@Test
	public void thirdTest(){
		
		String d = RESTServiceOne.celciustofahrenheit((double) 5);
				 
		String[] string = d.split(" ");
		   assertEquals(Double.parseDouble(string[1]), 41, 0.1);	
	}
	 
	@Test
	public void fourthTest(){
		
		String d = RESTServiceOne.celciustofahrenheit((double) 12);
		 
		String[] string = d.split(" ");
		   assertEquals(Double.parseDouble(string[1]), 53.6, 0.1);	
	}
	 
}
