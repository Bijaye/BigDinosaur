package com.base.bigdinosaur.master;




public class RealGenerics<E extends SupprGenerics> extends SupprNonGenerics{
	E t;
	RealGenerics(E t){
	this.t=t;
	}
	String Opeartion1(){
		return t.Opeartion1();
	}
String Opeartion2(){
		return t.Opeartion1();
	}

}
