package tictactoe;

//https://www.javatpoint.com/java-awt : AWT(abstract window toolkit) API 
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
public class TicTacToe implements ActionListener {
Random random = new Random();
JFrame frame = new JFrame();
JPanel title_panel = new JPanel();
JPanel button_panel = new JPanel();
JLabel text_field = new JLabel();
JButton[] buttons = new JButton[9];
boolean player1_turn;

TicTacToe(){
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(800,800);
	frame.getContentPane().setBackground(new Color(50,50,50));
	frame.setLayout(new BorderLayout());
	frame.setVisible(true);
	
	text_field.setBackground(new Color(25,25,25));
	text_field.setForeground(new Color(25,255,0));
	text_field.setFont(new Font("Ink Free",Font.BOLD,75));
	text_field.setHorizontalAlignment(JLabel.CENTER);
	text_field.setText("Tic-Tac-Toe");
	text_field.setOpaque(true);
	
	title_panel.setLayout(new BorderLayout());
	title_panel.setBounds(0,0,800,100);
	
	button_panel.setLayout(new GridLayout(3,3));
	button_panel.setBackground(new Color(150,150,150));
	for(int i=0;i<9;i++)
	{
		buttons[i]=new JButton();
		button_panel.add(buttons[i]);
		buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
		buttons[i].setFocusable(false);
		buttons[i].addActionListener(this);
		
		firstTurn();
		
		
	} 
	
	title_panel.add(text_field);
	frame.add(title_panel,BorderLayout.NORTH); 	
	frame.add(button_panel);
	
}

@Override
public void actionPerformed(ActionEvent e) {
	for(int i=0;i<9;i++)
	{
		if(e.getSource()==buttons[i]) {
			if(player1_turn) {
				if(buttons[i].getText()=="") {
					buttons[i].setForeground(new Color(255,0,0));
					buttons[i].setText("X");
					player1_turn=false;
					text_field.setText("O turn");
					check();
					
				}
			}
			else
			{
				if(buttons[i].getText()=="") {
					buttons[i].setForeground(new Color(0,0,255));
					buttons[i].setText("O");
					player1_turn=true;
					text_field.setText("X turn");
					check();
					}
			}
		}
	}
	
}
public void firstTurn()
{
	
}
public void check()
{
//	Check for X win
	if(buttons[0].getText()=="X" && 
		buttons[1].getText()=="X" &&
		buttons[2].getText()=="X"){
		
		xwin(0,1,2);
	}
	if(buttons[3].getText()=="X" && 
			buttons[4].getText()=="X" &&
			buttons[5].getText()=="X"){
			
			xwin(3,4,5);
		}
	if(buttons[6].getText()=="X" && 
			buttons[7].getText()=="X" &&
			buttons[8].getText()=="X"){
			
			xwin(6,7,8);
		}
	if(buttons[0].getText()=="X" && 
			buttons[3].getText()=="X" &&
			buttons[6].getText()=="X"){
			
			xwin(0,3,6);
		}
	if(buttons[1].getText()=="X" && 
			buttons[4].getText()=="X" &&
			buttons[7].getText()=="X"){
			
			xwin(1,4,7);
		}
	if(buttons[2].getText()=="X" && 
			buttons[5].getText()=="X" &&
			buttons[8].getText()=="X"){
			
			xwin(0,1,2);
		}
	if(buttons[0].getText()=="X" && 
			buttons[4].getText()=="X" &&
			buttons[8].getText()=="X"){
			
			xwin(0,4,8);
		}

//	 Check for O win
	
	if(buttons[0].getText()=="O" && 
			buttons[1].getText()=="O" &&
			buttons[2].getText()=="O"){
			
			owin(0,1,2);
		}
		if(buttons[3].getText()=="O" && 
				buttons[4].getText()=="O" &&
				buttons[5].getText()=="O"){
				
				owin(3,4,5);
			}
		if(buttons[6].getText()=="O" && 
				buttons[7].getText()=="O" &&
				buttons[8].getText()=="O"){
				
				xwin(6,7,8);
			}
		if(buttons[0].getText()=="O" && 
				buttons[3].getText()=="O" &&
				buttons[6].getText()=="O"){
				
				owin(0,3,6);
			}
		if(buttons[1].getText()=="O" && 
				buttons[4].getText()=="O" &&
				buttons[7].getText()=="O"){
				
				owin(1,4,7);
			}
		if(buttons[2].getText()=="O" && 
				buttons[5].getText()=="O" &&
				buttons[8].getText()=="O"){
				
				owin(0,1,2);
			}
		if(buttons[0].getText()=="O" && 
				buttons[4].getText()=="O" &&
				buttons[8].getText()=="O"){
				
				owin(0,4,8);
			}
	
}


public void xwin(int a,int b, int c)
{
	buttons[a].setBackground(Color.GREEN);
	buttons[b].setBackground(Color.GREEN);
	buttons[c].setBackground(Color.GREEN);
	
	for(int i=0;i<9;i++)
	{
		buttons[i].setEnabled(false);
		
	}
	text_field.setText("X wins");
}
public void owin(int a,int b,int c) {
	buttons[a].setBackground(Color.GREEN);
	buttons[b].setBackground(Color.GREEN);
	buttons[c].setBackground(Color.GREEN);
	
	for(int i=0;i<9;i++)
	{
		buttons[i].setEnabled(false);
		
	}
	text_field.setText("O wins");
}
}
