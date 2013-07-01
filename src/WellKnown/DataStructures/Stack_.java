package WellKnown.DataStructures;

public class Stack_ {

    private int top;
    private int max_size;
    private int items[];

    public Stack_(int max_size) {
        this.max_size = max_size;
        this.top = -1;
        items = new int[max_size];
    }

    public int pop() {
        return items[top--];
    }

    public int push(int e) {
        return items[++top] = e;
    }

    public boolean is_empty() {
        return top == -1;
    }

    public int peek() {
        return items[top];
    }

    public boolean is_full() {
        return top == max_size - 1;
    }

    public static void main(String[] args) {
        Stack_ st = new Stack_(10);

        st.push(5);
        System.out.println(st.peek());
        System.out.println(st.pop());
        st.push(4);
        st.push(8);
        st.push(-2);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());


    }
}
