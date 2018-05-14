package com.example.quartzmultitask;

import com.example.quartzmultitask.componets.MyScheduler;
import com.example.quartzmultitask.job.ScheduledJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.Map;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

@Configuration
public class SchedulerListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    public MyScheduler myScheduler;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Scheduler  scheduler = myScheduler.formatScheduler();

        Trigger trigger1 = getSimpleTrigger("example", "com", 30);

        Trigger trigger2 = getCronTrigger("example2", "com", "0/5 * * * * ?");

        JobDetail jobDetail1 = getJobDetail("example", "com", "version-1.0.0", "201805141135");

        JobDetail jobDetail2 = getJobDetail("example2", "com", "version-1.0.2", "201805141134");
        try {
            //启动一个定时调度器 和 触发器
            myScheduler.startScheduler(scheduler, jobDetail1, trigger1);

            //再启动一个定时调度器 和 触发器，两个任务同时执行
            myScheduler.startScheduler(scheduler, jobDetail2, trigger2);

            //关闭这个定时调度器
//            myScheduler.stopScheduler(scheduler);

            //重启这个定时调度器
//            myScheduler.restartScheduler(scheduler, trigger1);

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }


    public JobDetail getJobDetail(String name, String group, String param1, String param2){
        return JobBuilder.newJob(ScheduledJob.class)
                .withIdentity(name, group)
                .usingJobData("version", param1)//向jobDataMap中传递参数，可在job中获取并使用
                .usingJobData("addTime", param2)
                .build();
    }

    public Trigger getCronTrigger(String name, String group, String cron){
        return newTrigger()
                .withIdentity(name, group)
                .startNow()
                .withSchedule(
                        cronSchedule(cron))
                .build();
    }

    public Trigger getSimpleTrigger(String name, String group, int interval){
        return newTrigger()
                .withIdentity(name, group)
                .startNow()
                .withSchedule(
                        simpleSchedule()
                                .withIntervalInSeconds(interval)//设置间隔30秒
                                .repeatForever())//永远执行下去
                .build();
    }


}