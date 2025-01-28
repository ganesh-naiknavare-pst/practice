// Graph Traversal and Utilities
class TreeAndGraph {
  // 1. Depth-First Search (DFS) for a Graph (Recursive)
  static dfsGraph(graph: Map<string, string[]>, start: string, visited: Set<string> = new Set()): Set<string> {
    visited.add(start);
    for (let neighbor of graph.get(start) || []) {
      if (!visited.has(neighbor)) {
        this.dfsGraph(graph, neighbor, visited);
      }
    }
    return visited;
  }

  // 2. Breadth-First Search (BFS) for a Graph
  static bfsGraph(graph: Map<string, string[]>, start: string): void {
    const visited = new Set<string>();
    const queue: string[] = [start];
    visited.add(start);
    while (queue.length > 0) {
      const vertex = queue.shift()!;
      console.log(vertex);
      for (let neighbor of graph.get(vertex) || []) {
        if (!visited.has(neighbor)) {
          visited.add(neighbor);
          queue.push(neighbor);
        }
      }
    }
  }

  // 3. Inorder Traversal of a Binary Tree (Recursive)
  static inorderTree(root: TreeNode | null): void {
    if (root) {
      this.inorderTree(root.left);
      console.log(root.data);
      this.inorderTree(root.right);
    }
  }

  // 4. Preorder Traversal of a Binary Tree (Recursive)
  static preorderTree(root: TreeNode | null): void {
    if (root) {
      console.log(root.data);
      this.preorderTree(root.left);
      this.preorderTree(root.right);
    }
  }

  // 5. Postorder Traversal of a Binary Tree (Recursive)
  static postorderTree(root: TreeNode | null): void {
    if (root) {
      this.postorderTree(root.left);
      this.postorderTree(root.right);
      console.log(root.data);
    }
  }

  // 6. Level Order Traversal of a Binary Tree (BFS)
  static levelOrderTree(root: TreeNode | null): void {
    if (!root) return;
    const queue: TreeNode[] = [root];
    while (queue.length > 0) {
      const node = queue.shift()!;
      console.log(node.data);
      if (node.left) queue.push(node.left);
      if (node.right) queue.push(node.right);
    }
  }

  // 7. Find the Shortest Path in a Graph (BFS)
  static shortestPath(graph: Map<string, string[]>, start: string, end: string): string[] | null {
    const parentMap = new Map<string, string | null>();
    const queue: string[] = [start];
    parentMap.set(start, null);
    while (queue.length > 0) {
      const vertex = queue.shift()!;
      for (let neighbor of graph.get(vertex) || []) {
        if (!parentMap.has(neighbor)) {
          parentMap.set(neighbor, vertex);
          queue.push(neighbor);
          if (neighbor === end) {
            const path: string[] = [];
            for (let at: string | null = end; at !== null; at = parentMap.get(at)) {
              path.push(at);
            }
            return path.reverse();
          }
        }
      }
    }
    return null; // No path found
  }

  // 8. Depth-First Search for a Tree (Recursive)
  static dfsTree(root: TreeNode | null, visited: Set<TreeNode> = new Set()): void {
    if (root && !visited.has(root)) {
      visited.add(root);
      console.log(root.data);
      this.dfsTree(root.left, visited);
      this.dfsTree(root.right, visited);
    }
  }

  // 9. Find the Height of a Binary Tree
  static heightTree(root: TreeNode | null): number {
    if (root === null) return -1;
    const leftHeight = this.heightTree(root.left);
    const rightHeight = this.heightTree(root.right);
    return Math.max(leftHeight, rightHeight) + 1;
  }

  // 10. Check if a Graph is a Tree
  static isTree(graph: Map<string, string[]>): boolean {
    const visited = new Set<string>();
    if (!this.dfsCheckCycle(graph, graph.keys().next().value, null, visited)) {
      return false;
    }
    return visited.size === graph.size;
  }

  private static dfsCheckCycle(graph: Map<string, string[]>, node: string, parent: string | null, visited: Set<string>): boolean {
    visited.add(node);
    for (let neighbor of graph.get(node) || []) {
      if (!visited.has(neighbor)) {
        if (!this.dfsCheckCycle(graph, neighbor, node, visited)) {
          return false;
        }
      } else if (neighbor !== parent) {
        return false; // Cycle detected
      }
    }
    return true;
  }
}

// TreeNode class for Binary Tree
class TreeNode {
  data: number;
  left: TreeNode | null;
  right: TreeNode | null;

  constructor(data: number) {
    this.data = data;
    this.left = this.right = null;
  }
}

// Example usage:
const graph = new Map<string, string[]>([
  ['A', ['B', 'C']],
  ['B', ['A', 'D', 'E']],
  ['C', ['A', 'F']],
  ['D', ['B']],
  ['E', ['B']],
  ['F', ['C']],
]);

const root = new TreeNode(1);
root.left = new TreeNode(2);
root.right = new TreeNode(3);
root.left.left = new TreeNode(4);
root.left.right = new TreeNode(5);
root.right.left = new TreeNode(6);

// Test Graph Functions
console.log('DFS on Graph: ', TreeAndGraph.dfsGraph(graph, 'A'));
console.log('BFS on Graph:');
TreeAndGraph.bfsGraph(graph, 'A');
console.log('Shortest Path from A to F:', TreeAndGraph.shortestPath(graph, 'A', 'F'));

// Test Tree Functions
console.log('Inorder Traversal:');
TreeAndGraph.inorderTree(root);
console.log('Preorder Traversal:');
TreeAndGraph.preorderTree(root);
console.log('Postorder Traversal:');
TreeAndGraph.postorderTree(root);
console.log('Level Order Traversal:');
TreeAndGraph.levelOrderTree(root);
console.log('DFS on Tree:');
TreeAndGraph.dfsTree(root);
console.log('Height of Tree:', TreeAndGraph.heightTree(root));
console.log('Is the graph a tree?', TreeAndGraph.isTree(graph));
