package org.bd.core.fs.contract;


import com.bigdinosaur.config.BdConfiguration;





public class TestLocalFSContractSeek extends AbstractContractSeekTest {

  @Override
  protected AbstractFSContract createContract(BdConfiguration conf) {
    return new LocalFSContract(conf);
  }
}
