package jrx.data.report.config;


import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;


/**
 * @author xiaocongcong
 * @date 2020/6/8
 */
public class ListenDailiSummaryStatistic implements JobExecutionListener {


    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println(jobExecution.getJobInstance().getJobName()+"任务已开始------------");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println(jobExecution.getJobInstance().getJobName()+"任务已完成------------");
    }
}
