package org.psjava.algo.math;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.math.MiddleValue;
import org.psjava.ds.numbersystrem.Float64;
import org.psjava.ds.numbersystrem.Float64NumberSystem;


public class MiddleValueTest {
	
	@Test
	public void test() {
		Float64 r = MiddleValue.calc(Float64NumberSystem.getInstance(), Float64.valueOf(1), Float64.valueOf(2), Float64.valueOf(0.2));
		Assert.assertEquals(1.2, r.toPrimitive(), 1e-10);
	}

}