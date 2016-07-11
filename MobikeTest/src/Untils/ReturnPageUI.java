package Untils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import android.net.Uri;
import android.util.Log;

/**
 * @author mac-li
 * 返回每个页面控件Map对象
 */
public class ReturnPageUI{
	//初始化控件
	public Map<String, String> HomeInfoMap = new HashMap<String, String>();;
	public Map<String, String> SearchPageMap = new HashMap<String, String>();;
	
//	private String proFilePath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"PageUI.Properties";
//	private String proFilePath = getClass().getResourceAsStream("/assets/PageUI.Properties");
	public ReturnPageUI(){
		init();
	}
	
	private void init(){
		Properties prop = new Properties();
		try{
			//读取属性文件properties
//			InputStream in = new BufferedInputStream (new FileInputStream(proFilePath));
			//读取安卓项目assets目录
			InputStream in = getClass().getResourceAsStream("/assets/PageUI.Properties");
			prop.load(in);     ///加载属性列表
			Iterator<String> it=prop.stringPropertyNames().iterator();
			while(it.hasNext()){
				String key=it.next();
				if(key.startsWith("HomeInfo")){
					
					HomeInfoMap.put(key, prop.getProperty(key));
				}
				if(key.startsWith("SearchPage")){
					SearchPageMap.put(key, prop.getProperty(key));
				}
				}
			in.close();
		}catch(Exception e){
			Log.e("PageUI.Propertites文件加载错误",e.getMessage());
			}
		}
	/**
	 * 首页控件
	 */
	public Map<String ,String> getHomeInfoPageUI(){
		
		return HomeInfoMap;
	}
	/**
	 * 搜索页控件
	 */
	public Map<String ,String> getSearchPageUI(){
		
		return SearchPageMap;
		
	}
}
