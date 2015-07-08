package com.easy.base.batch.server.service;

import com.easy.base.batch.server.dto.AccessLogDto;
import com.easy.batch.extend.model.BaseServiceDto;




public interface AccessLogService
{

    public abstract BaseServiceDto log(AccessLogDto accesslogdto);

    public abstract BaseServiceDto log(String s);
}
