/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/reverse-words-of-sentence.html
*/

package com.dsalgo;


public class ReverseWordsInSentence
{
 public static void main(String[] args)
 {
  String str = "reverse words of a sentence";
  String result = reverseWords(str);
  System.out.println(result);
 }

 private static String reverseWords(String str)
 {
  char[] chars = str.toCharArray();
  reverse(chars, 0, chars.length - 1);
  int wordStart = 0;
  int wordEnd = 0;
  while (wordEnd < chars.length)
  {
   if (chars[wordEnd] == ' ')
   {
    reverse(chars, wordStart, wordEnd - 1);
    wordStart = wordEnd + 1;
   }
   wordEnd++;
  }
  reverse(chars, wordStart, wordEnd - 1);
  return new String(chars);
 }

 private static void reverse(char[] chars, int i, int j)
 {
  while (i < j)
  {
   char temp = chars[i];
   chars[i] = chars[j];
   chars[j] = temp;
   i++;
   j--;
  }
 }
}
   
