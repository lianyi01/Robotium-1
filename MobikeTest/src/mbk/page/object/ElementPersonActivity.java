package mbk.page.object;

import com.robotium.solo.Solo;

import Untils.Utils;
import android.util.Log;
import android.view.View;

public class ElementPersonActivity {
	private Utils util;
	private Solo solo;
	private View loginButton;

	public ElementPersonActivity(Solo solo) {
		super();
		this.solo = solo;
		this.util = new Utils(solo);
		initView();

	}

	private void initView() {
		loginButton = util.findViewById("btn_credit");
	}

	/*
	 * 未登录时 登录按钮
	 */
	public void pressLoginButton() {
		solo.clickOnView(loginButton);
	}

}
