package cn.wangjf.java.thread;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * 多线程排序
 * User: wangjf
 * Date: 15-1-4
 * Time: 下午4:37
 */
public class ThreadMax implements Callable<Integer> {

    private int[] nums;

    public ThreadMax(int[] nums) {
        this.nums = nums;
    }

    @Override
    public Integer call() throws Exception {
        int max = Integer.MIN_VALUE;
        if (nums != null) {
            for (int i = 0; i < nums.length; i++) {
                max = max < nums[i] ? nums[i] : max;
            }
        }
        return max;
    }


    public static void main(String[] args) throws InterruptedException,
            ExecutionException {

        int threadNums = 2;
        int[][] nums = {{11, 5, 12, 123, 12, 3, 213, 123, 56, 324}, {234, 2, 3, 4, 1, 87733, 234, 732, 76, 28}};

        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();    //Future用来存放Executor的执行结果

        for (int i = 0; i < threadNums; i++) {
            results.add(exec.submit(new ThreadMax(nums[i])));
        }

        int max = Integer.MIN_VALUE;

        for (Future<Integer> fs : results) {
            max = max < fs.get() ? fs.get() : max;
        }

        exec.shutdown();

        System.out.println("max:" + max);
    }
}
