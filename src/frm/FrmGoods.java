package frm;

import factory.GoodsServiceFactory;
import factory.ServiceFactory;
import vo.Goods;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class FrmGoods extends JFrame {

	private JPanel contentPane;
	private JTextField key;
	private JButton lan;
	private JButton cha;

	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scr;
	
	private JLabel p;
	private JComboBox page_1;
	private JComboBox cha1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmGoods frame = new FrmGoods();
					frame.setLocationRelativeTo(null);
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
	public FrmGoods() {

		setTitle("服务大厅");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("查找");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		key = new JTextField();
		key.setBounds(15, 15, 152, 36);
		contentPane.add(key);
		key.setColumns(10);
		
		table = new JTable();
		contentPane.add(table);
		
		
		String[] c= {"模糊查找","具体查找"};
		cha1 = new JComboBox(c);
		cha1.setBounds(173, 18, 104, 29);
		contentPane.add(cha1);
		
		
		p = new JLabel("页数：");
		p.setBounds(446, 22, 54, 21);
		contentPane.add(p);
		
		String[] page= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};
		page_1 = new JComboBox(page);
		page_1.setBounds(509, 19, 54, 27);
		contentPane.add(page_1);
		
		

		lan = new JButton("浏览");
		lan.setBounds(325, 18, 112, 29);
		contentPane.add(lan);
//		
//		cha1 = new JComboBox();
//		cha1.setBounds(181, 37, 112, 27);
//		contentPane.add(cha1);
		lan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(key.getText().length()==0) {
					Vector<Vector> vc = new Vector<Vector>();
				Vector<String> titles = new Vector<String>();// 定义动态数组表示表格标题

				Collections.addAll(titles, "服务/餐饮名称", "服务/餐饮类型", "详情");
				try {
					List<Goods> list = GoodsServiceFactory.getIGoodsServiceInstance().list();
					for(Goods g:list) {
						
						Vector vector=new Vector();
						
						vector.add(g.getGname());
						vector.add(g.getKind());
						vector.add(g.getDetails());//表格无法识别，可通过get得到
						
						vc.add(vector);
						
					}
					
					System.out.println(vc);
					table = new JTable(vc, titles);
					
					    scr = new JScrollPane(table);// 加入滚动条，不将表格加入滚动条，表格标题无法显示
						scr.setBounds(0, 66, 578, 478);
						contentPane.add(scr);
						scr.setViewportView(table);
						//JOptionPane.showMessageDialog(null, "success!");
						
						table.setAutoCreateRowSorter(true);//（动态Vector）排序
						scr.setViewportView(table);
					  
					  
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				}
				else if((cha1.getSelectedItem().toString()).equals("具体查找")) {
					String gname=key.getText();
				Vector<String> titles = new Vector<String>();// 定义动态数组表示表格标题
				Collections.addAll(titles, "服务/餐饮名称", "服务/餐饮类型", "详情");
				try {
					Goods vo=GoodsServiceFactory.getIGoodsServiceInstance().get(gname);
					Vector vector=new Vector();
					vector.add(vo.getGname());
					vector.add(vo.getKind());
					vector.add(vo.getDetails());
					
					Vector<Vector> vc = new Vector<Vector>();
					vc.add(vector);
					
					table = new JTable(vc, titles);
					
				    scr = new JScrollPane(table);// 加入滚动条，不将表格加入滚动条，表格标题无法显示
					scr.setBounds(0, 66, 578, 478);
					contentPane.add(scr);
					scr.setViewportView(table);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				}
				else if((cha1.getSelectedItem().toString()).equals("模糊查找")) {
					Vector<Vector> vc = new Vector<Vector>();
					Vector<String> titles = new Vector<String>();// 定义动态数组表示表格标题

					Collections.addAll(titles, "服务/餐饮名称", "服务/餐饮类型", "详情");
					try {
						Map<String, Object> map=GoodsServiceFactory.getIGoodsServiceInstance().listSplit("gname", key.getText(), 1, 20);
						List<Goods> goods=(List<Goods>)map.get("gname");
						for (Goods g : goods) {
							Vector vector=new Vector();
							
							vector.add(g.getGname());
							vector.add(g.getKind());
							vector.add(g.getDetails());//表格无法识别，可通过get得到
							
							vc.add(vector);
						}
						table = new JTable(vc, titles);
						
					    scr = new JScrollPane(table);// 加入滚动条，不将表格加入滚动条，表格标题无法显示
						scr.setBounds(0, 66, 578, 478);
						contentPane.add(scr);
						scr.setViewportView(table);
						//JOptionPane.showMessageDialog(null, "success!");
						
						table.setAutoCreateRowSorter(true);//（动态Vector）排序
						scr.setViewportView(table);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		
		if(key.getText().length()==0) {
			Vector<Vector> vc = new Vector<Vector>();
			Vector<String> titles = new Vector<String>();// 定义动态数组表示表格标题

			Collections.addAll(titles, "服务/餐饮名称", "服务/餐饮类型", "详情");
			try {
				List<Goods> list = GoodsServiceFactory.getIGoodsServiceInstance().list();
				for(Goods g:list) {
					
					Vector vector=new Vector();
					
					vector.add(g.getGname());
					vector.add(g.getKind());
					vector.add(g.getDetails());//表格无法识别，可通过get得到
					
					vc.add(vector);
					
				}
				
				table = new JTable(vc, titles);
				
				    scr = new JScrollPane(table);// 加入滚动条，不将表格加入滚动条，表格标题无法显示
					scr.setBounds(0, 66, 578, 478);
					contentPane.add(scr);
					scr.setViewportView(table);
					//JOptionPane.showMessageDialog(null, "success!");
					
					table.setAutoCreateRowSorter(true);//（动态Vector）排序
					scr.setViewportView(table);
				  
				  
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		

	
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
