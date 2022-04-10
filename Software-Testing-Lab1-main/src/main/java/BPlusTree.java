
public class BPlusTree<Key extends Comparable<Key>, Value> {

    //M defines the number of links for each node
    private static final int M = 6;

    private Node root;

    //The bottom is 0    root is highest
    private int height;

    //Total number of key-value pairs
    private int n;

    private static final class Node{

        private int m;
        private Entry[] children = new Entry[M];
        private Node(int k){
            m = k;
        }
    }

    private static class Entry{
        private Comparable key;
        private final Object val;

        private Node next;
        public Entry(Comparable key, Object val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Entry [key=");
            builder.append(key);
            builder.append("]");
            return builder.toString();
        }

    }

    public BPlusTree(){
        root = new Node(0);
    }

    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int height(){
        return height;
    }

//  Get(value):
//      get(key)
//

    public Value get(Key key){
        return search(root, key, height);
    }

    private Value search(Node x, Key key, int ht) {
        Entry[] children = x.children;//The first entry means root node

        if(ht == 0){
            for(int j=0; j<x.m; j++){
                if(equal(key, x.children[j].key))//find key
                    return (Value)children[j].val;
            }
        }
        else{
            for(int j=0; j<x.m; j++){
                if(j+1==x.m || less(key, x.children[j+1].key))
                    return search(x.children[j].next, key, ht-1);//go to next layer to find
            }
        }
        return null;
    }

//  Add:
//    put(key, value)
//
//
    public void put(Key key, Value val){
        //if node is split, return the new node
        Node u = insert(root, key, val, height);
        n++;
        if(u == null) return;//node isn't split

        //（Notice M=6）so M>>2
        //point the first element of the new node(after split) to the parent node
        Node t = new Node(M>>2);
        t.children[0] = new Entry(root.children[0].key, null, root);
        t.children[1] = new Entry(u.children[0].key, null, u);
        root = t;
        height++;
    }

    private Node insert(Node h, Key key, Value val, int ht) {
        int j;

        Entry t = new Entry(key, val, null);
        if(ht == 0){
            for(j=0; j<h.m; j++){
                if(less(key, h.children[j].key))
                    break;
            }
        }else{

            for(j=0; j<h.m; j++){
                if(j+1==h.m || less(key, h.children[j+1].key)){
                    Node u = insert(h.children[j++].next, key, val, ht-1);
                    if(u == null) return null;
                    t.key = u.children[0].key;
                    t.next = u;
                    break;
                }
            }
        }

        for(int i=h.m; i>j; i--){
            h.children[i] = h.children[i-1];
        }

        //Inserted successfully
        System.out.println(j + t.toString() + " Inserted Successfully ");
        h.children[j] = t;
        h.m++;
        if(h.m < M) return null;
        else return split(h);
    }

    private Node split(Node h) {

        Node t = new Node(M / 2);
        h.m = M / 2;
        for (int j = 0; j < M / 2; j++) {
            t.children[j] = h.children[M / 2 + j];
            h.children[M / 2 + j] = null;
        }
        return t;//return to new node
    }

// Delete :
//    remove(key)
//

    public void remove(Key key){
        remove(root, key, height);
    }

    private void remove(Node x, Key key, int ht){
        Entry[] children = x.children;
        if(ht == 0){
            for(int j=0; j<x.m; j++){
                if(equal(key, x.children[j].key)){
                    children[j] = null;//delete data in this node
                    //delete successfully
                    System.out.println(" Delete Successfully ");
                    x.m--;
                }
            }
        }
        else{
            for(int j=0; j<x.m; j++){
                if(j+1==x.m || less(key, x.children[j+1].key))
                    remove(x.children[j].next, key, ht-1);
            }
        }

    }

    private boolean equal(Comparable k1, Comparable k2){
        return k1.compareTo(k2)==0;
    }

    private boolean less(Comparable k1, Comparable k2){
        return k1.compareTo(k2)<0;
    }

    public String toString() {
        return toString(root, height, "") + "\n";
    }

    private String toString(Node h, int ht, String indent) {
        StringBuilder s = new StringBuilder();
        Entry[] children = h.children;


        if (ht == 0) {
            for (int j = 0; j < h.m; j++) {
                s.append(indent + children[j].key + " " + children[j].val + "\n");
            }
        }
        else {
            for (int j = 0; j < h.m; j++) {
                s.append(indent + "(" + children[j].key + ")\n");
                s.append(toString(children[j].next, ht-1, indent + "     "));
            }
        }
        return s.toString();
    }

}