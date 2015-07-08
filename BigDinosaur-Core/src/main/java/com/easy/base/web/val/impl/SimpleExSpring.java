package com.easy.base.web.val.impl;


import org.springmodules.validation.util.condition.Condition;

public class SimpleExSpring
{

            private SimpleExSpring()
            {
            }

            public static Condition I18nImpl(int maxByteLength)
            {
       return new I18nImpl();
            }

            public static Condition EmptyImpl()
            {
       return new EmptyImpl();
            }

            public static Condition ObjectValImpl()
            {
       return new ObjectValImpl();
            }

}