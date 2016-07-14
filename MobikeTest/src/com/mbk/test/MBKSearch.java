package com.mbk.test;

import Untils.BaseTest;

public class MBKSearch extends BaseTest {

	public MBKSearch() {
		// TODO Auto-generated constructor stub
	}
	public void setUp() throws Exception{
		super.setUp();
	}
	public void tearDown() throws Exception{
		super.tearDown();
	}
	
	public void testSearch(){
		//点击搜索按钮
		uihelper.getElementsHomeInfo().clickSearch();
		//enter text
		uihelper.getElementsSearchPage().enterSearchMessage("建国门");
		//location message
		Boolean mes = uihelper.getElementsSearchPage().getLocationMessage();
		assertTrue(mes);
		//select result
		uihelper.getElementsSearchPage().clickResultList();
		uihelper.getsolo().sleep(3000);
		assertTrue(solo.searchButton("扫码开锁"));
		
	}
}
