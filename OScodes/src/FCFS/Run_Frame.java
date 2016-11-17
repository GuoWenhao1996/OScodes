/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FCFS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
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

    protected static int num1 = Get_rNum();
    protected static int num2 = Get_rNum();
    protected static int num3 = Get_rNum();
    protected static int num4 = Get_rNum();
    protected static int num5 = Get_rNum();

    protected static String s1 = ">";
    protected static String s2 = ">";
    protected static String s3 = ">";
    protected static String s4 = ">";
    protected static String s5 = ">";

    protected static JTextField run1_1 = new JTextField(s1, 20);
    protected static JTextField run2_1 = new JTextField(s2, 20);
    protected static JTextField run3_1 = new JTextField(s3, 20);
    protected static JTextField run4_1 = new JTextField(s4, 20);
    protected static JTextField run5_1 = new JTextField(s5, 20);
    private JLabel label2_2 = new JLabel("服务顺序：");
    protected static JTextField run2_2 = new JTextField("", 6);
    protected static JTextField run3_2 = new JTextField("", 20);
    protected static JLabel label5_2 = new JLabel("                      结束！");

    private JLabel sleepLable1 = new JLabel("P");
    private JLabel sleepLable2 = new JLabel("P");
    private JLabel sleepLable3 = new JLabel("P");
    private JLabel sleepLable4 = new JLabel("P");
    private JLabel sleepLable5 = new JLabel("P");
    private JButton start_all = new JButton("全部开始");
    protected static JButton zanting = new JButton("暂停");
    private JButton jixu = new JButton("继续");
    private JButton restart = new JButton("重置");

    protected static Queue<Integer> queue = new LinkedList<Integer>();

    Thread_1 t1 = new Thread_1();
    Thread_2 t2 = new Thread_2();
    Thread_3 t3 = new Thread_3();
    Thread_4 t4 = new Thread_4();
    Thread_5 t5 = new Thread_5();
    Thread_12345 t = new Thread_12345();

    public Run_Frame() {
        super("先来先服务 ");
        setSize(1100, 400);
        setLocation(170, 180);
        myLayout();
        myEventListener();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void myLayout() {
        JPanel p1 = new JPanel();
        GridLayout gird = new GridLayout(5, 1);
        p1.setLayout(gird);
        run1_1.setFont(new Font("Dialog", 0, 30));
        run2_1.setFont(new Font("Dialog", 0, 30));
        run3_1.setFont(new Font("Dialog", 0, 30));
        run4_1.setFont(new Font("Dialog", 0, 30));
        run5_1.setFont(new Font("Dialog", 0, 30));
        run2_2.setFont(new Font("Dialog", 0, 30));
        run1_1.setForeground(Color.red);
        run2_1.setForeground(Color.green);
        run3_1.setForeground(Color.blue);
        run4_1.setForeground(Color.black);
        run5_1.setForeground(Color.orange);

        run3_2.setFont(new Font("Dialog", 0, 30));
        run1_1.setEditable(false);
        run2_1.setEditable(false);
        run3_1.setEditable(false);
        run4_1.setEditable(false);
        run5_1.setEditable(false);
        run2_2.setEditable(false);
        run3_2.setEditable(false);
        sleepLable1.setFont(new Font("Dialog", 0, 40));
        sleepLable2.setFont(new Font("Dialog", 0, 40));
        sleepLable3.setFont(new Font("Dialog", 0, 40));
        sleepLable4.setFont(new Font("Dialog", 0, 40));
        sleepLable5.setFont(new Font("Dialog", 0, 40));
        label2_2.setFont(new Font("Dialog", 0, 40));
        label5_2.setFont(new Font("Dialog", 0, 40));
        label5_2.setVisible(false);
        //为下面三个进程实例创建流式布局（左对齐）
        FlowLayout flow = new FlowLayout(FlowLayout.LEFT);
        //第一进程实例布局
        JPanel p1_1 = new JPanel();
        p1_1.setLayout(flow);
        p1_1.add(run1_1);
        p1_1.add(sleepLable1);

        //第二进程实例布局
        JPanel p1_2 = new JPanel(flow);
        p1_2.add(run2_1);
        p1_2.add(sleepLable2);
        p1_2.add(label2_2);
        p1_2.add(run2_2);

        //第三进程实例布局
        JPanel p1_3 = new JPanel(flow);
        p1_3.add(run3_1);
        p1_3.add(sleepLable3);
        p1_3.add(run3_2);

        //第四进程实例布局
        JPanel p1_4 = new JPanel(flow);
        p1_4.add(run4_1);
        p1_4.add(sleepLable4);

        //第五进程实例布局
        JPanel p1_5 = new JPanel(flow);
        p1_5.add(run5_1);
        p1_5.add(sleepLable5);
        p1_5.add(label5_2);

        //将五个进程实例加入面板
        p1.add(p1_1);
        p1.add(p1_2);
        p1.add(p1_3);
        p1.add(p1_4);
        p1.add(p1_5);

        JPanel p2 = new JPanel();
        p2.add(start_all);
        p2.add(zanting);
        p2.add(jixu);
        zanting.setVisible(false);
        jixu.setVisible(false);
        p2.add(restart);

        BorderLayout border = new BorderLayout();
        setLayout(border);
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
    }

    private void myEventListener() {
        //全部开始事件监听
        start_all.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start_all.setVisible(false);
                zanting.setVisible(true);
                t1.start();
                t2.start();
                t3.start();
                t4.start();
                t5.start();
                t.start();
            }
        });
        //暂停事件监听
        zanting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zanting.setVisible(false);
                jixu.setVisible(true);
                t1.suspend();
                t2.suspend();
                t3.suspend();
                t4.suspend();
                t5.suspend();
                t.suspend();
            }
        });
        //继续事件监听
        jixu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jixu.setVisible(false);
                zanting.setVisible(true);
                t1.resume();
                t2.resume();
                t3.resume();
                t4.resume();
                t5.resume();
                t.resume();
            }
        });
        //重置事件监听
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                t1.stop();
                t2.stop();
                t3.stop();
                t4.stop();
                t5.stop();
                t.stop();
                s1 = ">";
                s2 = ">";
                s3 = ">";
                s4 = ">";
                s5 = ">";
                run1_1.setText(s1);
                run2_1.setText(s2);
                run3_1.setText(s3);
                run4_1.setText(s4);
                run5_1.setText(s5);
                run2_2.setText("");
                run3_2.setText("");
                num1 = Get_rNum();
                num2 = Get_rNum();
                num3 = Get_rNum();
                num4 = Get_rNum();
                num5 = Get_rNum();
                run2_2.setText("");
                queue.clear();
                Run_Frame m = new Run_Frame();
            }
        });
    }

    //获取随机整数并返回
    public static int Get_rNum() {
        int num = 0;
        java.util.Random rNum = new java.util.Random();
        while (true) {
            num = (rNum.nextInt(10) + 5) * 5;
            if (num != num1 && num != num2 && num != num3 && num != num4 && num != num5) {
                break;
            }
        }
        return num;
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
