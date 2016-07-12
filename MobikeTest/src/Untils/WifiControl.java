package Untils;

import android.content.Context;
import android.net.wifi.WifiManager;

public class WifiControl {
	private WifiManager wifiManager = null;

	public WifiControl(Context context) {
		wifiManager = (WifiManager) context.getSystemService(context.WIFI_SERVICE);

	}

	// 启动wifi
	public void openWifi() {
		if (!wifiManager.isWifiEnabled()) {
			wifiManager.setWifiEnabled(true);
		}

	}

	// 关闭wifi
	public void closeWifi() {
		if (wifiManager.isWifiEnabled()) {
			wifiManager.setWifiEnabled(false);
		}

	}

	// 获取网络状态 1-关闭状态 3-开启状态
	public int fromWifiState() {
		int iWifiState = wifiManager.getWifiState();
		return iWifiState;

	}

	/**
	 * 
	 * @return true：开启  false：关闭
	 */
	public Boolean isWifiOpen() {
		int iWifiState = wifiManager.getWifiState();
		if (iWifiState == 1) {
			return false;
		} else if (iWifiState == 3) {
			return true;
		}
		return false;
	}

}
