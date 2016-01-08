/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/RunningMedian.php.html
*/

package com.dsalgo;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;


public class RunningMedian
{
    PriorityQueue<Integer> upperQueue;
    PriorityQueue<Integer> lowerQueue;

    public RunningMedian()
    {
        lowerQueue=new PriorityQueue<Integer>(20,new Comparator<Integer>()
        {

            @Override
            public int compare(Integer o1, Integer o2)
            {

                return -o1.compareTo(o2);
            }

        });
        upperQueue=new PriorityQueue<Integer>();
        upperQueue.add(Integer.MAX_VALUE);
        lowerQueue.add(Integer.MIN_VALUE);
    }

    public double getMedian(int num)
    {
        //adding the number to proper heap
            if(num>=upperQueue.peek())
                upperQueue.add(num);
            else
                lowerQueue.add(num);
        //balancing the heaps
        if(upperQueue.size()-lowerQueue.size()==2)
            lowerQueue.add(upperQueue.poll());
        else if(lowerQueue.size()-upperQueue.size()==2)
            upperQueue.add(lowerQueue.poll());
        //returning the median
        if(upperQueue.size()==lowerQueue.size())
            return(upperQueue.peek()+lowerQueue.peek())/2.0;
        else if(upperQueue.size()>lowerQueue.size())
            return upperQueue.peek();
        else
            return lowerQueue.peek();

    }
    public static void main(String[] args)
    {
        Random random=new Random();
        RunningMedian runningMedian=new RunningMedian();
        System.out.println("num\tmedian");
        for(int i=0;i<50;++i)
        {
            int num=random.nextInt(100);
            System.out.print(num);
            System.out.print("\t");
            System.out.println(runningMedian.getMedian(num));
        }

    }

}
        
