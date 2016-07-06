package com.mbk.test;

import Untils.BaseTest;
import Untils.RedisUtils;
import android.util.Log;
//import mbk.page.object.ElementsLoginActivity;
import mbk.page.object.ElementsLoginActivity;
/*
 *   登录测试
 */
public class MBKLogin extends BaseTest {
	private ElementsLoginActivity loginObject;

	@Override
	public void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		solo.unlockScreen();
	}

	public void login(String username) {
		loginObject.getVerifyCode(username);
		String password = RedisUtils.getCode(username);
		loginObject.dologin(password);
		solo.sleep(1000);
		exitlogin();

	}

	private void exitlogin() {
		uihelper.getElementsPersonActivity().pressSettingButton();
		uihelper.getElementsQuitLogin().clickQuitButton();
		uihelper.getElementsQuitLogin().opsAlert(true);
		uihelper.getElementsPersonActivity().swipeTop();
		uihelper.getElementsPersonActivity().pressLoginButton();

	}

	public void testexecutor() {
		solo.sleep(1000);
		uihelper.getElementsHomeInfo().info();
		solo.sleep(1000);
		// 判断是否是登录状态
		if (!uihelper.getElementsPersonActivity().isnotlogin()) {
			// 是－－> 退出登录
			exitlogin();
		}
		uihelper.getElementsPersonActivity().pressLoginButton();
		solo.sleep(1000);
		String info[] = new String[] { "18001000002", "18501039991" };
		for (int i = 0; i < info.length; i++) {
			String phone = info[i];
			loginObject = uihelper.getElementsLoginActivity();
			login(phone);
		}

	}

}
