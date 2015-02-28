package com.magitech.simplestbudget;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUI {
	
	private static JFrame mainFrame = new JFrame("Simplest Budget");
	private JPanel mainPanel = new JPanel(new BorderLayout());
	private JPanel topPanel = new JPanel(new BorderLayout());
	private JPanel bottomPanel = new JPanel(new FlowLayout());
	private static JPanel centerPanel = new JPanel();
	private JPanel leftPanel = new JPanel(new BorderLayout());

	public GUI(){
		generalPanel = new JPanel(new GridLayout(0,3));
		generalPanel.add(new JLabel("INCOME"));
		generalPanel.add(new JLabel("Planned"));
		generalPanel.add(new JLabel("Actual"));//3
		
		generalPanel.add(new JLabel("Wages/Salaries (after taxes)"));
		generalPanel.add(new JTextField());//5
		generalPanel.add(new JTextField());//6
		
		generalPanel.add(new JLabel("Other income"));
		generalPanel.add(new JTextField());
		generalPanel.add(new JTextField());
		
		generalPanel.add(new JLabel("Total income"));
		generalPanel.add(new JTextField());//10
		JTextField tF = (JTextField)generalPanel.getComponent(10);
		tF.setEditable(false);
		generalPanel.add(new JTextField());
		tF = (JTextField)generalPanel.getComponent(11);
		tF.setEditable(false);
				
		generalPanel.add(new JLabel("EXPENSES"));
		generalPanel.add(new JLabel("Planned"));
		generalPanel.add(new JLabel("Actual"));
		
		generalPanel.add(new JLabel("Donations"));
		generalPanel.add(new JTextField());
		generalPanel.add(new JTextField());

		generalPanel.add(new JLabel("Savings"));
		generalPanel.add(new JTextField());
		generalPanel.add(new JTextField());
		
		generalPanel.add(new JLabel("Food"));
		generalPanel.add(new JTextField());
		generalPanel.add(new JTextField());

		generalPanel.add(new JLabel("Mortgage"));
		generalPanel.add(new JTextField());
		generalPanel.add(new JTextField());

		generalPanel.add(new JLabel("Utilities"));
		generalPanel.add(new JTextField());
		generalPanel.add(new JTextField());

		generalPanel.add(new JLabel("Transportation"));
		generalPanel.add(new JTextField());
		generalPanel.add(new JTextField());

		generalPanel.add(new JLabel("Debt Payments"));
		generalPanel.add(new JTextField());
		generalPanel.add(new JTextField());

		generalPanel.add(new JLabel("Insurance"));
		generalPanel.add(new JTextField());
		generalPanel.add(new JTextField());

		generalPanel.add(new JLabel("Medical"));
		generalPanel.add(new JTextField());
		generalPanel.add(new JTextField());
		
		generalPanel.add(new JLabel("Clothing"));
		generalPanel.add(new JTextField());
		generalPanel.add(new JTextField());

		generalPanel.add(new JLabel("School Expenses"));
		generalPanel.add(new JTextField());
		generalPanel.add(new JTextField());

		generalPanel.add(new JLabel("Other"));
		generalPanel.add(new JTextField());
		generalPanel.add(new JTextField());
		
		generalPanel.add(new JLabel("Total Expenses"));
		generalPanel.add(new JTextField());
		tF = (JTextField)generalPanel.getComponent(52);
		tF.setEditable(false);
		generalPanel.add(new JTextField());
		tF = (JTextField)generalPanel.getComponent(53);
		tF.setEditable(false);
		
		generalPanel.add(new JLabel("Income less Expenses"));
		generalPanel.add(new JTextField());
		tF = (JTextField)generalPanel.getComponent(55);
		tF.setEditable(false);
		generalPanel.add(new JTextField());
		tF = (JTextField)generalPanel.getComponent(56);
		tF.setEditable(false);
	}
	
	public GUI(User mainUser){
		currentIndexSelected = 0;
		user = mainUser;
	}
	
	public static void saveData(JPanel panel){
		JTextField tField = (JTextField) panel.getComponent(5);
		if(tField.getText()==null||tField.getText().equals(""))
			tField.setText("0");
		vPanels.remove(currentIndexSelected);
		vPanels.add(currentIndexSelected, panel);
		user.getAccount(currentIndexSelected).getIncomeActual().setWagesAsalaries(Float.parseFloat(tField.getText()));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void ShowEvent(){
		JButton newAccountButton = new JButton("NEW MONTH");
		JButton clear = new JButton("Clear all cells");
		JButton save = new JButton("SAVE ALL");
		JButton load = new JButton("LOAD");
		load.setEnabled(false);
		JButton delete = new JButton("DELETE");
		delete.setEnabled(false);
		listMonths = new JList(model);
		listMonths.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listMonths.setLayoutOrientation(JList.VERTICAL);
		listMonths.setVisibleRowCount(-1);
		listMonths.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent arg0) {
				if(listMonths.getSelectedIndex()>=0){
					load.setEnabled(true);
					delete.setEnabled(true);
				}
			}
		});
		JScrollPane listScroller = new JScrollPane(listMonths);
		listScroller.setPreferredSize(new Dimension(100, 400));
		topPanel.add(newAccountButton, BorderLayout.CENTER);
		leftPanel.add(new JLabel("Select Month:"), BorderLayout.WEST);
		leftPanel.add(listScroller, BorderLayout.CENTER);
		JPanel leftDownPanel = new JPanel(new FlowLayout());
		leftDownPanel.add(delete);
		leftDownPanel.add(load);
		leftPanel.add(leftDownPanel, BorderLayout.SOUTH);
		bottomPanel.add(clear);
		bottomPanel.add(save);
		newAccountButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				inputMonthYearFrame();
			}
		});
		load.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				int index = listMonths.getSelectedIndex();
				if(centerPanel.getComponentCount()==0)
					centerPanel.add(vPanels.get(index));
				else{
					saveData((JPanel) centerPanel.getComponent(0));
					centerPanel.remove(centerPanel.getComponent(0));
					centerPanel.add(vPanels.get(index));
				}
				JPanel panel = (JPanel) centerPanel.getComponent(0);
				JTextField tField= (JTextField)panel.getComponent(5);
				tField.setText(Float.toString(user.getAccount(index).getIncomeActual().getWagesAsalaries()));
				centerPanel.remove(centerPanel.getComponent(0));
				centerPanel.add(panel);
				currentIndexSelected = listMonths.getSelectedIndex();
				mainFrame.revalidate();
			}
		});
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				int index = listMonths.getSelectedIndex();
				model.remove(index);
				listMonths.setSelectedIndex(index-1);
				user.removeAccount(index);
			}
		});
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				vPanels.remove((JPanel)centerPanel.getComponent(0));
				centerPanel.remove(centerPanel.getComponent(0));
				centerPanel.add(new GUI().generalPanel);
				vPanels.add((JPanel)centerPanel.getComponent(0));
				mainFrame.revalidate();
			}
		});
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				new System(user);
			}
		});
	}

	public static void inputMonthYearFrame(){
		JFrame inputMonthYearFrame = new JFrame();
		inputMonthYearFrame.setLocationRelativeTo(null);
		JPanel panel = new JPanel(new FlowLayout());
		inputMonthYearFrame.setVisible(true);
		inputMonthYearFrame.setSize(250, 50);
		JLabel newMonth = new JLabel("Insert Month and Year (MM/YYY): ");
		JTextField tField = new JTextField();
		tField.setColumns(15);
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener(){
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent arg0) {
				if(tField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Insert Month and Year (MM/YYY)!");
				else{
					user.addNewAccount();
					//Insert an account name to account
					user.getAccount(user.getAccount().size()-1).setMonthYear(tField.getText());
					if(centerPanel.getComponentCount()==0){
						centerPanel.add(new GUI().generalPanel);
						vPanels.add((JPanel)centerPanel.getComponent(0));
					}
					else{
						saveData((JPanel) centerPanel.getComponent(0));
						centerPanel.remove(centerPanel.getComponent(0));
						centerPanel.add(new GUI().generalPanel);
						vPanels.add((JPanel)centerPanel.getComponent(0));
					}
					model.addElement(tField.getText());
					listMonths.setSelectedIndex(model.getSize()-1);
					currentIndexSelected = listMonths.getSelectedIndex();
					mainFrame.revalidate();
					inputMonthYearFrame.dispatchEvent(new WindowEvent(inputMonthYearFrame, WindowEvent.WINDOW_CLOSING));
				}
			}
		});
		panel.add(newMonth);
		panel.add(tField);
		panel.add(ok);
		inputMonthYearFrame.add(panel);
	}
	
	public void prepareFrame(){
		mainFrame.setSize(900, 600);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ShowEvent();
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(leftPanel, BorderLayout.WEST);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		mainFrame.add(mainPanel);
		mainFrame.setVisible(true);
	}

	private JPanel generalPanel;
	private static Vector<JPanel> vPanels = new Vector<JPanel>();
	private static User user;
	@SuppressWarnings("rawtypes")
	private static JList listMonths;
	private static int currentIndexSelected;
	@SuppressWarnings("rawtypes")
	private static DefaultListModel model= new DefaultListModel();
}
