package jp.itohiro.playground.jcip;

import net.jcip.annotations.Immutable;

/**
 * Created by hiroshi on 12/27/15.
 */
@Immutable
public class MarkMutableClassImmutable {
    //This will be warned without "final" when running FindBugs
    private final String state;

    public MarkMutableClassImmutable(String state) {
        this.state = state;
    }

    //After "final" is added, the class cannot have a method that mutates state
//    public void mutateState(String state){
//        this.state = state;
//    }
}
