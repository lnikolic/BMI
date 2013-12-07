package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

@SuppressWarnings("unused")
public class BMI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMI frame = new BMI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BMI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField("0.0");
		textField.setBounds(96, 11, 113, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField("0.0");
		textField_1.setColumns(10);
		textField_1.setBounds(96, 111, 113, 43);
		contentPane.add(textField_1);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHeight.setBounds(40, 16, 46, 29);
		contentPane.add(lblHeight);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWeight.setBounds(40, 116, 46, 29);
		contentPane.add(lblWeight);
		
		
		
		final JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 165, 414, 29);
		contentPane.add(label);
		
		final JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(10, 205, 414, 29);
		contentPane.add(label_1);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				double h = Double.parseDouble(textField.getText());
				double w = Double.parseDouble(textField_1.getText());
				
				if (h <= 0 || w <= 0) {
					label.setText("Error! Invalid parameter(s)!");
				} else {
					double bmi = w/(h*h);
					label.setText("Your Body Mass Index is "+bmi);
					if (bmi > 0) {
						if (bmi < 18.5) label_1.setText("You are underweight. Feed!");
						if ((18.5 < bmi) && (bmi < 24.9)) label_1.setText("You are of normal weight. Keep it up!");
						if ((25 < bmi) && (bmi < 29.9)) label_1.setText("You are overweight. Cool down a bit!");
						if ((30 < bmi) && (bmi < 34.9)) label_1.setText("You are obese, class I. Beware!");
						if ((35 < bmi) && (bmi < 39.9)) label_1.setText("You are obese, class II. You damage yourself!");
						if (bmi > 40) label_1.setText("You are obese, class III. Go see a doctor!");
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(311, 16, 113, 138);
		contentPane.add(btnNewButton);
		
		JLabel lblM = new JLabel("m");
		lblM.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblM.setHorizontalAlignment(SwingConstants.CENTER);
		lblM.setBounds(219, 11, 46, 43);
		contentPane.add(lblM);
		
		JLabel lblKg = new JLabel("kg");
		lblKg.setHorizontalAlignment(SwingConstants.CENTER);
		lblKg.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKg.setBounds(219, 111, 46, 43);
		contentPane.add(lblKg);
		
		
	}
}
