/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producer_Consumer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author guowenhao
 */
public class StoreFrame extends JFrame {

    protected static String goods = "";
    protected static int count_store = 0;
    private int count_producer = 0;
    private int count_consumer = 0;

    protected static JTextField store = new JTextField(goods, 24);
    protected static JLabel count_store_Label = new JLabel(count_store + "");
    private JLabel count_producer_Label = new JLabel(count_producer + "");
    private JLabel count_consumer_Label = new JLabel(count_consumer + "");

    private JLabel name = new JLabel("           仓库=>");
    private JLabel count_Label1 = new JLabel("                当前仓库中☆的库存为：");
    private JLabel state_Label1 = new JLabel("个          当前状态为：");
    private JLabel state_Label2 = new JLabel("个生产者  ");
    private JLabel state_Label3 = new JLabel("个消费者");
    private JLabel item1 = new JLabel("<1> ");
    private JLabel item2 = new JLabel("<2> ");
    private JLabel item3 = new JLabel("<3> ");
    private JButton producer1 = new JButton("开始生产");
    private JButton consumer1 = new JButton("开始消费");
    private JButton producer2 = new JButton("开始生产");
    private JButton consumer2 = new JButton("开始消费");
    private JButton producer3 = new JButton("开始生产");
    private JButton consumer3 = new JButton("开始消费");

    Producer p1 = new Producer();
    Producer p2 = new Producer();
    Producer p3 = new Producer();
    Consumer c1 = new Consumer();
    Consumer c2 = new Consumer();
    Consumer c3 = new Consumer();

    public StoreFrame() {
        super("生产者与消费者");
        setSize(1200, 320);
        setLocation(100, 240);
        myLayout();
        myEventListener();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void myLayout() {
        FlowLayout flow = new FlowLayout(FlowLayout.LEFT);
        JPanel p1 = new JPanel();
        p1.setLayout(flow);
        store.setEditable(false);
        name.setFont(new Font("Dialog", 0, 40));
        store.setFont(new Font("Dialog", 0, 40));
        p1.add(name);
        p1.add(store);

        JPanel p2 = new JPanel();
        p2.setLayout(flow);
        p2.add(count_Label1);
        p2.add(count_store_Label);
        p2.add(state_Label1);
        p2.add(count_producer_Label);
        p2.add(state_Label2);
        p2.add(count_consumer_Label);
        p2.add(state_Label3);
        count_Label1.setFont(new Font("Dialog", 0, 30));
        count_store_Label.setFont(new Font("Dialog", 0, 30));
        state_Label1.setFont(new Font("Dialog", 0, 30));
        count_producer_Label.setFont(new Font("Dialog", 0, 30));
        state_Label2.setFont(new Font("Dialog", 0, 30));
        count_consumer_Label.setFont(new Font("Dialog", 0, 30));
        state_Label3.setFont(new Font("Dialog", 0, 30));

        JPanel p3 = new JPanel();
        item1.setFont(new Font("Dialog", 0, 30));
        item2.setFont(new Font("Dialog", 0, 30));
        item3.setFont(new Font("Dialog", 0, 30));
        producer1.setBackground(Color.green);
        producer2.setBackground(Color.green);
        producer3.setBackground(Color.green);
        consumer1.setBackground(Color.green);
        consumer2.setBackground(Color.green);
        consumer3.setBackground(Color.green);
        JPanel p3_1 = new JPanel();
        p3_1.add(item1);
        p3_1.add(producer1);
        p3_1.add(consumer1);
        JPanel p3_2 = new JPanel();
        p3_2.add(item2);
        p3_2.add(producer2);
        p3_2.add(consumer2);
        JPanel p3_3 = new JPanel();
        p3_3.add(item3);
        p3_3.add(producer3);
        p3_3.add(consumer3);
        p3.add(p3_1);
        p3.add(p3_2);
        p3.add(p3_3);
        GridLayout gird = new GridLayout(3, 1);
        p3.setLayout(gird);

        BorderLayout border = new BorderLayout();
        setLayout(border);
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
    }

    private void myEventListener() {
        //第一生产者事件监听
        producer1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    shengchan(producer1, p1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(StoreFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        producer2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    shengchan(producer2, p2);
                } catch (InterruptedException ex) {
                    Logger.getLogger(StoreFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        producer3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    shengchan(producer3, p3);
                } catch (InterruptedException ex) {
                    Logger.getLogger(StoreFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        consumer1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    xiaofei(consumer1, c1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(StoreFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        consumer2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    xiaofei(consumer2, c2);
                } catch (InterruptedException ex) {
                    Logger.getLogger(StoreFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        consumer3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    xiaofei(consumer3, c3);
                } catch (InterruptedException ex) {
                    Logger.getLogger(StoreFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void shengchan(JButton b, Producer p) throws InterruptedException {
        if (b.getText() == "开始生产") {
            p.start();
            count_producer++;
            b.setText("暂停生产");
            b.setBackground(Color.red);
        } else if (b.getText() == "暂停生产") {
            p.suspend();
            count_producer--;
            b.setText("继续生产");
            b.setBackground(Color.green);
        } else {
            p.resume();
            count_producer++;
            b.setText("暂停生产");
            b.setBackground(Color.red);
        }
        count_producer_Label.setText(count_producer + "");
    }

    private void xiaofei(JButton b, Consumer c) throws InterruptedException {
        if (b.getText() == "开始消费") {
            c.start();
            count_consumer++;
            b.setText("暂停消费");
            b.setBackground(Color.red);
        } else if (b.getText() == "暂停消费") {
            c.suspend();
            count_consumer--;
            b.setText("继续消费");
            b.setBackground(Color.green);
        } else {
            c.resume();
            count_consumer++;
            b.setText("暂停消费");
            b.setBackground(Color.red);
        }
        count_consumer_Label.setText(count_consumer + "");
    }

    public static void main(String[] args) {
        StoreFrame sf = new StoreFrame();
    }
}
