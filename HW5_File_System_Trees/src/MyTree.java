import javax.crypto.spec.DESedeKeySpec;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.*;
import java.util.*;


/**
 * MyTree class creates a tree from the file and provides some methods to search, move and view the tree
 */
public class MyTree {
    private JFrame frame;
    private JTree tree;

    private DefaultMutableTreeNode root;
    private int step = 1; //Since I use a recursive algorithm in the DFS and PostOrderTraversal method, I had to keep a step variable to indicate the number of steps.
    /**
     * Constructor for objects of class MyTree
     * Reads the file and creates the tree
     */
    public MyTree()
    {
        //Reads the file with readFile method and creates the tree

        //Reads the file
        ArrayList<String []> allData = new ArrayList<String []>();
        try {
            allData = readFile();
        } catch (IOException e) {
            System.out.println("File not found, object not created");
            return;
        }

        //Creates the tree

        root = new DefaultMutableTreeNode("Root");
        JTree tree = new JTree(root);
        DefaultMutableTreeNode temp_root = root;
        int equalityControl = 0;
        for(int i = 0;i<allData.size();i++)
        {
            for(int j = 0;j< allData.get(i).length;j++)
            {
                equalityControl = equalityControl(temp_root, allData.get(i)[j]);
                if(equalityControl == -1) //Means that the datum is not found in the tree
                {
                    //Add the datum to the tree and set the temp_root to the new node
                    DefaultMutableTreeNode new_node = new DefaultMutableTreeNode(allData.get(i)[j]);
                    temp_root.add(new_node);
                    temp_root = new_node;
                }
                else
                {
                    //Go to the child that is equal to the datum
                    temp_root = (DefaultMutableTreeNode) temp_root.getChildAt(equalityControl);
                }
            }
            temp_root = root;
        }
        viewTree();
    }

    /**
     * Reads the file and returns an arraylist that conrains all words in the file
     * @return
     * @throws IOException
     */

    private ArrayList<String[]> readFile() throws IOException //reads file and returns a string array that contains each line of the file
    {
        File file = new File("tree.txt");
        FileReader filereader = new FileReader(file);
        BufferedReader bufferedreader = new BufferedReader(filereader); //buffering characters to provide for the efficient reading of characters, arrays, and lines.
        ArrayList<String[]> lines = new ArrayList<String[]>();
        String line = null;
        String [] lineArray = null; //contains the words in a line
        while ((line = bufferedreader.readLine()) != null) //reads the file line by line
        {
            lineArray = line.split(";");    //splits the line into words
            lines.add(lineArray);                 //adds the line to the arraylist
        }
        bufferedreader.close(); //closes the file
        return lines;
    }

    /**
     * Checks which child is equal to the datum, returns the index of child if it is found, else returns -1 to indicate that the datum is not found
     * If the datum is found, new node is not be addedto the tree
     * @return
     */
    private int equalityControl(DefaultMutableTreeNode parent_node, String datum)/*Like saying, "Are you my child?"*/
    {
        DefaultMutableTreeNode child_node = new DefaultMutableTreeNode(datum);
        int childcount = parent_node.getChildCount();
        for(int i = 0;i<childcount;i++)
        {
            if(parent_node.getChildAt(i).toString().equals(child_node.toString()))
                return i;
        }
        return -1;
    }

    /**
     * Method to call the BFS method with root node
     * @param datum
     * @return
     */

    public DefaultMutableTreeNode BFS(String datum)
    {
        return BFS(root, datum);
    }

    /**
     * Breadth First Search
     * @param datum datum to be searched
     */
    private DefaultMutableTreeNode BFS(DefaultMutableTreeNode temp_node, String datum)
    {
        int step = 1;
        Queue<DefaultMutableTreeNode> queue = new LinkedList<DefaultMutableTreeNode>();
        queue.add(temp_node);
        while(!queue.isEmpty())
        {
            temp_node = queue.poll();
            System.out.println("Step " + step + ": " + temp_node.toString());
            step++;
            if(temp_node.toString().equals(datum))
            {
                System.out.println("Found");
                return temp_node;
            }
            int childnum = temp_node.getChildCount();
            for(int i = 0;i<childnum;i++)
            {
                queue.add((DefaultMutableTreeNode) temp_node.getChildAt(i));
            }
        }
        System.out.println("Not found");
        return null;
    }

    /**
     * Breadth First Search without printing the steps
     * @param temp_node
     * @param datum
     * @return
     */
    public DefaultMutableTreeNode BFSWithoutSteps(DefaultMutableTreeNode temp_node, String datum)
    {
        Queue<DefaultMutableTreeNode> queue = new LinkedList<DefaultMutableTreeNode>();
        queue.add(temp_node);
        while(!queue.isEmpty())
        {
            temp_node = queue.poll();
            if(temp_node.toString().equals(datum))
            {
                return temp_node;
            }
            int childnum = temp_node.getChildCount();
            for(int i = 0;i<childnum;i++)
            {
                queue.add((DefaultMutableTreeNode) temp_node.getChildAt(i));
            }
        }
        return null;
    }

    /**
     * Depth First Search
     * @param datum datum to be searched
     */
    public void DFS(String datum)
    {
        if(DFS_Rec(root, datum) == false)
            System.out.println("Not found");
        step = 1;
    }

    /**
     * Depth First Search
     * @param node is the root at the beginning, then it is the child of the root
     * @param datum datum to be searched
     * @return
     */
    private boolean DFS_Rec(DefaultMutableTreeNode node, String datum)
    {
        if(node == null)
            return false;
        else
        {
            System.out.println("Step " + step + ": " + node.toString());
            step++;
            if(node.toString().equals(datum))
            {
                System.out.println("Found");
                return true;
            }
            else
            {
                int childnum = node.getChildCount();
                for(int i = childnum-1;i>=0;i--)
                    if(DFS_Rec((DefaultMutableTreeNode) node.getChildAt(i), datum) == true)
                        return true;
            }
        }
        return false;
    }

    /**
     * Post Order Traversal
     * @param datum datum to be searched
     */
    public void PostOrderTraversal(String datum)
    {
        if(PostOrderTraversalRec(root, datum) == false)
            System.out.println("Not found");
        step = 1;
    }
    private boolean PostOrderTraversalRec(DefaultMutableTreeNode node, String datum)
    {
        if(node == null)
            return false;
        else
        {
            int childnum = node.getChildCount();
            if(childnum != 0)
            {
                for(int i = 0;i<childnum;i++)
                    if(PostOrderTraversalRec((DefaultMutableTreeNode) node.getChildAt(i), datum) == true)
                        return true;
            }
            if(node.toString().equals(datum))
            {
                System.out.println("Step " + step + ": " + node.toString());
                System.out.println("Found");
                return true;
            }
            System.out.println("Step " + step + ": " + node.toString());
            step++;
        }
        return false;
    }
    /**
     * Searches the node with the given path
     * @param path
     * @return
     */
    public DefaultMutableTreeNode searchNodeWithPath(String path)
    {
        String [] pathArray = path.split(",");
        DefaultMutableTreeNode temp_node = root;
        for(int i = 0;i<pathArray.length;i++)
        {
            temp_node = BFSWithoutSteps((DefaultMutableTreeNode) temp_node, pathArray[i]);
            if(temp_node == null)
                return null;
        }
        return temp_node;
    }

    /**
     * Moves a node to a new parent
     * @param NodePath
     * @param newParentPath
     */
    public void MoveNode(String NodePath, String newParentPath)
    {
        DefaultMutableTreeNode toMove = searchNodeWithPath(NodePath); //Node to be moved
        DefaultMutableTreeNode toWhere = searchNodeWithPath(newParentPath); //New parent of the node
        if(toMove == null) //If node is not found
        {
            System.out.println("ERROR : Node not found. Path can be wrong.");
            return;
        }
        if(toWhere == null) //If new parent is not found create new one
        {
            toWhere = new DefaultMutableTreeNode(newParentPath);
            root.add(toWhere);
        }
        if(toMove.getParent().equals(toWhere)) //If the node is already a child of the new parent
        {
            System.out.println("ERROR : Node is already a child of the new parent.");
            viewTree();
            return;
        }
        if(toMove.equals(root)) //If the node is the root
        {
            System.out.println("ERROR : Root cannot be moved.");
            viewTree();
            return;
        }
        addNode(toMove, toWhere);
        viewTree();

    }

    /**
     * removes a node from the tree
     * @param toRemove
     */
    private void removeNode(DefaultMutableTreeNode toRemove)
    {
        DefaultMutableTreeNode toRemoveCopy = toRemove;
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) toRemove.getParent();

        if(parent.getChildCount() > 1)
        {
            ((DefaultMutableTreeNode) toRemove.getParent()).remove(toRemove);
            return;
        }
        while(parent.getChildCount() == 1)
        {
            parent.remove(toRemove);
            toRemove = parent;
            parent = (DefaultMutableTreeNode) toRemove.getParent();
        }
        parent.remove(toRemove);
        toRemove = toRemoveCopy;
    }

    /**
     * Adds a node to the tree
     * @param toAdd
     * @param toWhere
     */
    private void addNode(DefaultMutableTreeNode toAdd, DefaultMutableTreeNode toWhere)
    {
        // We will add upper path of the node we are going to move to stack (because it is upside down)
        DefaultMutableTreeNode copyToAdd = toAdd;
        Stack<DefaultMutableTreeNode> stack = new Stack<DefaultMutableTreeNode>();
        while(!toAdd.getParent().equals(root)) /*Adds upper path in a stack*/
        {
            stack.push((DefaultMutableTreeNode) toAdd.getParent());
            toAdd = (DefaultMutableTreeNode) toAdd.getParent();
        }
        toAdd = copyToAdd; //reseting toAdd to the original value
        //We will stored all the element that we are going to move so we can now remove this node and continue
        removeNode(toAdd);

        //our steps are in stack(stack) and queue(elements), now we can add the node
        //We will traverse all tree again to add our path (which is stored stack + queue in order)
        int equalityControl = -1; //This flag is used to check if stack and pop is empty or not
        DefaultMutableTreeNode steps;
        stack.pop(); //Pop the subtree (years)
        while(!stack.isEmpty())
        {
            steps = stack.pop();
            equalityControl = equalityControl(toWhere, steps.toString());
            if (steps != null && equalityControl == -1) //is steps the child of toWhere? if yes, which index?
            {
                toWhere.add(new DefaultMutableTreeNode(steps.toString()));
                equalityControl = equalityControl(toWhere, steps.toString());
                toWhere = (DefaultMutableTreeNode) toWhere.getChildAt(equalityControl);
            }
            else
            {
                toWhere = (DefaultMutableTreeNode) toWhere.getChildAt(equalityControl);
            }
        }
        toWhere.add(toAdd);
    }

    /**
     * Views the tree
     */
    public void viewTree()
    {
        frame = new JFrame();
        JTree newTree = new JTree(root);
        frame.add(newTree);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

}
