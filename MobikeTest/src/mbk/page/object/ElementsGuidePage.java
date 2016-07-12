package mbk.page.object;

import com.robotium.solo.Solo;

import Untils.IdHelper.HomeInfo;
import Untils.Utils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
/**
 * 引导页
 * @author mac-li
 *
 */
public class ElementsGuidePage {
	private Utils util;
	private Solo solo;
	


	public ElementsGuidePage(Solo solo) {
		// TODO Auto-generated constructor stub
		this.solo = solo;
		util = new Utils(solo);
	}
	
	public void scrollPage(){
		solo.sleep(2000);
		//等待引导图出现
		solo.waitForFragmentByTag("background_img", 5000);
		//引导图数量
		int page_num = 1;
		
		while(page_num<=4){
			
			if(page_num==4){
				//点击 开启摩拜之旅
				solo.clickOnView(util.findViewById("guide_start"));
				
			}else{
				
				solo.scrollToSide(solo.RIGHT);
				Log.e("滑动次数", String.valueOf(page_num));
			}
			page_num++;
		}
		
	}
	public Boolean getSearchTxt(String exceptText){
		//摩拜单车使用说明按钮
		solo.waitForFragmentByTag(HomeInfo.guide, 5000);
		Boolean exmess = solo.searchText(exceptText);
		return exmess;
	}
	
	
	

}
