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
 Boid getBoird();
 BdSpace getBdSpace();
 BdSession getBdSession();
 BdAcl getBdAcl();
 public abstract String getModuleId();
 void ConstructObjectAccess();
 void ConstructObjectBpm();
 void ConstructObjectEcm();
 void ConstructObjectBatch();
 void BridgeBpm();
 void BridgeUI();
 void Process();
 void ProcessState();
 void State();
 void WorkFlow();
 void WorkFlowState();
 void AccessLogInterceptor();
 
 
 // new concept 
 //Object move into mature stage from child stage.Form goes on improving till reaches mature state .
 // Similar to evolution of human specifies that is gradually going on from one from to another with certain improvement.
 //Concept is similar to Production of Vehicles that goes into different assembly line for construction of complete Vehilce .
 //OOP power resemble i to Production lines 
 Object ConstructObjectIterateObjectGrowth(Object growth);
 Class ConstructObjectIterateClassGrowth(Class growth);
  void getBusinessType();
  void getBusiness();
  void getBusinessPackages(String businesstype);
  void getModulesList(String businesspackage);
  void getModule(String programid);
  void BdDynamicObject();
  void BdMaster();
  void BdmasterLinkSlaveStation();
  void  BdPlaceholderEvent();
  void BdSlave();
  void BdStaticObject();
  void BdThreeWayCommunication();
  void BdTwoWayCommunication();
  void  BigDinosaurObject();
  void   CommonObjectModel();
  void InsfractureProvider();
  void  MainStationControlEngine();
  void  ObjectInformationResolutionDescriptor();
  void  StationJVM();
  void TimerBindToClusterComponent();
 
 
 

}
