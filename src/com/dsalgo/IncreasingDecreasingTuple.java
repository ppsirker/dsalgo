/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/03/first-increasing-second-decreasing-tuple.html
*/

package com.dsalgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IncreasingDecreasingTuple
{
 static int count = 0;

 /**
  * Given N pairs of integers, write an algorithm to sort the pairs so that
  * the first number in each pair is sorted increasingly while the second
  * number in each pair is sorted decreasingly. The first and second numbers
  * in each pair can be swapped. Sometimes there will be no solution, in that
  * case return an error.
  * 
  * Examples:
  * 
  * Input: 1 5 7 1 3 8 5 6
  * 
  * Output: 1 7  < - Swapped 1 5 6 5  < - Swapped 8 3  < - Swapped
  * 
  * Input: 1 5 6 9
  * 
  * Output: Not Possible
  * 
  * @param args
  */
 public static void main(String[] args)
 {
  Integer[][] input =
  {
  { 1, 5 },
  { 7, 1 },
  { 3, 8 },
  { 5, 6 } };
  List < List < Integer >  >  list = new ArrayList < List < Integer >  > ();
  for (Integer[] tuple : input)
  {
   List < Integer >  tupleList = new ArrayList < Integer > ();
   for (Integer el : tuple)
   {
    tupleList.add(el);
   }
   list.add(tupleList);
  }

  System.out.println(getArrangeMent(list));

 }

 public static List < List < List < Integer >  >  >  getArrangeMent(
   List < List < Integer >  >  list)
 {
  List < List < List < Integer >  >  >  result = new ArrayList < List < List < Integer >  >  > ();
  for (int i = 0; i  <  list.size(); ++i)
  {
   List < Integer >  tuple = list.get(i);
   List < List < Integer >  >  subList = new ArrayList < List < Integer >  > (list);
   subList.remove(i);
   List < List < List < Integer >  >  >  r1 = getRecurseArrangeMent(tuple, subList);
   if (r1 != null)
    result.addAll(prepend(tuple, r1));
   List < Integer >  rTuple = new ArrayList < Integer > (tuple);
   Collections.reverse(rTuple);
   List < List < List < Integer >  >  >  r2 = getRecurseArrangeMent(rTuple,
     subList);
   if (r2 != null)
    result.addAll(prepend(rTuple, r2));
  }
  return result;
 }

 public static List < List < List < Integer >  >  >  getRecurseArrangeMent(
   List < Integer >  start, List < List < Integer >  >  list)
 {
  List < List < List < Integer >  >  >  result = new ArrayList < List < List < Integer >  >  > ();
  if (list.size() == 0)
   return result;

  for (int i = 0; i  <  list.size(); ++i)
  {
   List < Integer >  tuple = list.get(i);
   if (tuple.get(0)  >= start.get(0) && start.get(1)  >= tuple.get(1))
   {
    List < List < Integer >  >  subList = new ArrayList < List < Integer >  > (list);
    subList.remove(i);
    List < List < List < Integer >  >  >  r1 = getRecurseArrangeMent(tuple,
      subList);
    if (r1 != null)
     result.addAll(prepend(tuple, r1));
   }
   List < Integer >  rTuple = new ArrayList < Integer > (tuple);
   Collections.reverse(rTuple);
   if (rTuple.get(0)  >= start.get(0) && start.get(1)  >= rTuple.get(1))
   {
    List < List < Integer >  >  subList = new ArrayList < List < Integer >  > (list);
    subList.remove(i);
    List < List < List < Integer >  >  >  r1 = getRecurseArrangeMent(rTuple,
      subList);
    if (r1 != null)
     result.addAll(prepend(rTuple, r1));
   }
  }
  if (result.size() != 0)
   return result;
  return null;
 }

 public static List < List < List < Integer >  >  >  prepend(List < Integer >  start,
   List < List < List < Integer >  >  >  list)
 {
  List < List < List < Integer >  >  >  results = new ArrayList < List < List < Integer >  >  > ();
  if (list.size() == 0)
  {
   List < List < Integer >  >  result = new ArrayList < List < Integer >  > ();
   result.add(start);
   results.add(result);
  } else
  {
   for (List < List < Integer >  >  result : list)
   {
    result.add(0, start);
    results.add(result);
   }
  }
  return results;
 }
}

