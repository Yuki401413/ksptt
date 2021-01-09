package frm;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import factory.ServiceFactory;
import vo.Cust;

import javax.swing.SwingConstants;

public class FrmRoom2 extends JFrame {

	private JPanel contentPane;
	private JLabel mar;
	private JLabel nam;
	private JLabel age;
	private JLabel tim;
	private JLabel mon;
	private JLabel rnu;
	
	private JTextField mar_w;
	private JTextField nam_w;
	private JTextField rnu_w;
	
	private JLabel mar_n;
	private JLabel rnu_n;
	private JButton button;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRoom2 frame = new FrmRoom2();
					frame.setLocationRelativeTo(null);//窗体居中
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
	public FrmRoom2() {
		setTitle("KTV房间管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel tit = new JLabel("退房管理");
		tit.setHorizontalAlignment(SwingConstants.CENTER);
		tit.setBounds(148, 10, 181, 50);
		tit.setFont(new Font("宋体", Font.PLAIN, 45));
		contentPane.add(tit);
		
		JLabel mar = new JLabel("身份证号：");
		mar.setBounds(15, 80, 130, 28);
		mar.setFont(new Font("宋体", Font.PLAIN, 25));
		mar.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(mar);
		

		JLabel nam = new JLabel("姓名：");
		nam.setHorizontalAlignment(SwingConstants.CENTER);
		nam.setFont(new Font("宋体", Font.PLAIN, 25));
		nam.setBounds(70, 130, 75, 28);
		contentPane.add(nam);
		
		mar_w = new JTextField();
		mar_w.setBounds(150, 80, 180, 28);
		contentPane.add(mar_w);
		mar_w.setColumns(10);
		
		nam_w = new JTextField();
		nam_w.setBounds(150, 130, 180, 28);
		contentPane.add(nam_w);
		nam_w.setColumns(10);
		
		rnu = new JLabel("房间号：");
		rnu.setFont(new Font("宋体", Font.PLAIN, 25));
		rnu.setHorizontalAlignment(SwingConstants.CENTER);
		rnu.setBounds(45, 185, 100, 27);
		contentPane.add(rnu);
		
		rnu_w = new JTextField();
		rnu_w.setBounds(150, 187, 96, 27);
		contentPane.add(rnu_w);
		rnu_w.setColumns(10);
		
		mar_n = new JLabel("");
		mar_n.setForeground(Color.RED);
		mar_n.setBounds(345, 85, 118, 21);
		contentPane.add(mar_n);
		
		button = new JButton("确定");
		button.setBounds(148, 266, 150, 30);
		contentPane.add(button);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(checkInputMar()) {
				String coding=mar_w.getText();
			
				try {
					ServiceFactory.getCustServiceInstance().dalete(coding);
					JOptionPane.showMessageDialog(null, "退房成功！");
				} catch (Exception e2) {
					e2.printStackTrace();
				}finally {
					dispose();
					
				}
		}
		}
		
	});
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	public boolean checkInputMar() {
		if(mar_w.getText().length()==0) {
		    mar_n.setText("号码不能为空");//设置警告信息
		    mar_n.requestFocus();//成绩输入框获取焦点
		    return false;
		  }else if(mar_w.getText().length()!=0&&mar_w.getText().length()<=5) {
			  mar_n.setText("请按要求填写");//设置警告信息
			    mar_n.requestFocus();//成绩输入框获取焦点
			    return false;
		  }
		mar_n.setText("");
		  return true;
	}
}
