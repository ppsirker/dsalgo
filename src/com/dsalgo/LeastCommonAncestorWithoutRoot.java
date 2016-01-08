/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/LeastCommonAncestorWithoutRoot.php.html
*/

package com.dsalgo;


import java.util.HashSet;


public class LeastCommonAncestorWithoutRoot
{
 public static void main(String[] args)
 {
  NodeWithParent a=new NodeWithParent(5);
  NodeWithParent b=new NodeWithParent(6);
  NodeWithParent c=new NodeWithParent(7);
  NodeWithParent d=new NodeWithParent(8);
  NodeWithParent e=new NodeWithParent(9);
  a.left=b;
  b.parent=a;
  b.left=c;
  c.parent=b;
  b.right=d;
  d.parent=b;
  d.right=e;
  e.parent=d;
  System.out.println("LCA: "+getLCA(c, e).value);
  
 }
 
 public static NodeWithParent getLCA(NodeWithParent a, NodeWithParent b)
 {
  HashSet<NodeWithParent> table=new HashSet<NodeWithParent>();
  while(a!=null)
  {
   table.add(a);
   a=a.parent;
  }
  while(b!=null)
  {
   if(table.contains(b))
    return b;
   b=b.parent;
  }
  return null;
 }

}

class NodeWithParent
{
 public NodeWithParent parent;
 public int value;
 public NodeWithParent left;
 public NodeWithParent right;
 
 public NodeWithParent(int value)
 {
  this.value=value;
 }
}        
