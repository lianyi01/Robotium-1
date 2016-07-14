package mbk.page.object;

import com.robotium.solo.Solo;

import Untils.IdHelper.BookingPage;
import Untils.Utils;
import android.view.View;
import android.widget.TextView;

public class ElementsBookingPage {
	private Solo solo;
	private Utils utils;
	//预约卡片帮助按钮
	private TextView bookingPicTitle;
	//预约帮助卡片关闭按钮
	private View closeBookingPicBtn;
	//预约15分钟提示框title
	private TextView bookingMessageTitle;
	//预约15分钟提示框关闭按钮
	private View bookingMessageBtn;
	//待预约面板可用车数量
	private TextView ubookingBikeNum;
	//待预约面板车辆位置信息
	private TextView ubookingBikeLocation;
	//预约按钮
	private View bookingButton;
	//预约面板用户定位信息
	private TextView bookingUserLocalMessage;
	//寻车铃
	private View beepButton;

	//车编号
	private TextView bikeID;
	//保留时间
	private TextView bookingRemainTime;
	//取消按钮
	private View cancleButton;
	
	//取消按钮文案
	private Boolean cancleButtonText;
	
	public ElementsBookingPage(Solo solo) {
		this.solo = solo;
		utils = new Utils(solo);
	}
	/**
	 * 预约帮助卡片title
	 */
	public String getBookingPicText(){
		bookingPicTitle = (TextView) utils.findViewById(BookingPage.bookingHelpPicTitle);
		return bookingPicTitle.getText().toString();
	}
	/**
	 * 预约帮助卡片关闭按钮
	 */
	public void closeBookingpic(){
		closeBookingPicBtn = utils.findViewById(BookingPage.bookingHelpCloseBtn);
		solo.clickOnView(closeBookingPicBtn);
	}
	/**
	 * 预约15分钟提示框
	 */
	public String bookingMessageBox(){
		bookingMessageTitle = (TextView) utils.findViewById(BookingPage.messageBox);
		return bookingMessageTitle.getText().toString();
	}
	/**
	 * 预约15分钟提示框关闭
	 */
	public void bookingMessageClose(){
		bookingMessageBtn = utils.findViewById(BookingPage.messageBoxCloseBtn);
		solo.clickOnView(bookingMessageBtn);
	}
	/**
	 * 待预约面板可用车数量
	 */
	public int bookingBikeNum(){
		ubookingBikeNum = (TextView) utils.findViewById(BookingPage.uBikeUseNum);
		return Integer.parseInt(ubookingBikeNum.getText().toString());
	}
	/**
	 * 待预约面板车辆定位信息
	 */
	public Boolean isBookingLocationMessage(){
		
		ubookingBikeLocation = (TextView) utils.findViewById(BookingPage.uLocalText);
		String textValue = ubookingBikeLocation.getText().toString();
		if(textValue != null && textValue != ""){
			return true;
		}else {
		return false;
		}
	}
	/**
	 * 点击预约用车按钮
	 */
	public void clickBookingButton() {
		bookingButton = utils.findViewById(BookingPage.bookingButton);
		solo.clickOnView(bookingButton);
	}
	/**
	 * 预约面板用户定位信息
	 */
	public Boolean isUserLocalText() {
		bookingUserLocalMessage = (TextView) utils.findViewById(BookingPage.localText);
		String userLocalMessage = bookingUserLocalMessage.getText().toString();
		if (userLocalMessage != null && userLocalMessage != "" ) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 寻车铃
	 */
	public void clickBeep() {
		beepButton = utils.findViewById(BookingPage.beepButton);
		solo.clickOnView(beepButton);
	}
	/**
	 * 寻车铃文案
	 */
	public Boolean isBeepText() {
		if (solo.searchText(BookingPage.beepText)) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 车编号
	 */
	public String getBikeID() {
		bikeID = (TextView) utils.findViewById(BookingPage.bikeNumText);
		return bikeID.getText().toString();
	}
	/**
	 * 保留时间
	 */
	public Boolean isBookingRemainTime() {
		bookingRemainTime = (TextView) utils.findViewById(BookingPage.timerText);
		String timeText = bookingRemainTime.getText().toString();
		if (timeText != null & timeText != "") {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 取消按钮
	 */
	public void clickCancleBookingBtn() {
		cancleButton = utils.findViewById(BookingPage.cancelBookingBtn);
		solo.clickOnView(cancleButton);
	}
	
	/**
	 * 取消按钮文案
	 */
	public Boolean isCancleBookingBtnText() {
		cancleButtonText = solo.searchText(BookingPage.cancelText);
		if (cancleButtonText) {
			return true;
		}else{
			return false;
		}
	}

}
