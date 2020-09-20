public class Main {
    static int N, T;
    static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            for(int i = 0 ; i < N ; i++){
                list.add(br.readLine());
            }
            list.sort(Comparator.comparing(String::length));

            if(solution())
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static boolean solution(){
        Trie trie = new Trie();
        for(String s : list){
            if(!trie.insert(s)){
                return false;
            }
        }
        return true;
    }

    public static class Trie {

        private final TrieNode rootNode;
        Trie() {
            rootNode = new TrieNode();
        }

        boolean insert(String word) {
            TrieNode thisNode = this.rootNode;
            for (int i = 0; i < word.length(); i++) {
                if(thisNode.isLastChar()){
                    return false;
                }
                thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }
            thisNode.setIsLastChar(true);
            return true;
        }
    }

    public static class TrieNode {
        private Map<Character, TrieNode> childNodes = new HashMap<>();
        private boolean isLastChar;
        Map<Character, TrieNode> getChildNodes() {
            return this.childNodes;
        }
        boolean isLastChar() {
            return this.isLastChar;
        }
        void setIsLastChar(boolean isLastChar) {
            this.isLastChar = isLastChar;
        }
    }
}