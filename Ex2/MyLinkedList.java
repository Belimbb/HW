package ForGit.Ex2;

public class MyLinkedList<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;

    public void add(T value){
        if (firstNode == null){
            firstNode = new Node<>(null, null, value);
        } else if (lastNode == null){
            lastNode = new Node<>(firstNode, null, value);
            firstNode.setNextNode(lastNode);
        } else{
            Node<T> newLastNode = new Node<>(lastNode, null, value);
            lastNode.setNextNode(newLastNode);
            lastNode = newLastNode;
        }
    }
    public void remove(int index){
        Node<T> currentNode = findNode(index);
        Node<T> prevNode = currentNode.getPrevNode();
        Node<T> nextNode = currentNode.getNextNode();
        prevNode.setNextNode(nextNode);
        nextNode.setPrevNode(prevNode);

    }
    public void clear(){
        firstNode = null;
        lastNode = null;
    }
    public int size() {
        int count = 0;
        Node<T> currentNode = firstNode;
        while (currentNode.getNextNode() != null) {
            count++;
            currentNode = currentNode.getNextNode();
        }
        return count + 1;
    }
    public T get(int index){
        try {
            Node<T> currentNode = findNode(index);
            return currentNode.getValue();
        }catch (NullPointerException e){
            return null;
        }
    }
    public Node<T> findNode(int index){
        Node<T> currentNode = firstNode;
        for (int i = 0; i<index; i++){
            currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }
}
