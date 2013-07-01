package WellKnown.DataStructures;

public class SortedList {

    static class Link {

        long i_data;
        Link next;

        Link(long i_data) {
            this.i_data = i_data;
        }

        public void display_link() {
            System.out.println("{" + i_data + "}");
        }
    }

    static class SortList {

        Link first;

        public void insert(long key) {
            Link new_link = new Link(key);
            Link current = first;
            Link previous = first;
            while (current != null && current.i_data < key) {
                previous = current;
                current = current.next;
            }
            if (current == first) {
                new_link.next = first;
                first = new_link;
            } else {
                previous.next = new_link;
                new_link.next = current;
            }
        }

        //assumes non-empty list
        public Link remove_first(long key) {
            Link temp = first;
            first = first.next;
            return temp;

        }

        public void display_list() {
            Link current = first;
            System.out.println("----->");
            while (current != null) {
                current.display_link();
                current = current.next;
            }
            System.out.println("<-----");


        }

        public static void main(String[] args) {
            SortList sl = new SortList();
            sl.insert(5);
            sl.insert(3);
            sl.insert(6);
            sl.insert(4);
            sl.display_list();
        }
    }
}
