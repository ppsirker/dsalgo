
/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/AllUniqueSubstring.php.html
*/

package com.dsalgo;

import java.util.HashSet;

public class AllUniqueSubstring
{
 public static void main(String[] args)
 {
  String input = "abacbdadbc";
  printAllUniqueSubstring(input);
 }

 public static void printAllUniqueSubstring(String input)
 {
  HashSet<Character> set = new HashSet<Character>();
  int startIndex = 0;
  int endIndex = 0;
  int maxLength = 0;
  int startMax = 0;
  int endMax = 0;

  while (endIndex < input.length())
  {
   char addChar = input.charAt(endIndex);
   if (!set.contains(addChar))
   {
    set.add(addChar);
    int currentLength = endIndex - startIndex + 1;
    if (currentLength > maxLength)
    {
     maxLength = currentLength;
     startMax = startIndex;
     endMax = endIndex;
    }
    endIndex++;
   } else
   {
    char removeChar = input.charAt(startIndex);
    set.remove(removeChar);
    startIndex++;
    if (removeChar == addChar)
    {
     int currentLength = endIndex - startIndex + 1;
     if (currentLength > maxLength)
     {
      maxLength = currentLength;
      startMax = startIndex;
      endMax = endIndex;
     }
     endIndex++;
    }
   }
  }
  System.out.println(startMax + "," + endMax);
  System.out.println(input.substring(startMax, endMax));
 }

}
  
