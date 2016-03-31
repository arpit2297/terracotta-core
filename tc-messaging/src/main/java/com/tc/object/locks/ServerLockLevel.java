/*
 *
 *  The contents of this file are subject to the Terracotta Public License Version
 *  2.0 (the "License"); You may not use this file except in compliance with the
 *  License. You may obtain a copy of the License at
 *
 *  http://terracotta.org/legal/terracotta-public-license.
 *
 *  Software distributed under the License is distributed on an "AS IS" basis,
 *  WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 *  the specific language governing rights and limitations under the License.
 *
 *  The Covered Software is Terracotta Core.
 *
 *  The Initial Developer of the Covered Software is
 *  Terracotta, Inc., a Software AG company
 *
 */
package com.tc.object.locks;

import com.tc.object.locks.LockLevel;

public enum ServerLockLevel {
  READ, WRITE;

  public static LockLevel toClientLockLevel(ServerLockLevel lockLevel) {
    switch (lockLevel) {
      case READ:
        return LockLevel.READ;
      case WRITE:
        return LockLevel.WRITE;
      default:
        throw new AssertionError("Unknown State: " + lockLevel);
    }
  }

  public static ServerLockLevel fromClientLockLevel(LockLevel lockLevel) {
    switch (lockLevel) {
      case READ:
        return ServerLockLevel.READ;
      case SYNCHRONOUS_WRITE:
      case WRITE:
        return ServerLockLevel.WRITE;
      case CONCURRENT:
      default:
        throw new AssertionError("Unexpected lock level: " + lockLevel);
    }
  }  
}