/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/NextLargerNumber.php.html
*/

package com.dsalgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NextLargerNumber
{

 /**
  * given a number whose digits are unique find the next bigger number formed by those digits
  * @param args
  */
 public static void main(String[] args) throws Exception
 {
  System.out.println("insert one number whose digits are unique");
  String input = new BufferedReader(new InputStreamReader(System.in))
    .readLine();
  try
  {
   Integer.parseInt(input);
  } catch (NumberFormatException ex)
  {
   System.out.println("Not a valid number");
   return;
  }
  if (input.length() == 1)
  {
   System.out.println("no greater number possible");
   return;
  }
  List<Integer> digits = new ArrayList<Integer>();
  for (int i = 0; i < input.length(); ++i)
  {
   Integer digit = Integer.parseInt(input.substring(i, i + 1));
   if (digits.contains(digit))
   {
    System.out.println("All digits are not unique");
    return;
   } else
   {
    digits.add(digit);
   }
  }

  int rightBiggerIndex=-1;
  int leftSmallerIndex=-1;
  for(int rightDigit=digits.size()-1;rightDigit>0&&rightBiggerIndex==-1;--rightDigit)
   for(int leftDigit=rightDigit-1;leftDigit>=0;--leftDigit)
   {
    if(digits.get(rightDigit)>digits.get(leftDigit))
    {
     rightBiggerIndex=rightDigit;
     leftSmallerIndex=leftDigit;
     break;
    }
   }
  if(rightBiggerIndex==-1 ||leftSmallerIndex==-1)
  {
   System.out.println("no greater number possible");
   return;
  }
  swap(digits,rightBiggerIndex,leftSmallerIndex);
  sort(digits,leftSmallerIndex+1,digits.size()-1);
  for(int num:digits)
  {
   System.out.print(num);
  }
  
 }

 private static void sort(List<Integer> digits, int startIndex, int endIndex)
 {
  if(startIndex==endIndex)return;
  for(int k=startIndex;k<endIndex;++k)
   for(int l=startIndex+1;l<=endIndex;++l)
   {
    if(digits.get(k)>digits.get(l))
     swap(digits,k,l);
   }
  
 }

 private static void swap(List<Integer> digits, int i, int j)
 {
  Integer temp=digits.get(i);
  digits.set(i, digits.get(j));
  digits.set(j, temp);
 }
}
   
