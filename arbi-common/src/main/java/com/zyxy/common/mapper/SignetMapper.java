package com.zyxy.common.mapper;

import com.zyxy.common.dto.SignatoryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SignetMapper {

    List<SignatoryDTO> querySignatoryByUserIds(@Param("userIds") String[] userIds);
}
