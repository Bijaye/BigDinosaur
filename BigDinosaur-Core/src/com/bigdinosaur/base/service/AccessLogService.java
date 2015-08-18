package com.bigdinosaur.base.service;

import com.bigdinosaur.base.model.BaseServiceDto;





public interface AccessLogService
{

    public abstract BaseServiceDto log(Object accesslogdto);

    public abstract BaseServiceDto log(String s);
}
