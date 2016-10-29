package ce1103.ChefREST.dataStructure;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Node <T> {

   private T data;
   private int id;
   public Node<T> nextNode;
   
   public Node() {
	      this.nextNode = null;
	   }
   public Node(T data) {
      this.data = data;
      this.nextNode = null;
   }
   public Node(T data, int IDN) {
	      this.data = data;
	      this.id = IDN;
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
   public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
