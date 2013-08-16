package com.sin90lzc.training.training_rtti;

import junit.framework.Assert;
import junit.framework.TestCase;

public class BuildingTest extends TestCase {

	private Building building;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		building = new Building();
	}

	public void testToString() {
		String strBuilding = building.toString();
		Assert.assertEquals(strBuilding, "building");
	}
}
