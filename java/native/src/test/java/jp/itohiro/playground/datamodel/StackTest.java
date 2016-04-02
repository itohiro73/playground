package jp.itohiro.playground.datamodel;

import org.junit.Test;
import org.testng.Assert;

public class StackTest {
    @Test
    public void stack(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(1);
        stack.push(3);
        Assert.assertEquals(3, (int)stack.pop());
        Assert.assertEquals(1, (int)stack.pop());
        Assert.assertEquals(2, (int)stack.pop());
        Assert.assertEquals(1, (int)stack.pop());
    }
}
