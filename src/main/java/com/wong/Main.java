package com.wong;

public class Main {
    public static void main(String[] args) {
        //int 对应的包装类是 Integer

        java.util.ArrayList<Object> objects = new java.util.ArrayList<>();

        //所有的类,最终都继承java.lang.Object
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(new Person(10,"小李"));
        personArrayList.add(new Person(11,"小王"));
        personArrayList.add(new Person(12,"小杨"));
        personArrayList.add(new Person(13,"小钱"));
        System.out.println(personArrayList);
        personArrayList.clear();

        AssertionError error = new AssertionError(personArrayList.size() == 0);
        System.out.println(error);


        //提醒JVM进行垃圾回收
        System.gc();
        System.out.println(personArrayList);
//        arrayList.add(12);
//        arrayList.add(13);
//        arrayList.add(14);
//        arrayList.add(15);
//        arrayList.add(16);
//        System.out.println(arrayList);
//
//        arrayList.add(33);
//        System.out.println(arrayList);
//        System.out.println(arrayList.size());
    }
}
