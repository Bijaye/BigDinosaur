package com.base.bigdinosaur.core.validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.bigdinosaur.base.client.basecomponent.ComponentParts;
import com.bigdinosaur.base.client.validator.ValidatorTask;

public class ValidatorVerifier
{

            public ValidatorVerifier()
            {
       taskList = new ArrayList();
            }

            public void addValidator(ValidatorTask task)
            {
    taskList.add(task);
}

public List<Collection> validate()
{
	 List<Collection> result=null;
   
    for(Iterator iterator = taskList.iterator(); iterator.hasNext();)
    {
        ValidatorTask task = (ValidatorTask)iterator.next();
        boolean error = false;
        try
        {
        	error = task.validate();
        }
        catch(Exception ex)
        {
        	error = false;
        }
        if(!error)
        {
        	ComponentParts componentparts[];
            int j = (componentparts = task.getFields()).length;
            for(int i = 0; i < j; i++)
            {
            	ComponentParts field = componentparts[i];
                field.setErrorStyle(true);
            }

            // return accumulated result at once for validation.
        }
    }

    
    return result;
}




            private List taskList;
}

