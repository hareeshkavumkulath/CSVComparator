package com.csvcomparator.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JTextField;

import com.csvcomparator.model.MemoryClass;
import com.csvcomparator.model.MemoryFinalReport2;
import com.csvcomparator.model.MemoryFinalReport3;
import com.csvcomparator.model.MetricClass;

public class MainController {
	
	private String searchKey;
	
	private ArrayList<MemoryClass> memoryClass1, memoryClass2, memoryClass3;
	
	private ArrayList<MetricClass> metricClass1, metricClass2, metricClass3;
	
	ArrayList<MemoryFinalReport3> report;
	ArrayList<MemoryFinalReport2> report2;
	
	StringBuffer buffer = null;
	
	private ArrayList<MetricClass> createMetricList(File file) {
		ArrayList<MetricClass> list = new ArrayList<MetricClass>();
		try {
			Scanner input = new Scanner(file);
			String line = input.nextLine();
			while(input.hasNext()) {
				int wmc, noc, cbo, lcom, rfc, dit;
				line = input.nextLine();
				String[] values = line.split(",");
				String kind = values[0];
				String name = values[1];
				try {
					wmc = Integer.parseInt(values[2]);
				}catch(Exception e) {
					wmc = -1;
				}
				try {
					noc = Integer.parseInt(values[3]);
				}catch(Exception e) {
					noc = -1;
				}
				try {
					cbo = Integer.parseInt(values[4]);
				}catch(Exception e) {
					cbo = -1;
				}
				try {
					lcom = Integer.parseInt(values[5]);
				}catch(Exception e) {
					lcom = -1;
				}
				try {
					rfc = Integer.parseInt(values[6]);
				}catch(Exception e) {
					rfc = -1;
				}
				try {
					dit = Integer.parseInt(values[7]);
				}catch(Exception e) {
					dit = -1;
				}
				String nameIgnoreCase = name.toLowerCase();
				if(nameIgnoreCase.contains(searchKey)) {
					list.add(new MetricClass(kind, name, wmc, noc, cbo, lcom, rfc, dit));
				}
			}
			input.close();
		}catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		System.out.println(list.size());
		return list;
	}
	
	private ArrayList<MemoryClass> createList(File file) {
		ArrayList<MemoryClass> list = new ArrayList<MemoryClass>();
		try {
			System.out.println(file);
			Scanner input = new Scanner(file);
			String line = input.nextLine();
			while(input.hasNext()) {
				line = input.nextLine();
				String[] values = line.split(",");
				System.out.println(line);
				String className = values[0];
				String liveBytes1 = values[1];
				String liveBytes2 = values[2];
				String liveObjects = values[3];
				String classNameIgnoreCase = className.toLowerCase();
				if(classNameIgnoreCase.contains(searchKey)) {
					int liveBytes = Integer.parseInt(liveBytes2);
					int numObjects = Integer.parseInt(liveObjects);
					list.add(new MemoryClass(className, liveBytes1, liveBytes, numObjects));
				}
			}
			input.close();
		}catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		System.out.println(list.size());
		return list;
	}
	
	public void compare(File file1, File file2, File file3, File file4, File file5, File file6, String path, String searchKey) {
		this.searchKey = searchKey.toLowerCase(); 
		report = new ArrayList<MemoryFinalReport3>();
		memoryClass1 = createList(file1);
		memoryClass2 = createList(file2);
		memoryClass3 = createList(file3);
		metricClass1 = createMetricList(file4);
		metricClass2 = createMetricList(file5);
		metricClass3 = createMetricList(file6);
		System.out.println("Search Key"+searchKey);
		for(int i=0;i<memoryClass1.size();i++) { 
			String className1 = memoryClass1.get(i).getClassName(); 
			for(int j=0;j<memoryClass2.size();j++) {
				String className2 = memoryClass2.get(j).getClassName();
				if(className2.equals(className1)) {
					System.out.println("First file and second file has same"); 
					for(int k=0;k<memoryClass3.size();k++) { 
						String className3 = memoryClass3.get(k).getClassName(); 
						if(className3.equals(className1)) {
							System.out.println("Second file and third file has same"); 
							int size1 = memoryClass1.get(i).getLiveBytes()/memoryClass1.get(i).getNumObjects(); 
							int size2 = memoryClass2.get(j).getLiveBytes()/memoryClass2.get(j).getNumObjects(); 
							int size3 = memoryClass3.get(k).getLiveBytes()/memoryClass3.get(k).getNumObjects();
							System.out.println(size1 + "," + size2 + ", " + size3); 
							if(size1 == size3 && size1 != size2 && size2 != size3) {
								report.add(new MemoryFinalReport3(memoryClass1.get(i).getClassName(), memoryClass1.get(i).getPercent(), memoryClass1.get(i).getLiveBytes(), memoryClass1.get(i).getNumObjects(), size1, 
										memoryClass2.get(j).getPercent(), memoryClass2.get(j).getLiveBytes(), memoryClass2.get(j).getNumObjects(), size2, 
										memoryClass3.get(k).getPercent(), memoryClass3.get(k).getLiveBytes(), memoryClass3.get(k).getNumObjects(), size3));
								//buffer.append(memoryClass1.get(i).getClassName() + "," + memoryClass1.get(i).getPercent() + "," + memoryClass1.get(i).getLiveBytes() + "," + memoryClass1.get(i).getNumObjects() + "," + size1 + "," );
								//buffer.append(memoryClass2.get(j).getPercent() + "," + memoryClass2.get(j).getLiveBytes() + "," + memoryClass2.get(j).getNumObjects() + "," + size2 + ",");
								//buffer.append(memoryClass3.get(k).getPercent() + "," + memoryClass3.get(k).getLiveBytes() + "," + memoryClass3.get(k).getNumObjects() + "," + size3 + "\r\n"); 
							} 
						} 
					} 
				} 
			} 
		}
		compareMetrics1();
		compareMetrics2();
		compareMetrics3();
		writeCSV(path);
	}

	private void compareMetrics1() {
		for(int i=0;i<report.size();i++) {
			String className = report.get(i).getClassName();
			for(int j=0;j<metricClass1.size();j++) {
				if(className.equals(metricClass1.get(j).getName()) && metricClass1.get(j).getKind().equals("Public Class")) {
					report.get(i).setMetrics1(metricClass1.get(j));
				}
			}
		}
	}
	
	private void compareMetrics2() {
		for(int i=0;i<report.size();i++) {
			String className = report.get(i).getClassName();
			for(int j=0;j<metricClass2.size();j++) {
				if(className.equals(metricClass2.get(j).getName()) && metricClass2.get(j).getKind().equals("Public Class")) {
					report.get(i).setMetrics2(metricClass2.get(j));
				}
			}
		}
	}
	
	private void compareMetrics3() {
		for(int i=0;i<report.size();i++) {
			String className = report.get(i).getClassName();
			for(int j=0;j<metricClass3.size();j++) {
				if(className.equals(metricClass3.get(j).getName()) && metricClass3.get(j).getKind().equals("Public Class")) {
					report.get(i).setMetrics3(metricClass3.get(j));
				}
			}
		}
	}

	private void writeCSV(String path) {
		buffer = new StringBuffer();
		
		populateBuffer();
		
		try { 
	    	File saveFile = new File(path);
	        FileWriter outputfile = new FileWriter(saveFile); 
	        outputfile.append("Class Name - Live Objects,Live Bytes11,Live Bytes12,Live Objects1,size1,Live Bytes21,Live Bytes22,Live Objects2,size2,Live Bytes31,Live Bytes32,Live Objects3,size3,Metric1-WMC,Metric1-NOC,Metric1-CBO,Metric1-LCOM,Metric1-RFC,Metric1-DIT,Metric2-WMC,Metric2-NOC,Metric2-CBO,Metric2-LCOM,Metric2-RFC,Metric2-DIT,Metric3-WMC,Metric3-NOC,Metric3-CBO,Metric3-LCOM,Metric3-RFC,Metric3-DIT\r\n"); 
	  
	        outputfile.append(buffer.toString());
	        outputfile.close();
	    } 
	    catch (FileNotFoundException e) {
	        System.out.println(e.getMessage());
	    }catch(IOException e) {
	    	System.out.println(e.getMessage());
	    }
	}

	private void populateBuffer() {
		for(int i=0;i<report.size();i++) {
			buffer.append(report.get(i).getClassName() + "," + report.get(i).getPercentage() + "," + report.get(i).getLiveBytes1() + "," + report.get(i).getNumObjects1() + "," + report.get(i).getSize1() + "," );
			buffer.append(report.get(i).getPercentage2() + "," + report.get(i).getLiveBytes2() + "," + report.get(i).getNumObjects2() + "," + report.get(i).getSize2() + "," );
			buffer.append(report.get(i).getPercentage3() + "," + report.get(i).getLiveBytes3() + "," + report.get(i).getNumObjects3() + "," + report.get(i).getSize3() + "," );
			if(report.get(i).getMetrics1() != null) {
				buffer.append(report.get(i).getMetrics1().getWmc() + "," + report.get(i).getMetrics1().getNoc() + "," + report.get(i).getMetrics1().getCbo() + "," + report.get(i).getMetrics1().getLcom() + "," + report.get(i).getMetrics1().getRfc() + "," + report.get(i).getMetrics1().getDit() + ",");
			}else {
				buffer.append(",,,,,,");
			}
			if(report.get(i).getMetrics2() != null) {
				buffer.append(report.get(i).getMetrics2().getWmc() + "," + report.get(i).getMetrics2().getNoc() + "," + report.get(i).getMetrics2().getCbo() + "," + report.get(i).getMetrics2().getLcom() + "," + report.get(i).getMetrics2().getRfc() + "," + report.get(i).getMetrics2().getDit() + ",");
			}else {
				buffer.append(",,,,,,");
			}
			if(report.get(i).getMetrics3() != null) {
				buffer.append(report.get(i).getMetrics3().getWmc() + "," + report.get(i).getMetrics3().getNoc() + "," + report.get(i).getMetrics3().getCbo() + "," + report.get(i).getMetrics3().getLcom() + "," + report.get(i).getMetrics3().getRfc() + "," + report.get(i).getMetrics3().getDit() + "\r\n");
			}else {
				buffer.append(",,,,,\r\n");
			}
		}
	}

	public void compare(File file1, File file2, File ufile1, File ufile2, String path, String searchKey) {
		this.searchKey = searchKey.toLowerCase(); 
		report2 = new ArrayList<MemoryFinalReport2>();
		memoryClass1 = createList(file1);
		memoryClass2 = createList(file2);
		metricClass1 = createMetricList(ufile1);
		metricClass2 = createMetricList(ufile2);
		System.out.println("Search Key"+searchKey);
		for(int i=0;i<memoryClass1.size();i++) { 
			String className1 = memoryClass1.get(i).getClassName(); 
			for(int j=0;j<memoryClass2.size();j++) {
				String className2 = memoryClass2.get(j).getClassName();
				if(className2.equals(className1)) {
					System.out.println("First file and second file has same"); 
					int size1 = memoryClass1.get(i).getLiveBytes()/memoryClass1.get(i).getNumObjects(); 
					int size2 = memoryClass2.get(j).getLiveBytes()/memoryClass2.get(j).getNumObjects(); 
					if(size1 != size2) {
						report2.add(new MemoryFinalReport2(memoryClass1.get(i).getClassName(), memoryClass1.get(i).getPercent(), memoryClass1.get(i).getLiveBytes(), memoryClass1.get(i).getNumObjects(), size1, 
										memoryClass2.get(j).getPercent(), memoryClass2.get(j).getLiveBytes(), memoryClass2.get(j).getNumObjects(), size2));
					} 
				} 
			} 
		}
		compareMetrics12();
		compareMetrics22();
		writeCSV2(path);
		
	}	
	
	private void writeCSV2(String path) {
		buffer = new StringBuffer();
		
		populateBuffer2();
		
		try { 
	    	File saveFile = new File(path);
	        FileWriter outputfile = new FileWriter(saveFile); 
	        outputfile.append("Class Name - Live Objects,Live Bytes11,Live Bytes12,Live Objects1,size1,Live Bytes21,Live Bytes22,Live Objects2,size2,Metric1-WMC,Metric1-NOC,Metric1-CBO,Metric1-LCOM,Metric1-RFC,Metric1-DIT,Metric2-WMC,Metric2-NOC,Metric2-CBO,Metric2-LCOM,Metric2-RFC,Metric2-DIT\r\n"); 
	  
	        outputfile.append(buffer.toString());
	        outputfile.close();
	    } 
	    catch (FileNotFoundException e) {
	        System.out.println(e.getMessage());
	    }catch(IOException e) {
	    	System.out.println(e.getMessage());
	    }
		
	}

	private void populateBuffer2() {
		System.out.println("Report2 Size:"+report2.size());
		for(int i=0;i<report2.size();i++) {
			buffer.append(report2.get(i).getClassName() + "," + report2.get(i).getPercentage() + "," + report2.get(i).getLiveBytes1() + "," + report2.get(i).getNumObjects1() + "," + report2.get(i).getSize1() + "," );
			buffer.append(report2.get(i).getPercentage2() + "," + report2.get(i).getLiveBytes2() + "," + report2.get(i).getNumObjects2() + "," + report2.get(i).getSize2() + "," );
			if(report2.get(i).getMetrics1() != null) {
				buffer.append(report2.get(i).getMetrics1().getWmc() + "," + report2.get(i).getMetrics1().getNoc() + "," + report2.get(i).getMetrics1().getCbo() + "," + report2.get(i).getMetrics1().getLcom() + "," + report2.get(i).getMetrics1().getRfc() + "," + report2.get(i).getMetrics1().getDit() + ",");
			}else {
				buffer.append(",,,,,,");
			}
			if(report2.get(i).getMetrics2() != null) {
				buffer.append(report2.get(i).getMetrics2().getWmc() + "," + report2.get(i).getMetrics2().getNoc() + "," + report2.get(i).getMetrics2().getCbo() + "," + report2.get(i).getMetrics2().getLcom() + "," + report2.get(i).getMetrics2().getRfc() + "," + report2.get(i).getMetrics2().getDit() + "\r\n");
			}else {
				buffer.append(",,,,,,\r\n");
			}
		}
		
	}

	private void compareMetrics12() {
		for(int i=0;i<report2.size();i++) {
			String className = report2.get(i).getClassName();
			for(int j=0;j<metricClass1.size();j++) {
				if(className.equals(metricClass1.get(j).getName()) && metricClass1.get(j).getKind().equals("Public Class")) {
					report2.get(i).setMetrics1(metricClass1.get(j));
				}
			}
		}
	}
	
	private void compareMetrics22() {
		for(int i=0;i<report2.size();i++) {
			String className = report2.get(i).getClassName();
			for(int j=0;j<metricClass2.size();j++) {
				if(className.equals(metricClass2.get(j).getName()) && metricClass2.get(j).getKind().equals("Public Class")) {
					report2.get(i).setMetrics1(metricClass2.get(j));
				}
			}
		}
	}

}
