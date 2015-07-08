package com.easy.base.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class CustomEventPublisher 
   implements ApplicationEventPublisherAware {
   
   private ApplicationEventPublisher publisher;

   public void setApplicationEventPublisher
              (ApplicationEventPublisher publisher){
      this.publisher = publisher;
   }

   public void publish() {
	   EasyEvent ce = new EasyEvent(this);
      publisher.publishEvent(ce);
   }
}