package Node;

 class Node1<T> {
	private T data;
	private Node1<T> next;
	private Node1<T> previous;
	public Node1<T> getPrevious() {
		return previous;
	}
	public void setPrevious(Node1<T> previous) {
		this.previous = previous;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node1<T> getNext() {
		return next;
	}
	public void setNext(Node1<T> next,Node1<T> previous) {
		this.next = next;
		this.previous=previous;
	}
	Node1(T data,Node1<T> next){
		this.data=data;
		this.next=next;
		
	}
	public String toString(){
		return this.data.toString()+this.next==null?"":","+this.next.toString();
	}

}
 public class Node{
	 public static void main(String[] argv) throws Exception {
		 Node1<String> node1=new Node1<String>("abc", null);
		 Node1<String> node3=new Node1<String>("abcde", null);
		 Node1<String> node2=new Node1<String>("def", node1);
		 System.out.println(node2.getData());
		 System.out.println(node2.getNext().getData());
		 System.out.println(node2.toString());
		 ;
	 }
	 
 }
