package com.mbk.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import Untils.BaseTest;
import android.util.Log;
/**
 * 1.先调用登录
 * 2.进入个人中心
 * @author mac-li
 *
 */
public class MBKQuit extends BaseTest {
	

	public MBKQuit() {
		// TODO Auto-generated constructor stub
	}
	
	public void setUp() throws Exception{
		super.setUp();
		//初始化登录方法
	}
	public void testquitLogin(){
		uihelper.getsolo().sleep(5000);
		//首页进入个人中心
		uihelper.getElementsHomeInfo().info();
		uihelper.getsolo().sleep(2000);
		//点击设置
		uihelper.getElementsQuitLogin().clickSetButton();
		uihelper.getElementsQuitLogin().clickQuitButton();
		
		uihelper.getsolo().sleep(2000);
		uihelper.getElementsQuitLogin().opsAlert(true);
		
		
		
	}
	public void tearDown() throws Exception{
		uihelper.getsolo().sleep(5000);
		super.tearDown();
	}
}

