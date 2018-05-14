package com.ts.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.Vector;

public class TreeDemo {
public static void main(String[] args) {
	List l=new ArrayList();
	TreeSet ts=new TreeSet();
	Vector v=new Vector();
	v.add(null);
	Map<String,Object> hmap=new HashMap<>();
	Map<String,Object> htab=new Hashtable<>();
	hmap.put(null,"java");
	//htab.put(null, java);
	//ts.add(null);
	l.add(null);
	System.out.println(v);
}
}
