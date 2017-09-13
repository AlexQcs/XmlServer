import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by alex on 2017/8/14.
 */
public class test {
    public static void main(String[] args) {
        List<FatherClass> list = new ArrayList<>();
        FatherClass a = new FatherClass();
        a.setmFatherAge(5);
        FatherClass b = new FatherClass();
        b.setmFatherAge(1);
        FatherClass c = new FatherClass();
        c.setmFatherAge(78);
        FatherClass d = new FatherClass();
        d.setmFatherAge(45);
        FatherClass f = new FatherClass();
        f.setmFatherAge(45);

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(f);

        for (FatherClass fatherClass : list) {
            System.out.println("排序前"+fatherClass.getmFatherAge());
        }

        Collections.sort(list);
        for (FatherClass fatherClass : list) {
            System.out.println("排序后"+fatherClass.getmFatherAge());
        }
    }
}
