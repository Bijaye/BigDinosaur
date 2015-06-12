package org.bigdinosaur.core.database;

public interface BdCore
{
 boolean canRead(Object o);
 boolean canWrite(Object o);
 Object getAsBdFile(Object o);
 Object getAsBdTableNode(Object o);
 Object getAsBdQuery(Object o);
 Object getAsBdFileRow(Object o);
 // Universal Map scope is Global within the application .Any time can get value from key
 Object AddOnUniversalMap(Object key,Object value);
 BdCore getBdCore();
 Boird getBoird();
 BdSpace getBdSpace();
 BdSession getBdSession();
 
 

}
