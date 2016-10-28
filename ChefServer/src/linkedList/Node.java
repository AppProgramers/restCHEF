package linkedList;

public class Node <T> {

   private T data;
   public Node<T> nextNode;
   
   public Node(T data) {
      this.data = data;
      this.nextNode = null;
   }
   
   public T getData() {
      return data;
   }

   public void setData(T data) {
      this.data = data;
   }
   
   public void setNextNode(Node<T> node) {
      this.nextNode = node;
   }
   
   public Node<T> getNextNode() {
      return nextNode;
   }

}
