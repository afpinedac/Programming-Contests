package WellKnown.DataStructures;

public class DoubleLinkedList {

    static class Link {

        long data;
        Link next;
        Link previous;

        Link(long data) {
            this.data = data;
        }

        public void display_link() {
            System.out.println("{" + data + "}");
        }
    }

    static class DoubleLinkList {

        Link first;
        Link last;

        public void insert_first(long data) {
            Link new_link = new Link(data);
            if (is_empty()) {
                last = new_link;
            } else {
                first.previous = new_link;
            }
            new_link.next = first;
            first = new_link;

        }

        public boolean is_empty() {
            return first == null;
        }

        public void insert_last(long data) {
            Link new_link = new Link(data);
            if (is_empty()) {
                first = new_link;
            } else {
                last.next = new_link;
                new_link.previous = last;
            }
            last = new_link;
        }

        public Link delete_first() {
            if (is_empty()) {
                return null;
            }
            Link temp = first;
            if (first.next == null) {
                last = null;
                first = null;
            } else {
                first = first.next;
                first.previous = null;
            }

            return temp;
        }

        public Link delete_last() {
            if (is_empty()) {
                return null;
            }
            Link temp = last;
            if (last.previous == null) {
                last = null;
                first = null;
            } else {
                last.previous.next = null;
                last = last.previous;
            }

            return temp;
        }

        public Link delete_key(long key) {
            if (is_empty()) {
                return null;
            }
            Link current = first;

            while (current != null && current.data != key) {
                current = current.next;
            }
            if (current == null) {
                return null;
            }
            if (current.previous == null && current.next == null) {
                first = last = null;
            } else if (current.previous == null) {
                first = current.next;
                current.next.previous = null;
            } else if (current.next == null) {
                current.previous.next = null;
                last = current.previous;
            } else {
                current.previous.next = current.next;
                current.next.previous = current.previous;
            }
            return current;
        }

        public boolean insert_after(long key, long value) {
            if (is_empty()) {
                return false;
            }

            Link new_link = new Link(value);
            Link current = first;
            while (current != null && current.data != key) {
                current = current.next;
            }
            //   current.display_link();
            if (current == null) {
                return false;
            }

            if (current.next == null) {
                current.next = new_link;
                new_link.previous = current;
                last = new_link;
            } else {
                new_link.next = current.next;
                current.next.previous = new_link;
                current.next = new_link;
                new_link.previous = current;

            }
            return true;



        }

        public void display_forward() {
            Link current = first;
            System.out.println("Forward---------->");
            while (current != null) {
                current.display_link();
                current = current.next;
            }
            System.out.println("<----------");
        }

        public void display_backward() {
            Link current = last;
            System.out.println("Backward----------->");
            while (current != null) {
                current.display_link();
                current = current.previous;
            }
            System.out.println("<----------");
        }
    }

    public static void main(String[] args) {
        DoubleLinkList dll = new DoubleLinkList();


        dll.insert_first(5);
        dll.insert_last(7);
        dll.insert_after(5, 6);
        dll.delete_key(5);
        dll.insert_first(1);
        dll.delete_last();
        dll.delete_last();
        dll.insert_last(5);
        dll.delete_first();
        dll.delete_last();
        dll.insert_last(5);
        dll.insert_after(5, 5);


        dll.display_forward();
        dll.display_backward();

    }
}
