import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.net.NetworkInterface;
import java.io.*;
import java.net.*;
import java.util.*;

public class Serveur {
  public static void main(String args[]) {
    int port  = 1099;
    if(args.length==1)
      port = Integer.parseInt(args[0]);
    try {
      Tricount stub = (Tricount)UnicastRemoteObject.exportObject(new TricountImpl(), 0);
      Registry registry = LocateRegistry.getRegistry(port);
      if(!Arrays.asList(registry.list()).contains("Tricountdesfamilles"))
          registry.bind("Tricountdesfamilles", stub);
      else
          registry.rebind("Tricountdesfamilles", stub);
      System.out.println("Serveur lancé sous le nom Tricountdesfamilles");
      for (
          final Enumeration< NetworkInterface > interfaces =
              NetworkInterface.getNetworkInterfaces( );
          interfaces.hasMoreElements( );
      )
      {
          final NetworkInterface cur = interfaces.nextElement( );

          if ( cur.isLoopback( ) )
          {
              continue;
          }

          for ( final InterfaceAddress addr : cur.getInterfaceAddresses( ) )
          {
              final InetAddress inet_addr = addr.getAddress( );

              if ( !( inet_addr instanceof Inet4Address ) )
              {
                  continue;
              }

              System.out.println(
                  "Address IP: " + inet_addr.getHostAddress( )
              );
          }
      }

    } catch (Exception e) {
      System.out.println(e);
    }
  }
}