package com.bigdinosaur.bigdata.query;

public interface BdQuery
{

  void QueryAsClient();
  void QueryAsPlatform();
  void QueryAsCluster();
  void QueryAsVirtualFile();
}
