public class linkedList <T>{

    private linkedList<T> next;
    private T value;

    public linkedList(){
        next = null;
    }

    public void add(T newNumber){

        if (next == null){
            linkedList<T> newNode = new linkedList<>();
            newNode.value = newNumber;
            next = newNode;
        }else {
            linkedList<T> currNode = next;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            linkedList<T> newNode = new linkedList<>();
            newNode.value = newNumber;
            currNode.next = newNode;
        }
    }

    public boolean isExist(T srcNumber){
        linkedList<T> currNode = next;
        while(true){
            if (currNode.value == srcNumber){
                return true;
            }else{
                currNode = currNode.next;
                if (currNode == null){
                    return false;
                }
            }
        }
    }

    public int findIndex(T srcNumber){
        linkedList<T> currNode = next;
        int index = 0;
        while(true){
            if (currNode.value == srcNumber){
                return index;
            }else{
                currNode = currNode.next;
                index++;
                if (currNode == null){
                    return -1;
                }
            }
        }
    }

    public void delete(T delNumber){
        linkedList<T> currNode = next;
        if (currNode == null){
            System.out.println("This list is empty");
        }else {
            int index = findIndex(delNumber);
            if (index == -1) {
                System.out.println("This number is not in the list");
            } else if (index == 0) {
                next = currNode.next;
                if (next == null) {
                    System.out.println("This list is empty now");
                }
            } else {
                linkedList<T> prevNode = currNode;
                for (int i = 0; i < index; i++) {
                    prevNode = currNode;
                    currNode = currNode.next;
                }
                prevNode.next = currNode.next;
            }
        }
    }

    public void traverse(){
        if (next == null){
            System.out.println("This List is Empty");
        }else{
            linkedList<T> currNode = next;
            while(true){
                if (currNode.next == null){
                    System.out.println(currNode.value+"->Null");
                    break;
                }else{
                    System.out.print(currNode.value+"->");
                    currNode = currNode.next;
                }
            }
        }
    }


    public static void main(String[] args){
        linkedList<Object> list = new linkedList<>();
        list.add(3);
        list.add("hello");
        list.traverse();
        if (list.isExist(3)){
            int index = list.findIndex(3);
            System.out.println(index);
        }
        list.delete("hello");
        list.traverse();
    }
}
