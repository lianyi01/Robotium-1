package com.mbk.test;

import Untils.BaseTest;

public class MBKGuide extends BaseTest{

	public MBKGuide() {
		// TODO Auto-generated constructor stub
	}
	public void setUp() throws Exception{
		super.setUp();
	}
	
	public void testScrollpage(){
		uihelper.getElementsGuidePage().scrollPage();
		assertTrue(uihelper.getElementsGuidePage().getSearchTxt("摩拜单车使用说明"));
		
	}
	public void tearDown() throws Exception{
		super.tearDown();
	}

}
