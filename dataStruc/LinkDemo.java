package dataStruc;

class LNode<T> {
    private T data;
    private LNode<T> next;
    private LNode<T> last;

    public LNode(T data) {
        this.data = data;
        this.next = null;
        this.last = null;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LNode<T> getNext() {
        return this.next;
    }

    public void setNext(LNode<T> node) {
        this.next = node;
    }

    public LNode<T> getLast() {
        return last;
    }

    public void setLast(LNode<T> last) {
        this.last = last;
    }
}

interface LList<T> {
    public LNode<T> add(T data);

    public void show();

    public int size();

    public Boolean empty();

    public Object[] toArray();

    public LNode<T> getNode(int index);

    public void setNode(int index, T data);

    public int indexOf(T data);

    public int indexOf(T data, int index);

    public void remove(int index);

    public void clear();

    public Boolean contains(T data);
}

class LListImpl<T> implements LList<T> {
    private LNode<T> head;
    private LNode<T> tail;

    public LListImpl() {
        this.head = null;
        this.tail = head;
    }

    public LListImpl(T data) {
        if (data == null) {
            this.head = null;
            this.tail = head;
        } else {
            this.head = new LNode<T>(data);
            this.tail = head;
        }
    }

    public LNode<T> getHead() {
        return head;
    }

    public void setHead(LNode<T> head) {
        this.head = head;
    }

    public LNode<T> getTail() {
        return tail;
    }

    public LNode<T> add(T data) {
        LNode<T> node = new LNode<T>(data);
        if (this.head == null) {
            this.head = node;
            this.tail = head;
            return this.head;
        }
        node.setLast(tail);
        this.tail.setNext(node);
        this.tail = node;
        return this.head;
    }

    public void show() {
        for (LNode<T> i = this.head; i != null; i = i.getNext()) {
            System.out.println(i.getData());
        }
    }

    public int size() {
        int cnt = 0;
        LNode<T> point = this.head;
        while (point != null) {
            point = point.getNext();
            cnt++;
        }
        return cnt;
    }

    public Boolean empty() {
        return this.head == null;
    }

    public Object[] toArray() {
        if (this.empty())
            return null;
        Object[] array = new Object[this.size()];
        LNode<T> i = this.head;
        int index = 0;
        while (i != null) {
            array[index++] = i.getData();
            i = i.getNext();
        }
        return array;
    }

    public LNode<T> getNode(int index) {
        LNode<T> point = head;
        if (index >= this.size())
            return null;
        while (index-- > 0) {
            point = point.getNext();
        }
        return point;
    }

    public void setNode(int index, T data) {
        this.getNode(index).setData(data);
    }

    public int indexOf(T data) {
        int cnt = 0;
        LNode<T> point = this.head;
        while (point != null) {
            if (point.getData().equals(data))
                return cnt;
            cnt++;
            point = point.getNext();
        }
        return -1;
    }

    public int indexOf(T data, int index) {
        int cnt = index;
        LNode<T> point = this.getNode(index);
        while (point != null) {
            if (point.getData().equals(data))
                return cnt;
            cnt++;
            point = point.getNext();
        }
        return -1;
    }

    public Boolean contains(T data) {
        if (indexOf(data) != -1)
            return true;
        return false;
    }

    public void remove(int index) {
        LNode<T> point = this.getNode(index);
        if (point.getNext() != null) {
            point.getNext().setLast(point.getLast());
        } else {
            this.tail = point.getLast();
        }
        if (point.getLast() != null) {
            point.getLast().setNext(point.getNext());
        } else {
            this.head = point.getNext();
        }
        point.setLast(null);
        point.setNext(null);
    }

    public void clear() {
        this.tail = this.head;
        while (this.tail != null) {
            this.tail = this.head.getNext();
            this.head.setLast(null);
            this.head.setNext(null);
            this.head = this.tail;
        }
        this.head = null;
        this.tail = null;
    }
}

public class LinkDemo {
    public static void main(String[] args) {
        // LNode<Integer> linkhead = new LNode<Integer>(0);
        // LNode<Integer> linktail = linkhead;
        // for (int i = 1; i < 4; i++) {
        // LNode<Integer> node = new LNode<Integer>(i);
        // linktail.setNext(node);
        // linktail = node;
        // }
        // for (LNode<Integer> i = linkhead; i != null; i = i.getNext()) {
        // System.out.println(i.getData());
        // }
        LListImpl<Integer> linklist = new LListImpl<Integer>();
        System.out.println("linklist empty:" + linklist.empty());
        linklist.add(4);
        linklist.add(1);
        linklist.add(3);
        linklist.add(7);
        linklist.add(9);
        linklist.add(3);
        linklist.add(6);
        linklist.add(2);
        linklist.show();
        System.out.println("linklist empty:" + linklist.empty());
        System.out.println("linklist size :" + linklist.size());
        System.out.println("---------");
        for (Object i : linklist.toArray())
            System.out.println(i);
        System.out.println("---------");
        System.out.println(linklist.getNode(4).getData());
        linklist.setNode(4, 5);
        System.out.println(linklist.getNode(4).getData());
        System.out.println("---------");
        linklist.show();
        System.out.println("---------");
        System.out.println(linklist.indexOf(3, 0));
        System.out.println(linklist.indexOf(3, linklist.indexOf(3, 0) + 1));
        System.out.println("---------");
        System.out.println(linklist.indexOf(3, 0));
        linklist.remove(4);
        System.out.println(linklist.indexOf(3, linklist.indexOf(3, 0) + 1));
        System.out.println("---------");
        linklist.show();
        System.out.println("linklist contians 6: " + linklist.contains(6));
        System.out.println("linklist contians 9: " + linklist.contains(9));
        System.out.println("---------");
        System.out.println("linklist size :" + linklist.size());
        linklist.clear();
        linklist.show();
        System.out.println("linklist size :" + linklist.size());
    }
}
