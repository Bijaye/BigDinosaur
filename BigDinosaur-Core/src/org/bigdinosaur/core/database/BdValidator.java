package org.bigdinosaur.core.database;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import bigdinosaur.base.action.handler.ComponentParts;
import bigdinosaur.base.action.handler.ValidatorTask;


public class BdValidator
{

            public BdValidator()
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

