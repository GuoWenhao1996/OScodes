/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producer_Consumer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guowenhao
 */
public class Producer extends Thread {

    @Override
    public void run() {
        while (true) {
            try {
                sleep(1000);
                P_V.getInstance().Pwait(P_V.getEmpty());
                P_V.getInstance().Pwait(P_V.getMutex());
                StoreFrame.count_store++;
                StoreFrame.goods = StoreFrame.goods + "☆";
                P_V.getInstance().Vsignal(P_V.getMutex());
                P_V.getInstance().Vsignal(P_V.getFull());
                
                StoreFrame.store.setText(StoreFrame.goods);
                StoreFrame.count_store_Label.setText(StoreFrame.count_store + "");
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
