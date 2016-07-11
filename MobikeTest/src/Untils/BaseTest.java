package Untils;

import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.TextView;
/**
 * 初始化Solo对象和UIHelper统一入口对象
 * @author mac-li
 *
 */
public class BaseTest extends ActivityInstrumentationTestCase2{
	
	protected Solo solo;
	protected UIHelper uihelper;
	private WifiControl wifiControl;
	
//	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.xiaomi.channel.ui.ChannelLauncherActivity";
	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.mobike.mobikeapp.SplashActivity";
	private static Class<?> launcherActivityClass;
	
	static{
		try{
			launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		}catch(ClassNotFoundException e){
			throw new RuntimeException(e);
		}
	}

	public BaseTest() {
		// TODO Auto-generated constructor stub
		super(launcherActivityClass);
	}
	
	/**
	 * 初始化solo对象
	 * 初始化UIHelper对象
	 */
	public void setUp() throws Exception{
		
		try{
			super.setUp();
			init();
			solo.unlockScreen();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	private void init(){
		
		solo = new Solo(getInstrumentation(), getActivity());
		
		//init uihelper
		uihelper = new UIHelper(solo);
		
	}
	/**
	 * Wifi设置
	 */
	public void closeWifi(){  
        if(wifiControl == null){  
        	wifiControl = new WifiControl(getActivity().getBaseContext());  
        }  
        wifiControl.closeWifi();  
        solo.sleep(6000);  
    }
	public void openWifi(){  
        if(wifiControl == null){  
        	wifiControl = new WifiControl(getActivity().getBaseContext());  
        }  
        wifiControl.openWifi();  
        solo.sleep(6000);  
    } 
	public void statusWifi(){  
        if(wifiControl == null){  
        	wifiControl = new WifiControl(getActivity().getBaseContext());  
        }  
        Log.i("Wifi状态", Integer.toString(wifiControl.fromWifiState()));
    } 
	
	public void tearDown() throws Exception{
		super.tearDown();
		solo.finishOpenedActivities();
	}
}
