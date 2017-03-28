//   Point3.java
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
//  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307 USA

package net.sf.jsi;

/**
 * Currently hardcoded to 3 dimensions, but could be extended.
 */
public class Point3 {
  /**
   * The (x, y, z) coordinates of the Point3.
   */
  public float x, y, z;

  /**
   * Constructor.
   *
   * @param x The x coordinate of the Point3
   * @param y The y coordinate of the Point3
   * @param z The z coordinate of the Point3
   */
  public Point3(float x, float y, float z) {
    this.x = x;
    this.y = y;
	this.z = z;
  }

  /**
   * Copy from another Point3 into this one
   */
  public void set(Point3 other) {
    x = other.x;
    y = other.y;
	z = other.z;
  }

  /**
   * Print as a string in format "(x, y, z)"
   */
  @Override
  public String toString() {
    return "(" + x + ", " + y + ", " + z +")";
  }

  /**
   * @return X coordinate rounded to an int
   */
  public int xInt() {
    return Math.round(x);
  }

  /**
   * @return Y coordinate rounded to an int
   */
  public int yInt() {
    return Math.round(y);
  }
  
  /**
   * @return Z coordinate rounded to an int
   */
  public int zInt() {
    return Math.round(z);
  }
}
