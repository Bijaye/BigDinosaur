package om.bigdinosaur.data.type;

public class ArrayType implements Types
{
  public static final int defaultArrayCardinality      = 1024;
  public static final int defaultLargeArrayCardinality = Integer.MAX_VALUE;
  final Type              dataType;
  final int               maxCardinality;

  public ArrayType(Type dataType, int cardinality) {


      

      this.dataType       = dataType;
      this.maxCardinality = cardinality;
  }

}
