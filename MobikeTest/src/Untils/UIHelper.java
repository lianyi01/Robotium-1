package Untils;

import com.robotium.solo.Solo;

import android.util.Log;
import android.widget.TextView;
import mbk.page.object.ElementMainActivity;
import mbk.page.object.ElementsGuidePage;
import mbk.page.object.ElementsHomeInfo;
import mbk.page.object.MiLiaoLoginActivity;
import mbk.page.object.ElementsQuitLogin;
/**
 * Case统一入口
 * 每个Case页面类都需要在此声明
 * @author mac-li
 *
 */
public class UIHelper {
	private Solo solo;
	private ElementsGuidePage  elementsGuidePage;
	private ElementsHomeInfo elementsHomeInfo;
	private ElementsQuitLogin elementsQuitLogin;
	private ElementMainActivity elementMainActivity;
	
	public UIHelper(Solo solo) {
		// TODO Auto-generated constructor stub
		this.solo = solo;
	}
	public Solo getsolo(){
		
		return solo;
	}

	/**
	 * 引导页
	 * @return
	 */
	
	public ElementsGuidePage getElementsGuidePage(){
		if (elementsGuidePage == null){
			elementsGuidePage = new ElementsGuidePage(solo);
		}
		return elementsGuidePage;
		
	}
	/**
	 * 首页进入个人中心操作
	 */
	public ElementsHomeInfo getElementsHomeInfo(){
		if(elementsHomeInfo == null){
			elementsHomeInfo = new ElementsHomeInfo(solo);
		}
		return elementsHomeInfo;
	}
	
	/**
	 * 退出登录操作
	 */
	public ElementsQuitLogin getElementsQuitLogin(){
		if(elementsQuitLogin == null){
			elementsQuitLogin = new ElementsQuitLogin(solo);
		}
		return elementsQuitLogin;
	}
	
	/**
	 * 主页
	 */
	public ElementMainActivity getElementsMainActivity(){
		if(elementMainActivity == null){
			elementMainActivity = new ElementMainActivity(solo);
		}
		return elementMainActivity;
	}

	/**
	 * 获取toast消息
	 * @param timeout
	 * @return toast的string
	 */
	public Boolean toastMessage(int timeout,String exceptMessage){
		
		int timeoutnum=0;
		String toastms = null;
		
		while(timeoutnum<10){
			//获取toast，getView("message",0)参数“message”为固定值类似一个key,toast内容是这个key的value
			TextView toastmes = (TextView) solo.getView("message",0);
			
			toastms = toastmes.getText().toString().trim();
			
			if(toastms.equals(exceptMessage.toString())){
				Log.e("Toast消失内容：",toastms);
				return true;
				
			}else{
				timeoutnum++;
				solo.sleep(timeout);
			}
			
		}
		return false;
	}
	
}