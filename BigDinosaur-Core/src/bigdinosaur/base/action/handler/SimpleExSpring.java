package bigdinosaur.base.action.handler;


import java.util.concurrent.locks.Condition;

public class SimpleExSpring
{

            private SimpleExSpring()
            {
            }

            public static Condition I18nImpl(int maxByteLength)
            {
       return (Condition) new I18nImpl();
            }

            public static Condition EmptyImpl()
            {
       return (Condition) new EmptyImpl();
            }

            public static Condition ObjectValImpl()
            {
       return (Condition) new ObjectValImpl();
            }

}