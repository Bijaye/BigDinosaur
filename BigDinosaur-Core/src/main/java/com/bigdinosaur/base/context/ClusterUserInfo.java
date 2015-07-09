package com.bigdinosaur.base.context;



import java.io.Serializable;


public class ClusterUserInfo
    implements ClusterInfo, Serializable
{

            public ClusterUserInfo()
            {
     
  }

  public String getUsrId()
  {
      return usrId;
  }

  public void setUsrId(String usrId)
  {
      this.usrId = usrId;
  }

  public String getUsrNm()
  {
      return usrNm;
  }

  public void setUsrNm(String usrNm)
  {
      this.usrNm = usrNm;
  }

            private String usrId;
            private String usrNm;
			@Override
			public String getClusterId() {
				// TODO Auto-generated method stub
				return null;
			}

			
			@Override
			public String getClusterHardWareInfo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getClusterServerStatus() {
				// TODO Auto-generated method stub
				return null;
			}
}


