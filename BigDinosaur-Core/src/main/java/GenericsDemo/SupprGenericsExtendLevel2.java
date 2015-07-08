package GenericsDemo;



public class SupprGenericsExtendLevel2 extends SupprGenericsExtendLevel1 {
	private String String1;
	private String string2;
	private String string3;

	String Opeartion111() {
		return String1;
	}

	String Opeartion222() {
		return string2;
	}

	String Opeartion333(RealGenerics<? super SupprGenericsExtendLevel2> a) {
		return string3;
	}

}
