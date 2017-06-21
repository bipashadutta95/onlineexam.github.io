package org.servlet;

public class QuestionsPojo {
	private int qid;
	private String qtext;
	private String opt1;
	private String opt2;
	private String opt3;
	private String opt4;
	private int  copt;
	private String sub_name;
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQtext() {
		return qtext;
	}
	public void setQtext(String qtext) {
		this.qtext = qtext;
	}
	public String getOpt1() {
		return opt1;
	}
	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}
	public String getOpt2() {
		return opt2;
	}
	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}
	public String getOpt3() {
		return opt3;
	}
	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}
	public String getOpt4() {
		return opt4;
	}
	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}
	public int getCopt() {
		return copt;
	}
	public void setCopt(int copt) {
		this.copt = copt;
	}
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	public QuestionsPojo(int qid, String qtext, String opt1, String opt2, String opt3, String opt4, int copt,
			String sub_name) {
		super();
		this.qid = qid;
		this.qtext = qtext;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
		this.copt = copt;
		this.sub_name = sub_name;
	}
	public QuestionsPojo() {
		super();
	}
	public QuestionsPojo(int qid, int copt) {
		// TODO Auto-generated constructor stub
		super();
		this.qid = qid;
		this.copt = copt;
	}
	
}