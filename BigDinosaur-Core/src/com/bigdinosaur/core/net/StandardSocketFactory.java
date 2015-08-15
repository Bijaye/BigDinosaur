package com.bigdinosaur.core.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;

import javax.net.SocketFactory;
public class StandardSocketFactory extends SocketFactory {

  
  public StandardSocketFactory() {
  }

  @Override
  public Socket createSocket() throws IOException {

    return SocketChannel.open().socket();
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
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    return obj.getClass().equals(this.getClass());
  }

  @Override
  public int hashCode() {
    return this.getClass().hashCode();
  }

}
