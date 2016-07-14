package mbk.page.object;

import com.robotium.solo.Solo;

import Untils.IdHelper.LoginPage;
import Untils.Utils;

public class ElementsLoginActivity {
	private Utils util;
	private Solo solo;
	// private EditText edt_mobileNum;
	// private EditText edt_verify;
	// private View btn_verify;
	// private View btn_login;

	public ElementsLoginActivity(Solo solo) {
		super();
		this.solo = solo;
		util = new Utils(solo);
		// initViews();
	}

	public void initViews() {
		// edt_mobileNum = util.findEditTextById("mobile_number");
		// edt_verify = util.findEditTextById("verify_code");
		// btn_verify = util.findViewById("get_verify_code_btn");
		// btn_login = util.findViewById("sign_in_button");
	}

	public void enterMobile(String phone) {
		// solo.clearEditText(edt_mobileNum);
		solo.enterText(util.findEditTextById(LoginPage.mobileEditText), phone);
	}

	public void enterVerifyCode(String verifycode) {
		// solo.clearEditText(edt_verify);
		solo.enterText(util.findEditTextById(LoginPage.verifyEditText), verifycode);
	}

	/*
	 * 获取短信验证码
	 */
	public void getVerifyCode(String phone) {
		enterMobile(phone);
		solo.sleep(1000);
		solo.clickOnView(util.findViewById(LoginPage.getVerifyBtn));
//		solo.sleep(1000);
		
	}

	/*
	 * 获取语音验证码
	 */
	public void getVerifyPhone(String phone) {
		enterMobile(phone);
		solo.sleep(1000);
		// solo.clickOnText("收不到短信，试试语音验证码");
		solo.clickOnView(util.findViewById(LoginPage.getVoiceVerifyBtn));
		solo.sleep(1000);
		// 点击我知道了
		clickOnknow();
		solo.sleep(1000);
	}

	public void clickOnknow() {
		if (solo.waitForDialogToOpen()) {
			// solo.clickOnText("我知道了");
			solo.clickOnText(LoginPage.voiceDialog);
		}
	}

	public void dologin(String verifycode) {
		enterVerifyCode(verifycode);
		solo.sleep(1000);
		solo.clickOnView(util.findViewById(LoginPage.signBtn));
		solo.sleep(3000);
	}

	public String title() {
		return solo.getCurrentActivity().getTitle().toString();
	}

}
