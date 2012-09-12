package com.scia.converter.xml.scia;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class HeaderItem {
	
	@XStreamAsAttribute
	private String t;

	public HeaderItem(String t) {
		super();
		this.t = t;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}
	
	
}
