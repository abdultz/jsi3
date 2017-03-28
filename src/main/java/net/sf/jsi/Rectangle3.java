//   Rectangle3.java
//   Java Spatial Index Library
//   Copyright (C) 2002-2005 Infomatiq Limited
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
import java.lang.Math;


/**
 * Currently hardcoded to 3 dimensions, but could be extended.
 */
public class Rectangle3 {

  /**
   * use primitives instead of arrays for the coordinates of the rectangle,
   * to reduce memory requirements.
   */
  public float minX, minY, minZ, maxX, maxY, maxZ;

  public Rectangle3() {
    minX = Float.MAX_VALUE;
    minY = Float.MAX_VALUE;
	minZ = Float.MAX_VALUE;
    maxX = -Float.MAX_VALUE;
    maxY = -Float.MAX_VALUE;
	maxZ = -Float.MAX_VALUE;
  }

  /**
   * Constructor.
   *
   * @param x1 coordinate of any corner of the rectangle3
   * @param y1 (see x1)
   * @param z1 (see x1)
   * @param x2 coordinate of the opposite corner
   * @param y2 (see x2)
   * @param z2 (see x2)
   */
  public Rectangle3(float x1, float y1, float z1 , float x2, float y2, float z2) {
    set(x1, y1, z1, x2, y2, z2);
  }

 /**
   * Sets the size of the rectangle3.
   *
   * @param x1 coordinate of any corner of the rectangle3
   * @param y1 (see x1)
   * @param z1 (see x1)
   * @param x2 coordinate of the opposite corner
   * @param y2 (see x2)
   * @param z2 (see x2)
   */
  public void set(float x1, float y1, float z1, float x2, float y2, float z2) {
    minX = Math.min(x1, x2);
    maxX = Math.max(x1, x2);
    minY = Math.min(y1, y2);
    maxY = Math.max(y1, y2);
	minZ = Math.min(z1, z2);
    maxZ = Math.max(z1, z2);
  }

  /**
   * Sets the size of this rectangle3 to equal the passed rectangle3.
   */
  public void set(Rectangle3 r) {
    minX = r.minX;
    minY = r.minY;
	minZ = r.minZ;
    maxX = r.maxX;
    maxY = r.maxY;
	maxZ = r.maxZ;
  }

  /**
   * Make a copy of this rectangle3
   *
   * @return copy of this rectangle3
   */
  public Rectangle3 copy() {
    return new Rectangle3(minX, minY, minZ, maxX, maxY, maxZ);
  }

  /**
   * Determine whether an edge of this rectangle3 overlies the equivalent
   * edge of the passed rectangle3
   */
  public boolean edgeOverlaps(Rectangle3 r) {
    return minX == r.minX || maxX == r.maxX || minY == r.minY || maxY == r.maxY || minZ == r.minZ || maxZ == r.maxZ;
  }

  /**
   * Determine whether this rectangle3 intersects the passed rectangle3
   *
   * @param r The rectangle3 that might intersect this rectangle3
   *
   * @return true if the rectangle3s intersect, false if they do not intersect
   */
  public boolean intersects(Rectangle3 r) {
    return maxX >= r.minX && minX <= r.maxX && maxY >= r.minY && minY <= r.maxY && maxZ >= r.minZ && minZ <= r.maxZ;
  }

  /**
   * Determine whether or not two rectangle3s intersect
   *
   * @param r1MinX minimum X coordinate of rectangle3 1
   * @param r1MinY minimum Y coordinate of rectangle3 1
   * @param r1MinZ minimum Z coordinate of rectangle3 1
   * @param r1MaxX maximum X coordinate of rectangle3 1
   * @param r1MaxY maximum Y coordinate of rectangle3 1
   * @param r1MaxZ maximum Z coordinate of rectangle3 1
   * @param r2MinX minimum X coordinate of rectangle3 2
   * @param r2MinY minimum Y coordinate of rectangle3 2
   * @param r2MinZ minimum Z coordinate of rectangle3 2
   * @param r2MaxX maximum X coordinate of rectangle3 2
   * @param r2MaxY maximum Y coordinate of rectangle3 2
   * @param r2MaxZ maximum Z coordinate of rectangle3 2
   *
   * @return true if r1 intersects r2, false otherwise.
   */
  static public boolean intersects(float r1MinX, float r1MinY, float r1MinZ, float r1MaxX, float r1MaxY, float r1MaxZ,
                                 float r2MinX, float r2MinY, float r2MinZ, float r2MaxX, float r2MaxY, float r2MaxZ) {
    return r1MaxX >= r2MinX && r1MinX <= r2MaxX && r1MaxY >= r2MinY && r1MinY <= r2MaxY && r1MaxZ >= r2MinZ && r1MinZ <= r2MaxZ;
  }

  /**
   * Determine whether this rectangle3 contains the passed rectangle3
   *
   * @param r The rectangle3 that might be contained by this rectangle3
   *
   * @return true if this rectangle3 contains the passed rectangle3, false if
   *         it does not
   */
  public boolean contains(Rectangle3 r) {
    return maxX >= r.maxX && minX <= r.minX && maxY >= r.maxY && minY <= r.minY && maxZ >= r.maxZ && minZ <= r.minZ;
  }

  /**
   * Determine whether or not one rectangle3 contains another.
   *
   * @param r1MinX minimum X coordinate of rectangle3 1
   * @param r1MinY minimum Y coordinate of rectangle3 1
   * @param r1MaxX maximum X coordinate of rectangle3 1
   * @param r1MaxY maximum Y coordinate of rectangle3 1
   * @param r2MinX minimum X coordinate of rectangle3 2
   * @param r2MinY minimum Y coordinate of rectangle3 2
   * @param r2MaxX maximum X coordinate of rectangle3 2
   * @param r2MaxY maximum Y coordinate of rectangle3 2
   *
   * @return true if r1 contains r2, false otherwise.
   */
  static public boolean contains(float r1MinX, float r1MinY, float r1MinZ, float r1MaxX, float r1MaxY, float r1MaxZ,
                                 float r2MinX, float r2MinY, float r2MinZ, float r2MaxX, float r2MaxY, float r2MaxZ) {
    return r1MaxX >= r2MaxX && r1MinX <= r2MinX && r1MaxY >= r2MaxY && r1MinY <= r2MinY && r1MaxZ >= r2MaxZ && r1MinZ <= r2MinZ;
  }

  /**
   * Determine whether this rectangle3 is contained by the passed rectangle3
   *
   * @param r The rectangle3 that might contain this rectangle3
   *
   * @return true if the passed rectangle3 contains this rectangle3, false if
   *         it does not
   */
  public boolean containedBy(Rectangle3 r) {
    return r.maxX >= maxX && r.minX <= minX && r.maxY >= maxY && r.minY <= minY && r.maxZ >= maxZ && r.minZ <= minZ;
  }

  /**
   * Return the distance between this rectangle3 and the passed point3.
   * If the rectangle3 contains the point3, the distance is zero.
   *
   * @param p Point3 to find the distance to
   *
   * @return distance between this rectangle3 and the passed point3.
   */
  public float distance(Point3 p) {
    float distanceSquared = 0;

    float temp = minX - p.x;
    if (temp < 0) {
      temp = p.x - maxX;
    }

    if (temp > 0) {
      distanceSquared += (temp * temp);
    }

    temp = minY - p.y;
    if (temp < 0) {
      temp = p.y - maxY;
    }

    if (temp > 0) {
      distanceSquared += (temp * temp);
    }

	temp = minZ - p.z;
    if (temp < 0) {
      temp = p.z - maxZ;
    }

    if (temp > 0) {
      distanceSquared += (temp * temp);
    }
	
    return (float) Math.sqrt(distanceSquared);
  }

  /**
   * Return the distance between a rectangle3 and a point3.
   * If the rectangle3 contains the point3, the distance is zero.
   *
   * @param minX minimum X coordinate of rectangle3
   * @param minY minimum Y coordinate of rectangle3
   * @param minZ minimum Z coordinate of rectangle3
   * @param maxX maximum X coordinate of rectangle3
   * @param maxY maximum Y coordinate of rectangle3
   * @param maxZ maximum Z coordinate of rectangle3
   * @param pX X coordinate of point3
   * @param pY Y coordinate of point3
   * @param pZ Z coordinate of point3
   *
   * @return distance between this rectangle3 and the passed point3.
   */
  static public float distance(float minX, float minY, float minZ, float maxX, float maxY, float maxZ, float pX, float pY, float pZ) {
    return (float) Math.sqrt(distanceSq(minX, minY, minZ, maxX, maxY, maxZ, pX, pY, pZ));
  }

  static public float distanceSq(float minX, float minY, float minZ, float maxX, float maxY, float maxZ, float pX, float pY, float pZ) {
    float distanceSqX = 0;
    float distanceSqY = 0;
	float distanceSqZ = 0;
    if (minX > pX) {
      distanceSqX = minX - pX;
      distanceSqX *= distanceSqX;
    } else if (pX > maxX) {
      distanceSqX = pX - maxX;
      distanceSqX *= distanceSqX;
    }

    if (minY > pY) {
      distanceSqY = minY - pY;
      distanceSqY *= distanceSqY;
    } else if (pY > maxY) {
      distanceSqY = pY - maxY;
      distanceSqY *= distanceSqY;
    }
	
	if (minZ > pZ) {
      distanceSqZ = minZ - pZ;
      distanceSqZ *= distanceSqZ;
    } else if (pZ > maxZ) {
      distanceSqZ = pZ - maxZ;
      distanceSqZ *= distanceSqZ;
    }

    return distanceSqX + distanceSqY + distanceSqZ;
  }

  /**
   * Return the distance between this rectangle3and the passed rectangle3.
   * If the rectangle3s overlap, the distance is zero.
   *
   * @param r Rectangle3 to find the distance to
   *
   * @return distance between this rectangle3 and the passed rectangle3
   */

  public float distance(Rectangle3 r) {
    float distanceSquared = 0;
    float greatestMin = Math.max(minX, r.minX);
    float leastMax    = Math.min(maxX, r.maxX);
    if (greatestMin > leastMax) {
      distanceSquared += ((greatestMin - leastMax) * (greatestMin - leastMax));
    }
    greatestMin = Math.max(minY, r.minY);
    leastMax    = Math.min(maxY, r.maxY);
    if (greatestMin > leastMax) {
      distanceSquared += ((greatestMin - leastMax) * (greatestMin - leastMax));
    }
	greatestMin = Math.max(minZ, r.minZ);
    leastMax    = Math.min(maxZ, r.maxZ);
    if (greatestMin > leastMax) {
      distanceSquared += ((greatestMin - leastMax) * (greatestMin - leastMax));
    }
    return (float) Math.sqrt(distanceSquared);
  }

  /**
   * Calculate the area by which this rectangle3 would be enlarged if
   * added to the passed rectangle3. Neither rectangle3 is altered.
   *
   * @param r Rectangle3 to union with this rectangle3, in order to
   *          compute the difference in area of the union and the
   *          original rectangle3
   *
   * @return enlargement
   */
  public float enlargement(Rectangle3 r) {
    float enlargedArea = (Math.max(maxX, r.maxX) - Math.min(minX, r.minX)) *
                         (Math.max(maxY, r.maxY) - Math.min(minY, r.minY)) *
						 (Math.max(maxZ, r.maxZ) - Math.min(minZ, r.minZ));

    return enlargedArea - area();
  }

  /**
    * Calculate the area by which a rectangle3 would be enlarged if
    * added to the passed rectangle3..
    *
    * @param r1MinX minimum X coordinate of rectangle3 1
    * @param r1MinY minimum Y coordinate of rectangle3 1
	* @param r1MinZ minimum Z coordinate of rectangle3 1
    * @param r1MaxX maximum X coordinate of rectangle3 1
    * @param r1MaxY maximum Y coordinate of rectangle3 1
	* @param r1MaxZ maximum Z coordinate of rectangle3 1
    * @param r2MinX minimum X coordinate of rectangle3 2
    * @param r2MinY minimum Y coordinate of rectangle3 2
	* @param r2MinZ minimum Z coordinate of rectangle3 2
    * @param r2MaxX maximum X coordinate of rectangle3 2
    * @param r2MaxY maximum Y coordinate of rectangle3 2
	* @param r2MaxZ maximum Z coordinate of rectangle3 2
    *
    * @return enlargement
    */
  static public float enlargement(float r1MinX, float r1MinY, float r1MinZ, float r1MaxX, float r1MaxY, float r1MaxZ,
                                  float r2MinX, float r2MinY, float r2MinZ, float r2MaxX, float r2MaxY, float r2MaxZ) {
    float r1Area = (r1MaxX - r1MinX) * (r1MaxY - r1MinY) * (r1MaxZ - r1MinZ);

    if (r1Area == Float.POSITIVE_INFINITY) {
      return 0; // cannot enlarge an infinite rectangle3...
    }

    if (r2MinX < r1MinX) r1MinX = r2MinX;
    if (r2MinY < r1MinY) r1MinY = r2MinY;
	if (r2MinZ < r1MinZ) r1MinZ = r2MinZ;
    if (r2MaxX > r1MaxX) r1MaxX = r2MaxX;
    if (r2MaxY > r1MaxY) r1MaxY = r2MaxY;
	if (r2MaxZ > r1MaxZ) r1MaxZ = r2MaxZ;

    float r1r2UnionArea = (r1MaxX - r1MinX) * (r1MaxY - r1MinY) * (r1MaxZ - r1MinZ);;

    if (r1r2UnionArea == Float.POSITIVE_INFINITY) {
      // if a finite rectangle3 is enlarged and becomes infinite,
      // then the enlargement must be infinite.
      return Float.POSITIVE_INFINITY;
    }
    return r1r2UnionArea - r1Area;
  }

  /**
   * Compute the area of this rectangle3.
   *
   * @return The area of this rectangle3
   */
  public float area() {
    return (maxX - minX) * (maxY - minY) * (maxZ - minZ);
  }

  /**
   * Compute the area of a rectangle3.
   *
   * @param minX the minimum X coordinate of the rectangle3
   * @param minY the minimum Y coordinate of the rectangle3
   * @param minZ the minimum Z coordinate of the rectangle3
   * @param maxX the maximum X coordinate of the rectangle3
   * @param maxY the maximum Y coordinate of the rectangle3
   * @param maxZ the maximum Z coordinate of the rectangle3
   *
   * @return The area of the rectangle3
   */
  static public float area(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
    return (maxX - minX) * (maxY - minY) * (maxZ - minZ);
  }

  /**
   * Computes the union of this rectangle3 and the passed rectangle3, storing
   * the result in this rectangle3.
   *
   * @param r Rectangle3 to add to this rectangle3
   */
  public void add(Rectangle3 r) {
    if (r.minX < minX) minX = r.minX;
    if (r.maxX > maxX) maxX = r.maxX;
    if (r.minY < minY) minY = r.minY;
    if (r.maxY > maxY) maxY = r.maxY;
	if (r.minZ < minZ) minZ = r.minZ;
    if (r.maxZ > maxZ) maxZ = r.maxZ;
  }

  /**
   * Computes the union of this rectangle3 and the passed point3, storing
   * the result in this rectangle3.
   *
   * @param p Point3 to add to this rectangle3
   */
  public void add(Point3 p) {
    if (p.x < minX) minX = p.x;
    if (p.x > maxX) maxX = p.x;
    if (p.y < minY) minY = p.y;
    if (p.y > maxY) maxY = p.y;
	if (p.z < minZ) minZ = p.z;
    if (p.z > maxZ) maxZ = p.z;
  }

  /**
   * Find the the union of this rectangle3 and the passed rectangle3.
   * Neither rectangle3 is altered
   *
   * @param r The rectangle3to union with this rectangle3
   */
  public Rectangle3 union(Rectangle3 r) {
    Rectangle3 union = this.copy();
    union.add(r);
    return union;
  }

  @Override
  public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + Float.floatToIntBits(this.maxX);
      result = prime * result + Float.floatToIntBits(this.maxY);
	  result = prime * result + Float.floatToIntBits(this.maxZ);
      result = prime * result + Float.floatToIntBits(this.minX);
      result = prime * result + Float.floatToIntBits(this.minY);
	  result = prime * result + Float.floatToIntBits(this.minZ);
      return result;
  }

  /**
   * Determine whether this rectangle3 is equal to a given object.
   * Equality is determined by the bounds of the rectangle3.
   *
   * @param o The object to compare with this rectangle3
   */
  @Override
public boolean equals(Object o) {
    boolean equals = false;
    if (o instanceof Rectangle3) {
      Rectangle3 r = (Rectangle3) o;
      if (minX == r.minX && minY == r.minY && minZ == r.minZ && maxX == r.maxX && maxY == r.maxY && maxZ == r.maxZ) {
        equals = true;
      }
    }
    return equals;
  }

  /**
   * Determine whether this rectangle3 is the same as another object
   *
   * Note that two rectangle3s can be equal but not the same object,
   * if they both have the same bounds.
   *
   * @param o The object to compare with this rectangle3.
   */
  public boolean sameObject(Object o) {
    return super.equals(o);
  }

  /**
   * Return a string representation of this rectangle3, in the form:
   * (1.2, 3.4), (5.6, 7.8)
   *
   * @return String String representation of this rectangle3.
   */
  @Override
  public String toString() {
    return "(" + minX + ", " + minY + ", " + minZ + "), (" + maxX + ", " + maxY + ", " + maxZ + ")";
  }

  /**
   * Utility methods (not used by JSI); added to
   * enable this to be used as a generic rectangle3 class
   */
  public float width() {
    return maxX - minX;
  }

  public float height() {
    return maxY - minY;
  }

  public float depth() {
    return maxZ - minZ;
  }

  
  public float aspectRatio() {
	return Math.max(width(), Math.max(height(),depth())) / Math.min(width(), Math.min(height(),depth()));
    //return width() / height();
  }

  public Point3 centre() {
    return new Point3((minX + maxX) / 2, (minY + maxY) / 2, (minZ + maxZ) / 2);
  }

}
