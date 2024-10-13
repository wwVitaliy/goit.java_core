package module6.anonymousClasses;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnonymousReflection {


    public static void main(String[] args){

        //anonymous inner class with method defined inside which
        //does not override anything
        Object o = new Object()
        {
            public int test = 5;
            public void sayHello()
            {
                System.out.println("Hello World");
            }
        };

        //o.sayHello();//Does not work

        try
        {
            Method m = o.getClass().getMethod("sayHello");
            Field f = o.getClass().getField("test");
            System.out.println(f.getInt(o));
            m.invoke(o);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
