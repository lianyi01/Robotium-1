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
//		solo.scrollToBottom();
//		Log.e("方法:", "scrollToBottom()");
//		solo.sleep(2000);
//		solo.scrollDown();
//		Log.e("方法:", "scrollDown()");
//		solo.sleep(2000);
//		solo.scrollToTop();
//		Log.e("方法:", "scrollToTop()");
		solo.drag(101, 101, 1210, 355, 3);
		Log.e("方法:", "drag()");
		solo.sleep(2000);
//		solo.sendKey(KeyEvent.KEYCODE_BACK);
		//点击设置按钮
		try{
			
			setButton = utils.findViewById("setting_rootview");
			solo.clickOnView(setButton);
			
			
		}catch(Exception e){
			
			Log.e("设置按钮点击异常:", e.getMessage());
			
			Log.e("发生错误函数：", Thread.currentThread().getStackTrace()[2].getMethodName());

		}
	}
	/**
	 * 点击退出按钮
	 */
	public void clickQuitButton(){
		try{
			
		quitButton = utils.findViewById("logout_button");
		solo.clickOnView(quitButton);
		
		}catch(Exception e){
			
			Log.e("退出按钮点击异常", e.getMessage());
			Log.e("发生错误函数：", Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		
	}
	/**
	 * 处理确认弹窗
	 */
	public void opsAlert(Boolean confirm){
		if(confirm){
			
			solo.clickOnButton("确定");
//			Log.e("确定按钮：", "clickOnButton(\"确定\")");

		}else{
			solo.clickOnButton("取消");
		}
	}
}
