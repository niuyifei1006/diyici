package com.niuyifei.bean;

public class Blog {
	private Integer bid;
	private String title;
	private String content;
	private String label;
	private Integer cid;
	private String cname;
	private String created;
	public Blog(Integer bid, String title, String content, String label, Integer cid, String cname, String created) {
		super();
		this.bid = bid;
		this.title = title;
		this.content = content;
		this.label = label;
		this.cid = cid;
		this.cname = cname;
		this.created = created;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public Blog() {
		super();
	}
	public Blog(Integer bid, String title, String content, String label, Integer cid, String cname) {
		super();
		this.bid = bid;
		this.title = title;
		this.content = content;
		this.label = label;
		this.cid = cid;
		this.cname = cname;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Blog [bid=" + bid + ", title=" + title + ", content=" + content + ", label=" + label + ", cid=" + cid
				+ ", cname=" + cname + ", created=" + created + "]";
	}
}
