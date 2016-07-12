package com.mbk.Model;

/*
 * 登录预期结果枚举
 * success 成功
 * failedByPhone 手机号码不合法
 * failedByVerify 验证码相关错误
 * failedByNetWork 网络相关
 */
public enum ExpectEnum {
	success, failedByPhone, failedByVerify, failedByNetWork;

}
