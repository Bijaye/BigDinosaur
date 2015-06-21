package com.bigdinosaur.core.io;

public interface BdWritec
{

  public abstract void writeBooleanbd(boolean paramBooleanbd);



  public abstract void writeUnsignedIntegerbd(long paramLongbd);


  public abstract void writeSignedIntegerbd(int paramInt1, int paramInt2);

  public abstract void writeDoublebd(int paramInt, double paramDoublebd);




  public abstract void writeCharacterStringbd(String paramStringbd);

  public abstract void writeEncodedValuebd(byte[] paramArrayOfBytebd);

  public abstract void writeEncodedValuebd(int paramInt, byte[] paramArrayOfBytebd);

  public abstract void writebd(byte[] paramArrayOfBytebd);

}
