package org.bigdinosaur.core.database;

public class BdQuery
{
  // complete pattern of query
String patternquery;
String basebdquery;// this field Narrow down searching criteria 

String moddlebdquery;// this field Narrow down searching criteria 

String endbdquery;// this field Narrow down searching criteria 

// example I
//it implies search local file system all file directories
//local:file

//example II
//it implies search local file system all file directories with history data.History data 
// is the type of data 
//local:file:historyDb
}
