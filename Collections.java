public class Collections {

    public static void main(String[] args) {

        System.out.println();

        Collections.timeWorkArrayList(1000000);

        System.out.println();

        Collections.timeWorLinkedList(1000000);

        System.out.println();

        Collections.timeWorTreeSet(1000000);

    }

    public static void timeWorkArrayList(int countElements){

        long start, finish, timeAdd = 0, timeRemove = 0;

        ArrayList<TestClass> arrayList = new ArrayList<>();

        //add arrayList
        for (int i = 0; i < countElements; i++) {
            TestClass testClass = new TestClass(i, i, ""+i);
            start = System.nanoTime();
            arrayList.add(testClass);
            finish = System.nanoTime();
            timeAdd += finish - start;
        }

        //remove arrayList
        for (int i = 0; i < countElements; i++) {
            start = System.nanoTime();
            arrayList.remove(0);
            finish = System.nanoTime();
            timeRemove += finish - start;
        }

        System.out.println("ArrayList:");
        System.out.println("time add - " + String.format("%,5d",timeAdd) + " ns");
        System.out.println("time remove - " + String.format("%,5d",timeRemove) + " ns");
        System.out.println("time work ArrayList - " +  String.format("%,5d",timeAdd + timeRemove) + " ns");
    }

    public static void timeWorLinkedList(int countElements){

        long start, finish, timeAdd = 0, timeRemove = 0;

        LinkedList<TestClass> linkedList = new LinkedList<>();

        //add linkedList
        for (int i = 0; i < countElements; i++) {
            TestClass testClass = new TestClass(i, i, ""+i);
            start = System.nanoTime();
            linkedList.add(testClass);
            finish = System.nanoTime();
            timeAdd += finish - start;
        }

        //remove linkedList
        for (int i = 0; i < countElements; i++) {
            start = System.nanoTime();
            linkedList.remove(0);
            finish = System.nanoTime();
            timeRemove += finish - start;
        }

        System.out.println("LinkedList:");
        System.out.println("time add - " + String.format("%,5d",timeAdd) + " ns");
        System.out.println("time remove - " + String.format("%,5d",timeRemove) + " ns");
        System.out.println("time work LinkedList - " +  String.format("%,5d",timeAdd + timeRemove) + " ns");
    }

    public static void timeWorTreeSet(int countElements){

        long start, finish, timeAdd = 0, timeRemove = 0;

        TreeSet<TestClass> treeSet = new TreeSet<TestClass>();

        //add treeSet
        for (int i = 0; i < countElements; i++) {
            TestClass testClass = new TestClass(i, i, ""+i);
            start = System.nanoTime();
            treeSet.add(testClass);
            finish = System.nanoTime();
            timeAdd += finish - start;
        }

        //remove treeSet
        for (int i = 0; i < countElements; i++) {
            start = System.nanoTime();
            TestClass testClass = new TestClass(i, i, ""+i);
            treeSet.remove(testClass);
            finish = System.nanoTime();
            timeRemove += finish - start;
        }

        System.out.println("TreeSet:");
        System.out.println("time add - " + String.format("%,5d",timeAdd) + " ns");
        System.out.println("time remove - " + String.format("%,5d",timeRemove) + " ns");
        System.out.println("time work TreeSet - " +  String.format("%,5d",timeAdd + timeRemove) + " ns");
    }

}

class TestClass implements Comparable<TestClass>{
    int i;
    double d;
    String s;

    TestClass(int i, double d, String s){
        this.i = i;
        this.d = d;
        this.s = s;
    }


    @Override
    public int compareTo(TestClass o) {
        int result = s.compareTo(o.s);
        return result;
    }
}