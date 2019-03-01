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

public class VersionSelectPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @param controller 
	 */
	public VersionSelectPage(MainController controller) {
		setTitle("Select Number of Versions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVersions = new JButton("2 Versions");
		btnVersions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CSVComparatorView2 csvComparatorView = new CSVComparatorView2(controller);
				csvComparatorView.setVisible(true);
			}
		});
		btnVersions.setBounds(160, 68, 115, 29);
		contentPane.add(btnVersions);
		
		JButton btnVersions_1 = new JButton("3 Versions");
		btnVersions_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CSVComparatorView csvComparatorView = new CSVComparatorView(controller);
				csvComparatorView.setVisible(true);
			}
		});
		btnVersions_1.setBounds(160, 127, 115, 29);
		contentPane.add(btnVersions_1);
	}

}
