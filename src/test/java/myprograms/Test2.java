package myprograms;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2 {

	@Test
	public void MySecondTest() {
		System.out.println("I am second tEst");
		Assert.fail();
	}
}
