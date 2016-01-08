/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/FindRepetitionWithoutExtraSpace.php.html
*/

package com.dsalgo;

public class FindRepetitionWithoutExtraSpace
{

 /**
  * @param args
  */
 public static void main(String[] args)
 {
  int[][]arr={{8,12,13,16,17,22,24,29},
    {4,8,14,16,18,23},
    {33,36,37,44,95,126},
    {5,7,15,18}};
  findRepetition(arr);
 }

 public static void findRepetition(int[][] arr)
 {
  int index[]=new int[arr.length];
  int frontNumber[]=new int[arr.length];
  int length[]=new int[arr.length];
  for(int i=0;i<arr.length;++i)
  {
   length[i]=arr[i].length;
  }
  boolean modified=true;
  while(modified)
  {
   modified=false;
   for(int i=0;i<arr.length;++i)
   {
    if(index[i]<length[i])
    {
     modified=true;
     frontNumber[i]=arr[i][index[i]];
    }
    else
    {
     frontNumber[i]=Integer.MAX_VALUE;
    }
   }
   int min=frontNumber[0];
   int minIndex=0;
   for(int i=1;i<arr.length;++i)
   {
    if(frontNumber[i]==min)
    {
     if(frontNumber[i]!=Integer.MAX_VALUE)
      System.out.println(frontNumber[i]);
     index[i]++;
    }
    else if(frontNumber[i]<min)
    {
     min=frontNumber[i];
     minIndex=i;
    }
   }
   index[minIndex]++;
  }
 }
}
    
