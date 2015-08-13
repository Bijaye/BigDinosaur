package org.bigdinosaur.core.database;

import java.util.ArrayList;

public class BdMasterI
{
  String mastername;
  private ArrayList<BdSlave> slavelist=new ArrayList<BdSlave>();
  private ArrayList<BdData> datatobeprocessed=new ArrayList<BdData>();
  int noofworkers;

}
