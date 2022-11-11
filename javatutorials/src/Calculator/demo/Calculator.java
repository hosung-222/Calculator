package Calculator.demo;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener {
	private JPanel panel;
	boolean state = false;
	private JTextField tField;
	private JButton[] buttons;
	double num1, num2 ,result;
	String ninput = "";
	String func = "";
	private String[] labels = { 
		"Backspace", "", "", "CE", "C",
		"7", "8", "9", "/", "sqrt",
		"4", "5", "6", "x", "%",
		"1", "2", "3", "-", "1/x",
		"0", "+/-", ".", "+", "=",
	}; // labels[25]
	
	
	public Calculator() {
		tField = new JTextField(35);
		panel = new JPanel();
		
		panel.setLayout(new GridLayout(0, 5, 3, 3)); // 자동, 열, hG,vG
		buttons = new JButton[25];
		int index = 0;
	
		for (int rows = 0; rows < 5; rows++) {
			for (int cols = 0; cols < 5; cols++) {
			buttons[index] = new JButton(labels[index]);
				if( cols >= 3 ) {
					buttons[index].setForeground(Color.red);
					buttons[index].addActionListener(this);
				}
				else {
					buttons[index].setForeground(Color.blue);
					buttons[index].addActionListener(this);
				}
				
				buttons[index].setBackground(Color.yellow);
				panel.add(buttons[index]);
				
				index++;
			}
		}
		add(tField, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		setVisible(true);
		pack();
	}

public static void main(String args[]) {
Calculator s = new Calculator();
	}

@Override
public void actionPerformed(ActionEvent e) {
	 String input = e.getActionCommand();
	 
	
	 if (input.equals("Backspace")) {
		 setBackSpace(getBackSpace().substring(0,getBackSpace().length()-1));
		 if (getBackSpace().length()<1) {
			 ninput = "";
			 num2 =0;
			 num1 = 0;
			 tField.setText("0");
		 }
	 }
	 //사칙연산 입력시 num2에 저장되있던값을 num1으로 옮긴뒤 사칙연산 이후값을 다시 num2에 입력받기위함, 연산자는 func에 저장 
	 else if(input.equals("+")) {
		 num1 = num2;
		 func = "+";
		 ninput = "";
	 }
	 else if(input.equals("-")) {
		 num1 = num2;
		 func = "-";
		 ninput = "";
	 }
	 else if(input.equals("x")) {
		 num1 = num2;
		 func = "x";
		 ninput = "";
	 }
	 else if(input.equals("%")) {
		 num1 = num2;
		 func = "%";
		 ninput = "";
	 }
	 else if(input.equals("/")) {
		 num1 = num2;
		 func = "/";
		 ninput = "";
	 }
	 else if(input.equals("C")) {
		 num1 = 0;
		 num2 = 0;
		 func = "";
		 tField.setText("0");
	 }
	 // = 입력시 num1과 num2를 func에 저장된 연산자를 이용하여 처리
	 else if (input.equals("=")) {
		 if(func.equals("+")) {
			 result = num1 +num2;
			 tField.setText(String.valueOf(result));
			 state = true;
		 }
		 else if (func.equals("-")) {
	            result = num1 - num2;
	            tField.setText(String.valueOf(result));
	            state = true;

	   } else if (func.equals("x")) {
	            result = num1 * num2;
	            tField.setText(String.valueOf(result));
	            state = true;

	   } else if (func.equals("÷")) {
	            result = num1 % num2;
	            tField.setText(String.valueOf(result));
	            state = true;
	        }
	   else if (func.equals("/")) {
           result = num1 / num2;
           tField.setText(String.valueOf(result));
           state = true;
       }
	 }
	 
	 
	 //숫자 입력시
	 else {
		 //=계산후
		 if (state) {
			 tField.setText("0");
			 state = false;
			 num1 = 0;
			 num2 = 0;
			 ninput ="";
		 }
		 //num2에 저장
		 ninput += input;
		 tField.setText(ninput);
		 num2 = Double.parseDouble(ninput);
	 }
}
private void setBackSpace(String bs) {
	tField.setText(bs);
}
private String getBackSpace() {
	return tField.getText();
	}
}


