//   SpatialIndex.java
//   Java Spatial Index Library
//   Copyright (C) 2002-2005 Infomatiq Limited.
//
//  This library is free software; you can redistribute it and/or
//  modify it under the terms of the GNU Lesser General Public
//  License as published by the Free Software Foundation; either
//  version 2.1 of the License, or (at your option) any later version.
//
//  This library is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//  Lesser General Public License for more details.
//
//  You should have received a copy of the GNU Lesser General Public
//  License along with this library; if not, write to the Free Software
//  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

package net.sf.jsi;

import gnu.trove.procedure.TIntProcedure;

import java.util.Properties;

/**
 * Defines methods that must be implemented by all
 * spatial indexes. This includes the RTree and its variants.
 */
public interface SpatialIndex3 {

  /**
   * Initializes any implementation dependent properties
   * of the spatial index. For example, RTree implementations
   * will have a NodeSize property.
   *
   * @param props The set of properties used to initialize the spatial index.
   */
  public void init(Properties props);

  /**
   * Adds a new rectangle3 to the spatial index
   *
   * @param r  The rectangle3 to add to the spatial index.
   * @param id The ID of the rectangle3 to add to the spatial index.
   *           The result of adding more than one rectangle3 with
   *           the same ID is undefined.
   */
  public void add(Rectangle3 r, int id);

  /**
   * Deletes a rectangle3 from the spatial index
   *
   * @param r  The rectangle3 to delete from the spatial index
   * @param id The ID of the rectangle3 to delete from the spatial
   *           index
   *
   * @return true  if the rectangle3 was deleted
   *         false if the rectangle3 was not found, or the
   *               rectangle3 was found but with a different ID
   */
  public boolean delete(Rectangle3 r, int id);

  /**
   * Finds the nearest rectangle3s to the passed rectangle3 and calls
   * v.execute(id) for each one.
   *
   * If multiple rectangle3s are equally near, they will
   * all be returned.
   *
   * @param p The point for which this method finds the
   * nearest neighbours.
   *
   * @param v The IntProcedure whose execute() method is is called
   * for each nearest neighbour.
   *
   * @param furthestDistance The furthest distance away from the rectangle3
   * to search. Rectangle3s further than this will not be found.
   *
   * This should be as small as possible to minimise
   * the search time.
   *
   * Use Float.POSITIVE_INFINITY to guarantee that the nearest rectangle3 is found,
   * no matter how far away, although this will slow down the algorithm.
   */
  public void nearest(Point3 p, TIntProcedure v, float furthestDistance);

  /**
   * Finds the N nearest rectangle3s to the passed rectangle3, and calls
   * execute(id, distance) on each one, in order of increasing distance.
   *
   * Note that fewer than N rectangle3s may be found if fewer entries
   * exist within the specified furthest distance, or more if rectangle3s
   * N and N+1 have equal distances.
   *
   * @param p The point3 for which this method finds the
   * nearest neighbours.
   *
   * @param v The IntfloatProcedure whose execute() method is is called
   * for each nearest neighbour.
   *
   * @param n The desired number of rectangle3s to find (but note that
   * fewer or more may be returned)
   *
   * @param distance The furthest distance away from the rectangle3
   * to search. Rectangle3s further than this will not be found.
   *
   * This should be as small as possible to minimise
   * the search time.
   *
   * Use Float.POSITIVE_INFINITY to guarantee that the nearest rectangle3 is found,
   * no matter how far away, although this will slow down the algorithm.
   */
  public void nearestN(Point3 p, TIntProcedure v, int n, float distance);

  /**
   * Same as nearestN, except the found rectangle3s are not returned
   * in sorted order. This will be faster, if sorting is not required
   */
  public void nearestNUnsorted(Point3 p, TIntProcedure v, int n, float distance);

  /**
   * Finds all rectangle3s that intersect the passed rectangle3.
   *
   * @param  r The rectangle3 for which this method finds
   *           intersecting rectangle3s.
   *
   * @param ip The IntProcedure whose execute() method is is called
   *           for each intersecting rectangle3.
   */
  public void intersects(Rectangle3 r, TIntProcedure ip);

  /**
   * Finds all rectangle3s contained by the passed rectangle3.
   *
   * @param r The rectangle3 for which this method finds
   *           contained rectangle3s.
   *
   * @param ip The procedure whose visit() method is is called
   *           for each contained rectangle3.
   */
  public void contains(Rectangle3 r, TIntProcedure ip);

  /**
   * Returns the number of entries in the spatial index
   */
  public int size();


  /**
   * Returns the bounds of all the entries in the spatial index,
   * or null if there are no entries.
   */
  public Rectangle3 getBounds();

  /**
   * Returns a string identifying the type of
   * spatial index, and the version number,
   * eg "SimpleIndex-0.1"
   */
  public String getVersion();

}
