/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bigdinosaur.record.compiler;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

/**
 * C Code generator front-end for Hadoop record I/O.
 */
class CGenerator extends CodeGenerator {
  
  CGenerator() {
  }
  
  /**
   * Generate C code. This method only creates the requested file(s)
   * and spits-out file-level elements (such as include statements etc.)
   * record-level code is generated by JRecord.
   */
  void genCode(String name, ArrayList<JFile> ilist,
               ArrayList<JRecord> rlist, String destDir, ArrayList<String> options)
    throws IOException {
    name = new File(destDir, (new File(name)).getName()).getAbsolutePath();
    FileWriter cc = new FileWriter(name+".c");
    try {
      FileWriter hh = new FileWriter(name+".h");
      try {
        hh.write("#ifndef __"+name.toUpperCase().replace('.','_')+"__\n");
        hh.write("#define __"+name.toUpperCase().replace('.','_')+"__\n");
        hh.write("#include \"recordio.h\"\n");
        for (Iterator<JFile> iter = ilist.iterator(); iter.hasNext();) {
          hh.write("#include \""+iter.next().getName()+".h\"\n");
        }

        cc.write("#include \""+name+".h\"\n");

        /*
        for (Iterator<JRecord> iter = rlist.iterator(); iter.hasNext();) {
        iter.next().genCppCode(hh, cc);
        }
         */

        hh.write("#endif //"+name.toUpperCase().replace('.','_')+"__\n");
      } finally {
        hh.close();
      }
    } finally {
      cc.close();
    }
  }
}
