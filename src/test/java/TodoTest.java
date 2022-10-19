import org.example.Todo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TodoTest {
    @Test
    public void testThatListIsEmpty(){
        Todo todoList= new Todo();
        Assert.assertEquals(todoList.getTodos().size(), 0);
    }

    @Test
    public void testAddOneItem(){
        Todo todoList= new Todo();
        todoList.addItem("Item1");
        Assert.assertEquals(todoList.getTodos().size(), 1);
    }

    @Test
    public void testThatTheAddedItemIsExist(){
        String Item= "Item100000000";
        Todo todoList= new Todo();
        todoList.addItem(Item);
        Assert.assertTrue(todoList.getTodos().contains(Item));
    }



}
