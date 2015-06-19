package com.bigdinosaur.core.io;

import java.io.InputStream;

public interface BdInput
{
  BdRead read(InputStream stream);
}

