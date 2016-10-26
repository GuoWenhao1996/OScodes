/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producer_Consumer;

import java.util.concurrent.Semaphore;

/**
 *
 * @author guowenhao
 */
public class P_V {

    //三个信号量
    private static Semaphore mutex;
    private static Semaphore empty;
    private static Semaphore full;
    private static P_V instance;

    private P_V(int m, int e, int f) {
        this.mutex = new Semaphore(m);
        this.empty = new Semaphore(e);
        this.full = new Semaphore(f);
    }

    public static P_V getInstance() {
        if (instance == null) {
            synchronized (P_V.class) {
                if (instance == null) {
                    instance = new P_V(1, 20, 0);
                }
            }
        }
        return instance;
    }

    public void Pwait(Semaphore s) throws InterruptedException {
        s.acquire();
    }

    public void Vsignal(Semaphore s) {
        s.release();
    }

    public static Semaphore getMutex() {
        return mutex;
    }

    public static Semaphore getEmpty() {
        return empty;
    }

    public static Semaphore getFull() {
        return full;
    }

}
