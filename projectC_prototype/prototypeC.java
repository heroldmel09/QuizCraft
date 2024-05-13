package projectC_prototype;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;

import com.spire.ms.System.Collections.ArrayList;
import java.lang.reflect.Field;


public class prototypeC {
    public int variableName = 50;
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        prototypeC myObject = new prototypeC();
        Class<?> prototypeC = myObject.getClass();
        Field field = prototypeC.getDeclaredField("variableName");
        int value = (int) field.get(myObject);
        System.out.println(value);
    }
}
