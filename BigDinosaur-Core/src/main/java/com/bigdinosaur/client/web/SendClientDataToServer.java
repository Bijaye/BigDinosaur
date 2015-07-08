package com.bigdinosaur.client.web;

import java.io.DataOutputStream;
import java.io.IOException;

public class SendClientDataToServer
{
  void writeClientDataToServer(DataOutputStream data, String input) throws IOException
  {
    data.writeUTF(input.toString());
  }
}
