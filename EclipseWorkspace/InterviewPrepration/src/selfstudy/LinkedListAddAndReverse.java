package selfstudy;



public class LinkedListAddAndReverse {
    
    public static void main(String[] args) {
     LinkedListImpl list = new LinkedListImpl();
     list.add(1);
     list.add(2);
     list.add(3);
     list.print();
     Node head = list.reverse();
     list.print();
  }
 
}

class Node{
  
  int value;
  Node next;
  
  Node(int value){
    this.value = value;
    this.next = null;
  }
}

class LinkedListImpl{
  private Node head = null;
  
   void add(int value){
    
    Node node = new Node(value);
    
    if(head == null){
      head = node;
    }else{
      Node current = head;
      while(current.next!=null){
        current = current.next;
      }
      current.next = node;
    }
  }

  
  Node reverse(){
    
    Node prev = null;
    Node current = head;
    Node temp;
    
    while(current!=null){
      temp=current.next;
      current.next=prev;
      prev = current;
     current = temp;
    }
    head = prev;
    return head;
    
    
  }
  
  void print(){
    Node current = head;
    while(current!=null){
      System.out.print(current.value+(current.next!=null?" -> ":""));
      current= current.next;
    }
    System.out.println(" -> "+null);
    
  }
}