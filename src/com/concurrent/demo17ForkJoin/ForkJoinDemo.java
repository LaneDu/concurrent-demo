package com.concurrent.demo17ForkJoin;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 任务需求：求和计算的任务！
 * 3000 6000（ForkJoin） 9000（Stream并行流）
 * // 如何使用 forkjoin
 * // 1、forkjoinPool 通过它来执行
 * // 2、计算任务 forkjoinPool.execute(ForkJoinTask task)
 * // 3. 计算类要继承 ForkJoinTask
 * @author lane
 * @date 2021年05月27日 下午3:04
 */
public class ForkJoinDemo extends RecursiveTask<Long> {
    //起始值
    private long start;
    //结束值
    private long end;
    //临界值
    private long temp = 10000l; //10000以下就不用拆分了


    public ForkJoinDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }

    //任务需求：求和1+2+..+20亿
    //计算方法
    @Override
    protected Long compute() {
        //剩余任务过小，就不拆分了
        if ((end-start)<temp){
            long sum = 0l;
            for (long i = start; i <=end ; i++) {
                sum +=i;
            }
            return sum;
        }else{
        //fork join 拆分执行，比线程更轻量效率更高
            //中间值拆
            long middle = (start+end)/2;
            //递归拆分两个子任务
            ForkJoinDemo task1 = new ForkJoinDemo(start,middle);
            //拆分任务放入工作队列中
            task1.fork();
            ForkJoinDemo task2 = new ForkJoinDemo(middle+1,end);
            task2.fork();
            //运行其他任务
            Long join1 = task1.join();
            Long join2 = task2.join();

            return join1+join2;
        }

    }

}
