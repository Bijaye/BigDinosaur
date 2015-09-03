package com.bigdinosaur.core.net;




import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.SocketFactory;

import com.bigdinosaur.config.Configurable;
import com.bigdinosaur.config.BdConfiguration;








public class BdSocksSocketFactory extends SocketFactory implements
Configurable
     {
  private BdConfiguration conf;

  private Proxy proxy;

  
  public BdSocksSocketFactory() {
    this.proxy = Proxy.NO_PROXY;
  }


  public BdSocksSocketFactory(Proxy proxy) {
    this.proxy = proxy;
  }

  @Override
  public Socket createSocket() throws IOException {

    return new Socket(proxy);
  }

  @Override
  public Socket createSocket(InetAddress addr, int port) throws IOException {

    Socket socket = createSocket();
    socket.connect(new InetSocketAddress(addr, port));
    return socket;
  }

  @Override
  public Socket createSocket(InetAddress addr, int port,
      InetAddress localHostAddr, int localPort) throws IOException {

    Socket socket = createSocket();
    socket.bind(new InetSocketAddress(localHostAddr, localPort));
    socket.connect(new InetSocketAddress(addr, port));
    return socket;
  }

  @Override
  public Socket createSocket(String host, int port) throws IOException,
      UnknownHostException {

    Socket socket = createSocket();
    socket.connect(new InetSocketAddress(host, port));
    return socket;
  }

  @Override
  public Socket createSocket(String host, int port,
      InetAddress localHostAddr, int localPort) throws IOException,
      UnknownHostException {

    Socket socket = createSocket();
    socket.bind(new InetSocketAddress(localHostAddr, localPort));
    socket.connect(new InetSocketAddress(host, port));
    return socket;
  }

  @Override
  public int hashCode() {
    return proxy.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof BdSocksSocketFactory))
      return false;
    final BdSocksSocketFactory other = (BdSocksSocketFactory) obj;
    if (proxy == null) {
      if (other.proxy != null)
        return false;
    } else if (!proxy.equals(other.proxy))
      return false;
    return true;
  }





  private void setProxy(String proxyStr) {
    String[] strs = proxyStr.split(":", 2);
    if (strs.length != 2)
      throw new RuntimeException("Bad SOCKS proxy parameter: " + proxyStr);
    String host = strs[0];
    int port = Integer.parseInt(strs[1]);
    this.proxy =
        new Proxy(Proxy.Type.SOCKS, InetSocketAddress.createUnresolved(host,
            port));
  }
  


  @Override
  public void setConf(BdConfiguration conf) {
    this.conf = conf;
    String proxyStr = conf.get("hadoop.socks.server");
    if ((proxyStr != null) && (proxyStr.length() > 0)) {
      setProxy(proxyStr);
    }
  }




  @Override
  public BdConfiguration getConf()
  {
    // TODO Auto-generated method stub
    return null;
  }
  
}
