package activity;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.*;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.TextField;

public class DocotorRegister extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DocotorRegister frame = new DocotorRegister();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public DocotorRegister() {
		this.setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 743);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(154, 13, 243, 44);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u59D3\u540D");
		label.setBounds(68, 26, 72, 18);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(154, 63, 243, 44);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(154, 113, 243, 44);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(154, 163, 243, 44);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(154, 213, 243, 44);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(154, 264, 243, 44);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(154, 314, 243, 44);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(154, 364, 243, 44);
		contentPane.add(textField_7);
		
		JLabel lblNewLabel = new JLabel("\u6027\u522B");
		lblNewLabel.setBounds(68, 76, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5E74\u9F84");
		lblNewLabel_1.setBounds(68, 126, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("\u51FA\u751F\u5E74\u6708");
		label_1.setBounds(68, 176, 72, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		label_2.setBounds(68, 226, 72, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u5BB6\u5EAD\u4F4F\u5740");
		label_3.setBounds(68, 277, 72, 18);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u7535\u8BDD");
		label_4.setBounds(68, 327, 72, 18);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u5DE5\u4F5C\u5355\u4F4D");
		label_5.setBounds(68, 377, 72, 18);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u5DE5\u4F5C\u7ECF\u5386");
		label_6.setBounds(68, 426, 72, 18);
		contentPane.add(label_6);

		TextArea textArea = new TextArea();
		textArea.setBounds(154, 414, 336, 190);
		contentPane.add(textArea);
		
		
	
	}
}
