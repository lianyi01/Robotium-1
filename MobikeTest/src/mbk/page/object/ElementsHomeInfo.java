package mbk.page.object;

import com.robotium.solo.Solo;

import Untils.Utils;
import android.util.Log;
import android.view.View;

public class ElementsHomeInfo {
	private Solo solo;
	private Utils util;
	private View guide,btn_scan;

	public ElementsHomeInfo(Solo solo) {
		// TODO Auto-generated constructor stub
		this.solo = solo;
		util = new Utils(solo);
		initView();
	}

	public void initView() {
		guide = util.findViewById("mobike_user_manual_button");
		btn_scan = util.findViewById("unlock_toolbar");
		
	}

	/**
	 * 首页个人中心按钮
	 */
	public void info() {
		try {
			solo.waitForFragmentByTag("unlock_toolbar", 5000);
			solo.sleep(2000);
			// 个人中心按钮
			solo.clickOnImageButton(0);
		} catch (Exception e) {
			Log.e("错误信息：", e.getMessage());
			Log.e("发生错误函数：", Thread.currentThread().getStackTrace()[2].getMethodName());
		}
	}

	/*
	 * 首页摩拜单车使用说明
	 */
	public void pressUserManualButton() {
		try {
			solo.clickOnView(guide);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public boolean searchMobikeIntroduce() {
		Boolean hasIntroduceBtn = solo.searchButton("摩拜单车使用说明");
		return hasIntroduceBtn;
	}

	public void pressScanbtn() {
		solo.clickOnView(btn_scan);
	}
	
	public void pressloginFromScan(){
		pressScanbtn();
		View loginScan = util.findViewById("hintCard_login_button");
		solo.clickOnView(loginScan);
	}

}
