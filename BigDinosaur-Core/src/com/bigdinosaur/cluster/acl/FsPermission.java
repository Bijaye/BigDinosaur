package com.bigdinosaur.cluster.acl;

public class FsPermission
{
  private FsAction useraction = null;
  private FsAction groupaction = null;
  private FsAction otheraction = null;
  private boolean stickyBit = false;
  public static FsPermission getDefault() {
    return new FsPermission((short)00777);
  }
  public FsPermission(short mode) { fromShort(mode); }
  
  public void fromShort(short n) {
    FsAction[] v = FsAction.values();

    set(v[(n >>> 6) & 7], v[(n >>> 3) & 7], v[n & 7], (((n >>> 9) & 1) == 1) );
  }
  
  private void set(FsAction u, FsAction g, FsAction o, boolean sb) {
    useraction = u;
    groupaction = g;
    otheraction = o;
    stickyBit = sb;
  }
  
}
