package mbk.page.object;

import com.robotium.solo.Solo;

import Untils.Utils;
import android.view.View;
import android.widget.EditText;

public class ElementsLoginActivity {
	private Utils util;
	private Solo solo;
	private EditText edt_mobileNum;
	private EditText edt_verify;
	private View btn_verify;
	private View btn_login;

	public ElementsLoginActivity(Solo solo) {
		super();
		this.solo = solo;
		util = new Utils(solo);
		initViews();
	}

	private void initViews() {
		edt_mobileNum = util.findEditTextById("mobile_number");
		edt_verify = util.findEditTextById("verify_code");
		btn_verify = util.findViewById("get_verify_code_btn");
		btn_login = util.findViewById("sign_in_button");
	}

	private void enterMobile(String phone) {
		solo.clearEditText(edt_mobileNum);
		solo.enterText(edt_mobileNum, phone);
	}

	private void enterVerifyCode(String verifycode) {
		solo.clearEditText(edt_verify);
		solo.enterText(edt_verify, verifycode);
	}

	public void getVerifyCode(String phone) {
		enterMobile(phone);
		solo.clickOnView(btn_verify);
		solo.sleep(1000);
	}

	public void dologin(String verifycode) {
		enterVerifyCode(verifycode);
		solo.sleep(1000);
		solo.clickOnView(btn_login);
		solo.sleep(3000);
	}

}
