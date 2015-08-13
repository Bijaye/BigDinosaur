package com.bigdinosaur.base.client.basecomponent;





import com.bigdinosaur.base.client.ui.request.UiobjectRequest;

public interface ComponentParts
{

    public abstract String getInternalValue();

    public abstract void setErrorStyle(boolean flag);

    public abstract UiobjectRequest getRootUi();

   
}


