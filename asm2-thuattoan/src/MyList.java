public class MyList<T> {
    private Node<T> head;
    private Node<T> tail;
    private T data;


    public MyList(){
        this.head = head;
        this.tail = tail;
    }
    public MyList(Node<T> head, Node<T> tail) {
        this.head = head;
        this.tail = tail;
    }
    public Node<T> getHead(){
        return head;
    }

    public boolean isEmpty(){
        return this.head == null;
    }
    public  int length(){
        int length = 0;
        Node<T> current = this.head;
        while (current!=null){
            length++;
            current = current.getNextNode();
        }
        return length;
    }
    public void insertToHead(T data){
        Node<T> newNode = new Node(data);
        if(isEmpty()){
            this.head =this.tail = newNode;
        } else {
        newNode.setNextNode(this.head);
        this.head = newNode;
        }
    }
    public void insertAfterPosition(int position, T data){
        int count = 0 ;
        Node<T> current = this.head;
        while (current!=null){
            count++;
            if (count == position){
                Node<T> newNode =new Node(data);
                newNode.setNextNode(current.getNextNode());
                current = newNode;
                break;
            }
            current = current.getNextNode();
        }
    }
    public void insertToTail(T data){
        Node<T> newNode = new Node(data);
        if(isEmpty()){
            this.head = this.tail = newNode;
        } else {
            this.tail.setNextNode(newNode);
            this.tail =newNode;
            newNode.setNextNode(null);
            }
        }


    public void deleteTail(){
        Node<T> current = this.head;
        while (current.getNextNode().getNextNode() != null){
            current = current.getNextNode();
        }
        current.setNextNode(null);
        this.tail = current;
    }
    public void deleteElement(T data){
        Node<T> current = this.head;
        if(this.head.getData() == data){
            this.head = this.head.getNextNode();
        } else {
            while (current != null){
                if(current.getNextNode().getData() == data){
                    if(this.tail.getData()== data){
                        this.tail = current;
                    }
                    current.setNextNode(current.getNextNode().getNextNode());
            }
            current = current.getNextNode();
            }
        }
    }
    public void swap(Node<T> firstNode, Node<T> secondNode){
        T temp =  firstNode.getData();
        firstNode.setData(secondNode.getData());
        secondNode.setData(temp);
    }
    public void clear(){
        this.head.setNextNode(null);
        this.head = null;
    }
    public String toString(){
        String result ="ID |  Title   | Quantity | price\n" +
                "--------------------------------\n";
        Node<T> current = this.head;
        while (current!=null){
            result += current.toString() +"\n";
            current = current.getNextNode();
        }
        return result;
    }


}
