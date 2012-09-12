package com.scia.converter.bean;

public class Part {
	
	private String id;
	private String name;
	private String type;
	private Node initialNode;
	private Node finalNode;
	
	public Part() {		
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Node getInitialNode() {
		return initialNode;
	}

	public void setInitialNode(Node initialNode) {
		this.initialNode = initialNode;
	}

	public Node getFinalNode() {
		return finalNode;
	}

	public void setFinalNode(Node finalNode) {
		this.finalNode = finalNode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Part [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", type=");
		builder.append(type);
		builder.append(", initialNode=");
		builder.append(initialNode);
		builder.append(", finalNode=");
		builder.append(finalNode);
		builder.append("]");
		return builder.toString();
	}
}
