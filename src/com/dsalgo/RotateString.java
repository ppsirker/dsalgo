/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/rotate-string-to-make-another.html
*/

package com.dsalgo;


public class RotateString
{
 public static void main(String[] args)
 {
  String string1 = "rotation";
  String string2 = "tionrota";
  System.out.println(isRotationPossible(string1, string2));
 }

 private static boolean isRotationPossible(String string1, String string2)
 {
  String str = string1 + string1;
  return str.contains(string2) && string1.length() == string2.length();
 }

}


