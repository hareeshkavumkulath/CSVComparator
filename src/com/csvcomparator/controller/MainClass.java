package com.csvcomparator.controller;

import java.awt.EventQueue;

import com.csvcomparator.view.LandingWindow;

public class MainClass {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainController controller = new MainController();
					LandingWindow frame = new LandingWindow(controller);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
