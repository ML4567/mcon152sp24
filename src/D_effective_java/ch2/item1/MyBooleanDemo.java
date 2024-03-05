package D_effective_java.ch2.item1;

import java.util.Objects;

// mimics java.lang.Boolean
class MyBoolean {
    private boolean value;
    private static final MyBoolean TRUE = new MyBoolean(true),
                                   FALSE = new MyBoolean(false);

    private MyBoolean(boolean value) {
        this.value = value;
    }

    public static MyBoolean valueOf(boolean value) {
        // return new MyBoolean(value);
        return value ? TRUE : FALSE;
    }
}

public class MyBooleanDemo {
    public static void main(String[] args) {
        // we don't want this to create four different objects
        MyBoolean[] myBooleans = {
                MyBoolean.valueOf(true),
                MyBoolean.valueOf(true),
                MyBoolean.valueOf(false),
                MyBoolean.valueOf(true)
        };

        MyBoolean b1 = MyBoolean.valueOf(true);
        MyBoolean b2 = MyBoolean.valueOf(true);
        System.out.println(b1 == b2); // true
    }
}
