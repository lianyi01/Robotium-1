package mbk.page.object;

import com.robotium.solo.Solo;

import Untils.Utils;
import android.util.Log;

public class ElementsHomeInfo {
	private Solo solo;
	private Utils util;
	public ElementsHomeInfo(Solo solo) {
		// TODO Auto-generated constructor stub
		this.solo = solo;
		util = new Utils(solo);
	}
	/**
	 * 首页个人中心按钮
	 */
	public void info(){
		try{
		solo.waitForFragmentByTag("unlock_toolbar", 5000);
		solo.sleep(2000);
		//个人中心按钮
		solo.clickOnImageButton(0);
		}catch(Exception e){
			Log.e("错误信息：", e.getMessage());
		}
		
	}

}
