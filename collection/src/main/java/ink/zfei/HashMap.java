package ink.zfei;

public class HashMap {

    private Node[] nodes;

    private int size;

    private int index = 0;

    public HashMap() {
        nodes = new Node[16];
    }

    public HashMap(int size) {
        this.size = size;
        nodes = new Node[size];
    }


    public static void main(String[] args) {

        java.util.HashMap<Node,String> map = new java.util.HashMap();
        Node node = new Node("aa","bb");
        map.put(node,"zhangsan");
//        map.put("age",15);

        Node node1 = new Node("aa","bb");
        String name =  (String)map.get(node1);
        System.out.println(name);

//        HashMap map = new HashMap();
//        map.put("name", "zhangsan");
//        String value = map.get(new String("name"));
//        System.out.println(value);
    }

    private String get(String key) {

        if (key == null) {
            return null;
        }

        for (int i = 0; i < index; i++) {
            Node node = nodes[i];
            if (key.equals(node.getKey())) {
                return node.getValue();
            }
        }

        return null;
    }

    private void put(String key, String value) {
        Node node = new Node(key, value);
        nodes[index] = node;
        index++;

    }


    static class Node {

        public int hashCode() {
            return key.hashCode()+value.hashCode();
        }

        public boolean equals(Object obj) {
            Node node = (Node) obj;

            return key.equals(node.key) &&
                    value.equals(node.value);
        }

        public boolean equals(Node node) {

            return key.equals(node.key) &&
                    value.equals(node.value);
        }

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }


        private String key;

        public String getValue() {
            return value;
        }

        private String value;
    }
}
