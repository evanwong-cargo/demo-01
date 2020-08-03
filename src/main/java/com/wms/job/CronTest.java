package com.wms.job;

import org.springframework.scheduling.support.CronSequenceGenerator;

import java.util.Date;

public class CronTest {

    public static void main(String[] args) throws ClassNotFoundException {

        //每个五分钟执行一次
        String cron = "0 */5 * * * ?";

        CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator(cron);

        Date currentTime = new Date();

        System.out.println("currentTime: " + currentTime);

        // currentTime为计算下次时间点的开始时间
        Date nextTimePoint = cronSequenceGenerator.next(currentTime);
        System.out.println("nextTimePoint: " + nextTimePoint);

        Date nextNextTimePoint = cronSequenceGenerator.next(nextTimePoint);

        System.out.println("nextNextTimePoint: " + nextNextTimePoint);

    }

}
