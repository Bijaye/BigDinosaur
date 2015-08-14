package com.bigdinosaur.base.batch.server.service;

import com.bigdinosaur.batch.extend.model.BaseServiceDto;




public interface AccessLogService
{

    public abstract BaseServiceDto log(Object accesslogdto);

    public abstract BaseServiceDto log(String s);
}
