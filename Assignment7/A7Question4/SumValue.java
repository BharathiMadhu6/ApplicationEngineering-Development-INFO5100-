package A7Question4;

import java.util.Random;

public class SumValue implements Runnable {

    private long total;
    private int lowerIndex ;
    private int upperIndex ;
    private int[] sumArr;

    public int getLowerIndex() {
        return lowerIndex;
    }

    public void setLowerIndex(int lowerIndex) {
        this.lowerIndex = lowerIndex;
    }

    public void setUpperIndex(int upperIndex) {
        this.upperIndex = upperIndex;
    }

    public int getUpperIndex() {
        return upperIndex;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    SumValue(int[] sumArr, int lowerIndex, int upperIndex, long total) {
        this.sumArr = sumArr;
        this.lowerIndex = lowerIndex;
        this.upperIndex = upperIndex;
        this.total = total;
    }

    public static int[] generateRandomArray(int[] arr) {
        Random random = new Random();
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(20);
        }
        return arr;
    }

    public void run() {
        long sum = 0;
        for (int i = this.getLowerIndex(); i < this.getUpperIndex(); i++) {
            sum = sum + sumArr[i];
        }
        this.setTotal(sum);
    }


    public static long sum(int[] arr) {
        long sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0;
        SumValue runnable1 = new SumValue(arr,0,1000000,sum1);
        Thread t1 = new Thread(runnable1);
        t1.start();

        SumValue runnable2 = new SumValue(arr,1000000,2000000,sum2);
        Thread t2 = new Thread(runnable2);
        t2.start();

        SumValue runnable3 = new SumValue(arr,2000000,3000000,sum3);
        Thread t3 = new Thread(runnable3);
        t3.start();

        SumValue runnable4 = new SumValue(arr,3000000,4000000,sum4);
        Thread t4 = new Thread(runnable4);
        t4.start();

        // join threads
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long result = runnable1.getTotal() + runnable2.getTotal() + runnable3.getTotal() + runnable4.getTotal();
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[4000000];
        arr = generateRandomArray(arr);
        long sum = sum(arr);
        System.out.println("Sum : "+sum);
    }
}
