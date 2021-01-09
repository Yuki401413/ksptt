package frm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Frmy extends JFrame {

	private JPanel contentPane;
	private JPasswordField yzm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmy frame = new Frmy();
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
	public Frmy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel label = new JLabel("验证界面");
		label.setBorder(new LineBorder(SystemColor.activeCaption, 4, true));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		label.setBounds(31, 15, 217, 38);
		contentPane.add(label);
		
		JLabel yz1 = new JLabel("请输入管理员验证码：");
		yz1.setBounds(18, 71, 203, 21);
		contentPane.add(yz1);
		
		JLabel jj = new JLabel("");
		jj.setForeground(Color.RED);
		jj.setBounds(18, 125, 171, 21);
		contentPane.add(jj);
		
		
		JButton button = new JButton("是");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(yzm.getText().equals("99999")) {
					File f=new File("./history.txt");
					

					
		            try {
		            	FileWriter fileWriter =new FileWriter(f);
						fileWriter.write("");
						fileWriter.flush();
						fileWriter.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					JOptionPane.showMessageDialog(null, "清除成功！");

				}else {
					jj.setText("验证码输入错误！");
					yzm.setText("");
				}
				
			}
		});
		button.setBounds(212, 160, 51, 25);
		contentPane.add(button);
		
		yzm = new JPasswordField();
		yzm.setBounds(67, 95, 196, 27);
		contentPane.add(yzm);
		
		
		
		JLabel lblNewLabel = new JLabel("是否清空登录历史记录？");
		lblNewLabel.setBounds(7, 164, 211, 21);
		contentPane.add(lblNewLabel);
		
		JButton button_1 = new JButton("进入信息中心");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(yzm.getText().equals("99999")) {
				Xxzx zXxzx=new Xxzx();
				zXxzx.setVisible(true);
					}else {
						jj.setText("验证码输入错误！");
						yzm.setText("");
					}
				} finally {
					
				}
				
			}
		});
		button_1.setBounds(67, 200, 151, 29);
		contentPane.add(button_1);
		
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
	}
}
