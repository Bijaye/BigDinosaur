package com.base.bigdinosaur.batch;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassGenericImpl {
	public static Object createGenericProgram(String programPath, String mode)
			throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		Object object;
		Class<?> c;
		c = Class.forName(programPath);
		Constructor<?> m = c.getConstructor(String.class, String.class);
		object = (Object) m.newInstance(programPath, mode);
		return object;
	}

}
