/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurrency;

/**
 *
 * @author guowh
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Count extends JFrame {

    int run_count = 0;//正在run状态的线程个数
    private JLabel timeLable1 = new JLabel("第一计数器未开始");
    private JLabel timeLable2 = new JLabel("第二计数器未开始");
    private JLabel timeLable3 = new JLabel("第三计数器未开始");
    private JButton start_all = new JButton("全部开始");
    private JButton restart = new JButton("重置");
    private JButton start1 = new JButton("开始");
    private JButton start2 = new JButton("开始");
    private JButton start3 = new JButton("开始");
    private JButton stop1 = new JButton("暂停");
    private JButton stop2 = new JButton("暂停");
    private JButton stop3 = new JButton("暂停");
    String number1 = "";
    String number2 = "";
    String number3 = "";
    MyThread m = new MyThread();
    Thread t1 = new Thread(m);
    Thread t2 = new Thread(m);
    Thread t3 = new Thread(m);

    public Count() {
        super("计数器 ");
        setSize(1350, 300);
        setLocation(10, 240);
        myLayout();
        myEventListener();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void myLayout() {
        JPanel p1 = new JPanel();
        GridLayout gird = new GridLayout(3, 1);
        p1.setLayout(gird);
        timeLable1.setFont(new Font("Dialog", 0, 40));
        timeLable2.setFont(new Font("Dialog", 0, 40));
        timeLable3.setFont(new Font("Dialog", 0, 40));
        start1.setEnabled(false);
        start2.setEnabled(false);
        start3.setEnabled(false);
        stop1.setEnabled(false);
        stop2.setEnabled(false);
        stop3.setEnabled(false);
        //为下面三个计数器创建流式布局（左对齐）
        FlowLayout flow = new FlowLayout(FlowLayout.LEFT);
        //第一计数器布局
        JPanel p1_1 = new JPanel();
        p1_1.setLayout(flow);
        p1_1.add(start1);
        p1_1.add(stop1);
        p1_1.add(timeLable1);
        //第二计数器布局
        JPanel p1_2 = new JPanel(flow);
        p1_2.add(start2);
        p1_2.add(stop2);
        p1_2.add(timeLable2);
        //第三计数器布局
        JPanel p1_3 = new JPanel(flow);
        p1_3.add(start3);
        p1_3.add(stop3);
        p1_3.add(timeLable3);
        //将三个计数器加入面板
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
        //全部开始事件监听
        start_all.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.start();
                t2.start();
                t3.start();
                start_all.setVisible(false);
                start1.setEnabled(false);
                start2.setEnabled(false);
                start3.setEnabled(false);
                stop1.setEnabled(true);
                stop2.setEnabled(true);
                stop3.setEnabled(true);
                run_count = 3;//正在运行的为三个
            }
        });
        //重置事件监听
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Count m = new Count();
            }
        });
        //第一计数器开始事件监听
        start1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.resume();
                start1.setEnabled(false);
                stop1.setEnabled(true);
                run_count++;//正在运行的个数+1
            }
        });
        //第二计数器开始事件监听
        start2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t2.resume();
                start2.setEnabled(false);
                stop2.setEnabled(true);
                run_count++;//正在运行的个数+1
            }
        });
        //第三计数器开始事件监听
        start3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t3.resume();
                start3.setEnabled(false);
                stop3.setEnabled(true);
                run_count++;//正在运行的个数+1
            }
        });
        //第一计数器暂停事件监听
        stop1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.suspend();
                start1.setEnabled(true);
                stop1.setEnabled(false);
                run_count--;//正在运行的个数-1
            }
        });
        //第二计数器暂停事件监听
        stop2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t2.suspend();
                start2.setEnabled(true);
                stop2.setEnabled(false);
                run_count--;//正在运行的个数-1
            }
        });
        //第三计数器暂停事件监听
        stop3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t3.suspend();
                start3.setEnabled(true);
                stop3.setEnabled(false);
                run_count--;//正在运行的个数-1
            }
        });

    }

    private class MyThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                if (Thread.currentThread() == t1) {
                    number1 = number1 + "|";
                    timeLable1.setText(number1);
                    while (number1.length() > 99) {
                        run_count--;//正在运行的个数-1
                        start1.setEnabled(false);
                        start1.setText("  结  ");
                        stop1.setEnabled(false);
                        stop1.setText("  束  ");
                        t1.stop();
                    }
                }
                if (Thread.currentThread() == t2) {
                    number2 = number2 + "|";
                    timeLable2.setText(number2);
                    while (number2.length() > 99) {
                        run_count--;//正在运行的个数-1
                        start2.setEnabled(false);
                        start2.setText("  结  ");
                        stop2.setEnabled(false);
                        stop2.setText("  束  ");
                        t2.stop();
                    }
                }
                if (Thread.currentThread() == t3) {
                    number3 = number3 + "|";
                    timeLable3.setText(number3);
                    while (number3.length() > 99) {
                        run_count--;//正在运行的个数-1
                        start3.setEnabled(false);
                        start3.setText("  结  ");
                        stop3.setEnabled(false);
                        stop3.setText("  束  ");
                        t3.stop();
                    }
                }
                try {
                    Thread.sleep(1+ 50 * run_count);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Count.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
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
        Count f = new Count();
    }

}
