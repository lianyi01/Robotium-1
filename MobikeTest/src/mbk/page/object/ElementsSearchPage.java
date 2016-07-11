package mbk.page.object;

import java.util.Map;

import com.robotium.solo.Solo;

import Untils.ReturnPageUI;
import Untils.Utils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ElementsSearchPage {
	
	private Solo solo;
	private Utils util;
	//页面控件UI对象
	private ReturnPageUI rePageUI;
	private Map<String,String> mapKey;
	//搜索输入框
	private EditText searchText;
	//清空输入框按钮
	private View deleteClick;
	//取消按钮
	private View cancelClick;
	//定位信息
	private TextView locationMessage;
	//搜索结果列表
	private ListView resultList;
	
	public  ElementsSearchPage(Solo solo){
		
		this.solo =solo;
		
		util = new Utils(solo);
		//初始化SearchPage数据页对象
		rePageUI = new ReturnPageUI();
		mapKey = rePageUI.getSearchPageUI();
	}

	
	/**
	 * 搜索输入框
	 */
	public void enterSearchMessage(String message){
		try{
			searchText = util.findEditTextById(mapKey.get("SearchPage.searchText"));
			solo.enterText(searchText, message);
		}catch(Exception e){
			Log.e("搜索输入框错误信息：", e.getMessage());
		}
	}
	/**
	 * 清空输入框按钮
	 */
	public void clickDeleteEnterText(){
		try{
			deleteClick = util.findViewById(mapKey.get("SearchPage.deleteClick"));
			solo.clickOnView(deleteClick);
		}catch(Exception e){
			Log.e("搜索输入框清空按钮错误信息：", e.getMessage());
		}
	}
	/**
	 * 取消按钮
	 */
	public void clickCancelButton(){
		try{
			cancelClick = util.findViewById(mapKey.get("SearchPage.cancelClick"));
			solo.clickOnView(cancelClick);
			
		}catch(Exception e){
			Log.e("搜索页面取消按钮错误信息：", e.getMessage());
		}
	}
	/**
	 * 获取定位信息按钮
	 */
	public Boolean getLocationMessage(){
		
		try{
			//获取控件
			locationMessage = (TextView) util.findViewById(mapKey.get("SearchPage.locationMessage"));
			//定位信息
			String locationms;
			locationms = locationMessage.getText().toString();
			
			if(locationms != null && locationms != ""){
				return true;
			}
			
		}catch(Exception e){
			Log.e("获取定位内容错误信息：", e.getMessage());
		}
		return false;
	}
	/**
	 * 选择结果列表
	 */
	public Boolean clickResultList(){
		try{
			//整个listView
			resultList = (ListView) util.findViewById(mapKey.get("SearchPage.resultList"));
			if(resultList.getCount()>0){
			//默认点击结果列表第0个
				solo.clickInList(0);
				return true;
		}
		}catch (Exception e) {
			// TODO: handle exception
			Log.e("点击搜索结果列表错误信息：", e.getMessage());
		}
		return false;
	}
}
