package UvaHunting.DataStructures.PriorityQueue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class ICanGuessTheDataStructure {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader(new File("in.txt")));
        StringBuilder r = new StringBuilder();

        boolean pq, st, qu;

        int n, o, v;
        Comparator<Integer> c = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        Stack<Integer> stack;
        PriorityQueue<Integer> priority;
        Queue<Integer> cola;
        String s[];
        String line;
        while ((line = br.readLine()) != null) {
            pq = st = qu = true;
            n = Integer.parseInt(line);
            priority = new PriorityQueue<Integer>(1000, c);
            stack = new Stack<Integer>();
            cola = new LinkedList<Integer>();

            while (n-- > 0) {
                s = br.readLine().split(" ");
                o = Integer.parseInt(s[0]);
                v = Integer.parseInt(s[1]);

                if (o == 1) {
                    if (st) {
                        stack.push(v);
                    }
                    if (pq) {
                        priority.add(v);
                    }
                    if (qu) {
                        cola.add(v);
                    }
                } else {
                    if (st) {
                        if (stack.size() > 0) {
                            if (stack.pop() != v) {
                                st = false;
                            }
                        } else {
                            st = false;
                        }
                    }

                    if (pq) {
                        if (priority.size() > 0) {
                            if (priority.poll() != v) {
                                pq = false;
                            }
                        } else {
                            pq = false;
                        }
                    }

                    if (qu) {
                        if (cola.size() > 0) {
                            if (cola.poll() != v) {
                                qu = false;
                            }
                        } else {
                            qu = false;
                        }
                    }

                }
            }

            if (!qu && !st && !pq) {
                r.append("impossible\n");
            } else if ((pq && st) || (st && qu) || (qu && pq)) {
                r.append("not sure\n");
            } else if (pq && !st && !qu) {
                r.append("priority queue\n");
            } else if (st && !qu && !pq) {
                r.append("stack\n");
            } else {
                r.append("queue\n");
            }
        }
        System.out.println(r.toString().trim());
    }
}
