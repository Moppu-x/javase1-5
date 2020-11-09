package org.zuel.app.myutils;

public static class ListUtil {
    public static void outputList(List<T> list) {
        Iterator<T> iter = new list.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next().toString());
        }
    }
}
