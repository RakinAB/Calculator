package lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.KeyStore.CallbackHandlerProtection;

public class GUI {

	// add variables if needed
	private double num1 = 0;
	private double num2 = 0;
	private double result = 0;
	private String operator = "";
	private boolean nextNum = false;
	private boolean afterOperator = false;
	
	public GUI() {
		
	}

	/**
	 * <h1>start()</h1>
	 * <p>This method starts the GUI by creating the 
	 * frame and panels needed to show this Java App.
	 * <br>
	 * <em>Feel free to configure the settings to match
	 * your intended output!</em></p>
	 */
	public void start() {
		JFrame frame = new JFrame();

		// configure your frame's size, title, and close operation
		frame.setSize(600, 800);
		frame.setTitle("UAB CS LAB 10 Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		// add the JPanel into your JFrame
		frame.add(createPanel(), BorderLayout.CENTER);

		// for some reason, a JFrame defaults to false for visibility
		frame.setVisible(true);
	}

	/**
	 * <h1>createPanel()</h1>
	 * <p>This method creates all of the necessary components
	 * needed to be added into a main JPanel object.
	 * <br>
	 * <em>You will need to add more panels and components
	 * to make complete your Java App!</em></p>
	 * @return a main JPanel object to be added into the JFrame
	 */
	public JPanel createPanel() {

		// this is our main panel to house other panels or components
		JPanel mainPanel = new JPanel();

		// TODO change layout if needed
		// this BoxLayout will line its components vertically on the y axis
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		// TODO add more panels and components here!
		JPanel outputPanel = new JPanel();
		outputPanel.setMaximumSize(new Dimension(600,200));
		
		
		JTextField outputTxt = new JTextField(12);
		
		outputTxt.setEditable(false);
		outputTxt.setHorizontalAlignment(SwingConstants.TRAILING);
		outputTxt.setFont(new Font("Times", Font.BOLD, 50));
		outputPanel.add(outputTxt);
		
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(0,3));
		
		JButton clear = new JButton("CLEAR");
		JButton b0 = new JButton("0");
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton b7 = new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");
		JButton add = new JButton("+");
		JButton subtract = new JButton("-");
		JButton multiply = new JButton("*");
		JButton divide = new JButton("/");
		JButton equals = new JButton("=");
		JButton sqrRoot = new JButton("√");
		JButton decimal = new JButton(".");
		
		buttonsPanel.add(clear);
		buttonsPanel.add(sqrRoot);
		buttonsPanel.add(equals);
		buttonsPanel.add(b1);
		buttonsPanel.add(b2);
		buttonsPanel.add(b3);
		buttonsPanel.add(b4);
		buttonsPanel.add(b5);
		buttonsPanel.add(b6);
		buttonsPanel.add(b7);
		buttonsPanel.add(b8);
		buttonsPanel.add(b9);
		buttonsPanel.add(add);
		buttonsPanel.add(b0);
		buttonsPanel.add(subtract);
		buttonsPanel.add(multiply);
		buttonsPanel.add(divide);	
		buttonsPanel.add(decimal);
		
		
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				num1 = 0;
				num2 = 0;
				result = 0;
				operator = "";
				nextNum = false;
				afterOperator = false;
				outputTxt.setText("");
			}
			
		});
		
		equals.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 
				num2 = Double.parseDouble(outputTxt.getText());
				if(operator.equals("+")) {
					//num1 = Double.parseDouble(outputTxt.getText());
					result = num1+num2;
					outputTxt.setText(String.valueOf(result));
					
				}
				else if(operator.equals("-")) {
					//num1 = Double.parseDouble(outputTxt.getText());
					result = num1-num2;
					outputTxt.setText(String.valueOf(result));
					
				}
				else if(operator.equals("*")) {
					//num1 = Double.parseDouble(outputTxt.getText());
					result = num1*num2;
					outputTxt.setText(String.valueOf(result));
					
				}
				else if(operator.equals("/")) {
					//num1 = Double.parseDouble(outputTxt.getText());
					result = num1/num2;
					outputTxt.setText(String.valueOf(result));
					
				}
				afterOperator = true;
				nextNum = false;
				num1 = 0;
				num2 = 0;
			}
			
		});
		
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!nextNum) {
					num1 = Double.parseDouble(outputTxt.getText());
					result = num1+num2;
					num1 = result;
					nextNum = true;
				} else {
					num2 = Double.parseDouble(outputTxt.getText());
					if(operator.equals("+")) {
						result = num1+num2;
						outputTxt.setText(String.valueOf(result));
						num1 = result;
					}
					else if(operator.equals("-")) {
						result = num1-num2;
						outputTxt.setText(String.valueOf(result));
						num1 = result;
					}
					else if(operator.equals("*")) {
						result = num1*num2;
						outputTxt.setText(String.valueOf(result));
						num1 = result;
					}
					else if(operator.equals("/")) {
						result = num1/num2;
						outputTxt.setText(String.valueOf(result));
						num1 = result;
					}
					nextNum = true;
				}
				operator = "+";
				afterOperator = true;
			}
			
		});
		
		subtract.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!nextNum) {
					num1 = Double.parseDouble(outputTxt.getText());
					result = num1 - num2;
					num1 = result;
					nextNum = true;
				} else {
					num2 = Double.parseDouble(outputTxt.getText());
					if(operator.equals("+")) {
						result = num1+num2;
						outputTxt.setText(String.valueOf(result));
						num1 = result;
					}
					else if(operator.equals("-")) {
						result = num1-num2;
						outputTxt.setText(String.valueOf(result));
						num1 = result;
					}
					else if(operator.equals("*")) {
						result = num1*num2;
						outputTxt.setText(String.valueOf(result));
						num1 = result;
					}
					else if(operator.equals("/")) {
						result = num1/num2;
						outputTxt.setText(String.valueOf(result));
						num1 = result;
					}
					nextNum = true;
				}
				operator = "-";
				afterOperator = true;

				
			}
			
		});
		
		multiply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!nextNum) {
					num1 = Double.parseDouble(outputTxt.getText());
					result = num1 * 1;
					num1 = result;
					nextNum = true;
				} else {
					num2 = Double.parseDouble(outputTxt.getText());
					if(operator.equals("+")) {
						result = num1+num2;
						outputTxt.setText(String.valueOf(result));
						num1 = result;
					}
					else if(operator.equals("-")) {
						result = num1-num2;
						outputTxt.setText(String.valueOf(result));
						num1 = result;
					}
					else if(operator.equals("*")) {
						result = num1*num2;
						outputTxt.setText(String.valueOf(result));
						num1 = result;
					}
					else if(operator.equals("/")) {
						result = num1/num2;
						outputTxt.setText(String.valueOf(result));
						num1 = result;
					}
					nextNum = true;
				}
				operator = "*";
				afterOperator = true;
				
			}
		});
		
		divide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!nextNum) {
					num1 = Double.parseDouble(outputTxt.getText());
					result = num1 / 1;
					num1 = result;
					nextNum = true;
				} else {
					num2 = Double.parseDouble(outputTxt.getText());
					if(operator.equals("+")) {
						result = num1+num2;
						outputTxt.setText(String.valueOf(result));
						num1 = result;
					}
					else if(operator.equals("-")) {
						result = num1-num2;
						outputTxt.setText(String.valueOf(result));
						num1 = result;
					}
					else if(operator.equals("*")) {
						result = num1*num2;
						outputTxt.setText(String.valueOf(result));
						num1 = result;
					}
					else if(operator.equals("/")) {
						result = num1/num2;
						outputTxt.setText(String.valueOf(result));
						num1 = result;
					}
					nextNum = true;
				}
				operator = "/";
				afterOperator = true;
				
			}
			
		});
		
		
		
		sqrRoot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				num1 = Double.parseDouble(outputTxt.getText());
				result = Math.sqrt(num1);
				outputTxt.setText(String.valueOf(result));
				num1 = result;
				nextNum = true;
				afterOperator = true;
				
				
			}
			
		});
		
		decimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(afterOperator) {
					outputTxt.setText("");
					afterOperator = false;
				}
				outputTxt.setText(outputTxt.getText() + ".");
			}
			
		});
		
		b0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(afterOperator) {
					outputTxt.setText("");
					afterOperator = false;
				}
				outputTxt.setText(outputTxt.getText() + "0");
			}
			
		});
		
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(afterOperator) {
					outputTxt.setText("");
					afterOperator = false;
				}
				outputTxt.setText(outputTxt.getText() + "1");
				
			}
			
		});
		
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(afterOperator) {
					outputTxt.setText("");
					afterOperator = false;
				}
				outputTxt.setText(outputTxt.getText() + "2");
			}
			
		});
		
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(afterOperator) {
					outputTxt.setText("");
					afterOperator = false;
				}
				outputTxt.setText(outputTxt.getText() + "3");
			}
			
		});
		
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(afterOperator) {
					outputTxt.setText("");
					afterOperator = false;
				}
				outputTxt.setText(outputTxt.getText() + "4");
			}
			
		});
		
		b5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(afterOperator) {
					outputTxt.setText("");
					afterOperator = false;
				}
				outputTxt.setText(outputTxt.getText() + "5");
			}
			
		});
		
		b6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(afterOperator) {
					outputTxt.setText("");
					afterOperator = false;
				}
				outputTxt.setText(outputTxt.getText() + "6");
			}
			
		});
		
		b7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(afterOperator) {
					outputTxt.setText("");
					afterOperator = false;
				}
				outputTxt.setText(outputTxt.getText() + "7");
			}
			
		});
		
		b8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(afterOperator) {
					outputTxt.setText("");
					afterOperator = false;
				}
				outputTxt.setText(outputTxt.getText() + "8");
			}
			
		});
		
		b9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(afterOperator) {
					outputTxt.setText("");
					afterOperator = false;
				}
				outputTxt.setText(outputTxt.getText() + "9");
			}
			
		});
		
		

		mainPanel.add(outputPanel);
		mainPanel.add(buttonsPanel);
		

		// return the entire calculator panel as a JPanel object
		return mainPanel;
	}
	
	
	
}
