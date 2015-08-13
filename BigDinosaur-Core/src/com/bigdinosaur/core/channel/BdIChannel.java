package com.bigdinosaur.core.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class BdIChannel
{

 public  Object createServer(int port) throws IOException
  {
    try
    {
      Selector selector = Initialize();

      System.out.println("Waiting for client connections...");

      int amountToProcess = 0;
      while (true)
      {
        amountToProcess = selector.selectNow();

        if (amountToProcess > 0)
        {
          try
          {
            Set keys = selector.selectedKeys();

            Iterator iterator = keys.iterator();

            while (iterator.hasNext())
            {
              SelectionKey selectionKey = (SelectionKey) iterator.next();
              iterator.remove(); // remove the key

              int operation = selectionKey.interestOps();

              performOperation(selector, selectionKey, operation);
            }
          }
          catch (IOException e)
          {
            System.out.println(e);
          }
        }
      }
    }
    catch (IOException e)
    {
      System.out.println(e);
    }
    return port;

  }

  private void performOperation(Selector selector, SelectionKey selectionKey, int operation)
                                                                                            throws IOException,
                                                                                            ClosedChannelException
  {
    if ((SelectionKey.OP_ACCEPT & operation) != 0)
    {
      connectClient(selector, selectionKey);

    }
    else if ((SelectionKey.OP_READ & operation) != 0)
    {
      readFromClient(selectionKey);
    }
    else if ((SelectionKey.OP_WRITE & operation) != 0)
    {
      // Attempt to write...

      writeToClient(selector, selectionKey);

    }
  }

  private void writeToClient(Selector selector, SelectionKey selectionKey)
                                                                          throws ClosedChannelException,
                                                                          IOException
  {
    System.out.println("Now going to  write to client...");

    SocketChannel socket = (SocketChannel) selectionKey.channel();

    socket.register(selector, SelectionKey.OP_READ);

    String stringToSend = "This is a  message";

    int length = stringToSend.length() * 2;

    ByteBuffer lengthInBytes = ByteBuffer.allocate(4);
    // 4 = size of a 'int'
    ByteBuffer dataToSend = ByteBuffer.allocate(length);

    lengthInBytes.putInt(length);
    lengthInBytes.rewind();
    dataToSend.asCharBuffer().put(stringToSend);

    ByteBuffer sendArray[] = {
        lengthInBytes, dataToSend
    };

    socket.write(sendArray);
    // socket.close();
    System.out.println("Sent Message to Client...");
  }

  private void readFromClient(SelectionKey selectionKey) throws IOException
  {
    // Attempt to read...
    System.out.println("About to read  from client...");

    SocketChannel socket = (SocketChannel) selectionKey.channel();

    // get the message from the client...
    ByteBuffer incomingLengthInBytes = ByteBuffer.allocate(4);
    // size of an 'int'
    socket.read(incomingLengthInBytes);
    incomingLengthInBytes.rewind();
    int incomingLength = incomingLengthInBytes.getInt();
    System.out.println("Got Incoming Length as: " + incomingLength + "    bytes");

    // now allocate the correct size for
    // the message...
    ByteBuffer incomingData = ByteBuffer.allocate(incomingLength);
    socket.read(incomingData);
    incomingData.rewind();
    String string = incomingData.asCharBuffer().toString();

    // Finally print received message...
    System.out.println("Received:  " + string);

    // terminate the connection...
    socket.close();
  }

  private void connectClient(Selector selector, SelectionKey selectionKey) throws IOException,
                                                                          ClosedChannelException
  {
    // Accept the connection...
    ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
    SocketChannel socket = channel.accept();
    socket.configureBlocking(false);

    // register for a writing operation
    socket.register(selector, SelectionKey.OP_WRITE);

    System.out.println("Client Connected...");
  }

  private Selector Initialize() throws IOException, ClosedChannelException
  {
    Selector selector = Selector.open();

    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
    serverSocketChannel.configureBlocking(false);

    ServerSocket serverSocket = serverSocketChannel.socket();

    serverSocket.bind(new InetSocketAddress(9000));

    System.out.println("Non-blocking Server created on port  9000");

    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    return selector;
  }
}
