package ru.mail.polis.ads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Problem 3837.
 */
public final class Expressions {

    static class Node {
        char data;
        Node leftChild;
        Node rightChild;

        public Node(char data, Node leftChild, Node rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    private Expressions() {
        // Should not be instantiated
    }

    /**
     *
     * @param expression is a expression written in a Reverse Polish notation. Where chars in lower case are operands
     *                   and chars in upper case are operators.
     * @return expression tree represented by Deque<Node>.
     */
    private static Deque<Node> buildExpressionTree(String expression) {
        Deque<Node> expressionTree = new LinkedList<>();
        char[] charsOfExpression = expression.toCharArray();
        for (char currentChar : charsOfExpression) {
            if (Character.isLowerCase(currentChar)) {
                expressionTree.addLast(new Node(currentChar, null, null));
            } else {
                Node leftChild = expressionTree.removeLast();
                Node rightChild = expressionTree.removeLast();
                expressionTree.addLast(new Node(currentChar, leftChild, rightChild));
            }
        }
        return expressionTree;
    }

    /**
     * to solve this task we should make tree traversal by levels (from bottom to top)
     *
     * example for the input string "abcABdefgCDEF"
     *
                       F
                      /\
                     E  B
                    /\  /\
                    D d A a
                    /\  /\
                   С  e c b
                   /\
                  g f
     * output should be gfCecbDdAaEBF
     */
    private static void solve(final FastScanner in, final PrintWriter out) {
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String inputString = in.next();
            Deque<Node> expressionTree = buildExpressionTree(inputString);
            StringBuilder result = new StringBuilder();
            while (!expressionTree.isEmpty()) {
                Node currentNode = expressionTree.removeFirst();
                result.insert(0, currentNode.data);

                if (currentNode.rightChild != null) {
                    expressionTree.addLast(currentNode.rightChild);
                }

                if (currentNode.leftChild != null) {
                    expressionTree.addLast(currentNode.leftChild);
                }
            }
            out.print(result + "\n");

        }
    }

    private static class FastScanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner(final InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(final String[] arg) {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }
}
