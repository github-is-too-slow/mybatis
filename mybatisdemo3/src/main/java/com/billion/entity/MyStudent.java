package com.billion.entity;

/**
 * @author Billion
 * @create 2021-03-03 22:06
 */
public class MyStudent {
	private Integer myId;
	private String myName;

	public Integer getMyId() {
		return myId;
	}

	public void setMyId(Integer myId) {
		this.myId = myId;
	}

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	@Override
	public String toString() {
		return "MyStudent{" +
				"myId=" + myId +
				", myName='" + myName + '\'' +
				'}';
	}
}
