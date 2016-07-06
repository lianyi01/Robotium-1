package mbk.page.object;

import com.robotium.solo.Solo;

import Untils.Utils;
import android.util.Log;
import android.view.View;

public class ElementsQuitLogin {
	private Solo solo;
	private Utils utils;
	private View setButton, quitButton;
	private View dialog,dialog_quit,dialog_cancel;

	public ElementsQuitLogin(Solo solo) {
		// TODO Auto-generated constructor stub
		this.solo = solo;
		utils = new Utils(solo);
	}
	
	private void initView(){
		
		
	}
	/**
	 * 点击设置按钮
	 */
	public void clickSetButton() {
		solo.sleep(2000);
		// 向上滑动
		// solo.scrollToBottom();
		// Log.e("方法:", "scrollToBottom()");
		// solo.sleep(2000);
		// solo.scrollDown();
		// Log.e("方法:", "scrollDown()");
		// solo.sleep(2000);
		// solo.scrollToTop();
		// Log.e("方法:", "scrollToTop()");
		solo.drag(101, 855, 101, 1210, 1);
		Log.e("方法:", "drag()");
		solo.sleep(2000);
		// solo.sendKey(KeyEvent.KEYCODE_BACK);
		// utils.scrollUpDown("message_rootview");
		// 点击设置按钮
		setButton = utils.findViewById("setting_rootview");
		solo.clickOnView(setButton);
	}

	/**
	 * 点击退出按钮
	 */
	public void clickQuitButton() {
		Log.e("当前activity", solo.getCurrentActivity().toString());
		quitButton = utils.findViewById("logout_button");
		solo.clickOnView(quitButton);
		solo.sleep(1000);
	}

	/**
	 * 处理确认弹窗
	 */
	public void opsAlert(Boolean confirm) {
		if (solo.waitForDialogToOpen()) {
			if (confirm) {
				solo.clickOnButton("确定");
			} else {
				solo.clickOnButton("取消");
			}
		}
		solo.sleep(1000);
	}
}
