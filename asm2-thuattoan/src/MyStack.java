public class MyStack<T> {
    private Node<T> top;
    private T data;
    public MyStack(){
    }
    public Node<T> getTop() {
        return top;
    }
    public void setTop(Node<T> top) {
        this.top = top;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public boolean isEmpty(){
        return this.top == null;
    }
    public void push(T data){
        Node newNode = new Node(data);
        newNode.setNextNode(this.top);
        this.top = newNode;
    }
    public void pop(){
       this.top = this.top.getNextNode();
    }
    public void peek(){
        this.top.getData();
    }
    public String toString(){
        String result ="ID |  Title   | Quantity | price\n" +
                "--------------------------------\n";
        Node<T> current = this.top;
        while (current!=null){
            result += current.toString() +"\n";
            current = current.getNextNode();
        }
        return result;
    }
}
