package com.bigdinosaur.cluster.data.log;

//collecting, aggregating and moving large amounts of log data. 
//Its main goal is to deliver data from applications to the BDFS(BigDinosaurFileSystem)

public interface Bdlogetl
{
  void deleteLogInSuccess();

  void deleteSuccessDBOnly();

  void resetContext();
  void log();


}
