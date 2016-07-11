package Untils;

import java.io.IOException;
import java.util.Map;

/**
 * @author mac-li
 * 返回每个页面控件Map对象
 */
class ReturnPageUI{
	
	String PageYamlPath = "./DatabaseFile";
	public static  Map<String ,Object> pageMap;
	
	public ReturnPageUI(){
		AnalysisPageUI returnPage = new AnalysisPageUI(PageYamlPath);
		try {
			pageMap = returnPage.getYaml();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 首页控件
	 */
	public Map<String ,String> getHomeInfoPageUI(){
		
		return (Map<String, String>) pageMap.get("HomeInfo");
	}
	/**
	 * 搜索页控件
	 */
	public Map<String ,String> getSearchPageUI(){
		
		return (Map<String, String>) pageMap.get("SearchPage");
		
	}
}
