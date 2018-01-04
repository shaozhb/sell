package com.shao.sell.utils;

import java.util.Random;

/**
 * Created by zhibin.shao on 2018/1/4.
 */
public class KeyUtils {

    public static synchronized String genUniqueKey(){

        Random random=new Random();
        Integer num=random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(num);

    }

}
