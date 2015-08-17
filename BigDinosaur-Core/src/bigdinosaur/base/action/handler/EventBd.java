package bigdinosaur.base.action.handler;

public class EventBd
{
  public static boolean isGroupClickedOrEventGenerated(Object  object) throws Exception {
    return false;
    // check against the null value of object .If it is web based then object.getRequestParamter("groupClicked")!=null means group is clicked other wise if 
   // null then group event is not generated same is the case for EventGenerated non web case 
    
  }
public static boolean isRoleClickedOrEventGenerated(Object  object) throws Exception {
    // same as above 
    return false;
  }
}
