package WellKnown.DataStructures;

public class LinkedList {

    /**
     * *****
     */
    static class Link {

        public int i_data;
        public double d_data;
        public Link next;

        Link(int i_data, double d_data) {
            this.i_data = i_data;
            this.d_data = d_data;
            this.next = null;
        }

        public void display_link() {
            System.out.println("{" + i_data + "," + d_data + "}");
        }
    }

    /**
     * ************
     */
    static class LinkList {

        public Link first;

        public LinkList() {
            first = null;
        }

        public boolean is_empty() {
            return first == null;
        }

        public void insert_first(int i_data, double d_data) {
            Link new_link = new Link(i_data, d_data);
            new_link.next = first;
            first = new_link;
        }

        public Link delete_first() {
            Link temp = first;
            first = first.next;
            return temp;
        }

        public void display_list() {
            Link current = first;
            System.out.println("-----");
            while (current != null) {
                current.display_link();
                current = current.next;
            }
            System.out.println("-----");
        }

        public Link find(int key) {
            Link current = first;
            int i = 1;
            while (current.i_data != key) {
                System.out.println((i++));
                if (current.next == null) {
                    return null;
                } else {
                    current = current.next;
                }
            }
            return current;
        }

        public Link delete(int key) {
            Link current = first;
            Link previous = first;
            while (current.i_data != key) {
                if (current.next == null) {
                    return null;
                } else {
                    previous = current;
                    current = current.next;
                }
            }

            if (current == first) {
                first = first.next;
            } else {
                previous.next = current.next;
            }
            return current;
        }
    }

    public static void main(String[] args) {
        LinkList ll = new LinkList();
        ll.insert_first(1, 2);
        ll.insert_first(3, 4);
        ll.insert_first(5, 6);
        ll.insert_first(7, 8);
        ll.insert_first(9, 10);
        ll.insert_first(11, 12);

        ll.delete(10);
        ll.find(100).display_link();

        ll.display_list();



    }
}
