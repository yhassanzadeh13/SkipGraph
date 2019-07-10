/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package SkipGraph;

import static org.junit.Assert.*;

import org.junit.Test;

public class SkipNodeTest {
  @Test
  public void testSomeLibraryMethod() {
    try {
      SkipNode node = new SkipNode("none", "127.0.0.1:1099", "1001", 30);
      assertTrue("SkipNode should return 'cool'", node.getNumID() == 30);
    } catch (Exception e) {

      assertTrue("SkipNode should return 'cool'", false);
    }
  }
}