package com.jingoal.web.mongodb.sample.model;

import java.io.Serializable;
import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "igoalReadMask")
public class ReadMask implements Serializable {

	/**
	 * serialVersionUID: TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private BigInteger id;

	private ReadMaskNode root;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public ReadMaskNode getRoot() {
		return root;
	}

	public void setRoot(ReadMaskNode root) {
		this.root = root;
	}

}
