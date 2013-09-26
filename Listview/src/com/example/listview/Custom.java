package com.example.listview;

import com.example.daylist.SimpleDate;

public class Custom {
	private SimpleDate customBig;
	private String customSmall;

	public Custom(SimpleDate string, String string2) {
		this.customBig = string;
		this.customSmall = string2;
	}

	public SimpleDate getcustomBig() {
		return customBig;
	}

	public void setcustomBig(SimpleDate customBig) {
		this.customBig = customBig;
	}

	public String getcustomSmall() {
		return customSmall;
	}

	public void setcustomSmall(String customSmall) {
		this.customSmall = customSmall;
	}
}
