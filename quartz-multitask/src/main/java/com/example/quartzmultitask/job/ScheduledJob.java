package com.example.quartzmultitask.job;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduledJob implements Job {

    private SimpleDateFormat dateFormat() {
        return new SimpleDateFormat("HH:mm:ss");
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println(": The time is now " + dateFormat().format(new Date()));
//        JobKey key = context.getJobDetail().getKey();
//        String name = key.getName();
//        String group = key.getGroup();
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String version = dataMap.getString( "version");
        String addTime = dataMap.getString( "addTime");
        System.out.println("this job's version is : " + version + " , and addTime is : "+ addTime);
    }

}