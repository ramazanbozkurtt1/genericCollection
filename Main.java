public class Main {
    public static void main(String[] args){
        GenericCollection<String> myCollection = new GenericCollection<>();
        myCollection.add("Hello World");
        System.out.println(myCollection.getSize());
        System.out.println(myCollection.getCapacity());
//        addListData();
//        removeMethod();
//        indexOfMethod();
//        lastIndexOfMethod();
//        isEmptyMethod();
//        contains();
    }
    public static void addListData() {
        GenericCollection<String> myCollection = new GenericCollection<>();
        System.out.println("Array length : "+myCollection.getSize());
        myCollection.add("Hello World");
        System.out.println("Capacity : "+myCollection.getCapacity());
        myCollection.add("Hello World");
        myCollection.add("Hello World 123");
        myCollection.add("Hello World");
        myCollection.add("Hello World");
        myCollection.add("Hello World");
        myCollection.add("Hello World");
        myCollection.add("Hello World");
        myCollection.add("Hello World");
        myCollection.add("Hello World");
        myCollection.add("Hello World");

        System.out.println("Capacity : "+ myCollection.getCapacity());
        System.out.println("Array length : "+ myCollection.getSize());
        System.out.println("Third item in list : "+myCollection.get(2)); //Hello World 123
        System.out.println("Not in list : " + myCollection.get(12));
    }
    public static void removeMethod() {
        GenericCollection<Integer> list = new GenericCollection<>(20);
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("Third item in list : " + list.get(2));
        list.remove(2);
        list.remove(4);
        list.add(40);
        list.set(0, 100);
        System.out.println("First item in list : " + list.get(0));
        System.out.println("Third item in list : " + list.get(2));
    }

    public static void indexOfMethod() {
        GenericCollection<Integer> list = new GenericCollection<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println(list.indexOf(40));
        System.out.println(list.indexOf(50));
    }

    public static void lastIndexOfMethod(){
        GenericCollection<Integer> list = new GenericCollection<>(50);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(20);
        list.add(20);
        list.add(30);
        list.add(20);
        GenericCollection<Integer> sublist = list.sublist(2, 4);
        System.out.println(sublist.toString());
        System.out.println(list.lastIndexOf(20));
        System.out.println(list.lastIndexOf(50));
        GenericCollection<Integer> sublist2 = list.sublist(2, 9);
        GenericCollection<Integer> sublist3 = list.sublist(-1, 4);
        sublist.clear();
        System.out.println(sublist.getSize());
        System.out.println(sublist.getCapacity());
    }

    public static void isEmptyMethod() {
        GenericCollection<Integer> list = new GenericCollection<>();
        System.out.println("Is Empty ? : " + list.isEmpty());
        GenericCollection<Integer> list1 = new GenericCollection<>(100);
        list1.add(10);
        System.out.println("Is Empty ? : " + list1.isEmpty());
    }

    public static void contains() {
        GenericCollection<Integer> list = new GenericCollection<>(10);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(20);
        list.add(20);
        list.add(30);
        list.add(20);
        System.out.println("Contains ? : " + list.contains(40));
        System.out.println("Contains ? : " + list.contains(50));
    }
}
