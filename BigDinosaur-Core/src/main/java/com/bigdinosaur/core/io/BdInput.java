package com.bigdinosaur.core.io;

import java.io.FileReader;
import java.io.InputStream;

import org.bigdinosaur.core.database.BdMap;

public interface BdInput
{
  BdRead readByte(InputStream stream);
  BdRead readCharacter(FileReader stream);
  BdRead readString(BdMap mp);
}

