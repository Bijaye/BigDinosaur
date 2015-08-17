package com.bigdinosaur.core.common;




import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Base class for producing the Socket objects used by BdDB.
 *
 * 
 */
public class BdSocketFactory {

// ----------------------------- static members ---------------------------------
    private static BdSocketFactory plainImpl;
    private static BdSocketFactory sslImpl;

// ------------------------------ constructors ---------------------------------

    protected BdSocketFactory() throws Exception {}

// ------------------------- factory builder method ----------------------------

    /**
     * Retrieves an BdSocketFactory whose subclass and attributes are
     * determined by the specified argument, tls.
     *
     * @param tls whether to retrieve a factory producing SSL sockets
     * @throws Exception if the new factory cannot be constructed or is
     *      of the wrong type
     * @return a new factory
     */
    public static BdSocketFactory getInstance(boolean tls) throws Exception {
        return tls ? getSSLImpl()
                   : getPlainImpl();
    }

// -------------------------- public instance methods --------------------------
    public void configureSocket(Socket socket) {

        // default: do nothing
    }

    /**
     * Returns a server socket bound to the specified port.
     * The socket is configured with the socket options
     * given to this factory.
     *
     * @return the ServerSocket
     * @param port the port to which to bind the ServerSocket
     * @throws Exception if a network error occurs
     */
    public ServerSocket createServerSocket(int port) throws Exception {
        return new ServerSocket(port);
    }

    /**
     * Returns a server socket bound to the specified port.
     * The socket is configured with the socket options
     * given to this factory.
     *
     * @return the ServerSocket
     * @param port the port to which to bind the ServerSocket
     * @throws Exception if a network error occurs
     */
    public ServerSocket createServerSocket(int port,
                                           String address) throws Exception {
        return new ServerSocket(port, 128, InetAddress.getByName(address));
    }

    /**
     * If socket argument is not null, returns it. If it is null,
     * reates a socket and connects it to the specified remote host at the
     * specified remote port. This socket is configured using the socket options
     * established for this factory.
     *
     * @return the socket
     * @param socket the existing socket, can be null
     * @param host the server host
     * @param port the server port
     * @throws Exception if a network error occurs
     */
    public Socket createSocket(Socket socket, String host,
                               int port) throws Exception {
        return socket == null ? new Socket(host, port)
                              : socket;
    }

    /**
     * Creates a socket and connects it to the specified remote host at the
     * specified remote port. This socket is configured using the socket options
     * established for this factory.
     *
     * @return the socket
     * @param host the server host
     * @param port the server port
     * @throws Exception if a network error occurs
     */
    public Socket createSocket(String host, int port) throws Exception {
        return new Socket(host, port);
    }

    /**
     * Retrieves whether this factory produces secure sockets.
     *
     * @return true if this factory produces secure sockets
     */
    public boolean isSecure() {
        return false;
    }

// ------------------------ static utility methods -----------------------------
    private static BdSocketFactory getPlainImpl() throws Exception {

        synchronized (BdSocketFactory.class) {
            if (plainImpl == null) {
                plainImpl = new BdSocketFactory();
            }
        }

        return plainImpl;
    }

    private static BdSocketFactory getSSLImpl() throws Exception {

        synchronized (BdSocketFactory.class) {
            if (sslImpl == null) {
                sslImpl =
                    newFactory("org.Bddb.server.BdSocketFactorySecure");
            }
        }

        return sslImpl;
    }

    /**
     * Retrieves a new BdSocketFactory whose class
     * is determined by the implClass argument. The basic contract here
     * is that implementations constructed by this method should return
     * true upon calling isSecure() iff they actually create secure sockets.
     * There is no way to guarantee this directly here, so it is simply
     * trusted that an  implementation is secure if it returns true
     * for calls to isSecure();
     *
     * @return a new secure socket factory
     * @param implClass the fully qaulified name of the desired
     *      class to construct
     * @throws Exception if a new secure socket factory cannot
     *      be constructed
     */
    private static BdSocketFactory newFactory(String implClass)
    throws Exception {

        Class       clazz;
        Constructor ctor;
        Class[]     ctorParm;
        Object[]    ctorArg;
        Object      factory;

        clazz    = Class.forName(implClass);
        ctorParm = new Class[0];

        // protected constructor
        ctor    = clazz.getDeclaredConstructor(ctorParm);
        ctorArg = new Object[0];

        try {
            factory = ctor.newInstance(ctorArg);
        } catch (InvocationTargetException e) {
            Throwable t = e.getTargetException();

            throw (t instanceof Exception) ? ((Exception) t)
                                           : new RuntimeException(
                                               t.toString());
        }

        return (BdSocketFactory) factory;
    }

// --
}
