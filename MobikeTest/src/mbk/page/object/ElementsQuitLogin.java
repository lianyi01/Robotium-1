package mbk.page.object;

import com.robotium.solo.Solo;

import Untils.Utils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

public class ElementsQuitLogin {
	private Solo solo;
	private Utils utils;
	private View setButton,quitButton;
	
	public ElementsQuitLogin(Solo solo) {
		// TODO Auto-generated constructor stub
		this.solo = solo;
		utils = new Utils(solo);
	}
	/**
	 * 点击设置按钮
	 */
	public void clickSetButton(){
		solo.sleep(2000);
		//向上滑动
		solo.scrollToBottom();
//		solo.sendKey(KeyEvent.KEYCODE_BACK);

		//点击设置按钮
		setButton = utils.clickCtrlById("setting_rootview");
		solo.clickOnView(setButton);
	}
	/**
	 * 点击退出按钮
	 */
	public void clickQuitButton(){
		Log.e("当前activity", solo.getCurrentActivity().toString());
		quitButton = utils.clickCtrlById("logout_button");
		
		solo.clickOnView(quitButton);
		
	}
	/**
	 * 处理确认弹窗
	 */
	public void opsAlert(Boolean confirm){
		if(confirm){
			solo.clickOnText("确定");
		}else{
			solo.clickOnText("取消");
		}
	}
}