package com.bigdinosaur.core.io;

import java.io.OutputStream;

public interface BdWrite
{
  BdRead write(OutputStream stream,BdRead data);
}

