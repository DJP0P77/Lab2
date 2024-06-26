class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
   
   
   /*
   recursive insert method
   */
   public void insert(int value){
      //tree is empty
      if(root == null){
         root = new Node(value);
         return;
      }else{
         Node current = root;
         Node parent = null;

         while(true){
            parent = current;

            if(value < current.value){
               current = current.left;
               if(current == null){
                  parent.left = new Node(value);
                  return;
               }
            }else{
               current = current.right;
               if(current == null){
                  parent.right = new Node(value);
                  return;
               }
            }

         }//closing while

      }//closing main if-else
   }


   /**
    *
    * @param root PreOrder traversal method for the BST
    */
   /*
   pre-order traversal
   */
   public void preOrderTraversal(Node root){
      if (root == null)
         return;

      // traverse the root node
      System.out.print(root.value + "->");
      // traverse the left child
      preOrderTraversal(root.left);
      // traverse the right child
      preOrderTraversal(root.right);
   }



   /**
    *
    * @param root InOrder traversal method for the BST
    */
   /*
   in-order traversal
   */
   public void inOrderTraversal(Node root){
      if (root == null)
         return;

      // traverse the left child
      inOrderTraversal(root.left);
      // traverse the root node
      System.out.print(root.value + "->");
      // traverse the right child
      inOrderTraversal(root.right);
   }



   /**
    *
    * @param root PostOrder traversal method for the BST
    */
   /*
   post-order traversal
   */
   public void postOrderTraversal(Node root){
      if (root == null)
         return;

      // First recur on left subtree
      postOrderTraversal(root.left);
      // Then recur on right subtree
      postOrderTraversal(root.right);
      // Now deal with the node
      System.out.print(root.value + " ");
   }



   /**
    *
    * @param root root parameter to get the value of the current root
    * @param key key parameter to look for a specific value
    * @return false
    */
   /*
   a method to find the node in the tree
   with a specific value
   */
   public boolean find(Node root, int key){
      if (root==null || root.value==key)
         return false;
      // val is greater than root's key
      if (root.value > key)
         return find(root.left, key);
      // val is less than root's key
      return find(root.right, key);
   }
   
   
   
   /**
    *
    * @param root root param retrieves the value of the root
    * @return min value
    */
   /*
   a method to find the node in the tree
   with a smallest key
   */
   public int getMin(Node root){
      if (root.left == null)
         return root.value;
      return getMin(root.left);
   }



   /**
    *
    * @param root root param retrieves the value of the root
    * @return max value
    */
   /*
   a method to find the node in the tree
   with a largest key
   */
   public int getMax(Node root){
      if (root.right == null)
         return root.value;

      return getMax(root.right);
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}