package com.perform.svs.annotation_test;

import com.perform.svs.annotation_test.Myannotation.Quality;

public class At_InjectTest {
	
	@Myannotation(name="테스트1", quality=Quality.GOOD)
	String test1;
	
	@Myannotation(name="테스트2", quality=Quality.VERYGOOD)
	String test2;
	
	public String getTest1() {
		return test1;
	}

	public void setTest1(String test1) {
		this.test1 = test1;
	}

	public String getTest2() {
		return test2;
	}

	public void setTest2(String test2) {
		this.test2 = test2;
	}
	
	
}
