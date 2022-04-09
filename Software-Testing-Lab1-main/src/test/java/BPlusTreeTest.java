import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class BPlusTreeTest {

    private String expected;
    private String actual;


    @Test
    @DisplayName("Test 1 for put.")
    void put() {
        BPlusTree<Integer,String> bt = new BPlusTree<>();
        bt.put(1,"a");
        bt.put(1,"c");
        bt.put(2,"b");
        bt.put(3,"d");
        bt.put(4,"e");
        bt.put(5,"g");
        bt.put(6,"h");
        bt.put(7,"i");
        bt.put(8,"j");
        bt.put(9,"l");
        bt.put(10,"m");
        bt.put(11,"o");
        bt.put(12,"p");
        bt.put(13,"r");
        bt.put(14,"s");
        bt.put(15,"u");
        bt.put(16,"v");
        bt.put(17,"x");
        bt.put(18,"y");
        bt.put(19,"z");



        actual = bt.get(19);
        expected = "z";
        System.out.println("actual = "+actual+"   expected = "+expected);
        Assertions.assertEquals(actual, expected);

    }

    @Test
    @DisplayName("Test 2 for delete.")
    void delete() {
        BPlusTree<Integer,String> bt = new BPlusTree<>();
        bt.put(1,"a");
        bt.put(2,"b");
        bt.put(3,"d");
        bt.put(4,"e");
        bt.put(5,"g");
        bt.put(6,"h");
        bt.put(7,"i");
        bt.put(8,"j");
        bt.put(9,"l");
        bt.remove(4);

        actual = bt.get(4);
        expected = null;

        System.out.println("actual = "+actual+"   expected = "+expected);
        Assertions.assertEquals(actual, expected);

    }


}
