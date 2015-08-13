package com.bigdinosaur.event;

public interface EventChecker
{
  // on the basis of obj.getIdForEvent() check event and get event .Like Group is clicked ,User is clicked ,something like that.If id is null then event is not generated.
  //classify event into 2 ,either user generated event or programmatically generated event.
boolean IsEventGenerated(Object obj);


}
