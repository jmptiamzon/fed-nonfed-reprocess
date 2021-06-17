package com.sprint.pickrelease.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.sprint.pickrelease.controller.Controller;

public class View extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controller controller;
	private JLabel inputLbl;
	private JTextField inputField;
	private JButton submitBtn;
	private JPanel panel;
	private GridBagConstraints gbc;
	private Insets inset;

	
	public View() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		controller = new Controller();
		inset = new Insets(5, 5, 5, 5);
		gbc = new GridBagConstraints();
		panel = new JPanel(new GridBagLayout());
		
		inputLbl = new JLabel("Order Request ID: ");
		inputField = new JTextField(20);
		
		submitBtn = new JButton("Submit");
		
		setLayout(new BorderLayout());
		setResizable(false);
		setTitle("Pick Release Reprocess");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(panel, BorderLayout.CENTER);
		setComponent(inputLbl, panel, 1, 0, 0, 0, 0);
		setComponent(inputField, panel, 0.5, 0, 1, 0, 0);
		setComponent(submitBtn, panel, 0.5, 1, 1, 0, 0);
		
		pack();
		setLocationRelativeTo(null);
	}
	
	public void setComponent (Component component, JPanel panel, double weightx, int gridx, int gridy, int ipady, int ipadx) {
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = inset;
		gbc.weightx = weightx;
		gbc.gridy = gridy;
		gbc.gridx = gridx;
		gbc.ipady = ipady;
		panel.add(component, gbc);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == submitBtn) {
			
		}
		
	}

}
