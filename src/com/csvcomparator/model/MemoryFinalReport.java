package com.csvcomparator.model;

public abstract class MemoryFinalReport {
	
	public MemoryFinalReport() {
		super();
	}
	public String className;
	public String percentage;
	public int liveBytes1;
	public int numObjects1;
	public int size1;
	public MemoryFinalReport(String className, String percentage, int liveBytes1, int numObjects1, int size1) {
		super();
		this.className = className;
		this.percentage = percentage;
		this.liveBytes1 = liveBytes1;
		this.numObjects1 = numObjects1;
		this.size1 = size1;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public int getLiveBytes1() {
		return liveBytes1;
	}
	public void setLiveBytes1(int liveBytes1) {
		this.liveBytes1 = liveBytes1;
	}
	public int getNumObjects1() {
		return numObjects1;
	}
	public void setNumObjects1(int numObjects1) {
		this.numObjects1 = numObjects1;
	}
	public int getSize1() {
		return size1;
	}
	public void setSize1(int size1) {
		this.size1 = size1;
	}

}
