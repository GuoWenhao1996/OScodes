/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FCFS;

import java.awt.Color;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guowh
 */
public class Thread_12345 extends Thread {

    @Override
    public void run() {
        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread_12345.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (Run_Frame.run2_2.getText().length() == 5) {
                while (Run_Frame.queue.peek() != null) {
                    int q = Run_Frame.queue.poll();
                    if (q == 1) {
                        Run_Frame.run3_2.setForeground(Color.red);
                        Run_Frame.run1_1.setText("");
                        Run_Frame.run3_2.setText(">");
                        for (int i = 0; i < 60; i++) {
                            Run_Frame.run3_2.setText(" " + Run_Frame.run3_2.getText());
                            try {
                                sleep(Run_Frame.num1);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Thread_1.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        Run_Frame.run3_2.setText("");
                    } else if (q == 2) {
                        Run_Frame.run3_2.setForeground(Color.green);
                        Run_Frame.run2_1.setText("");
                        Run_Frame.run3_2.setText(">");
                        for (int i = 0; i < 60; i++) {
                            Run_Frame.run3_2.setText(" " + Run_Frame.run3_2.getText());
                            try {
                                sleep(Run_Frame.num2);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Thread_2.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        Run_Frame.run3_2.setText("");
                    } else if (q == 3) {
                        Run_Frame.run3_2.setForeground(Color.blue);
                        Run_Frame.run3_1.setText("");
                        Run_Frame.run3_2.setText(">");
                        for (int i = 0; i < 60; i++) {
                            Run_Frame.run3_2.setText(" " + Run_Frame.run3_2.getText());
                            try {
                                sleep(Run_Frame.num3);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Thread_3.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        Run_Frame.run3_2.setText("");
                    } else if (q == 4) {
                        Run_Frame.run3_2.setForeground(Color.black);
                        Run_Frame.run4_1.setText("");
                        Run_Frame.run3_2.setText(">");
                        for (int i = 0; i < 60; i++) {
                            Run_Frame.run3_2.setText(" " + Run_Frame.run3_2.getText());
                            try {
                                sleep(Run_Frame.num4);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Thread_4.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        Run_Frame.run3_2.setText("");
                    } else if (q == 5) {
                        Run_Frame.run3_2.setForeground(Color.orange);
                        Run_Frame.run5_1.setText("");
                        Run_Frame.run3_2.setText(">");
                        for (int i = 0; i < 60; i++) {
                            Run_Frame.run3_2.setText(" " + Run_Frame.run3_2.getText());
                            try {
                                sleep(Run_Frame.num5);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Thread_5.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        Run_Frame.run3_2.setText("");
                    } else {
                        System.out.println("未知错误");
                    }
                }
                Run_Frame.zanting.setVisible(false);
                Run_Frame.label5_2.setVisible(true);
                break;
            }
        }
    }
}
