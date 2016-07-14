package com.mbk.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mbk.Model.LoginCaseModle;
import com.mysql.jdbc.log.Slf4JLogger;

import Untils.BaseTest;
import Untils.DBUtils;
import Untils.ExcelReader;
import Untils.IdHelper.LoginPage;
import Untils.Utils;
import Untils.WifiControl;
import android.util.Log;
import mbk.page.object.ElementsLoginActivity;
import com.mbk.Model.ExpectEnum;

/*
 *   登录测试
 */
public class MBKLogin extends BaseTest {
	private ElementsLoginActivity loginObject;

	public void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}

	public void login_success(String username) {
		loginObject.getVerifyCode(username);
		String password = DBUtils.redisGetCode(username);
		loginObject.dologin(password);
		solo.sleep(1000);
		exitlogin();
		uihelper.getElementsPersonActivity().pressLoginButton();

	}

	public void login_failed_verify(String username) {
		 loginObject.enterMobile(username);
		 String password = "1234";
		 loginObject.dologin(password);
		 assertTrue(uihelper.toastMessage(100, "您输入的验证码不正确"));

	}

	public void login_failed_phone(String username) {
		loginObject.getVerifyCode(username);
<<<<<<< HEAD
		solo.sleep(1000);
		

=======
		assertTrue(uihelper.toastMessage(100, LoginPage.phoneInvalidity));
>>>>>>> fe1976e1fda949692484adb3fd2130353a4e00a9
	}

	public void login_faied_network(String username) {
		solo.setWiFiData(false);
		solo.sleep(1000);
		loginObject.getVerifyCode(username);
		solo.setWiFiData(true);
		assertTrue(uihelper.toastMessage(100, LoginPage.withoutNetwork));
		solo.sleep(3000);

	}


	/*
	 * 通过个人中心登录 测试正确号码段
	 */
	public void testexecutor() throws IOException {
		solo.sleep(1000);
		// homeexit();
		uihelper.getElementsHomeInfo().info();
		uihelper.getElementsPersonActivity().pressLoginButton();
		solo.sleep(1000);
		List<LoginCaseModle> loginCaseList = createLoginCaseData();
		executeCaseByData(loginCaseList);

	}

	/**
	 * 数据驱动执行
	 * 
	 * @param loginCaseList
	 */
	private void executeCaseByData(List<LoginCaseModle> loginCaseList) {
		for (int j = 0; j < loginCaseList.size(); j++) {
			LoginCaseModle item = loginCaseList.get(j);
			ExpectEnum expect = item.getExpect();
			String phone = item.getPhone();
			loginObject = uihelper.getElementsLoginActivity();
			switch (expect) {
			case success:
				// login_success(phone);
				break;
			case failedByPhone:
				// login_failed_phone(phone);

				break;
			case failedByVerify:
				 login_failed_verify(phone);

				break;
			case failedByNetWork:
//				login_faied_network(phone);

				break;

			default:
				break;
			}
		}
	}

	/**
	 * 从excel读取并生成LoginCaseModle对象数组
	 * 
	 * @return LoginCaseModle数组
	 */
	private List<LoginCaseModle> createLoginCaseData() {
		List<LoginCaseModle> loginCaseList = new ArrayList<LoginCaseModle>();
		ExcelReader reader = new ExcelReader();
		List<Map<String, Object>> datalist = reader.readExcelRow("/assets/data/loginCase.xls");
		// 将map转化为LoginCaseModle对象
		for (int i = 0; i < datalist.size(); i++) {
			Map<String, Object> data = datalist.get(i);
			LoginCaseModle lo_case = new LoginCaseModle();
			for (int j = 0; j < data.size(); j++) {
				String phone = data.get("phone").toString();
				String id = data.get("id").toString();
				String expect = data.get("expect").toString();
				String describe = data.get("describe").toString();
				lo_case.setId(id);
				lo_case.setPhone(phone);
				lo_case.setExpect(ExpectEnum.valueOf(expect));
				lo_case.setDescribe(describe);
			}
			loginCaseList.add(lo_case);
		}
		return loginCaseList;
	}

	private void exitlogin() {
		uihelper.getElementsPersonActivity().pressSettingButton();
		uihelper.getElementsQuitLogin().clickQuitButton();
		uihelper.getElementsQuitLogin().opsAlert(true);
		uihelper.getElementsPersonActivity().swipeTop();

	}
	/*
	 * 语音获取验证码
	 */
	// public void test_verifyByphone() {
	// homeexit();
	// uihelper.getElementsHomeInfo().info();
	// uihelper.getElementsPersonActivity().pressLoginButton();
	// uihelper.getElementsLoginActivity().getVerifyPhone("18501039991");
	// solo.sleep(2000);
	// }

	/*
	 * 通过首页mobike说明登录
	 */
	// public void test_login_by_introduce() {
	// homeexit();
	// uihelper.getElementsHomeInfo().clickGuideButton();
	// solo.sleep(10000);
	// assertTrue(uihelper.getElementsPersonActivity().isnotlogin());
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
		if (!uihelper.getElementsHomeInfo().isLogin()) {
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
