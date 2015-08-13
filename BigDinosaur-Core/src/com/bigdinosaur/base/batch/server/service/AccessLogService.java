package com.bigdinosaur.base.batch.server.service;

import com.bigdinosaur.base.batch.server.dto.AccessLogDto;
import com.bigdinosaur.batch.extend.model.BaseServiceDto;




public interface AccessLogService
{

    public abstract BaseServiceDto log(AccessLogDto accesslogdto);

    public abstract BaseServiceDto log(String s);
}
