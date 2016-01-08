/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/03/find-if-two-words-are-anagram-or-not.html
*/

package com.dsalgo;

import java.util.HashMap;
import java.util.Map;

public class OneWordPermutationOfOther
{
 public static void main(String[] args)
 {
  String a = "listen";
  String b = "enlist";
  System.out.println(isPermutation(a, b));
 }

 private static boolean isPermutation(String a, String b)
 {
  Map < Character, Integer> charMap = new HashMap < Character, Integer>();
  for (char ch : a.toCharArray())
  {
   if (charMap.containsKey(ch))
    charMap.put(ch, charMap.get(ch) + 1);
   else
    charMap.put(ch, 1);
  }
  for (char ch : b.toCharArray())
  {
   if (!charMap.containsKey(ch))
    return false;
   if (charMap.get(ch) == 1)
    charMap.remove(ch);
   else
    charMap.put(ch, charMap.get(ch) - 1);
  }
  if (charMap.keySet().size() == 0)
   return true;
  return false;
 }

}

