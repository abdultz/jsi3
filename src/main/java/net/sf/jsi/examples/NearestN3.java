package net.sf.jsi.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gnu.trove.procedure.TIntProcedure;

import net.sf.jsi.SpatialIndex3;
import net.sf.jsi.rtree.RTree3;
import net.sf.jsi.Rectangle3;
import net.sf.jsi.Point3;

public class NearestN3 {
  private static final Logger log = LoggerFactory.getLogger(NearestN3.class);
 
  public static void main(String[] args) {
    new NearestN3().run();
  }
 
  private class NullProc implements TIntProcedure {
    public boolean execute(int i) {
      return true;
    }
  }
    
  private void run() {
    int rowCount = 100;
    int columnCount = 100;
    int depthCount = 100;
    int count = rowCount * columnCount * depthCount;
    long start, end;
     start = System.currentTimeMillis();
    log.info("Creating " + count + " rectangles");
    final Rectangle3[] rects = new Rectangle3[count];
    int id = 0;
    for (int row = 0; row < rowCount; row++)
    {
      for (int column = 0; column < columnCount; column++)
        {
        for (int depth = 0; depth < depthCount; depth++)
        {
            rects[id++] = new Rectangle3(row, column, depth, row+0.5f, column+0.5f, depth+0.5f); // 
        }
        }
      if(row  % 100 == 0)
        {
            end = System.currentTimeMillis();
            System.out.println("Total time for generating: " + (row/100) + " million = "+ (end - start)  + " msec");
        }
    }
    end = System.currentTimeMillis();
    log.info("Total time for Creating = " + (end - start)  + " msec");
    log.info("Indexing " + count + " rectangles");
    start = System.currentTimeMillis();
    SpatialIndex3 si = new RTree3();
    si.init(null);
    for (id=0; id < count; id++) {
      si.add(rects[id], id);
      if((id > 1000000) && (id % 1000000 == 0))
      {
          end = System.currentTimeMillis();
          System.out.println("Total time for indexing: " + (id/1000000) + " million = "+ (end - start)  + " msec");
      }
    }
    end = System.currentTimeMillis();
    log.info("Average time to index rectangle = " + ((end - start) / (count / 1000.0)) + " us");
    log.info("Total time for indexing = " + (end - start)  + " msec");
    
//    final Point3 p = new Point3(36.3f, 84.3f, 55.6f);
//    log.info("Querying for the nearest 3 rectangles to " + p);
//    si.nearestN(p, new TIntProcedure() {
//      public boolean execute(int i) {
//        log.info("Rectangle " + i + " " + rects[i] + ", distance=" + rects[i].distance(p));
//        return true;
//      }
//    }, 3, Float.MAX_VALUE);
//
//    // Run a performance test, find the 3 nearest rectangles
//    final int[] ret = new int[1];
//    log.info("Running 10000 queries for the nearest 3 rectangles");
//    start = System.currentTimeMillis();
//    for (int row = 0; row < 100; row++) {
//      for (int column = 0; column < 100; column++) {
//        p.x = row + 0.6f;
//        p.y = column + 0.7f;
//        si.nearestN(p, new TIntProcedure() {
//          public boolean execute(int i) {
//            ret[0]++;
//            return true; // don't do anything with the results, for a performance test.
//          }
//        }, 3, Float.MAX_VALUE);
//      }
//    }
//    end = System.currentTimeMillis();
//    log.info("Average time to find nearest 3 rectangles = " + ((end - start) / (10000 / 1000.0)) + " us");
//    log.info("total time = " + (end - start) + "ms");
//    log.info("total returned = " + ret[0]);
//    
//    // Run a performance test, find the 3 nearest rectangles
//    log.info("Running 30000 queries for the nearest 3 rectangles");
//    
//    TIntProcedure proc = new NullProc();
//    start = System.currentTimeMillis();
//    for (int row = 0; row < 300; row++) {
//      for (int column = 0; column < 100; column++) {
//        p.x = row + 0.6f;
//        p.y = column + 0.7f;
//        si.nearestN(p, proc, 3, Float.MAX_VALUE);
//      }
//    }
//    end = System.currentTimeMillis();
//    log.info("Average time to find nearest 3 rectangles = " + ((end - start) / (30000 / 1000.0)) + " us");
//    log.info("total time = " + (end - start) + "ms");
//    log.info("total returned = " + ret[0]);
  }
}
