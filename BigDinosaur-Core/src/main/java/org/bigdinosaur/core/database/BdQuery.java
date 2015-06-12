package org.bigdinosaur.core.database;

public class BdQuery
{
  // complete pattern of query
String patternquery;
String basebdquery;// this field Narrow down searching criteria 

String middlebdquery;// this field Narrow down searching criteria 

String endbdquery;// this field Narrow down searching criteria 

public String getPatternquery()
{
  return patternquery;
}

public String getBasebdquery()
{
  return basebdquery;
}

public String getMiddlebdquery()
{
  return middlebdquery;
}

public String getEndbdquery()
{
  return endbdquery;
}

public void setPatternquery(String patternquery)
{
  this.patternquery = patternquery;
}

public void setBasebdquery(String basebdquery)
{
  this.basebdquery = basebdquery;
}

public void setMiddlebdquery(String middlebdquery)
{
  this.middlebdquery = middlebdquery;
}

public void setEndbdquery(String endbdquery)
{
  this.endbdquery = endbdquery;
}

// example I
//it implies search local file system all file directories
//local:file

//example II
//it implies search local file system all file directories with history data.History data 
// is the type of data 
//local:file:historyDb
}
