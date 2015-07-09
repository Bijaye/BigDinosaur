package com.easy.base.cache;

import com.base.bigdinosaur.core.Cachable;



public interface FieldNameCache
{

    public abstract void fetchByComponent(Cachable component);

    public abstract void fetchByComponent(Cachable component, boolean flag);

    
}

