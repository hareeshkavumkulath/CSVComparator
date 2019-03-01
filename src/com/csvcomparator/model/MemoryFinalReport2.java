package com.csvcomparator.model;

public class MemoryFinalReport2 extends MemoryFinalReport{
	
	public String percentage2;
	public int liveBytes2;
	public int numObjects2;
	public int size2;
	
	public MetricClass metrics1;
	public MetricClass metrics2;
	public MemoryFinalReport2(String className, String percentage, int liveBytes1, int numObjects1, int size1,
			String percentage2, int liveBytes2, int numObjects2, int size2) {
		super(className, percentage, liveBytes1, numObjects1, size1);
		this.percentage2 = percentage2;
		this.liveBytes2 = liveBytes2;
		this.numObjects2 = numObjects2;
		this.size2 = size2;
	}
	public String getPercentage2() {
		return percentage2;
	}
	public void setPercentage2(String percentage2) {
		this.percentage2 = percentage2;
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

}
