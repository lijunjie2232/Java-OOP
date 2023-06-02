package dataStruc;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

class TreeNode<T extends Comparable<T>> {
    private T data;
    private TreeNode<T> left;
    private TreeNode<T> right;
    private TreeNode<T> parent;

    public TreeNode(T data) {
        this.setData(data);
        this.parent = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    public int compareTo(TreeNode<T> node) {
        return this.data.compareTo(node.getData());
    }
}

interface BinaryTree<T extends Comparable<T>> {
    public void show();

    public void show(TreeNode<T> node);

    public BinaryTree<T> add(TreeNode<T> node);

    public BinaryTree<T> add(T data);

    public TreeNode<T> find(T data);

    public void remove(T data);

    public int deep();

    public int deep(TreeNode<T> node);

    public int count();

    public void clear();

}

class MyBinaryTree<T extends Comparable<T>> implements BinaryTree<T> {
    private TreeNode<T> root;

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    public MyBinaryTree() {
        this.root = null;
    }

    public MyBinaryTree(TreeNode<T> node) {
        this.root = node;
    }

    public BinaryTree<T> add(T newData) {
        return this.add(new TreeNode<T>(newData));
    }

    public BinaryTree<T> add(TreeNode<T> node) {
        TreeNode<T> point = root;
        while (point != null) {
            int result = point.compareTo(node);
            if (result == 0)
                return this;
            else if (result > 0) {
                if (point.getLeft() == null) {
                    node.setParent(point);
                    point.setLeft(node);
                    return this;
                } else {
                    point = point.getLeft();
                }
            } else {
                if (point.getRight() == null) {
                    node.setParent(point);
                    point.setRight(node);
                    return this;
                } else {
                    point = point.getRight();
                }
            }
        }
        root = node;
        node.setParent(point);
        return this;
    }

    public TreeNode<T> find(T data) {
        TreeNode<T> tmp = root;
        while (tmp != null) {
            int result = tmp.getData().compareTo(data);
            if (result == 0)
                return tmp;
            else if (result > 0) {
                tmp = tmp.getLeft();
            } else {
                tmp = tmp.getRight();
            }
        }
        return tmp;
    }

    public void remove(T data) {
        TreeNode<T> targetNode = this.find(data);
        if (targetNode == null)
            return;
        TreeNode<T> pNode = targetNode.getParent();
        if (targetNode.getLeft() != null && targetNode.getRight() != null) {
            TreeNode<T> cNode = targetNode.getRight();
            while (cNode.getLeft() != null) {
                cNode = cNode.getLeft();
            }
            pNode = cNode.getParent();
            if (cNode.equals(pNode.getLeft())) {
                pNode.setLeft(null);
            } else {
                pNode.setRight(null);
            }
            targetNode.getLeft().setParent(cNode);
            cNode.setLeft(targetNode.getLeft());
            targetNode.getRight().setParent(cNode);
            cNode.setRight(targetNode.getRight());
            pNode = targetNode.getParent();
            if (pNode != null) {
                cNode.setParent(pNode);
                if (targetNode.equals(pNode.getLeft())) {
                    pNode.setLeft(cNode);
                } else {
                    pNode.setRight(cNode);
                }
            } else {
                this.setRoot(cNode);
            }
        } else if (targetNode.getLeft() != null) {
            if (targetNode.equals(pNode.getLeft())) {
                targetNode.getLeft().setParent(pNode);
                pNode.setLeft(targetNode.getLeft());
            } else {
                targetNode.getLeft().setParent(pNode);
                pNode.setRight(targetNode.getLeft());
            }
        } else if (targetNode.getRight() != null) {
            if (targetNode.equals(pNode.getLeft())) {
                targetNode.getRight().setParent(pNode);
                pNode.setLeft(targetNode.getRight());
            } else {
                targetNode.getRight().setParent(pNode);
                pNode.setRight(targetNode.getRight());
            }
        } else {
            if (targetNode.equals(pNode.getLeft()))
                pNode.setLeft(null);
            else
                pNode.setRight(null);
        }
        targetNode.setParent(null);
        targetNode.setLeft(null);
        targetNode.setRight(null);
    }

    public void show() {
        this.show(this.root);
    }

    // inOrder
    public void show(TreeNode<T> node) {
        if (node != null) {
            System.out.println(node.getData());
            this.show(node.getLeft());
            this.show(node.getRight());
        }
    }

    public int deep(TreeNode<T> node) {
        if (node == null)
            return 0;
        int deep = 0, levelSize = 1;
        TreeNode<T> top = node, tmp = null;
        Queue<TreeNode<T>> queue = new ConcurrentLinkedQueue<TreeNode<T>>();
        queue.add(top);
        while (!queue.isEmpty()) {
            top = queue.remove();
            levelSize--;
            tmp = top.getLeft();
            if (tmp != null)
                queue.add(tmp);
            tmp = top.getRight();
            if (tmp != null)
                queue.add(tmp);
            if (levelSize == 0) {
                levelSize = queue.size();
                deep++;
            }
        }
        return deep;
    }

    public int deep() {
        return this.deep(this.root);
    }

    public int count() {
        if (this.root == null)
            return 0;
        int count = 0;
        TreeNode<T> top = root, tmp = null;
        Queue<TreeNode<T>> queue = new ConcurrentLinkedQueue<TreeNode<T>>();
        queue.add(top);
        while (!queue.isEmpty()) {
            top = queue.remove();
            tmp = top.getLeft();
            if (tmp != null)
                queue.add(tmp);
            tmp = top.getRight();
            if (tmp != null)
                queue.add(tmp);
            count++;
        }
        return count;
    }
    public void clear(){
        this.setRoot(null);
    }
}

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree<Integer> bt = new MyBinaryTree<Integer>();
        bt.add(5);
        bt.add(2);
        bt.add(8);
        bt.add(0);
        bt.add(3);
        bt.add(10);
        bt.add(10);
        bt.add(7);
        bt.show();
        System.out.println("depth: " + bt.deep());
        System.out.println("count: " + bt.count());
        // System.out.println(bt.find(8).getParent().getData());
        bt.remove(5);
        bt.show();
        bt.clear();
        System.out.println("count: " + bt.count());
    }
}
