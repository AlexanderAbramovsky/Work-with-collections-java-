public class Collections {

        public static void main(String[] args) {

        Collections.timeWorkArrayList(1000000);

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