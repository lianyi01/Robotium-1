package mbk.page.object;

import com.robotium.solo.Solo;

import Untils.IdHelper.HomeInfo;
import Untils.Utils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
/**
 * 首页所有控件信息
 * @author mac-li
 *
 */
public class ElementsHomeInfo {
	private Solo solo;
	private Utils util;

	// 页面控件UI对象
//	private ReturnPageUI rePageUI;
//	private Map<String, String> mapKey;
	// 摩拜单车使用说明

	// 页面控件UI对象

	// 摩拜单车使用说明
	private View guide;
	private TextView guideText;
	// 刷新按钮
	private View refreshButton;
	// 定位按钮
	private View locationButton;
	// 帮助按钮
	private View helpButton;
	// 搜索按钮
	private View searchButton;
	// 开锁按钮
	private View unlockButton;
	// 离我最近按钮
	private View nearByButton;
	//开锁－登录按钮
	private View uloginButton;
	
	public ElementsHomeInfo(Solo solo) {
		// TODO Auto-generated constructor stub
		this.solo = solo;
		util = new Utils(solo);
		// 初始化HomeInfo数据页对象
//		rePageUI = new ReturnPageUI();
//		mapKey = rePageUI.getHomeInfoPageUI();

	}

	/**
	 * 放弃全部初始化，加载时间太长，改为使用时加载控件
	 */
	// public void initView() {
	//
	// try{
	//
	//
	// }catch(Exception e){
	// Log.e("错误信息：首页按钮未找到", e.getMessage().toString());
	// }
	// }

	/**
	 * 首页个人中心按钮
	 */
	public void info() {
		try {
			// 个人中心按钮
			solo.clickOnImageButton(0);
		} catch (Exception e) {
			Log.e("个人中心按钮未找到：", e.getMessage().toString());
			Log.e("发生错误函数：", Thread.currentThread().getStackTrace()[2].getMethodName());
		}
	}

	/**
	 * 首页摩拜单车使用说明
	 */
	public String checkGuideText() {
		// 获取帮助说明文字
		String text;

		guideText = (TextView) util.findViewById(HomeInfo.guide);
		text = guideText.getText().toString();
		return text;
	}

	public void clickGuideButton() {
		// 点击
		try {
			guide = util.findViewById(HomeInfo.guide);
			solo.clickOnView(guide);
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("错误信息：点击摩拜单车使用说明按钮", e.getMessage().toString());
		}
	}

	/**
	 * 刷新
	 */
	public void clickRefresh() {
		try {
			refreshButton = util.findViewById(HomeInfo.refreshButton);
			solo.clickOnView(refreshButton);
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("错误信息：点击刷新钮", e.getMessage().toString());
		}
	}

	/**
	 * 搜索
	 */
	public void clickSearch() {
		try {
			searchButton = util.findViewById(HomeInfo.searchButton);
			solo.clickOnView(searchButton);
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("错误信息：点击搜索按钮", e.getMessage().toString());
		}
	}

	/**
	 * 定位
	 */
	public void clickLocation() {
		try {
			locationButton = util.findViewById(HomeInfo.locationButton);
			solo.clickOnView(locationButton);
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("错误信息：点击定位按钮", e.getMessage().toString());
		}
	}

	/**
	 * 帮助
	 */
	public void clickHelp() {
		try {
			helpButton = util.findViewById(HomeInfo.helpButton);
			solo.clickOnView(helpButton);
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("错误信息：点击帮助按钮", e.getMessage().toString());
		}
	}

	/**
	 * 开锁
	 */
	public void clickUnlock() {
		try {
			unlockButton = util.findViewById(HomeInfo.unlockButton);
			solo.clickOnView(unlockButton);
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("错误信息：点击开锁按钮", e.getMessage().toString());
		}
	}

	/**
	 * 离我最近
	 */
	public Boolean IsNotNearButton() {
		if (solo.searchText("离我最近")) {
			return true;
		} else {
			return false;
		}
	}

	public void clickNearButton() {
		try {
			nearByButton = util.findViewById(HomeInfo.nearByButton);
			solo.clickOnView(nearByButton);
		} catch (Exception e) {
			Log.e("错误信息：点击离我最近按钮", e.getMessage().toString());
		}
	}

	public boolean isLogin() {
		Boolean hasIntroduceBtn = solo.searchButton("摩拜单车使用说明");
		return hasIntroduceBtn;
	}
	/**
	 * 开锁－立即登陆
	 */
	public void pressloginFromScan() {
		try{
		clickUnlock();
		uloginButton = util.findViewById(HomeInfo.ulogin);
		solo.clickOnView(uloginButton);
		}catch(Exception e){
			Log.e("错误信息：首页点击登录按钮", e.getMessage());
		}
	}
	


}
