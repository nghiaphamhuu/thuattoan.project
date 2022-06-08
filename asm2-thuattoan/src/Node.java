public class Node<T> {
    private Node<T> nextNode;
    private T data;

    public Node(T data) {
        this.data = data;
        this.nextNode =null;
    }
    public Node(){

    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public String toString(){
        return data.toString();
    }
}
