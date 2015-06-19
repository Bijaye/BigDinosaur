package com.bigdinosaur.core.io;

import java.io.FileReader;
import java.io.InputStream;

public interface BdInput
{
  BdRead readByte(InputStream stream);
  BdRead readCharacter(FileReader stream);
}

