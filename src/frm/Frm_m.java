package frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frm_m extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_m frame = new Frm_m();
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
	public Frm_m() {
		setTitle("KTV房间管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		
		JTextArea text=new JTextArea();//定义文本域
		text.setEditable(true);
		//contentPane.getContenPane().add(new JScrollPane(text));
		
		JMenuItem newItem=new JMenuItem();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu men_1 = new JMenu("订房管理");
		men_1.setHorizontalAlignment(SwingConstants.LEFT);
		men_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 25));
		menuBar.add(men_1);
		
		JMenuItem menu_1 = new JMenuItem("订房");
		menu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmRoom r=new FrmRoom();
				r.setVisible(true);
			}
		});
		
		
		JMenuItem menu_2 = new JMenuItem("退房");
		menu_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmRoom2 r=new FrmRoom2();
				r.setVisible(true);
//				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		men_1.add(menu_2);
		menu_2.setMnemonic('S');
		menu_2.setAccelerator(KeyStroke.getKeyStroke('S',java.awt.Event.CTRL_MASK));
		men_1.add(menu_2);
		menu_1.setHorizontalAlignment(SwingConstants.LEFT);
		men_1.add(menu_1);
		menu_1.setMnemonic('N');
		menu_1.setAccelerator(KeyStroke.getKeyStroke('N',java.awt.Event.CTRL_MASK));
		men_1.add(menu_1);
		
		men_1.addSeparator();//加入分割线
		
		JMenu men_4 = new JMenu("服务大厅");
		men_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 25));
		menuBar.add(men_4);
		
		JMenuItem menuItem = new JMenuItem("食品信息");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmGoods r=new FrmGoods();
				r.setVisible(true);
			}
		});
		men_4.add(menuItem);
		menuItem.setMnemonic('Q');
		menuItem.setAccelerator(KeyStroke.getKeyStroke('Q',java.awt.Event.CTRL_MASK));
		
		JMenu men_2 = new JMenu("信息中心");
		men_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 25));
		menuBar.add(men_2);
		
		JMenuItem menuItem_1 = new JMenuItem("登录信息修改");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frmy frmy=new Frmy();
				frmy.setVisible(true);
			}
		});
		men_2.add(menuItem_1);
		menuItem_1.setMnemonic('H');
		menuItem_1.setAccelerator(KeyStroke.getKeyStroke('H',java.awt.Event.CTRL_MASK));
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
	}

}
