package frm;

import vo.Cust;
import factory.ServiceFactory;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.Panel;

public class FrmRoom extends JFrame {
	/**
	 * Swing组件不能直接添加到顶层容器中，它必须添加到一个与Swing顶层容器相关联的内容面板（content pane）上。
	 *内容面板是顶层容器包含的一个普通容器，它是一个轻量级组件。基本规则如下：
  	（1）把Swing组件放入一个顶层Swing容器的内容面板上
  	（2）避免使用非Swing的重量级组件。 
	 */
	private JPanel contentPane;
	
	private JLabel tit;
	private JLabel mar;
	private JLabel nam;
	private JLabel age;
	private JLabel tim;
	private JLabel mon;
	private JLabel rnu;
	
	private JTextField mar_w;
	private JTextField nam_w;
	private JTextField age_w;
	private JTextField tim_w;
	private JComboBox mon_w;
	private JTextField rnu_w;

	private JLabel mar_n;
	private JLabel nam_n;
	private JLabel age_n;
	private JLabel tim_n;
	private JLabel mon_n;
	private JLabel rnu_n;
	
	private JButton tj;
	private JButton xg;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRoom frame = new FrmRoom();
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
	 * @return 
	 */
	public  FrmRoom() {
		setTitle("KTV房间管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tit = new JLabel("订房管理");
		tit.setBounds(149, 10, 180, 52);
		tit.setFont(new Font("宋体", Font.PLAIN, 45));
		contentPane.add(tit);
		
		mar = new JLabel("身份证号：");
		mar.setFont(new Font("宋体", Font.PLAIN, 25));
		mar.setHorizontalAlignment(SwingConstants.CENTER);
		mar.setBounds(15, 80, 130, 28);
		contentPane.add(mar);
		
		nam = new JLabel("姓名：");
		nam.setHorizontalAlignment(SwingConstants.CENTER);
		nam.setFont(new Font("宋体", Font.PLAIN, 25));
		nam.setBounds(40, 130, 105, 28);
		contentPane.add(nam);
		
		JLabel age = new JLabel("年龄：");
		age.setHorizontalAlignment(SwingConstants.CENTER);
		age.setFont(new Font("宋体", Font.PLAIN, 25));
		age.setBounds(40, 180, 105, 28);
		contentPane.add(age);
		
		tim = new JLabel("时间：");
		tim.setHorizontalAlignment(SwingConstants.CENTER);
		tim.setFont(new Font("宋体", Font.PLAIN, 25));
		tim.setBounds(40, 230, 105, 28);
		contentPane.add(tim);
		
		mon = new JLabel("费用：");
		mon.setFont(new Font("宋体", Font.PLAIN, 25));
		mon.setHorizontalAlignment(SwingConstants.CENTER);
		mon.setBounds(40, 280, 105, 28);
		contentPane.add(mon);
		
		mar_w = new JTextField();
		mar_w.setBounds(150, 80, 180, 28);
		contentPane.add(mar_w);
		mar_w.setColumns(10);
		
		nam_w = new JTextField();
		nam_w.setBounds(150, 130, 180, 28);
		contentPane.add(nam_w);
		nam_w.setColumns(10);
		
		age_w = new JTextField();
		age_w.setBounds(150, 180, 180, 28);
		contentPane.add(age_w);
		age_w.setColumns(10);
		
		tim_w = new JTextField();
		tim_w.setBounds(150, 230, 180, 28);
		contentPane.add(tim_w);
		tim_w.setColumns(10);
		
		
		
		tj = new JButton("添加");
		tj.setBounds(40, 399, 150, 30);
		contentPane.add(tj);
		
		
		nam_n = new JLabel("");
		nam_n.setForeground(Color.RED);
		nam_n.setBounds(345, 136, 118, 21);
		contentPane.add(nam_n);
		
		age_n = new JLabel("");
		age_n.setForeground(Color.RED);
		age_n.setBounds(345, 186, 133, 21);
		contentPane.add(age_n);
		
		tim_n = new JLabel("");
		tim_n.setForeground(Color.RED);
		tim_n.setBounds(345, 236, 118, 21);
		contentPane.add(tim_n);
		
		mon_n = new JLabel("");
		mon_n.setForeground(Color.RED);
		mon_n.setBounds(345, 286, 118, 21);
		contentPane.add(mon_n);
		
		mar_n = new JLabel("");
		mar_n.setForeground(Color.RED);
		mar_n.setBounds(345, 85, 118, 21);
		contentPane.add(mar_n);
		
		rnu_n = new JLabel("");
		rnu_n.setForeground(Color.RED);
		rnu_n.setBounds(345, 85, 118, 21);
		contentPane.add(rnu_n);
		
		
		String money[]= {"100","150","200"};
		mon_w = new JComboBox(money);
		mon_w.setBounds(149, 283, 180, 27);
		contentPane.add(mon_w);
		
		rnu = new JLabel("房间号：");
		rnu.setFont(new Font("宋体", Font.PLAIN, 25));
		rnu.setHorizontalAlignment(SwingConstants.CENTER);
		rnu.setBounds(31, 328, 100, 27);
		contentPane.add(rnu);
		
		rnu_w = new JTextField();
		rnu_w.setBounds(147, 328, 96, 27);
		contentPane.add(rnu_w);
		rnu_w.setColumns(10);
		
		xg= new JButton("修改");
		xg.setBounds(287, 400, 150, 29);
		contentPane.add(xg);
		//事件监听
		tj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(checkInputMar()&&checkInputAge()&&checkInputMon()&&checkInputNam()&&checkInputTim()&&checkInputRnu()) {
				
				Cust vo=new Cust();
				vo.setCoding(mar_w.getText());
				vo.setName(nam_w.getText());
				vo.setAge(Integer.parseInt(age_w.getText()));
				vo.setTime(tim_w.getText());
				vo.setMoney(Integer.parseInt(mon_w.getSelectedItem().toString()));//读取下拉框中的内容
				vo.setRnumber(Integer.parseInt(rnu_w.getText()));
				
				try {
					ServiceFactory.getCustServiceInstance().insert(vo);
					JOptionPane.showMessageDialog(null, "订房成功！");
				} catch (Exception e2) {
					e2.printStackTrace();
				}finally {
					System.out.println("好耶！");
					dispose();
				}
		}
		}
		
	});
		
		xg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(checkInputMar()&&checkInputAge()&&checkInputMon()&&checkInputNam()&&checkInputTim()&&checkInputRnu()) {
				
				Cust vo=new Cust();
				vo.setCoding(mar_w.getText());
				vo.setName(nam_w.getText());
				vo.setAge(Integer.parseInt(age_w.getText()));
				vo.setTime(tim_w.getText());
				vo.setMoney(Integer.parseInt(mon_w.getSelectedItem().toString()));//读取下拉框中的内容
				vo.setRnumber(Integer.parseInt(rnu_w.getText()));
				
				try {
					ServiceFactory.getCustServiceInstance().update(vo);
					JOptionPane.showMessageDialog(null, "修改成功！");
				} catch (Exception e2) {
					e2.printStackTrace();
				}finally {
					System.out.println("好耶！");
					dispose();
				}
		}
		}
		
	});
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
}
	public boolean checkInputMar() {
		if(mar_w.getText().length()==0) {//获取成绩输入框的内容长度
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
	public boolean checkInputAge() {
		if(Integer.parseInt(age_w.getText())<=18) {//字符串转化为整型
			age_n.setText("年龄未满18周岁");
			age_n.requestFocus();
			return false;
		}age_n.setText("");
		return true;
	}
	public boolean checkInputNam() {
		if(nam_w.getText().length()==0) {
		    nam_n.setText("姓名不能为空");//设置警告信息
		    nam_n.requestFocus();//成绩输入框获取焦点
		    return false;
		  }
		nam_n.setText("");
		  return true;
	}
	public boolean checkInputMon() {
		if(mon_w.getSelectedItem().toString().length()==0) {//获取成绩输入框的内容长度
		    mon_n.setText("金额不能为空");//设置警告信息
		    mon_n.requestFocus();//成绩输入框获取焦点
		    return false;
		  }
		mon_n.setText("");
		  return true;
	}
	public boolean checkInputTim() {
		if(tim_w.getText().length()==0) {//获取成绩输入框的内容长度
		    tim_n.setText("时间不能为空");//设置警告信息
		    tim_n.requestFocus();//成绩输入框获取焦点
		    return false;
		  }
		tim_n.setText("");
		  return true;
	}
	public boolean checkInputRnu() {
		if(rnu_w.getText().length()==0) {//获取成绩输入框的内容长度
			rnu_n.setText("房号不能为空");//设置警告信息
			rnu_n.requestFocus();//成绩输入框获取焦点
		    return false;
		  }
		rnu_n.setText("");
		  return true;
	}
}
