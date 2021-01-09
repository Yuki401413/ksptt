package frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.security.auth.login.LoginContext;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JRadioButton;

public class Frm_start extends JFrame {

	private JPanel contentPane;
	private JTextField yh1;
	private JPasswordField mm1;

	private JLabel hy;
	private JLabel yh;
	private JLabel mm;
	private JButton dl;
	private JButton cz;
	
	private Frm_start frame;

	private JTextField nameT = new JTextField();
	private JPasswordField passT = new JPasswordField();// 定义文本域
	private JLabel jj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frm_start();
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
	public Frm_start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		hy = new JLabel("欢迎使用KTV管理系统");
		hy.setBounds(0, 0, 428, 52);
		hy.setFont(new Font("宋体", Font.PLAIN, 30));
		hy.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(hy);

		yh = new JLabel("用户名：");
		yh.setBounds(28, 83, 85, 30);
		yh.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(yh);

		mm = new JLabel("密码：");
		mm.setBounds(24, 138, 90, 31);
		mm.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(mm);

		yh1 = new JTextField();
		yh1.setBounds(116, 84, 121, 27);
		contentPane.add(yh1);
		yh1.setColumns(10);

		mm1 = new JPasswordField();
		mm1.setBounds(116, 143, 120, 27);
		contentPane.add(mm1);

		jj = new JLabel("");
		jj.setForeground(Color.RED);
		jj.setBounds(199, 185, 183, 21);
		contentPane.add(jj);

		dl = new JButton("登录");
		dl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f=new File("./manager.txt");
				Map<String, String> map = new HashMap<String , String>();
				String string =  "";
				String pc [] = null;//储存文件账号和密码的数组
				String zh = "";//账户
				String mm = "";//密码
				try {
					BufferedReader br = new BufferedReader(new FileReader(f));
					while ((string = br.readLine()) != null) {
						pc = string.split(",");
						zh = pc[0];
						mm = pc[1];
						map.put(zh, mm);
						}
					Set<Entry<String, String>> keySet = map.entrySet();//储存账号的集合
					System.out.println(keySet);
					for (Entry<String, String> s : keySet) {
					    if ((s.getKey().equalsIgnoreCase(yh1.getText()))&&(s.getValue().equalsIgnoreCase(mm1.getText()))) {
							System.out.println("aaaaaaaaaaaaaaaaaaaa");
							Frm_m m=new Frm_m();
							m.setVisible(true);
							break;
						}
					
						/*
						 * if(s.getKey().equalsIgnoreCase(yh1.getText())&&s.getValue().equalsIgnoreCase(
						 * mm1.getText())) { //frame.dispose(); System.out.println("!"); Frm_m m=new
						 * Frm_m(); m.setVisible(true);
						 * 
						 * break; }else {
						 * 
						 * jj.setText("账号或密码不符，请重新输入");  }
						 */
					    
					}
					jj.setText("账号或密码不符，请重新输入");
					yh1.setText(""); 
					mm1.setText("");
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		jj.setText("");
		dl.setBounds(259, 83, 123, 29);
		contentPane.add(dl);

		cz = new JButton("注册");
		cz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String yh=yh1.getText();
				String mm=mm1.getText();
				String s=yh1+","+mm1;
				File file=new File("./manager.txt");
				File file2=new File("./history.txt");
				try(FileWriter fw1=new FileWriter(file,true);
						FileWriter fw2=new FileWriter(file2,true)){//创建字符输出流
				    //将用户输入的信息写入指定文件
				   fw1.write(yh1.getText()+","+mm1.getText()+"\n");
				   fw2.write("\n"+yh1.getText()+","+mm1.getText());
				}catch(Exception e1) {e1.printStackTrace();}
				jj.setText("注册成功！");
			}
		});
		cz.setBounds(258, 141, 123, 29);
		contentPane.add(cz);

	}

}
