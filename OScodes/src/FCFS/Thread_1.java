/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FCFS;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guowh
 */
public class Thread_1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 60; i++) {
            Run_Frame.s1 = " " + Run_Frame.s1;
            Run_Frame.run1_1.setText(Run_Frame.s1);
            try {
                sleep(Run_Frame.num1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Run_Frame.queue.offer(1);
        Run_Frame.run2_2.setText(Run_Frame.run2_2.getText() + "红");
    }
}
