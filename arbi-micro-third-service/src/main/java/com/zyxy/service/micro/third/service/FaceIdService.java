package com.zyxy.service.micro.third.service;

import com.zyxy.common.dto.FaceIdDTO;
import com.zyxy.common.service.BusiExecuteResult;
import com.zyxy.common.vo.FaceIdGetTokenVO;

public interface FaceIdService {



    public BusiExecuteResult<FaceIdGetTokenVO> getToken(FaceIdDTO formData);
}
