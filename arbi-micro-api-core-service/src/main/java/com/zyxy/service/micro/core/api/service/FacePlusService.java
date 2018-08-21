package com.zyxy.service.micro.core.api.service;

import com.zyxy.common.dto.FaceIdNotifyDTO;
import com.zyxy.common.service.BusiExecuteResult;

public interface FacePlusService {
    BusiExecuteResult livenessReturnBusiExecuteResult(FaceIdNotifyDTO formData);
}
