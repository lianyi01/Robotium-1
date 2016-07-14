package Untils;

public class IdHelper {
	// 登录页
	public static class LoginPage {
		// 手机号输入框
		public static String mobileEditText = "mobile_number";
		// 验证码输入框
		public static String verifyEditText = "verify_code";
		// 获取验证码按钮
		public static String getVerifyBtn = "get_verify_code_btn";
		// 收不到短信，试试语音验证码
		public static String getVoiceVerifyBtn = "get_voice_verify_code";
		// 确认
		public static String signBtn = "sign_in_button";
		// 用车服务条款
		public static String disclaimerText = "disclaimer_title_text";
		// 标题
		public static String title = "手机验证";
		// 语音验证码对话框
		public static String voiceDialog = "我知道了";
	}

	// HomeInfo-首页
	public static class HomeInfo {
		// 刷新按钮
		public static String refreshButton = "refresh_nearby_bike_button_arrow";
		// 定位按钮
		public static String locationButton = "map_location_button";
		// 帮助按钮
		public static String helpButton = "map_menu_button";
		// 搜索按钮
		public static String searchButton = "action_search";
		// 开锁按钮
		public static String unlockButton = "unlock_toolbar";
		// 离我最近按钮
		public static String nearByButton = "info_window_text";
		// 摩拜单车使用说明
		public static String guide = "mobike_user_manual_button";
		// 首页点击开锁出现登录按钮
		public static String ulogin = "hintCard_login_button";
	}

	// 搜索页面
	public static class SearchPage {
		// 搜索输入框
		public static String searchText = "search_src_text";
		// 清空输入框按钮
		public static String deleteClick = "search_close_btn";
		// 取消按钮
		public static String cancelClick = "action_search";
		// 定位信息
		public static String locationMessage = "current_location";
		// 搜索结果列表
		public static String resultList = "search_listview";
		// public static String = "";

	}

	public static class PersonalPage {
		// 未登录
		// 登录／注册／信用分按钮
		public static String creditBtn = "btn_credit";
		// 登录状态
		// 设置按钮
		public static String settingBtn = "setting_rootview";
		// 登录/注册文字
		public static String loginText = "登录/注册";

	}
	public static class BookingPage{
		//待预约面板车辆地理位置
		public static String uLocalText = "bike_info_board_address";
		//待预约面板可用车数量
		public static String uBikeUseNum = "bike_info_board_bike_number";
		//预约用车按钮
		public static String bookingButton = "request_booking_button";
		//预约与计费卡片tilte
		public static String bookingHelpPicTitle = "hintcard_title";
		//预约与计费卡片关闭按钮
		public static String bookingHelpCloseBtn = "hintview_close";
		//预约用车描述框title
		public static String messageBox = "title";
		//预约用车描述框关闭按钮
		public static String messageBoxCloseBtn = "我知道了";
		//预约面板用户定位Text
		public static String localText = "booking_active_text";
		//自行车编号
		public static String bikeNumText = "booking_order_bike_id_text";
		//预约倒计时
		public static String timerText = "booking_countdown_time";
		//寻车铃按钮
		public static String beepButton = "beep_button";
		//寻车铃Text
		public static String beepText = "寻车铃";
		//取消预约按钮
		public static String cancelBookingBtn = "booking_cancel_button";
		//取消预约Text
		public static String cancelText = "取消预约";
	}

}
