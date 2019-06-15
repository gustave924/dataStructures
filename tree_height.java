import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeHeight {
		int n;
		TreeNode<Integer> parent[];
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new TreeNode[n];
			for (int i = 0; i < n; i++) {
				parent[i] = new TreeNode<>(in.nextInt());
			}
		}

		int computeHeight() {
                        // Replace this code with a faster implementation
			Tree<Integer> tree = new Tree<>(null);
			for(int i=0; i < n; i++) {
				if(parent[i].getData() == -1) {
					tree.setRoot(parent[i]);
				}else {
					parent[parent[i].getData()].addChild(parent[i]);
				}
			}
			/*int maxHeight = 0;
			for (int vertex = 0; vertex < n; vertex++) {
				int height = 0;
				for (int i = vertex; i != -1; i = parent[i])
					height++;
				maxHeight = Math.max(maxHeight, height);
			}
			return maxHeight;*/
			/*if(tree.getRoot() == null) return -1;
			Queue<TreeNode<Integer>> q = new ArrayDeque<>();
			q.add(tree.getRoot());
			while(!q.isEmpty()) {
				TreeNode<Integer> node = q.poll();
				System.out.print(node.getData()+"    ");
				if(!node.getChildren().isEmpty()) {
					for(TreeNode<Integer> nodeeee : node.getChildren()) {
						q.add(nodeeee);
					}
				}
			}*/
			return getHeight(tree.getRoot());
		}
	}
	
	
	public int getHeight(TreeNode<Integer> node) {
		List<Integer> length = new ArrayList<>();
		int maxLength;
		for(TreeNode<Integer> child : node.getChildren()) {
			length.add(getHeight(child));
		}
		if(length.isEmpty()) maxLength = 0;
		else maxLength = Collections.max(length);
		return 1+maxLength;
	}
	
	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println("\n"+tree.computeHeight());
	}
}

class Tree<T> {
	private TreeNode<T> root;
	
	public Tree(TreeNode<T> root) {
		this.root = root;
	}
	
	public TreeNode<T> getRoot() {
		return this.root;
	}

	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}
	
}




class TreeNode<T> {
	private T node;
	private List<TreeNode<T>> children;
	
	public TreeNode(T node) {
		this.node = node;
		children = new ArrayList<TreeNode<T>>();
	}
	
	public void addChild(TreeNode<T> node) {
		this.children.add(node);
	}
	
	public void removeChild(TreeNode<T> node) {
		this.children.remove(node);
	}
	
	public List<TreeNode<T>> getChildren(){
		return this.children;
	}
	public T getData() {
		return this.node;
	}
	
	public void setData(T data) {
		this.node = data;
	}
}







