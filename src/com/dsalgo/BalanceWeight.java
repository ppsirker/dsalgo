/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/BalanceTheBalance.php.html
*/

package com.dsalgo;

public class BalanceWeight
{
 final static int weightOfBalanceBeam = 10;

 public static void main(String[] args)
 {
  Balance a = new Balance(1, 4, 6);
  Balance b = new Balance(2, 3, 8);
  Balance c = new Balance(3, 5, 9);
  Balance d = new Balance(4, 3, 2);

  a.left = b;
  a.right = c;
  b.left = d;

  doBalance(a);
 }

 public static double doBalance(Balance balance)
 {
  if (balance == null)
   return 0;
  if (balance.left == null && balance.right == null)
  {
   return printBalance(balance.id, balance.leftWeight, balance.rightWeight);
  }
  else
  {
   return printBalance(balance.id, balance.leftWeight
     + doBalance(balance.left), balance.rightWeight
     + doBalance(balance.right));
  }
 }

 public static double printBalance(int id, double leftWeight,
   double rightWeight)
 {
  if (leftWeight > rightWeight)
  {
   System.out.println("Add " + (leftWeight - rightWeight) + " to the right of Balance#" + id);
   return leftWeight * 2 + weightOfBalanceBeam;
  }
  else if (leftWeight < rightWeight)
  {
   System.out.println("Add " + (rightWeight - leftWeight) + " to the left of Balance#" + id);
   return rightWeight * 2 + 10;
  }
  else
  {
   return rightWeight * 2 + 10;
  }
 }

}
class Balance
{
 public int id;
 public Balance left;
 public Balance right;
 public double leftWeight;
 public double rightWeight;

 public Balance(int id, double leftWeight, double rightWeight)
 {
  this.id = id;
  this.leftWeight = leftWeight;
  this.rightWeight = rightWeight;
 }
}
