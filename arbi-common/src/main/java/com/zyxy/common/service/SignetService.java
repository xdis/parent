package com.zyxy.common.service;

import com.zyxy.common.dto.SignatoryDTO;
import com.zyxy.common.dto.SignetDTO;
import com.zyxy.common.enums.CaseDocTypeEnum;
import com.zyxy.common.mapper.SignetMapper;
import com.zyxy.common.service.micro.MicroThirdService;
import com.zyxy.common.vo.ApiResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 签章服务
 */
@Service
public class SignetService {

    private Logger log = LoggerFactory.getLogger(SignetService.class);

    @Autowired
    private MicroThirdService microThirdService;

    @Autowired
    private SignetMapper signetMapper;

    public ApiResultVO<String> signet(String pdfFileId, List<String> metFiles, CaseDocTypeEnum caseDoc, List<SignatoryDTO> signatorys) {
        SignetDTO signetDTO = new SignetDTO();
        signetDTO.setContractName(caseDoc.getDocName());
        signetDTO.setDealTypeCode(1);
        signetDTO.setDocFileId(pdfFileId);
        signetDTO.setMetFileIdList(metFiles);
        signetDTO.setSignatoryDTOList(signatorys);
        signetDTO.setSignLevelCode(0);
        ApiResultVO<String> signet = microThirdService.signet(signetDTO);
        return signet;
    }

    public ApiResultVO<String> signet(String pdfFileId, List<String> metFiles, CaseDocTypeEnum caseDoc, String[] signatoryUserIds) {
        return signet(pdfFileId, metFiles, caseDoc, signatoryUserIds, false);
    }

    public ApiResultVO<String> signetAndArbitrationSignet(String pdfFileId, List<String> metFiles, CaseDocTypeEnum caseDoc, String[] signatoryUserIds) {
        return signet(pdfFileId, metFiles, caseDoc, signatoryUserIds, true);
    }

    public ApiResultVO<String> signet(String pdfFileId, List<String> metFiles, CaseDocTypeEnum caseDoc, String[] signatoryUserIds, boolean arbitrationSignet) {
        //是否需要仲裁委盖章
        List<SignatoryDTO> signatorys = signetMapper.querySignatoryByUserIds(signatoryUserIds);
        if (arbitrationSignet) {
            signatorys.add(getSignatoryDTO());
        }
        double lenght = signatorys.size();
        SignatoryDTO signatory;
        for (int i = 0; i < signatorys.size(); i++) {
            signatory = signatorys.get(i);
            List<SignatoryDTO.SignPageDTO> signPages = new ArrayList<>();
            SignatoryDTO.SignPageDTO signPage = new SignatoryDTO.SignPageDTO();
            signPage.setPage(-1);
            List<SignatoryDTO.SignChapteDTO> chaptes = new ArrayList<>();
            SignatoryDTO.SignChapteDTO chapte = new SignatoryDTO.SignChapteDTO();
            chapte.setOffsetY(0.9d);
            chapte.setOffsetX(i / lenght);
            chaptes.add(chapte);
            signPage.setChaptes(chaptes);
            signPages.add(signPage);
            signatory.setChapteJson(signPages);
        }
        return signet(pdfFileId, metFiles, caseDoc, signatorys);
    }

    /**
     * 得到仲裁委盖章信息
     *
     * @return
     */
    private SignatoryDTO getSignatoryDTO() {
        SignatoryDTO signatory = new SignatoryDTO();
        signatory.setEmail("yihaoxu1998@gmail.com");
        signatory.setFullName("徐奕豪");
        signatory.setIdentityTypeCode(1);
        signatory.setIdentityCard("441521199802138216");
        signatory.setMobile("13148726005");
        signatory.setNoNeedVerify(1);

        List<SignatoryDTO.SignPageDTO> signPages = new ArrayList<>();
        SignatoryDTO.SignPageDTO signPage = new SignatoryDTO.SignPageDTO();
        signPage.setPage(-1);
        List<SignatoryDTO.SignChapteDTO> chaptes = new ArrayList<>();
        SignatoryDTO.SignChapteDTO chapte = new SignatoryDTO.SignChapteDTO();
        chapte.setOffsetY(0.7d);
        chapte.setOffsetX(0.9d);
        chaptes.add(chapte);
        signPage.setChaptes(chaptes);
        signPages.add(signPage);
        signatory.setChapteJson(signPages);
        return signatory;
    }

    public ApiResultVO<String> signet(String pdfFileId, List<String> metFiles, CaseDocTypeEnum caseDoc) {
        List<SignatoryDTO> signatorys = new ArrayList<>();
        SignatoryDTO signatory = getSignatoryDTO();
        signatorys.add(signatory);
        return signet(pdfFileId, metFiles, caseDoc, signatorys);
    }

}