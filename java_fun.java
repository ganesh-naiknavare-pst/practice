public boolean isPalindrome(String str) {
    String clean = str.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
    int left = 0;
    int right = clean.length() - 1;
    
    while (left < right) {
        if (clean.charAt(left) != clean.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}

public long factorial(int n) {
    if (n < 0) throw new IllegalArgumentException("Negative numbers not allowed");
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}

public <T> ArrayList<T> arrayToList(T[] array) {
    return new ArrayList<>(Arrays.asList(array));
}

public <T extends Comparable<T>> T findMax(T[] array) {
    if (array == null || array.length == 0) {
        throw new IllegalArgumentException("Array cannot be empty or null");
    }
    
    T max = array[0];
    for (T element : array) {
        if (element.compareTo(max) > 0) {
            max = element;
        }
    }
    return max;
}

public boolean isPrime(int number) {
    if (number <= 1) return false;
    for (int i = 2; i <= Math.sqrt(number); i++) {
        if (number % i == 0) return false;
    }
    return true;
}

public String reverseString(String str) {
    return new StringBuilder(str).reverse().toString();
}

public double power(double base, int exponent) {
    if (exponent == 0) return 1;
    if (exponent < 0) {
        return 1 / power(base, -exponent);
    }
    double result = 1;
    for (int i = 0; i < exponent; i++) {
        result *= base;
    }
    return result;
}

public int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

public boolean isLeapYear(int year) {
    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
}

public double calculateAverage(double[] numbers) {
    if (numbers == null || numbers.length == 0) {
        throw new IllegalArgumentException("Array cannot be empty or null");
    }
    
    double sum = 0;
    for (double num : numbers) {
        sum += num;
    }
    return sum / numbers.length;
}
import java.util.*;

// Graph Traversal and Utilities
public class TreeAndGraph {

    // 1. Depth-First Search (DFS) for a Graph (Recursive)
    public static Set<String> dfsGraph(Map<String, List<String>> graph, String start, Set<String> visited) {
        if (visited == null) {
            visited = new HashSet<>();
        }
        visited.add(start);
        for (String neighbor : graph.get(start)) {
            if (!visited.contains(neighbor)) {
                dfsGraph(graph, neighbor, visited);
            }
        }
        return visited;
    }

    // 2. Breadth-First Search (BFS) for a Graph
    public static void bfsGraph(Map<String, List<String>> graph, String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            System.out.print(vertex + " ");
            for (String neighbor : graph.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    // 3. Inorder Traversal of a Binary Tree (Recursive)
    public static void inorderTree(TreeNode root) {
        if (root != null) {
            inorderTree(root.left);
            System.out.print(root.data + " ");
            inorderTree(root.right);
        }
    }

    // 4. Preorder Traversal of a Binary Tree (Recursive)
    public static void preorderTree(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderTree(root.left);
            preorderTree(root.right);
        }
    }

    // 5. Postorder Traversal of a Binary Tree (Recursive)
    public static void postorderTree(TreeNode root) {
        if (root != null) {
            postorderTree(root.left);
            postorderTree(root.right);
            System.out.print(root.data + " ");
        }
    }

    // 6. Level Order Traversal of a Binary Tree (BFS)
    public static void levelOrderTree(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    // 7. Find the Shortest Path in a Graph (BFS)
    public static List<String> shortestPath(Map<String, List<String>> graph, String start, String end) {
        Map<String, String> parentMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        parentMap.put(start, null);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            for (String neighbor : graph.get(vertex)) {
                if (!parentMap.containsKey(neighbor)) {
                    parentMap.put(neighbor, vertex);
                    queue.add(neighbor);
                    if (neighbor.equals(end)) {
                        List<String> path = new ArrayList<>();
                        for (String at = end; at != null; at = parentMap.get(at)) {
                            path.add(at);
                        }
                        Collections.reverse(path);
                        return path;
                    }
                }
            }
        }
        return null;  // No path found
    }

    // 8. Depth-First Search for a Tree (Recursive)
    public static void dfsTree(TreeNode root, Set<TreeNode> visited) {
        if (root != null && !visited.contains(root)) {
            visited.add(root);
            System.out.print(root.data + " ");
            dfsTree(root.left, visited);
            dfsTree(root.right, visited);
        }
    }

    // 9. Find the Height of a Binary Tree
    public static int heightTree(TreeNode root) {
        if (root == null) return -1;
        int leftHeight = heightTree(root.left);
        int rightHeight = heightTree(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 10. Check if a Graph is a Tree
    public static boolean isTree(Map<String, List<String>> graph) {
        Set<String> visited = new HashSet<>();
        if (!dfsCheckCycle(graph, graph.keySet().iterator().next(), null, visited)) {
            return false;
        }
        return visited.size() == graph.size();
    }

    private static boolean dfsCheckCycle(Map<String, List<String>> graph, String node, String parent, Set<String> visited) {
        visited.add(node);
        for (String neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                if (!dfsCheckCycle(graph, neighbor, node, visited)) {
                    return false;
                }
            } else if (!neighbor.equals(parent)) {
                return false; // Cycle detected
            }
        }
        return true;
    }

    // TreeNode class for Binary Tree
    public static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Example usage:
    public static void main(String[] args) {
        // Example Graph Representation (Adjacency List)
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("A", "D", "E"));
        graph.put("C", Arrays.asList("A", "F"));
        graph.put("D", Arrays.asList("B"));
        graph.put("E", Arrays.asList("B"));
        graph.put("F", Arrays.asList("C"));

        // Example Tree Construction
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        // Test Graph Functions
        System.out.println("DFS on Graph: " + dfsGraph(graph, "A", null));
        System.out.print("BFS on Graph: ");
        bfsGraph(graph, "A");
        System.out.println("\nShortest Path from A to F: " + shortestPath(graph, "A", "F"));

        // Test Tree Functions
        System.out.print("\nInorder Traversal: ");
        inorderTree(root);
        System.out.print("\nPreorder Traversal: ");
        preorderTree(root);
        System.out.print("\nPostorder Traversal: ");
        postorderTree(root);
        System.out.print("\nLevel Order Traversal: ");
        levelOrderTree(root);
        System.out.print("\nDFS on Tree: ");
        dfsTree(root, new HashSet<>());
        System.out.println("\nHeight of Tree: " + heightTree(root));
        System.out.println("Is the graph a tree? " + isTree(graph));
    }
}
