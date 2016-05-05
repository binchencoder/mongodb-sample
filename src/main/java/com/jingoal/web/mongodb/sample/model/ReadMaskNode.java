package com.jingoal.web.mongodb.sample.model;

import java.util.HashSet;
import java.util.Set;

public class ReadMaskNode {

	/**
	 * serialVersionUID: TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	private String itemKey;

	private Set<ReadMaskNode> children = new HashSet<ReadMaskNode>(0);

	public String getItemKey() {
		return itemKey;
	}

	public void setItemKey(String itemKey) {
		this.itemKey = itemKey;
	}

	public Set<ReadMaskNode> getChildren() {
		return children;
	}

	public void setChildren(Set<ReadMaskNode> children) {
		this.children = children;
	}

}
