import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    @Test
    public void testInsert(){
        BinarySearchTree tree = new BinarySearchTree();
        Album album = new Album(1, "RedHotChilliPeppers", "Californication", 15);
        Album album1 = new Album(2, "Post Malone", "Austin", 18);
        Album album2 = new Album(3, "Nirvana", "Nevermind", 12);
        tree.insert(album.songs);
        tree.insert(album1.songs);
        tree.insert(album2.songs);

        assertEquals(15, tree.root.data); // test to make sure root is 15
        assertEquals(12, tree.root.left.data); // test to make sure left chiuld is 12
        assertEquals(18, tree.root.right.data); // test to make sure right child is 18
        assertEquals(null, tree.root.left.left); // test to make sure left child has no children
    }

    @Test
    public void testDelete(){
        BinarySearchTree tree = new BinarySearchTree();
        Album album = new Album(1, "RedHotChilliPeppers", "Californication", 15);
        Album album1 = new Album(2, "Post Malone", "Austin", 18);
        Album album2 = new Album(3, "Nirvana", "Nevermind", 12);
        Album album3 = new Album(4, "Bon Jovi", "Bon Jovi", 9);
        Album album4 = new Album(5, "Greenday", "Father of All", 13);
        tree.insert(album.songs);
        tree.insert(album1.songs);
        tree.insert(album2.songs);
        tree.insert(album3.songs);
        tree.insert(album4.songs);

        tree.delete(tree.root.left, 12);
        assertEquals(13, tree.root.left.data);
        assertEquals(null, tree.root.left.right.data);
        assertEquals(9, tree.root.left.left.data);
        tree.delete(tree.root.right, 18);
        assertEquals(null, tree.root.right.data);
    }


}