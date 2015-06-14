package org.bigdinosaur.core.database;

public interface BdClient
{
Object readFiles();
Object readBlocks();
Object createBlock();
Object deleteBlock();
Object replicateBlock();


}
