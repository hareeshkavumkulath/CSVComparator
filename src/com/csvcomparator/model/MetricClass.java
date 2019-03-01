package com.csvcomparator.model;

public class MetricClass {
	
	public String kind;
	public String name;
	public int wmc;
	public int noc;
	public int cbo;
	public int lcom;
	public int rfc;
	public int dit;
	public MetricClass(String kind, String name, int wmc, int noc, int cbo, int lcom, int rfc, int dit) {
		super();
		this.kind = kind;
		this.name = name;
		this.wmc = wmc;
		this.noc = noc;
		this.cbo = cbo;
		this.lcom = lcom;
		this.rfc = rfc;
		this.dit = dit;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWmc() {
		return wmc;
	}
	public void setWmc(int wmc) {
		this.wmc = wmc;
	}
	public int getNoc() {
		return noc;
	}
	public void setNoc(int noc) {
		this.noc = noc;
	}
	public int getCbo() {
		return cbo;
	}
	public void setCbo(int cbo) {
		this.cbo = cbo;
	}
	public int getLcom() {
		return lcom;
	}
	public void setLcom(int lcom) {
		this.lcom = lcom;
	}
	public int getRfc() {
		return rfc;
	}
	public void setRfc(int rfc) {
		this.rfc = rfc;
	}
	public int getDit() {
		return dit;
	}
	public void setDit(int dit) {
		this.dit = dit;
	}

}
