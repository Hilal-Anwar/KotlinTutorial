package algorithems

import java.util.*

object li {
    @JvmStatic
    fun main(args: Array<String>) {
        val linkedList = LinkedList<Int>()
        /*linkedList.add(0);
        linkedList.add(5);
        linkedList.add(-5);
        linkedList.add(6326);
        linkedList.add(98);
        linkedList.add(69);
        linkedList.add(-69855);
        linkedList.add(-2);
        linkedList.add(-6);
        linkedList.add(-8);
        linkedList.add(5);
        System.out.println(linkedList);
        //Comparator<Integer> comparator= Comparator.reverseOrder();
        //linkedList.sort(comparator);
        Collections.sort(linkedList);
        System.out.println(linkedList);
        System.out.println(new Random().nextInt());*/draw_grid()
    }

    fun draw_grid() {
        val s = StringBuilder()
        for (i in 1..29) {
            for (j in 1..49) {
                if (i % 2 != 0 || j % 2 != 0) s.append("██") else s.append("  ")
            }
            s.append('\n')
        }
        println(s)
    }
}