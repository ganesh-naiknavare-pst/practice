def is_palindrome(string: str) -> bool:
    clean = ''.join(char.lower() for char in string if char.isalnum())
    return clean == clean[::-1]

def factorial(n: int) -> int:
    if n < 0:
        raise ValueError("Negative numbers not allowed")
    if n <= 1:
        return 1
    return n * factorial(n - 1)

def array_to_list(array: tuple) -> list:
    return list(array)

def find_max(array: list) -> any:
    if not array:
        raise ValueError("Array cannot be empty or None")
    return max(array)

def is_prime(number: int) -> bool:
    if number <= 1:
        return False
    return all(number % i != 0 for i in range(2, int(number ** 0.5) + 1))

def reverse_string(string: str) -> str:
    return string[::-1]

def power(base: float, exponent: int) -> float:
    if exponent == 0:
        return 1
    if exponent < 0:
        return 1 / power(base, -exponent)
    result = 1
    for _ in range(exponent):
        result *= base
    return result

def gcd(a: int, b: int) -> int:
    while b:
        a, b = b, a % b
    return a

def is_leap_year(year: int) -> bool:
    return year % 4 == 0 and (year % 100 != 0 or year % 400 == 0)

def calculate_average(numbers: list) -> float:
    if not numbers:
        raise ValueError("Array cannot be empty or None")
    return sum(numbers) / len(numbers)
# tree_and_graph.py

from collections import deque

# 1. Depth-First Search (DFS) for a Graph (Recursive)
def dfs_graph(graph, start, visited=None):
    if visited is None:
        visited = set()
    visited.add(start)
    for neighbor in graph[start]:
        if neighbor not in visited:
            dfs_graph(graph, neighbor, visited)
    return visited

# 2. Breadth-First Search (BFS) for a Graph
def bfs_graph(graph, start):
    visited = set()
    queue = deque([start])
    visited.add(start)
    while queue:
        vertex = queue.popleft()
        print(vertex, end=" ")
        for neighbor in graph[vertex]:
            if neighbor not in visited:
                visited.add(neighbor)
                queue.append(neighbor)
                
# 3. Inorder Traversal of a Binary Tree (Recursive)
def inorder_tree(root):
    if root:
        inorder_tree(root.left)
        print(root.data, end=" ")
        inorder_tree(root.right)

# 4. Preorder Traversal of a Binary Tree (Recursive)
def preorder_tree(root):
    if root:
        print(root.data, end=" ")
        preorder_tree(root.left)
        preorder_tree(root.right)

# 5. Postorder Traversal of a Binary Tree (Recursive)
def postorder_tree(root):
    if root:
        postorder_tree(root.left)
        postorder_tree(root.right)
        print(root.data, end=" ")

# 6. Level Order Traversal of a Binary Tree (BFS)
def level_order_tree(root):
    if not root:
        return
    queue = deque([root])
    while queue:
        node = queue.popleft()
        print(node.data, end=" ")
        if node.left:
            queue.append(node.left)
        if node.right:
            queue.append(node.right)

# 7. Find the Shortest Path in a Graph (BFS)
def shortest_path(graph, start, end):
    visited = {start: None}
    queue = deque([start])
    while queue:
        vertex = queue.popleft()
        for neighbor in graph[vertex]:
            if neighbor not in visited:
                visited[neighbor] = vertex
                queue.append(neighbor)
                if neighbor == end:
                    path = []
                    while visited[neighbor] is not None:
                        path.append(neighbor)
                        neighbor = visited[neighbor]
                    return path[::-1]
    return None

# 8. Depth-First Search for a Tree (Recursive)
def dfs_tree(root, visited=None):
    if visited is None:
        visited = set()
    if root and root not in visited:
        visited.add(root)
        print(root.data, end=" ")
        dfs_tree(root.left, visited)
        dfs_tree(root.right, visited)

# 9. Find the Height of a Binary Tree
def height_tree(root):
    if not root:
        return -1
    left_height = height_tree(root.left)
    right_height = height_tree(root.right)
    return max(left_height, right_height) + 1

# 10. Check if a Graph is a Tree
def is_tree(graph):
    def dfs(graph, node, parent, visited):
        visited.add(node)
        for neighbor in graph[node]:
            if neighbor not in visited:
                if not dfs(graph, neighbor, node, visited):
                    return False
            elif neighbor != parent:
                return False
        return True
    
    visited = set()
    if not dfs(graph, list(graph.keys())[0], None, visited):
        return False
    return len(visited) == len(graph)

# Example usage:
# Example Graph Representation (Adjacency List)
graph = {
    'A': ['B', 'C'],
    'B': ['A', 'D', 'E'],
    'C': ['A', 'F'],
    'D': ['B'],
    'E': ['B'],
    'F': ['C']
}

# Example Tree Node Class
class TreeNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

# Example Tree Construction
root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.left = TreeNode(4)
root.left.right = TreeNode(5)
root.right.left = TreeNode(6)

if __name__ == "__main__":
    # Test Graph Functions
    print("DFS on Graph:", dfs_graph(graph, 'A'))
    print("BFS on Graph:")
    bfs_graph(graph, 'A')
    print("\nShortest Path from A to F:", shortest_path(graph, 'A', 'F'))

    # Test Tree Functions
    print("\nInorder Traversal:")
    inorder_tree(root)
    print("\nPreorder Traversal:")
    preorder_tree(root)
    print("\nPostorder Traversal:")
    postorder_tree(root)
    print("\nLevel Order Traversal:")
    level_order_tree(root)
    print("\nDFS on Tree:")
    dfs_tree(root)
    print("\nHeight of Tree:", height_tree(root))
    print("Is the graph a tree?", is_tree(graph))
