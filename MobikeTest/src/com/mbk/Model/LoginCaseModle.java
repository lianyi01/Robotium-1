package com.mbk.Model;

public class LoginCaseModle {
	private String id;
	private String phone;
	private ExpectEnum expect;
	private String describe;

	public LoginCaseModle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginCaseModle(String phone, ExpectEnum expect) {
		super();
		this.phone = phone;
		this.expect = expect;
	}

	public LoginCaseModle(String id, String phone, ExpectEnum expect, String describe) {
		super();
		this.id = id;
		this.phone = phone;
		this.expect = expect;
		this.describe = describe;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ExpectEnum getExpect() {
		return expect;
	}

	public void setExpect(ExpectEnum expect) {
		this.expect = expect;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	@Override
	public String toString() {
		return "LoginCaseModle [id=" + getId() + ", phone=" + getPhone() + ", expect=" + getExpect() + ", describe="
				+ getDescribe();
	}

}
