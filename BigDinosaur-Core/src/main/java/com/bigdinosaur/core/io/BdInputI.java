package com.bigdinosaur.core.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BdInputI
    implements BdInput
{

  @Override
  public BdRead readByte(InputStream stream)
  {
    BdRead bddata = new BdRead();
    List<BdRead> readdata = new ArrayList<BdRead>();
    int datai;
    try
    {
      while ((datai = stream.read()) != -1)
      {
        BdRead data = new BdRead();
        data.setI(datai);
        readdata.add(data);
      }
      bddata.setReaddata(readdata);
    }
    catch (IOException e)
    {
    }
    return bddata;
  }

  @Override
  public BdRead readCharacter(FileReader stream)
  {
    BdRead bddata = new BdRead();
    List<BdRead> readdata = new ArrayList<BdRead>();
    int datai;
    try
    {
      while ((datai = stream.read()) != -1)
      {
        BdRead data = new BdRead();
        data.setI(datai);
        readdata.add(data);
      }
      bddata.setReaddata(readdata);
    }
    catch (IOException e)
    {
    }
    return bddata;
  }

}
