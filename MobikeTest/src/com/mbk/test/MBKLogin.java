package com.mbk.test;

import Untils.BaseTest;
import Untils.RedisUtils;
import android.util.Log;
//import mbk.page.object.ElementsLoginActivity;
import mbk.page.object.ElementsLoginActivity;

public class MBKLogin extends BaseTest {
	private ElementsLoginActivity loginObject;

	@Override
	public void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();

		// loginObject = uihelper.getElementsLogin();
	}

	public void login(String username) {
		loginObject.getVerifyCode(username);
		String password = RedisUtils.getCode(username);
		loginObject.dologin(password);
	}
	private void exitlogin(){
		uihelper.getElementsQuitLogin().clickQuitButton();
	}

	public void testexecutor() {
		uihelper.getElementsHomeInfo().info();
		solo.sleep(1000);
		uihelper.getElementsPersonActivity().pressLoginButton();
		loginObject = uihelper.getElementsLoginActivity();
		String info[] = new String[] { "18501039991"};
		for (int i = 0; i < info.length; i++) {
			login(info[i]);
		}

	}

}
