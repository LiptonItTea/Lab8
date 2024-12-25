package org.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTest {
    @Test
    public void linkedListAddTest01() {
        List<String> list = new LinkedList<>();
        list.addFirst("Todd");
        list.addFirst("Alice");
        list.addFirst("Connor");
        list.addFirst("Markus");
        list.addFirst("Kara");

        Assertions.assertEquals(5, list.size());
    }

    @Test
    public void linkedListAddTest02() {
        List<String> list = new LinkedList<>();
        list.addLast("Todd");
        list.addLast("Alice");
        list.addLast("Connor");
        list.addLast("Markus");
        list.addLast("Kara");

        Assertions.assertEquals(5, list.size());
    }

    @Test
    public void linkedListAddTest03() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.add(1, "Alice");
        list.add(2, "Connor");
        list.add(3, "Markus");
        list.add(4, "Kara");

        Assertions.assertEquals(5, list.size());
    }

    @Test
    public void linkedListAddTest04() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Alice");
        list.addLast("Connor");
        list.add(2, "Markus");
        list.addLast("Kara");

        Assertions.assertEquals(5, list.size());
    }

    @Test
    public void linkedListAddTest05() {
        Throwable exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            List<String> list = new LinkedList<>();
            list.add(0, "Todd");
            list.addFirst("Alice");
            list.addLast("Connor");
            list.add(5, "Markus");
            list.addLast("Kara");
        });

        Assertions.assertEquals("Index must be lower then the list size.", exception.getMessage());
    }

    @Test
    public void linkedListAddTest06() {
        Throwable exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            List<String> list = new LinkedList<>();
            list.add(-1, "Todd");
            list.addFirst("Alice");
            list.addLast("Connor");
            list.add(4, "Markus");
            list.addLast("Kara");
        });

        Assertions.assertEquals("Index must be greater than 0.", exception.getMessage());
    }

    @Test
    public void linkedListAddAllTest01() {
        List<String> one = new LinkedList<>();
        one.addLast("Todd");
        one.addLast("Alice");
        one.addLast("Connor");

        List<String> two = new LinkedList<>();
        two.addLast("Markus");
        two.addLast("Kara");

        two.addAll(0, one);
        Assertions.assertEquals(5, two.size());
    }

    @Test
    public void linkedListAddAllTest02() {
        List<String> one = new LinkedList<>();
        one.addLast("Todd");
        one.addLast("Alice");
        one.addLast("Connor");

        List<String> two = new LinkedList<>();
        two.addLast("Markus");
        two.addLast("Kara");

        two.addAll(1, one);
        Assertions.assertEquals(5, two.size());
    }

    @Test
    public void linkedListAddAllTest03() {
        List<String> one = new LinkedList<>();
        one.addLast("Todd");
        one.addLast("Alice");
        one.addLast("Connor");

        List<String> two = new LinkedList<>();
        two.addLast("Markus");
        two.addLast("Kara");

        two.addAll(2, one);
        Assertions.assertEquals(5, two.size());
    }

    @Test
    public void linkedListAddAllTest06() {
        List<String> one = new LinkedList<>();

        List<String> two = new LinkedList<>();
        two.addLast("Todd");
        two.addLast("Alice");
        two.addLast("Connor");

        two.addAll(2, one);
        Assertions.assertEquals(3, two.size());
    }

    @Test
    public void linkedListAddAllTest04() {
        Throwable exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            List<String> one = new LinkedList<>();
            one.addLast("Todd");
            one.addLast("Alice");
            one.addLast("Connor");

            List<String> two = new LinkedList<>();
            two.addLast("Markus");
            two.addLast("Kara");

            two.addAll(-1, one);
        });

        Assertions.assertEquals("Index must be greater than 0.", exception.getMessage());
    }

    @Test
    public void linkedListAddAllTest05() {
        Throwable exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            List<String> one = new LinkedList<>();
            one.addLast("Todd");
            one.addLast("Alice");
            one.addLast("Connor");

            List<String> two = new LinkedList<>();
            two.addLast("Markus");
            two.addLast("Kara");

            two.addAll(3, one);
        });

        Assertions.assertEquals("Index must be lower then the list size.", exception.getMessage());
    }

    @Test
    public void linkedListRemoveTest01() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Alice");
        list.addLast("Connor");
        list.add(2, "Markus");
        list.addLast("Kara");

        list.removeFirst();
        list.removeFirst();

        Assertions.assertEquals(3, list.size());
    }

    @Test
    public void linkedListRemoveTest02() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Alice");
        list.addLast("Connor");
        list.add(2, "Markus");
        list.addLast("Kara");

        list.removeLast();
        list.removeLast();

        Assertions.assertEquals(3, list.size());
    }

    @Test
    public void linkedListRemoveTest03() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Alice");
        list.addLast("Connor");
        list.add(2, "Markus");
        list.addLast("Kara");

        list.remove("Todd");
        list.remove("Markus");

        Assertions.assertEquals(3, list.size());
    }

    @Test
    public void linkedListRemoveTest04() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Alice");
        list.addLast("Connor");
        list.add(2, "Markus");
        list.addLast("Kara");

        list.remove("Amogus");
        list.remove("Bibop");

        Assertions.assertEquals(5, list.size());
    }

    @Test
    public void linkedListRemoveTest05() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Alice");
        list.addLast("Connor");
        list.add(2, "Markus");
        list.addLast("Kara");

        list.remove(0);
        list.remove(3);

        Assertions.assertEquals(3, list.size());
    }

    @Test
    public void linkedListRemoveTest06() {
        Throwable exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            List<String> list = new LinkedList<>();
            list.add(0, "Todd");
            list.addFirst("Alice");
            list.addLast("Connor");
            list.add(2, "Markus");
            list.addLast("Kara");

            list.remove(0);
            list.remove(5);
        });

        Assertions.assertEquals("Index must be lower than list size.", exception.getMessage());
    }

    @Test
    public void linkedListRemoveTest07() {
        Throwable exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            List<String> list = new LinkedList<>();
            list.add(0, "Todd");
            list.addFirst("Alice");
            list.addLast("Connor");
            list.add(2, "Markus");
            list.addLast("Kara");

            list.remove(-1);
            list.remove(3);
        });

        Assertions.assertEquals("Index must be greater than 0.", exception.getMessage());
    }

    @Test
    public void linkedListRemoveTest08() {
        Throwable exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            List<String> list = new LinkedList<>();

            list.remove(0);
        });

        Assertions.assertEquals("Index must be lower than list size.", exception.getMessage());
    }

    @Test
    public void linkedListRemoveTest09() {
        List<String> list = new LinkedList<>();
        list.removeLast();
        list.removeFirst();

        Assertions.assertEquals(0, list.size());
    }

    @Test
    public void linkedListClearTest() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Alice");
        list.addLast("Connor");
        list.add(2, "Markus");
        list.addLast("Kara");
        list.clear();

        Assertions.assertEquals(0, list.size());
        int realSize = 0;
        for (String value : list)
            realSize++;
        Assertions.assertEquals(0, realSize);
    }

    @Test
    public void linkedListContainsTest01() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Alice");
        list.addLast("Connor");
        list.add(2, "Markus");
        list.addLast("Kara");

        Assertions.assertTrue(list.contains("Todd"));
    }

    @Test
    public void linkedListContainsTest02() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Alice");
        list.addLast("Connor");
        list.add(2, "Markus");
        list.addLast("Kara");

        Assertions.assertTrue(list.contains("Alice"));
    }

    @Test
    public void linkedListContainsTest03() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Alice");
        list.addLast("Connor");
        list.add(2, "Markus");
        list.addLast("Kara");

        Assertions.assertTrue(list.contains("Kara"));
    }

    @Test
    public void linkedListContainsTest04() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Alice");
        list.addLast("Connor");
        list.add(2, "Markus");
        list.addLast("Kara");

        Assertions.assertFalse(list.contains("Dingus"));
    }

    @Test
    public void linkedListContainsAllTest01() {
        List<String> one = new LinkedList<>();
        one.add(0, "Todd");
        one.addFirst("Alice");
        one.addLast("Connor");
        one.add(2, "Markus");
        one.addLast("Kara");

        List<String> two = new LinkedList<>();
        two.addLast("Todd");
        two.addLast("Alice");
        two.addLast("Connor");
        two.addLast("Markus");
        two.addLast("Kara");

        Assertions.assertTrue(one.containsAll(two));
    }

    @Test
    public void linkedListContainsAllTest02() {
        List<String> one = new LinkedList<>();
        one.add(0, "Todd");
        one.addFirst("Alice");
        one.addLast("Connor");
        one.add(2, "Markus");
        one.addLast("Kara");

        List<String> two = new LinkedList<>();
        two.addLast("Todd");
        two.addLast("Alice");
        two.addLast("Connor");
        two.addLast("Markus");
        two.addLast("Dingus");

        Assertions.assertFalse(one.containsAll(two));
    }

    @Test
    public void linkedListGetTest01() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Alice");
        list.addLast("Connor");
        list.add(2, "Markus");
        list.addLast("Kara");

        Assertions.assertEquals("Alice", list.get(0));
    }

    @Test
    public void linkedListGetTest02() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Alice");
        list.addLast("Connor");
        list.add(2, "Markus");
        list.addLast("Kara");

        Assertions.assertEquals("Todd", list.get(1));
    }

    @Test
    public void linkedListGetTest03() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Alice");
        list.addLast("Connor");
        list.add(2, "Markus");
        list.addLast("Kara");

        Assertions.assertEquals("Kara", list.get(4));
    }

    @Test
    public void linkedListGetTest04() {
        Throwable exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            List<String> list = new LinkedList<>();
            list.add(0, "Todd");
            list.addFirst("Alice");
            list.addLast("Connor");
            list.add(2, "Markus");
            list.addLast("Kara");

            String element = list.get(-1);
        });

        Assertions.assertEquals("Index must be greater than 0.", exception.getMessage());
    }

    @Test
    public void linkedListGetTest05() {
        Throwable exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            List<String> list = new LinkedList<>();
            list.add(0, "Todd");
            list.addFirst("Alice");
            list.addLast("Connor");
            list.add(2, "Markus");
            list.addLast("Kara");

            String element = list.get(5);
        });

        Assertions.assertEquals("Index must be lower than list size.", exception.getMessage());
    }

    @Test
    public void linkedListGetTest06() {
        Throwable exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            List<String> list = new LinkedList<>();

            String element = list.get(0);
        });

        Assertions.assertEquals("Index must be lower than list size.", exception.getMessage());
    }

    @Test
    public void linkedListGetFirstTest() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Alice");
        list.addLast("Connor");
        list.add(2, "Markus");
        list.addLast("Kara");

        Assertions.assertEquals("Alice", list.getFirst());
    }

    @Test
    public void linkedListGetLastTest() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Alice");
        list.addLast("Connor");
        list.add(2, "Markus");
        list.addLast("Kara");

        Assertions.assertEquals("Kara", list.getLast());
    }

    @Test
    public void linkedListIndexOfTest01() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Alice");
        list.addLast("Connor");
        list.add(2, "Markus");
        list.addLast("Kara");

        Assertions.assertEquals(0, list.indexOf("Alice"));
    }

    @Test
    public void linkedListIndexOfTest02() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Alice");
        list.addLast("Connor");
        list.add(2, "Markus");
        list.addLast("Kara");

        Assertions.assertEquals(1, list.indexOf("Todd"));
    }

    @Test
    public void linkedListIndexOfTest03() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Alice");
        list.addLast("Connor");
        list.add(2, "Markus");
        list.addLast("Kara");

        Assertions.assertEquals(4, list.indexOf("Kara"));
    }

    @Test
    public void linkedListIndexOfTest04() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Alice");
        list.addLast("Connor");
        list.add(2, "Markus");
        list.addLast("Kara");

        Assertions.assertEquals(-1, list.indexOf("Dingus"));
    }

    @Test
    public void linkedListIndexOfTest05() {
        List<String> list = new LinkedList<>();

        Assertions.assertEquals(-1, list.indexOf("Dingus"));
    }

    @Test
    public void linkedListIsEmptyTest01() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Alice");
        list.addLast("Connor");
        list.add(2, "Markus");
        list.addLast("Kara");

        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void linkedListIsEmptyTest02() {
        List<String> list = new LinkedList<>();

        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void linkedListLastIndexOfTest01() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Todd");
        list.addLast("Connor");
        list.add(2, "Connor");
        list.addLast("Kara");
        list.addLast("Kara");

        Assertions.assertEquals(1, list.lastIndexOf("Todd"));
    }

    @Test
    public void linkedListLastIndexOfTest02() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Todd");
        list.addLast("Connor");
        list.add(2, "Connor");
        list.addLast("Kara");
        list.addLast("Kara");

        Assertions.assertEquals(3, list.lastIndexOf("Connor"));
    }

    @Test
    public void linkedListLastIndexOfTest03() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Todd");
        list.addLast("Connor");
        list.add(2, "Connor");
        list.addLast("Kara");
        list.addLast("Kara");

        Assertions.assertEquals(5, list.lastIndexOf("Kara"));
    }

    @Test
    public void linkedListLastIndexOfTest04() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Todd");
        list.addLast("Connor");
        list.add(2, "Connor");
        list.addLast("Kara");
        list.addLast("Kara");

        Assertions.assertEquals(-1, list.lastIndexOf("Dingus"));
    }

    @Test
    public void linkedListLastIndexOfTest05() {
        List<String> list = new LinkedList<>();

        Assertions.assertEquals(-1, list.lastIndexOf("Dingus"));
    }

    @Test
    public void linkedListReversedTest() {
        List<String> list = new LinkedList<>();

        List<String> reversedList = list.reversed();
        Assertions.assertEquals(list.size(), reversedList.size());
    }

    @Test
    public void linkedListArrayTest() {
        List<String> list = new LinkedList<>();

        Object[] arrayList = list.toArray();
        Assertions.assertEquals(list.size(), arrayList.length);
    }

    @Test
    public void linkedListOverallIntegrationTest() {
        List<String> list = new LinkedList<>();
        list.add(0, "Todd");
        list.addFirst("Alice");
        list.addLast("Connor");
        list.add(2, "Markus");
        list.addLast("Kara");

        list.removeFirst();
        list.removeLast();
        list.remove("Connor");
        list.remove(0);

        list.addLast("Connor");
        list.addFirst("Kara");
        list.add(1, "Todd");
        list.addLast("Alice");

        java.util.LinkedList<String> groundTruth = new java.util.LinkedList<>();
        groundTruth.add(0, "Todd");
        groundTruth.addFirst("Alice");
        groundTruth.addLast("Connor");
        groundTruth.add(2, "Markus");
        groundTruth.addLast("Kara");

        groundTruth.removeFirst();
        groundTruth.removeLast();
        groundTruth.remove("Connor");
        groundTruth.remove(0);

        groundTruth.addLast("Connor");
        groundTruth.addFirst("Kara");
        groundTruth.add(1, "Todd");
        groundTruth.addLast("Alice");

        Assertions.assertEquals(groundTruth.size(), list.size());
        for (int i = 0; i < list.size(); i++)
            Assertions.assertEquals(groundTruth.get(i), list.get(i));

        List<String> reversedList = list.reversed();

        Assertions.assertEquals(groundTruth.size(), reversedList.size());
        for (int i = 0; i < reversedList.size(); i++)
            Assertions.assertEquals(groundTruth.get(groundTruth.size() - 1 - i), reversedList.get(i));

        Object[] arrayList = list.toArray();
        Object[] groundTruthArrayList = groundTruth.toArray();
        Assertions.assertArrayEquals(groundTruthArrayList, arrayList);
    }
}
