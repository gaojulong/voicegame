package com.gaojulong.github;


import android.os.Message;


import cn.lovelqq.julong.voicerw.MainActivity;

/**
 * Created by julong on 2017/12/11.
 */

public class Time {
    private int limitSec;
    private static int timeint=0;

    /**
     * 更新mainactivity里的handle--页面剩余时间
     * 返回剩余时间
     * @param i
     */
    public void gettimer(int i){
        if (limitSec<=0){
            try {
                countDown(i);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void countDown(final int limitSe) throws InterruptedException{
        this.limitSec=limitSe;
        Thread threadtime = null;
             threadtime=new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Count from "+limitSec);
                    while(limitSec >= 0){
                        Message msg=new Message();
                        msg.what=1;
                        msg.arg1=limitSec;
                       // timeint=limitSec;
                        MainActivity.handlerMain.sendMessage(msg);
                        limitSec--;
                      //  System.out.println("remians "+ limitSec-- +" s");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Time is out");
                }
            });

        threadtime.start();

    }

}
