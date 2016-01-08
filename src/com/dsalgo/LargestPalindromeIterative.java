/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/find-largest-palindrome-iterative.html
*/

package com.dsalgo;


public class LargestPalindromeIterative
{
 public static void main(String[] args)
 {
  String str = "abccbabacbcacba";
  String result = findLargestPalindrome(str);
  System.out.println(result);
 }

 private static String findLargestPalindrome(String str)
 {
  if (str == null || str.length() == 0)
   return "";
  int centers = 2 * str.length() - 1;
  int radii = str.length() - 1;
  int maxCenter = 0;
  int maxRadius = 0;
  for (int center = 0; center < centers; ++center)
  {
   for (int radius = 0; radius <= radii; ++radius)
   {
    if (center - radius < 0 || center + radius >= centers)
    {
     break;
    } else if ((center + radius) % 2 == 1)
    {
     continue;
    } else if (str.charAt((center - radius) / 2) != str
      .charAt((center + radius) / 2))
    {
     break;
    } else
    {
     if (radius > maxRadius)
     {
      maxRadius = radius;
      maxCenter = center;
     }
    }

   }
  }

  return str.substring((maxCenter - maxRadius) / 2,
    (maxCenter + maxRadius) / 2 + 1);

 }
}

        
