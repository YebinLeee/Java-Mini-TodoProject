package classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.border.Border;

public class ButtonPanel extends JButton{

	private JButton addTask;
	private JButton clear;
	
	Border emptyBorder= BorderFactory.createEmptyBorder();
	
	// Constructor
	ButtonPanel()
	{
		this.setLayout(new FlowLayout());
		//this.setPreferredSize(new Dimension(300,60));
		this.setBackground(Color.gray);
		
		addTask = new JButton("Add Task");
		addTask.setBorder(emptyBorder);
		addTask.setFont(new Font("IM���� Regular", Font.PLAIN, 20));
		addTask.setBackground(Color.white);
		
		this.add(addTask);
		
		this.add(Box.createHorizontalStrut(20));
		clear = new JButton("Clear Completed Tasks");
		clear.setBorder(emptyBorder);
		clear.setFont(new Font("IM���� Regular", Font.PLAIN, 20));
		clear.setBackground(Color.white);
		
		this.add(clear);
	}
	
	public JButton getAddTask() {
		return addTask;
	}
	
	public JButton getClear() {
		return clear;
	}
}

