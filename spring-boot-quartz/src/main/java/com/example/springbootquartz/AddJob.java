package com.example.springbootquartz;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Configuration
public class AddJob {
    @Autowired
   private  QuartzConfigration quartzConfigration;

//    @Bean(name = "任务1")
    public MethodInvokingJobDetailFactoryBean  addjob(){
        ScheduleTask scheduleTask1 = new ScheduleTask();
        ScheduleTask scheduleTask2 = new ScheduleTask();

        return quartzConfigration.detailFactoryBean(scheduleTask1);
    }


//    @Bean (name = "task2")
//    public MethodInvokingJobDetailFactoryBean  addjob2(){
//        ScheduleTask scheduleTask1 = new ScheduleTask("新建1");
//        ScheduleTask scheduleTask2 = new ScheduleTask("新建2");
//
//        return quartzConfigration.detailFactoryBean(scheduleTask2);
//    }


//    public void addJob(String jobClassName, String jobGroupName, String cronExpression)throws Exception{
//
//        // 启动调度器
//        scheduler.start();
//
//        //构建job信息
//        JobDetail jobDetail = JobBuilder.newJob((jobClassName).getClass()).withIdentity(jobClassName, jobGroupName).build();
//
//        //表达式调度构建器(即任务执行的时间)
//        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
//
//        //按新的cronExpression表达式构建一个新的trigger
//        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClassName, jobGroupName)
//                .withSchedule(scheduleBuilder).build();
//
//        try {
//            scheduler.scheduleJob(jobDetail, trigger);
//
//        } catch (SchedulerException e) {
//            System.out.println("创建定时任务失败"+e);
//            throw new Exception("创建定时任务失败");
//        }
//    }

}
