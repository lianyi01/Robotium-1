package Untils;

import com.robotium.solo.Solo;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
/**
 * 通过id定位操作
 * @author mac-li
 *
 */
public class Utils {
	
	private Solo solo;

	public Utils(Solo solo){
		
		this.solo = solo;
	}
	

	public View findViewById(String s){  
		//id 点击
        int ctrl = 0;  
        View v;  
        try{
        ctrl = solo.getCurrentActivity().getResources().getIdentifier(s,"id",solo.getCurrentActivity().getPackageName());  
        }catch(Exception e){
        	Log.e("未找到ID元素：", s);
        	Log.e("错误信息：", String.valueOf(e.getMessage()));
        }
        //等待元素出现，timeout 5s      
        solo.waitForFragmentById(ctrl, 5000);
        
        v = solo.getView(ctrl);

    	return v;  
    }  
	
	public Button findButtonByID(String s){
        int ctrl = 0;
        Button btn;
        try {
        		ctrl	= solo.getCurrentActivity().getResources().getIdentifier(s, "id", solo.getCurrentActivity().getPackageName());
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}        
        //等待元素出现，timeout 5s      
        solo.waitForFragmentById(ctrl, 5000);
        btn = solo.getButton(ctrl);
		return btn;
	}
	
	public EditText findEditTextById(String id){  
		  	//id 输入
	        int ctrl = 0;  
	        EditText e;  
	        try{
	        ctrl = solo.getCurrentActivity().getResources().getIdentifier(id,"id",solo.getCurrentActivity().getPackageName());  
	        }catch(Exception err){
	        	Log.e("未找到ID元素：", id);
	        	Log.e("错误信息：", String.valueOf(err.getMessage()));
	        }
	      //等待元素出现，timeout 5s      
	        solo.waitForFragmentById(ctrl, 5000);
	        
	        e = (EditText) solo.getView(ctrl);  
	        
	        return e;  
	}
	/**
	 * 上下滑动操作
	 */
//	public void scrollUpDown(String id){
//		ScrollView scrollView_city = (ScrollView) solo.getView(id);
//		int[] location = new int[2];
//		scrollView_city.getLocationOnScreen(location);
//		location[1] = location[1] + scrollView_city.getBottom();
//		//输出日志
//		Log.e("坐标x", Integer.toString(location[0]));
//		Log.e("坐标Y", Integer.toString(location[1]));
//		if(solo.waitForView(scrollView_city)){
//            //从上往下滑动
//            int newlistcount, listcount = scrollView_city.getChildCount();
//            while(true){
//            	solo.scrollToBottom();
////            	solo.scrollListToLine(scrollView_city, listcount);
//                solo.sleep(500);
//                solo.drag(location[0]+10f, location[0]+10f,location[1]-10f, location[0]-100f,50);
//                solo.sleep(2000);
////                newlistcount=listView_city.getCount();
////                if(newlistcount==listcount){
////                    break;
////                }else{
////                    listcount=newlistcount;
////                    Log.d("Tag","[Location]:  "+Integer.toString(listcount));
////                }
//            }
//	}
//	
//}
}
