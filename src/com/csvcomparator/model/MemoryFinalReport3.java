package com.csvcomparator.model;

public class MemoryFinalReport3 extends MemoryFinalReport{
	
	public String percentage2;
	public int liveBytes2;
	public int numObjects2;
	public int size2;
	public String percentage3;
	public int liveBytes3;
	public int numObjects3;
	public int size3;
	
	// Metrics value fields
	public MetricClass metrics1;
	public MetricClass metrics2;
	public MetricClass metrics3;
	public MemoryFinalReport3(String className, String percentage, int liveBytes1, int numObjects1, int size1,
			String percentage2, int liveBytes2, int numObjects2, int size2, String percentage3, int liveBytes3, int numObjects3, int size3) {
		super(className, percentage, liveBytes1, numObjects1, size1);
		this.percentage2 = percentage2;
		this.liveBytes2 = liveBytes2;
		this.numObjects2 = numObjects2;
		this.size2 = size2;
		this.percentage3 = percentage3;
		this.liveBytes3 = liveBytes3;
		this.numObjects3 = numObjects3;
		this.size3 = size3;
	}
	public String getPercentage2() {
		return percentage2;
	}
	public void setPercentage2(String percentage2) {
		this.percentage2 = percentage2;
	}
	public String getPercentage3() {
		return percentage3;
	}
	public void setPercentage3(String percentage3) {
		this.percentage3 = percentage3;
	}
	public int getLiveBytes2() {
		return liveBytes2;
	}
	public void setLiveBytes2(int liveBytes2) {
		this.liveBytes2 = liveBytes2;
	}
	public int getNumObjects2() {
		return numObjects2;
	}
	public void setNumObjects2(int numObjects2) {
		this.numObjects2 = numObjects2;
	}
	public int getSize2() {
		return size2;
	}
	public void setSize2(int size2) {
		this.size2 = size2;
	}
	public int getLiveBytes3() {
		return liveBytes3;
	}
	public void setLiveBytes3(int liveBytes3) {
		this.liveBytes3 = liveBytes3;
	}
	public int getNumObjects3() {
		return numObjects3;
	}
	public void setNumObjects3(int numObjects3) {
		this.numObjects3 = numObjects3;
	}
	public int getSize3() {
		return size3;
	}
	public void setSize3(int size3) {
		this.size3 = size3;
	}
	public MetricClass getMetrics1() {
		return metrics1;
	}
	public void setMetrics1(MetricClass metrics1) {
		this.metrics1 = metrics1;
	}
	public MetricClass getMetrics2() {
		return metrics2;
	}
	public void setMetrics2(MetricClass metrics2) {
		this.metrics2 = metrics2;
	}
	public MetricClass getMetrics3() {
		return metrics3;
	}
	public void setMetrics3(MetricClass metrics3) {
		this.metrics3 = metrics3;
	}

}
