package SkipGraph;

import java.rmi.RemoteException;
import org.junit.Test;

// SearchNumTest contains the integrated test methods conserning testing the
// SearchNum method of skipnodes
// Each method is by its own a test, in order to add new tests, add new methods.
public class SearchNumTest {

  @Test
  public void SearchNumIDTest1() throws RemoteException {

    // The mock (monitor) node and server ports to be used during this test
    int mockPORT = 2039;
    int serverPORT = 1999;

    // lookupTable which will be feed into the server node
    NodeInfo lookupTable[][] = {
      {
        new NodeInfo("127.0.0.1:" + mockPORT, 13, "10101"),
        new NodeInfo("127.0.0.1:" + mockPORT, 16, "00101")
      },
      {
        new NodeInfo("127.0.0.1:" + mockPORT, 11, "01100"),
        new NodeInfo("127.0.0.1:" + mockPORT, 20, "01110")
      },
      {
        new NodeInfo("127.0.0.1:" + mockPORT, 12, "00001"),
        new NodeInfo("127.0.0.1:" + mockPORT, 19, "00101")
      },
      {
        new NodeInfo("127.0.0.1:" + mockPORT, 13, "00111"),
        new NodeInfo("127.0.0.1:" + mockPORT, 17, "00110")
      },
      {
        new NodeInfo("127.0.0.1:" + mockPORT, 10, "01011"),
        new NodeInfo("127.0.0.1:" + mockPORT, 31, "01001")
      },
      {
        new NodeInfo("127.0.0.1:" + mockPORT, 13, "10101"),
        new NodeInfo("127.0.0.1:" + mockPORT, 16, "00101")
      },
    };

    // a group of test cases which will be ran (test table)
    // arguments:
    // 1. the numID we will ask the server node to search for
    // 2. the expected node that the server node will contact first
    // 3. the level in the skipgraph at which the search is conducted
    SearchTestCase tt[] = {
      new SearchTestCase(40, 31, 4),
      new SearchTestCase(40, 17, 3),
      new SearchTestCase(40, 19, 2),
      new SearchTestCase(40, 20, 1),
      new SearchTestCase(40, 16, 0),
      new SearchTestCase(5, 10, 4),
      new SearchTestCase(5, 13, 3),
      new SearchTestCase(5, 12, 2),
      new SearchTestCase(5, 11, 1),
      new SearchTestCase(5, 13, 0),
      new SearchTestCase(12, 13, 4),
      new SearchTestCase(12, 13, 3),
      new SearchTestCase(12, 12, 2),
      new SearchTestCase(12, 13, 1),
      new SearchTestCase(12, 13, 0),
      new SearchTestCase(20, 17, 4),
      new SearchTestCase(11, 13, 4),
      new SearchTestCase(16, 16, 4),
    };

    // constructing the mock node and starting the tests
    // arguments:
    // 1. test table consisting of SearchNumTestCases
    // 2. lookupTable supplied to the server node
    // 3. port which the server node will use
    // 4. nameID of the server node
    // 5. numID of the server noed
    // 6. port of the mock node (monitor)
    MockSearchNode mock = new MockSearchNode(tt, lookupTable, serverPORT, "01010", 15, mockPORT);
    mock.runTests();
  }

  @Test
  public void SearchNumIDTest2() throws RemoteException {

    int mockPORT = 2139;
    int serverPORT = 1199;

    NodeInfo lookupTable[][] = {
      {
        new NodeInfo("127.0.0.1:" + mockPORT, 14, "01100"),
        new NodeInfo("127.0.0.1:" + mockPORT, 16, "01110")
      },
      {
        new NodeInfo("127.0.0.1:" + mockPORT, 13, "00001"),
        new NodeInfo("127.0.0.1:" + mockPORT, 40, "00101")
      },
      {
        new NodeInfo("127.0.0.1:" + mockPORT, 11, "00111"),
        new NodeInfo("127.0.0.1:" + mockPORT, 27, "00110")
      },
      {
        new NodeInfo("127.0.0.1:" + mockPORT, 11, "10101"),
        new NodeInfo("127.0.0.1:" + mockPORT, 28, "00101")
      },
      {
        new NodeInfo("127.0.0.1:" + mockPORT, 10, "01011"),
        new NodeInfo("127.0.0.1:" + mockPORT, 31, "01001")
      },
    };

    SearchTestCase tt[] = {
      new SearchTestCase(16, 16, 4),
      new SearchTestCase(17, 16, 4),
      new SearchTestCase(14, 14, 4),
      new SearchTestCase(14, 14, 3),
      new SearchTestCase(14, 14, 2),
      new SearchTestCase(14, 14, 1),
      new SearchTestCase(14, 14, 0),
    };

    MockSearchNode mock = new MockSearchNode(tt, lookupTable, serverPORT, "01010", 15, mockPORT);
    mock.runTests();
  }

  @Test
  public void SearchNumIDTest3() throws RemoteException {
    int mockPORT = 3145;
    int serverPORT = 2395;

    NodeInfo lookupTable[][] = {
      {null, null},
      {null, null},
      {null, null},
      {null, null},
      {null, null},
    };

    SearchTestCase tt[] = {
      new SearchTestCase(40, 15, 4), new SearchTestCase(0, 15, 4),
    };

    MockSearchNode mock = new MockSearchNode(tt, lookupTable, serverPORT, "01010", 15, mockPORT);
    mock.runTests();
  }
}