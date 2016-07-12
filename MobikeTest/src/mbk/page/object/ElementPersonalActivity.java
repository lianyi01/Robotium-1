package mbk.page.object;

import com.robotium.solo.Solo;

import Untils.IdHelper.PersonalPage;
import Untils.Utils;
import android.util.Log;
import android.view.View;
import android.webkit.WebView.FindListener;
import android.widget.Button;

/*
 * 个人中心
 */
public class ElementPersonalActivity {
	private Utils util;
	private Solo solo;
	private View loginButton,setButton;

	public ElementPersonalActivity(Solo solo) {
		super();
		this.solo = solo;
		this.util = new Utils(solo);
		initView();

	}

	private void initView() {
		loginButton = util.findViewById(PersonalPage.creditBtn);
		setButton = util.findViewById(PersonalPage.settingBtn);
	}

	/*
	 * 未登录时 登录按钮
	 */
	public void pressLoginButton() {
		solo.clickOnView(loginButton);
	}

	/*
	 * 登录状态
	 */
	public void pressSettingButton() {
		swipeDown();
		solo.sleep(2000);
		solo.clickOnView(setButton);
	}
	/*
	 * 滑动到最顶端
	 */
	public void swipeTop(){
		solo.drag(0, 0, 300, 11200, 1);
		Log.e("elentmentPersonActivity", "滑动到顶最端");
	}
	/*
	 * 滑动到最底端
	 */
	public void swipeDown(){
		solo.drag(0, 0, 1210, 0, 1);
		Log.e("elentmentPersonActivity", "滑动到最底端");
	}
	/*
	 * 判断未登录状态
	 */
	public boolean isnotlogin(){
		Boolean islogin = solo.searchButton(PersonalPage.loginText);
		return islogin;
	}
	

}
