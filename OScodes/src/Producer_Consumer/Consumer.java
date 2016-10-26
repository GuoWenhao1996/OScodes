/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producer_Consumer;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guowenhao
 */
public class Consumer extends Thread {

    @Override
    public void run() {
        while (true) {
            try {
                sleep(500);
                P_V.getInstance().Pwait(P_V.getFull());
                P_V.getInstance().Pwait(P_V.getMutex());
                StoreFrame.count_store--;
                if (StoreFrame.count_store <= 1) {
                    StoreFrame.goods = "";
                } else {
                    StoreFrame.goods = StoreFrame.goods.substring(1);
                }
                StoreFrame.store.setText(StoreFrame.goods);
                StoreFrame.count_store_Label.setText(StoreFrame.count_store + "");
                P_V.getInstance().Vsignal(P_V.getMutex());
                P_V.getInstance().Vsignal(P_V.getEmpty());
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
