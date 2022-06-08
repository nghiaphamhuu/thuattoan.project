public class MyQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private T data;

    public MyQueue(){
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public boolean isEmpty(){
        return this.head == null;
    }
    public void enQueue(T data){
        Node<T> newNode =  new Node<>(data);
        if (isEmpty()){
            this.head = this.tail = newNode;
        } else {
            newNode.setNextNode(this.head);
            this.head = newNode;
        }
    }
    public void deQueue(){
        if(isEmpty()){
            return;
        } else if( this.head == this.tail){
            this.head = null;
        } else {
            Node<T> current = this.head;
            while (current!=null){
                if(current.getNextNode()==tail){
                    this.tail =current;
                    current.setNextNode(null);
                }
            current =current.getNextNode();
            }
        }
    }

}
