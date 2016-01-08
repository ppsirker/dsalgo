/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/FindOrderOfLetter.php.html
*/

package com.dsalgo;

import java.util.HashMap;

public class FindOrderOfLetter
{
 public static void main(String[] args)
 {
  String[] words =
  { "car", "cat", "cbr", "deer", "egg", "god", "rabe", "race", "rat",
    "tar" };
  char[] letters = getLetterOrdering(words);
  if (letters == null)
   System.out.println("not possible");
  else
  {
   for (char ch : letters)
    System.out.print(ch + ",");
  }
 }

 private static char[] getLetterOrdering(String[] words)
 {
  HashMap<Character, Integer> characters = new HashMap<Character, Integer>();
  for (String word : words)
  {
   for (int i = 0; i < word.length(); ++i)
   {
    char character = word.charAt(i);
    if (!characters.keySet().contains(character))
    {
     characters.put(character, characters.size());
    }
   }
  }
  boolean[][] adjacency = new boolean[characters.size()][characters
    .size()];
  for (int i = 0; i < words.length - 1; ++i)
  {
   for (int j = i + 1; j < words.length; ++j)
   {
    String prevWord = words[i];
    String nextWord = words[j];
    for (int k = 0; k < Math.min(prevWord.length(),
      nextWord.length()); ++k)
    {
     char prevCharacter = prevWord.charAt(k);
     char nextCharacter = nextWord.charAt(k);
     if (prevCharacter != nextCharacter)
     {
      adjacency[characters.get(prevCharacter)][characters
        .get(nextCharacter)] = true;
      break;
     }
    }
   }
  }

  char[] result = new char[characters.size()];
  int resultIndex = 0;
  while (!characters.isEmpty())
  {
   char lowChar = ' ';
   for (Character nextCharacter : characters.keySet())
   {
    int nextIndex = characters.get(nextCharacter);
    boolean lowest = true;
    for (Character prevCharacter : characters.keySet())
    {
     int prevIndex = characters.get(prevCharacter);
     if (adjacency[prevIndex][nextIndex])
     {
      lowest = false;
      break;
     }
    }
    if (lowest)
    {
     lowChar = nextCharacter;
     result[resultIndex++] = nextCharacter;
     break;
    }
   }
   if (lowChar == ' ')
   {
    return null;
   } else
   {
    characters.remove(lowChar);
    lowChar = ' ';
   }
  }
  return result;
 }

}
        
