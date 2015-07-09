package com.base.bigdinosaur.core.validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.easy.base.client.basecomponent.ComponentParts;
import com.easy.base.client.validator.ValidatorTask;
//Note:Easy Framework has broad sense for validation.Just Validation Does not mean only UI validation
//Validation has broad scope validation can be anything from UI,service,server,database .It makes program,modules ,packages less error free
// providing per checking,post checking 
//Important  every call or every action that happens in JVM ,require validation.For example call to any method ,has lots of common behaviour in common
// so for every event the attribute need a common interface .
// Need more enhancment 

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

