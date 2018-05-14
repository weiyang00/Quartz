package com.example.quartzmultitask.componets;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by weiyang on 2018/5/14.
 *
 * @author weiyang
 * @Title: Please fill file name here
 * @Package
 * @Description: Please fill description of the file here
 * @date 2018/5/14
 */
@Component
public class MyScheduler {

    public Scheduler formatScheduler(){
        Scheduler scheduler = null;
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return scheduler;
    }


    public void startScheduler(Scheduler scheduler, JobDetail jobDetail , Trigger trigger) throws SchedulerException {
//        String schedulerId = scheduler.getSchedulerInstanceId();
        scheduler.start();
        scheduler.scheduleJob(jobDetail,trigger);
    }


    public void stopScheduler(Scheduler scheduler) throws SchedulerException{
        scheduler.shutdown();
    }


    public void restartScheduler(Scheduler scheduler, Trigger trigger) throws SchedulerException{
        scheduler.rescheduleJob(trigger.getKey(), trigger);
    }



}
