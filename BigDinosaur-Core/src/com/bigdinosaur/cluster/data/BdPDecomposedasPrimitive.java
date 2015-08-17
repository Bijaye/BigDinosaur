package com.bigdinosaur.cluster.data;

import java.util.HashMap;
import java.util.Map;

// contains collection of Map containing BdPrimitiveUnDecomposed,which is recursively broken down into
//BdPrimitiveUnDecomposed
public class BdPDecomposedasPrimitive extends BdPrimitiveUnDecomposed
{
  // decompose from here and get BdPrimitiveUnDecomposed which is pure primitive
Map<Object,BdPrimitiveUnDecomposed> map=new HashMap<Object,BdPrimitiveUnDecomposed>();
}
