package org.bigdinosaur.core.database;

import java.util.List;

public interface BdContent
{

  BdContent QueryVersionHistory();
  BdContent  getQueryContentRepo();
  void setQueryContentRepo(BdContent content);
  BdContent getQueryContentRepoList();
  BdContent getContent();
  void setContent(BdContent content);
  BdContent getContentList();
  void setContentList(List<BdContent> content);
  BdContent getContentListQuery();
  void setContentListQuery(BdContent repo);
  BdContent getContentversioning();
  BdContent getContentversioningHistory();
  BdContent getContentversioningListHistory(BdContent history);
  BdContent  RepoVersioning();
  void setVersionNo();
  void setCurrentTime();
  void SetCurrentDate();
  void setLockNo();
  public  boolean isCheckedOut(Object object) throws Exception;
  public  boolean isCheckedIn(Object object) throws Exception;
  void pull();
  void push();
  void commit();
  BdContent CreateBranch();
  BdContent Tag();
  BdContent ListHistoryInformationContainer();
  BdContent Branch();
}
