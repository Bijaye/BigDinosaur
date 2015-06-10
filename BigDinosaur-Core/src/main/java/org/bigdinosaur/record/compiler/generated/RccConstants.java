/* Generated By:JavaCC: Do not edit this line. RccConstants.java */
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

package org.bigdinosaur.record.compiler.generated;

public interface RccConstants {

  int EOF = 0;
  int MODULE_TKN = 11;
  int RECORD_TKN = 12;
  int INCLUDE_TKN = 13;
  int BYTE_TKN = 14;
  int BOOLEAN_TKN = 15;
  int INT_TKN = 16;
  int LONG_TKN = 17;
  int FLOAT_TKN = 18;
  int DOUBLE_TKN = 19;
  int USTRING_TKN = 20;
  int BUFFER_TKN = 21;
  int VECTOR_TKN = 22;
  int MAP_TKN = 23;
  int LBRACE_TKN = 24;
  int RBRACE_TKN = 25;
  int LT_TKN = 26;
  int GT_TKN = 27;
  int SEMICOLON_TKN = 28;
  int COMMA_TKN = 29;
  int DOT_TKN = 30;
  int CSTRING_TKN = 31;
  int IDENT_TKN = 32;

  int DEFAULT = 0;
  int WithinOneLineComment = 1;
  int WithinMultiLineComment = 2;

  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "\"//\"",
    "<token of kind 6>",
    "<token of kind 7>",
    "\"/*\"",
    "\"*/\"",
    "<token of kind 10>",
    "\"module\"",
    "\"class\"",
    "\"include\"",
    "\"byte\"",
    "\"boolean\"",
    "\"int\"",
    "\"long\"",
    "\"float\"",
    "\"double\"",
    "\"ustring\"",
    "\"buffer\"",
    "\"vector\"",
    "\"map\"",
    "\"{\"",
    "\"}\"",
    "\"<\"",
    "\">\"",
    "\";\"",
    "\",\"",
    "\".\"",
    "<CSTRING_TKN>",
    "<IDENT_TKN>",
  };

}
