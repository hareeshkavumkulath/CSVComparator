package com.csvcomparator.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.csvcomparator.controller.MainController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LandingWindow extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public LandingWindow(MainController controller) {
		setTitle("Select Metric");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnMemory = new JButton("Memory");
		btnMemory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VersionSelectPage versionSelectPage = new VersionSelectPage(controller);
				versionSelectPage.setVisible(true);
			}
		});
		btnMemory.setBounds(159, 65, 115, 29);
		contentPane.add(btnMemory);
		
		JButton btnCpu = new JButton("CPU");
		btnCpu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VersionSelectPage versionSelectPage = new VersionSelectPage(controller);
				versionSelectPage.setVisible(true);
			}
		});
		btnCpu.setBounds(159, 110, 115, 29);
		contentPane.add(btnCpu);
	}

}
