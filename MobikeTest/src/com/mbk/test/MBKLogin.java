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

	public void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}

	public void login(String username) {
		loginObject.getVerifyCode(username);
		String password = RedisUtils.getCode(username);
		loginObject.dologin(password);
		solo.sleep(1000);
		exitlogin();
		uihelper.getElementsPersonActivity().pressLoginButton();

	}

	private void exitlogin() {
		uihelper.getElementsPersonActivity().pressSettingButton();
		uihelper.getElementsQuitLogin().clickQuitButton();
		uihelper.getElementsQuitLogin().opsAlert(true);
		uihelper.getElementsPersonActivity().swipeTop();

	}

	/*
	 * 通过个人中心登录 测试号码段
	 */
	// public void testexecutor() {
	// solo.sleep(1000);
	// homeexit();
	// uihelper.getElementsHomeInfo().info();
	// solo.sleep(1000);
	// // 判断是否是登录状态
	//// if (!uihelper.getElementsPersonActivity().isnotlogin()) {
	//// // 是－－> 退出登录
	//// exitlogin();
	//// }
	// uihelper.getElementsPersonActivity().pressLoginButton();
	// solo.sleep(1000);
	// String info[] = new String[] { "18001000002", "18501039991" };
	// for (int i = 0; i < info.length; i++) {
	// String phone = info[i];
	// loginObject = uihelper.getElementsLoginActivity();
	// login(phone);
	// }
	//
	// }

	/*
	 * 语音获取验证码
	 */
	public void test_verifyByphone() {
		homeexit();
		uihelper.getElementsHomeInfo().info();
		uihelper.getElementsPersonActivity().pressLoginButton();
		uihelper.getElementsLoginActivity().getVerifyPhone("18501039991");
		solo.sleep(2000);

	}

	/*
	 * 通过首页mobike说明登录
	 */
	// public void test_login_by_introduce() {
	// homeexit();
	// uihelper.getElementsHomeInfo().pressUserManualButton();
	// solo.sleep(10000);
	// assertTrue(uihelper.getElementsPersonActivity().isnotlogin());
	//
	// }

	/*
	 * 通过预约车辆登录
	 */
	// public void test_login_by_comfirm() {
	// homeexit();
	//
	// }

	/*
	 * 通过扫码开锁入口
	 */
	// public void test_login_by_scan() {
	// homeexit();
	// uihelper.getElementsHomeInfo().pressloginFromScan();
	// solo.sleep(1000);
	// assertEquals("手机验证", uihelper.getElementsLoginActivity().title());
	// }

	/*
	 * 主页判断登录状态，且退出登录
	 */
	public void homeexit() {
		solo.sleep(1000);
		// 判断是否是登录状态
		if (!uihelper.getElementsHomeInfo().searchMobikeIntroduce()) {
			// 没有既是登录状态－－> 退出登录
			uihelper.getElementsHomeInfo().info();
			exitlogin();
			solo.goBack();
		}
	}

	/*
	 *
	 * @see Untils.BaseTest#tearDown()
	 */
	public void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}
}
