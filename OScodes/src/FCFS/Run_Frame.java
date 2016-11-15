/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FCFS;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author guowh
 */
public class Run_Frame extends JFrame {

    private JTextField run1_1 = new JTextField(">", 20);
    private JTextField run2_1 = new JTextField(">", 20);
    private JTextField run3_1 = new JTextField(">", 20);
    private JTextField run1_2 = new JTextField("", 20);
    private JTextField run2_2 = new JTextField(" ", 20);
    private JTextField run3_2 = new JTextField(" ", 20);

    private JLabel sleepLable1 = new JLabel("P");
    private JLabel sleepLable2 = new JLabel("P");
    private JLabel sleepLable3 = new JLabel("P");
    private JButton start_all = new JButton("全部开始");
    private JButton restart = new JButton("重置");

    public Run_Frame() {
        super("先来先服务 ");
        setSize(1100, 300);
        setLocation(170, 240);
        myLayout();
        myEventListener();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void myLayout() {
        JPanel p1 = new JPanel();
        GridLayout gird = new GridLayout(3, 1);
        p1.setLayout(gird);
        run1_1.setFont(new Font("Dialog", 0, 30));
        run2_1.setFont(new Font("Dialog", 0, 30));
        run3_1.setFont(new Font("Dialog", 0, 30));
        run1_2.setFont(new Font("Dialog", 0, 30));
        run2_2.setFont(new Font("Dialog", 0, 30));
        run3_2.setFont(new Font("Dialog", 0, 30));
        run1_1.setEditable(false);
        run2_1.setEditable(false);
        run3_1.setEditable(false);
        run1_2.setEditable(false);
        run2_2.setEditable(false);
        run3_2.setEditable(false);
        sleepLable1.setFont(new Font("Dialog", 0, 40));
        sleepLable2.setFont(new Font("Dialog", 0, 40));
        sleepLable3.setFont(new Font("Dialog", 0, 40));

        //为下面三个进程实例创建流式布局（左对齐）
        FlowLayout flow = new FlowLayout(FlowLayout.LEFT);
        //第一进程实例布局
        JPanel p1_1 = new JPanel();
        p1_1.setLayout(flow);
        p1_1.add(run1_1);
        p1_1.add(sleepLable1);
        p1_1.add(run1_2);

        //第二进程实例布局
        JPanel p1_2 = new JPanel(flow);
        p1_2.add(run2_1);
        p1_2.add(sleepLable2);
        p1_2.add(run2_2);

        //第三进程实例布局
        JPanel p1_3 = new JPanel(flow);
        p1_3.add(run3_1);
        p1_3.add(sleepLable3);
        p1_3.add(run3_2);

        //将三个进程实例加入面板
        p1.add(p1_1);
        p1.add(p1_2);
        p1.add(p1_3);

        JPanel p2 = new JPanel();
        p2.add(start_all);
        p2.add(restart);

        BorderLayout border = new BorderLayout();
        setLayout(border);
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
    }

    private void myEventListener() {

    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static void main(String[] args) {
        setLookAndFeel();
        Run_Frame rf = new Run_Frame();
    }

}
