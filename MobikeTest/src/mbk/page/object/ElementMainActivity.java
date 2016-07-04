package mbk.page.object;

import com.robotium.solo.Solo;

import Untils.Utils;

public class ElementMainActivity {
	private Utils util;
	private Solo solo;

	public ElementMainActivity(Solo solo) {
		super();
		this.solo = solo;
		this.util = util;

	}
	
	public void getGuideButton(){
		solo.clickOnText("摩拜单车使用说明");
		
	}
	
	public void scanButton(){
		
	}
	public void menuButton(){
		
	}
	public void searchButton(){
		
	}

}
