package com.sprint.bean.details;

import java.util.Map;
public class StronglyTypeCollection {
	private Map<String, Float> accounts;

	public void setAccounts(Map<String, Float> accounts) {
		this.accounts = accounts;
	}

	public Map<String, Float> getAccounts() {
		return accounts;
	}
}
