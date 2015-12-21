package jp.itohiro.playground.gsc;

import com.gs.collections.api.bag.MutableBag;
import com.gs.collections.api.bag.primitive.MutableCharBag;
import com.gs.collections.api.list.MutableList;
import com.gs.collections.api.map.MutableMap;
import com.gs.collections.impl.block.factory.Functions0;
import com.gs.collections.impl.factory.Lists;
import com.gs.collections.impl.string.immutable.CharAdapter;
import com.gs.collections.impl.string.immutable.CodePointAdapter;
import com.gs.collections.impl.string.immutable.CodePointList;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by hiroshi on 12/14/15.
 */
public class GsCollectionsTest {

    @Test
    public void testGSC(){
        CodePointAdapter adapter = CodePointAdapter.adapt("\uD840\uDC00");
        CodePointList codePointList = CodePointList.from("基本多言語面(BMP means Basic Multilingual Pane.)");

        CharAdapter charAdapter = CharAdapter.adapt("This is a text to test CharAdapter");
        MutableCharBag charBag = charAdapter.toBag();
        System.out.println(charBag.occurrencesOf('t'));
        System.out.println(charAdapter.collectChar(c -> c==' ' ? ',' : c));

        System.out.println(adapter.reject(Character::isBmpCodePoint));
        System.out.println(codePointList.reject(Character::isIdeographic));
    }

    @Test
    public void groupBy()
    {
        MutableList<Emp> empList = Lists.mutable.empty();
        MutableMap<Dept, Integer> moreThan1000Sal
                = empList.aggregateBy(
                Emp::getDept,
                Functions0.zeroInteger(),
                (count, emp) -> emp.getSalary() > 1000 ? count + 1 : count);

        MutableBag<Dept> howManyEmpMoreThan1000InTheDept = empList.asLazy()
                .select(emp -> emp.sal > 1000)
                .collect(Emp::getDept)
                .toBag();


    }

    Map<Dept, Long> groupByDeptAndFilter1(List<Emp> list) {
        return list.stream()
                .collect(Collectors.groupingBy(emp -> emp.dept, Collectors.collectingAndThen(Collectors.toList(),
                        emps -> emps.stream()
                                .filter(e -> e.sal > 1000)
                                .count())));
    }

    private class Dept {
        String name;
    }

    private class Emp {
        public Dept dept;
        public int sal;

        public int getSalary() {
            return sal;
        }

        public Dept getDept() {
            return dept;
        }
    }
}
