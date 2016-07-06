package com.mbk.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import Untils.BaseTest;
import android.view.KeyEvent;
/**
 * 1.先调用登录
 * 2.进入个人中心
 * @author mac-li
 *
 */
public class MBKQuit extends BaseTest {
//	PropertyConfigurator.configure("./src/log4j.properties");
	private  Logger log = Logger.getLogger(MBKQuit.class);
	
	public void setUp() throws Exception{
		super.setUp();
		//初始化登录方法
		//初始化log
		
	}
	public void testquitLogin(){
		uihelper.getsolo().sleep(5000);
		log.warn("我是警告信息啊啊");
		log.debug("我是警告信息啊啊");
		//首页进入个人中心
		uihelper.getElementsHomeInfo().info();
		uihelper.getsolo().sleep(2000);
		//点击设置
		uihelper.getElementsQuitLogin().clickSetButton();
		//点击退出按钮
		uihelper.getElementsQuitLogin().clickQuitButton();
		//点击取消按钮
		uihelper.getsolo().sleep(1500);
		uihelper.getElementsQuitLogin().opsAlert(false);
		assertTrue(uihelper.getsolo().searchButton("退出登录"));
		
		//点击退出按钮
		uihelper.getElementsQuitLogin().clickQuitButton();
		//点击取消按钮
		uihelper.getsolo().sleep(1500);
		//点击确定按钮
		uihelper.getElementsQuitLogin().opsAlert(true);
		assertTrue(uihelper.getsolo().searchText("个人中心"));
		
		uihelper.getsolo().sendKey(KeyEvent.KEYCODE_BACK);
		
		this.log.warn("我是警告信息啊啊");
	}
	public void tearDown() throws Exception{
		uihelper.getsolo().sleep(1000);
		super.tearDown();
	}
}

