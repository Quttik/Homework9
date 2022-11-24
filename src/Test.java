import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        MyArrayList<Integer> mal = new MyArrayList<>();
        System.out.println("==================MyArrayList Test==================");
        mal.setArray(new Object[]{3, 4, 6574, 445, 786, 2});
        //MyArrayList add() test
        mal.add(7);
        System.out.println(Arrays.toString(mal.getArray()));
        //MyArrayList remove() test
        mal.remove(2);
        System.out.println(Arrays.toString(mal.getArray()));
        mal.remove(0);
        System.out.println(Arrays.toString(mal.getArray()));
        mal.remove(mal.array.length -1);
        System.out.println(Arrays.toString(mal.getArray()));
        // MyArrayList clear() test
        mal.clear();
        System.out.println(Arrays.toString(mal.getArray()));
        //MyArrayList size() test
        System.out.println(mal.size());
        //MyArrayList get() test
        System.out.println(mal.get(2));

        //-----------------------------------------------------------------------------------------

        MyLinkedList<Integer> mll = new MyLinkedList<>();

        System.out.println("-------------------MyLinkedList add() test--------------------");
        mll.add(1);
        mll.add(8);
        mll.add(0);
        mll.add(9);
        mll.add(234);
        mll.add(20);
        mll.add(10);
        mll.print();
        System.out.println("--------------------MyLinkedList remove() test-------------------");
        mll.remove(2);
        mll.print();
        System.out.println("--------------------MyLinkedList size() test-------------------");
        System.out.println(mll.size());
        System.out.println("--------------------MyLinkedList get() test-------------------");
        System.out.println(mll.get(1));
        System.out.println("--------------------MyLinkedList clear() test-------------------");
        mll.clear();
        mll.print();

        //-------------------------------------------------------------------------------------------

        MyQueue<Integer> mq = new MyQueue<>();
        System.out.println("------------------------MyQueue add() test-------------------------");
        mq.add(8);
        mq.add(2);
        mq.add(7);
        mq.add(56);
        mq.print();
        System.out.println("------------------------MyQueue peek() test-------------------------");
        System.out.println(mq.peek());
        System.out.println("------------------------MyQueue poll() test-------------------------");
        System.out.println(mq.poll());
        System.out.println("    ");
        mq.print();
        System.out.println("------------------------MyQueue size() test-------------------------");
        System.out.println(mq.size());
        System.out.println("------------------------MyQueue clear() test-------------------------");
        mq.clear();
        mq.print();
        System.out.println("\n");

        //--------------------------------------------------------------------------------------------

        MyStack<Integer> ms = new MyStack<>();

        System.out.println("-----------------MyStack push() test---------------");
        ms.push(8);
        ms.push(0);
        ms.push(9);
        ms.push(92);
        ms.print();
        System.out.println("-----------------MyStack remove() test---------------");
        ms.remove(2);
        ms.print();
        System.out.println("-----------------MyStack size() test---------------");
        System.out.println(ms.size());
        System.out.println("-----------------MyStack peek() test---------------");
        System.out.println(ms.peek());
        System.out.println("-----------------MyStack pop() test---------------");
        System.out.println(ms.pop());
        System.out.println("\n");
        ms.print();
        System.out.println("-----------------MyStack clear() test---------------");
        ms.clear();
        ms.print();

        //----------------------------------------------------------------------------------------

        MyHashMap <Integer, Integer> mhp = new MyHashMap<>();
        mhp.put(2, 3445);
        mhp.put(8, 665);
        mhp.put(142, 5);
        mhp.put(1, 2);
        mhp.put(22, 876);
        mhp.remove(2);
        mhp.remove(142);
        System.out.println(mhp.size());
        System.out.println(mhp.get(22));
        mhp.clear();
    }



}