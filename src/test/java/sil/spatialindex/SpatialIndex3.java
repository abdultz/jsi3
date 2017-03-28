// Spatial Index Library
//
// Copyright (C) 2002  Navel Ltd.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
//
// Contact information:
//  Mailing address:
//    Marios Hadjieleftheriou
//    University of California, Riverside
//    Department of Computer Science
//    Surge Building, Room 310
//    Riverside, CA 92521
//
//  Email:
//    marioh@cs.ucr.edu

package sil.spatialindex;

import java.io.FileNotFoundException;
import java.io.IOException;

import sil.storagemanager.DiskStorageManager;
import sil.storagemanager.MemoryStorageManager3;
import sil.storagemanager.PropertySet3;
import sil.storagemanager.IStorageManager3;

public class SpatialIndex3
{
	public static final String EMAIL = "marioh@cs.ucr.edu";
	public static final String VERSION = "0.44.2b";
	public static final String DATE = "27 July 2003";

	public static final double EPSILON = 1.192092896e-07;

	public static final int RtreeVariantQuadratic = 1;
	public static final int RtreeVariantLinear = 2;
	public static final int RtreeVariantRstar = 3;

	public static final int PersistentIndex = 1;
	public static final int PersistentLeaf = 2;

	public static final int ContainmentQuery = 1;
	public static final int IntersectionQuery = 2;

	public static ISpatialIndex3 createRTree(PropertySet3 ps, IStorageManager3 sm)
	{
		return null;
	}

	public static IStorageManager3 createMemoryStorageManager(PropertySet3 ps)
	{
		IStorageManager3 sm = (IStorageManager3) new MemoryStorageManager3();
		return sm;
	}

	public static IStorageManager3 createDiskStorageManager(PropertySet3 ps)
		throws SecurityException, NullPointerException, IOException, FileNotFoundException, IllegalArgumentException
	{
		IStorageManager3 sm = (IStorageManager3) new DiskStorageManager(ps);
		return sm;
	}
} // SpatialIndex
