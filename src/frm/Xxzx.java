package frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Xxzx extends JFrame {

	private JPanel mb;
	private JTextField zhm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Xxzx frame = new Xxzx();
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
	public Xxzx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		mb = new JPanel();
		mb.setBorder(new EmptyBorder(5, 5, 5, 5));
		mb.setLayout(null);
		setContentPane(mb);
		
		JLabel label = new JLabel("信息中心");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.PLAIN, 30));
		label.setBounds(36, 15, 412, 44);
		mb.add(label);
		
		JLabel zhml = new JLabel("管理员账号名：");
		zhml.setBounds(46, 74, 127, 21);
		mb.add(zhml);
		
		zhm = new JTextField();
		zhm.setBounds(208, 73, 149, 27);
		mb.add(zhm);
		zhm.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(126, 116, 337, 123);
		mb.add(textArea);
		
		JLabel jj = new JLabel("");
		jj.setForeground(Color.RED);
		jj.setBounds(126, 254, 231, 21);
		mb.add(jj);
		
		
		JButton btn2 = new JButton("查询");
		btn2.addActionListener(new ActionListener() {
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
					
					for (Entry<String, String> s : keySet) {
						if(s.getKey().equalsIgnoreCase(zhm.getText())) {
							System.out.println("!");
							textArea.setText("账号信息显示：\n"+"账户名："+zhm.getText()+"\n密码："+s.getValue());
							textArea.setVisible(true);
							
							break;
						}
					}
					jj.setText("账号或密码不符，请重新输入");
					zhm.setText("");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btn2.setBounds(369, 74, 94, 29);
		mb.add(btn2);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
	}
}
