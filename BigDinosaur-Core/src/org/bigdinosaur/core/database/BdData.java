package org.bigdinosaur.core.database;

import java.net.URI;

public abstract class BdData
{
  String datapath;
  URI datapathurl;
  abstract void abAgentControllerInternal();
  abstract void AgentControllerInternalContent();

}
