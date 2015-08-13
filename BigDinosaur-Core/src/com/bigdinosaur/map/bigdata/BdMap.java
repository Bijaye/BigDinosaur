package com.bigdinosaur.map.bigdata;

import java.util.HashMap;
import java.util.Map;
// go Recursively  
// everything is key ,value 
// No matter the size of data 
//do i.o  and load from file and key in map as key ,value
// hold upto jvm can handle without affecting performance .
public class BdMap
{
  BdMap layersmap=new BdMap();
  private Map bdmap=new HashMap<>();
  BdMap loadMap(){
    return layersmap;
    
  }
}
