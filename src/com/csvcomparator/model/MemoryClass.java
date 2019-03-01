package com.csvcomparator.model;

public class MemoryClass {
	
	public String className;
	public String percent;
	public int liveBytes;
	public int numObjects;
	
	public MemoryClass(String className, String percent, int liveBytes, int numObjects) {
		super();
		this.className = className;
		this.percent = percent;
		this.liveBytes = liveBytes;
		this.numObjects = numObjects;
	}
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	public int getLiveBytes() {
		return liveBytes;
	}
	public void setLiveBytes(int liveBytes) {
		this.liveBytes = liveBytes;
	}
	public int getNumObjects() {
		return numObjects;
	}
	public void setNumObjects(int numObjects) {
		this.numObjects = numObjects;
	}

}
