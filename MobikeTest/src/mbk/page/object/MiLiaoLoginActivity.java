package mbk.page.object;

import com.robotium.solo.Solo;

import android.view.View;
import android.widget.EditText;
import Untils.Utils;
/**
 * 米聊 请忽略
 * 登录页面封装类
 * @author mac-li
 *
 */
public class MiLiaoLoginActivity{
	private Utils util;
	private Solo solo;
	private EditText username, password;
	private View login;
	
	public MiLiaoLoginActivity(Solo solo) {
		// TODO Auto-generated constructor stub
		
		this.solo = solo;
		
		util = new Utils(this.solo);
	}

	public void initViews(){
		
		username = util.findEditTextById("my_account");
		
		password = util.findEditTextById("my_password");
		
		login = util.findViewById("login");
		
	}
	public void enterUsername(String name){
		//清空输入框
		solo.clearEditText(username);
		//输入用户名

		solo.enterText(username, name);
		
	}
	public void enterPassword(String pass){
		//清空输入框
		solo.clearEditText(password);
		//输入密码
		solo.enterText(password, pass);
	}
	public void clickLoginSubm(){
		//登录提交按钮
		solo.clickOnView(login);
	}
	public void clicklogin(){
		//首页登录按钮
		solo.clickOnText("登录");
	}
	
	public void doLogin(String[] arg){
		//点击登录按钮
		clicklogin();
		solo.sleep(1000);
		//usaername
		enterUsername(arg[0]);
		//password
		enterPassword(arg[1]);
		//login button
		clickLoginSubm();
		solo.sleep(1000);
	}
	public void doLogin(String username,String password){
		//点击登录按钮
		clicklogin();
		solo.sleep(1000);
		//usaername
		enterUsername(username);
		//password
		enterPassword(password);
		//login button
		clickLoginSubm();
		solo.sleep(1000);
	}
}
