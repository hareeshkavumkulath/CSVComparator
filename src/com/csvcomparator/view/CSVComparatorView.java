package com.csvcomparator.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.csvcomparator.controller.MainController;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class CSVComparatorView extends JFrame{

	private JFrame frmCsvComparator;
	private JTextField fileName1;
	private File file1;
	private File file2;
	private File file3;
	private File ufile1;
	private File ufile2;
	private File ufile3;
	private JTextField fileName2;
	private JButton btnBrowse1;
	private JButton btnBrowse2;
	private JButton btnCompare;
	private MainController controller;
	private JTextField fileName3;
	private JTextField textFieldLoc;
	private JTextField saveFileName;
	private JTextField understandFile1;
	private JTextField understandFile2;
	private JTextField understandFile3;
	private JButton uBtnBrowse1;
	private JButton uBtnBrowse2;
	private JButton uBtnBrowse3;
	private JTextField searchKey;

	/**
	 * Create the application.
	 * @param controller2 
	 */
	public CSVComparatorView(MainController controller) {
		initialize();
		this.controller = controller;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("CSV Comparator");
		setBounds(100, 100, 970, 478);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		fileName1 = new JTextField();
		fileName1.setBounds(31, 31, 290, 26);
		getContentPane().add(fileName1);
		fileName1.setColumns(10);
		
		btnBrowse1 = new JButton("Browse");
		btnBrowse1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".CSV File", "csv"));
				fileChooser.setAcceptAllFileFilterUsed(false);
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					fileName1.setText(fileChooser.getSelectedFile().getName().toString());
					file1 = fileChooser.getSelectedFile();
				}
			}
		});
		btnBrowse1.setBounds(336, 30, 115, 29);
		getContentPane().add(btnBrowse1);
		
		fileName2 = new JTextField();
		fileName2.setBounds(31, 87, 290, 26);
		getContentPane().add(fileName2);
		fileName2.setColumns(10);
		
		
		btnBrowse2 = new JButton("Browse");
		btnBrowse2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".CSV File", "csv"));
				fileChooser.setAcceptAllFileFilterUsed(false);
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					fileName2.setText(fileChooser.getSelectedFile().getName().toString());
					file2 = fileChooser.getSelectedFile();
				}
			}
		});
		btnBrowse2.setBounds(336, 86, 115, 29);
		getContentPane().add(btnBrowse2);
		
		btnCompare = new JButton("Compare");
		btnCompare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String folderName = textFieldLoc.getText();
				String fileName = saveFileName.getText();
				String path = folderName + "\\" + fileName + ".csv";
				controller.compare(file1, file2, file3, ufile1, ufile2, ufile3, path, searchKey.getText());
			}
		});
		btnCompare.setBounds(802, 377, 115, 29);
		getContentPane().add(btnCompare);
		
		fileName3 = new JTextField();
		fileName3.setBounds(31, 143, 290, 26);
		getContentPane().add(fileName3);
		fileName3.setColumns(10);
		
		JButton btnBrowse3 = new JButton("Browse");
		btnBrowse3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".CSV File", "csv"));
				fileChooser.setAcceptAllFileFilterUsed(false);
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					fileName3.setText(fileChooser.getSelectedFile().getName().toString());
					file3 = fileChooser.getSelectedFile();
				}
			}
		});
		btnBrowse3.setBounds(336, 142, 115, 29);
		getContentPane().add(btnBrowse3);
		
		textFieldLoc = new JTextField();
		textFieldLoc.setBounds(571, 280, 216, 26);
		getContentPane().add(textFieldLoc);
		textFieldLoc.setColumns(10);
		
		JLabel lblSaveTo = new JLabel("Save To:");
		lblSaveTo.setBounds(487, 283, 69, 20);
		getContentPane().add(lblSaveTo);
		
		JButton btnBrowseLoc = new JButton("Browse");
		btnBrowseLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileChooser.setAcceptAllFileFilterUsed(false);
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					textFieldLoc.setText(fileChooser.getSelectedFile().getAbsolutePath());
				}
			}
		});
		btnBrowseLoc.setBounds(802, 279, 115, 29);
		getContentPane().add(btnBrowseLoc);
		
		saveFileName = new JTextField();
		saveFileName.setBounds(571, 335, 216, 26);
		getContentPane().add(saveFileName);
		saveFileName.setColumns(10);
		
		JLabel lblSaveAs = new JLabel("Save As:");
		lblSaveAs.setBounds(492, 338, 69, 20);
		getContentPane().add(lblSaveAs);
		
		understandFile1 = new JTextField();
		understandFile1.setBounds(543, 31, 244, 26);
		getContentPane().add(understandFile1);
		understandFile1.setColumns(10);
		
		understandFile2 = new JTextField();
		understandFile2.setBounds(543, 87, 244, 26);
		getContentPane().add(understandFile2);
		understandFile2.setColumns(10);
		
		understandFile3 = new JTextField();
		understandFile3.setBounds(543, 143, 244, 26);
		getContentPane().add(understandFile3);
		understandFile3.setColumns(10);
		
		uBtnBrowse1 = new JButton("Browse");
		uBtnBrowse1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".CSV File", "csv"));
				fileChooser.setAcceptAllFileFilterUsed(false);
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					understandFile1.setText(fileChooser.getSelectedFile().getName().toString());
					ufile1 = fileChooser.getSelectedFile();
				}
			}
		});
		uBtnBrowse1.setBounds(802, 30, 115, 29);
		getContentPane().add(uBtnBrowse1);
		
		uBtnBrowse2 = new JButton("Browse");
		uBtnBrowse2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".CSV File", "csv"));
				fileChooser.setAcceptAllFileFilterUsed(false);
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					understandFile2.setText(fileChooser.getSelectedFile().getName().toString());
					ufile2 = fileChooser.getSelectedFile();
				}
			}
		});
		uBtnBrowse2.setBounds(802, 86, 115, 29);
		getContentPane().add(uBtnBrowse2);
		
		uBtnBrowse3 = new JButton("Browse");
		uBtnBrowse3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(".CSV File", "csv"));
				fileChooser.setAcceptAllFileFilterUsed(false);
				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					understandFile3.setText(fileChooser.getSelectedFile().getName().toString());
					ufile3 = fileChooser.getSelectedFile();
				}
			}
		});
		uBtnBrowse3.setBounds(802, 142, 115, 29);
		getContentPane().add(uBtnBrowse3);
		
		searchKey = new JTextField();
		searchKey.setBounds(175, 209, 146, 26);
		getContentPane().add(searchKey);
		searchKey.setColumns(10);
		
		JLabel lblSearchFor = new JLabel("Search For:");
		lblSearchFor.setBounds(62, 212, 98, 20);
		getContentPane().add(lblSearchFor);
	}
}
