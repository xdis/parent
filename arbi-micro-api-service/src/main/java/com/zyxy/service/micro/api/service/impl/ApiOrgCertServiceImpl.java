package com.zyxy.service.micro.api.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.ApiOrgCert;
import com.zyxy.common.domain.ApiOrgCertExample;
import com.zyxy.common.domain.ApiOrgCertWithBLOBs;
import com.zyxy.common.domain.ApiOrgnazation;
import com.zyxy.common.mapper.ApiOrgCertMapper;
import com.zyxy.common.service.SequenceService;
import com.zyxy.common.util.StringUtil;
import com.zyxy.common.vo.BuzzResultVO;
import com.zyxy.service.micro.api.service.ApiOrgCertService;
import com.zyxy.service.micro.api.service.ApiOrgnazationService;
import com.zyxy.service.micro.api.service.SysSecretService;
import com.zyxy.service.micro.api.service.cert.CertUtil;
/**
 * 
 * @author tanquan
 *
 */
@Service
public class ApiOrgCertServiceImpl implements ApiOrgCertService {

	@Autowired
	private ApiOrgCertMapper mapper;
	@Autowired
	private ApiOrgnazationService apiOrgnazationService;
	@Autowired
	private SequenceService sequenceService;
	@Autowired
	private SysSecretService sysSecretService;
	
	@Value("${api.cert.issuer}")
	private String issuer;
	@Value("${api.cert.validity}")
	private Integer validity;
	@Value("${api.cert.clientAlias}")
	private String clientAlias;
	@Value("${api.cert.serverAlias}")
	private String serverAlias;
	@Value("${api.cert.clientPrefix:C}")
	private String clientPrefix;
	@Value("${api.cert.serverPrefix:S}")
	private String serverPrefix;
	@Value("${api.cert.ext:.cer}")
	private String certExt;
	@Value("${api.cert.storeExt:.pfx}")
	private String certStoreExt;
	@Value("${api.cert.version:1}")
	private Integer certVersion;
	
	
	@Override
	public int countByExample(ApiOrgCertExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(ApiOrgCertExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return mapper.deleteByPrimaryKey(id);
	}


	@Override
	public List<ApiOrgCert> selectByExample(ApiOrgCertExample example) {
		return mapper.selectByExample(example);
	}



	@Override
	public int updateByExample(ApiOrgCert record,
			ApiOrgCertExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(ApiOrgCertWithBLOBs record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ApiOrgCert record) {
		return mapper.updateByPrimaryKey(record);
	}
	
	@Override
	public PageInfo<ApiOrgCert> selectPagedByExample(Integer page, Integer pageSize,
			ApiOrgCertExample example) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (pageSize == null || pageSize < 1 || pageSize > 1000) {
			pageSize = 10;
		}
		PageHelper.startPage(page, pageSize);
		return new PageInfo<>(this.selectByExample(example));
	}

    @Override
    public int insert(ApiOrgCertWithBLOBs record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(ApiOrgCertWithBLOBs record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<ApiOrgCertWithBLOBs> selectByExampleWithBLOBs(
            ApiOrgCertExample example) {
        return mapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public ApiOrgCertWithBLOBs selectByPrimaryKey(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(ApiOrgCertWithBLOBs record,
            ApiOrgCertExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExampleWithBLOBs(ApiOrgCertWithBLOBs record,
            ApiOrgCertExample example) {
        return mapper.updateByExampleWithBLOBs(record, example);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(ApiOrgCertWithBLOBs record) {
        return mapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public BuzzResultVO<ApiOrgCertWithBLOBs> generateCert(String orgNo, String clientStorePass) {
        BuzzResultVO<ApiOrgCertWithBLOBs> ret = new BuzzResultVO<ApiOrgCertWithBLOBs>();
        ApiOrgnazation org = apiOrgnazationService.selectByPrimaryKey(orgNo);
        if (org == null) {
            return ret.setOk(false).setMessage("机构/用户不存在");
        }
        // 生成证书及库
        if (StringUtil.isEmpty(org.getRegName())
                || StringUtil.isEmpty(org.getOrgSite())
                || StringUtil.isEmpty(org.getCountry())
                || StringUtil.isEmpty(org.getProvince())
                || StringUtil.isEmpty(org.getCity())) {
            return ret.setOk(false).setMessage("机构/用户信息不完整（机构名称/网址/国家代码/省份/地区（市）");
        }
        // 组织商户证书相关信息
        StringBuilder dn = new StringBuilder(); // 生成 dn 类似证书唯一标识
        dn.append("CN=").append(org.getOrgSite()).append(",OU=")
                .append(org.getRegName()).append(",O=")
                .append(org.getRegName()).append(",L=")
                .append(org.getCity()).append(",ST=")
                .append(org.getProvince()).append(",C=")
                .append(org.getCountry());
        byte[] clientCertStoreByte = CertUtil.createKeyStore(validity, clientAlias, dn.toString(), clientStorePass, clientStorePass, issuer);
        byte[] clientCertPublicByte = CertUtil.exportCer(clientAlias, clientStorePass, clientCertStoreByte); // 获取商户公钥证书
        ApiOrgCertWithBLOBs orgCertInfo = new ApiOrgCertWithBLOBs();
        orgCertInfo.setOrgId(orgNo);
        orgCertInfo.setCltPublicKey(clientCertPublicByte); // 保存商户公钥
        orgCertInfo.setCltPrivateCert(clientCertStoreByte); // 保存商户私钥库
        // 生成服务端私钥库和公钥
        // 组织服务端证书相关信息
        dn = new StringBuilder(issuer);
        String serverStorePass = UUID.randomUUID().toString().substring(0, 8);
        byte[] serverCertStoreByte = CertUtil.createKeyStore(validity,serverAlias, dn.toString(), serverStorePass, serverStorePass, issuer);
        byte[] serverCertPublicByte = CertUtil.exportCer(serverAlias, serverStorePass, serverCertStoreByte); // 获取商户公钥证书
        orgCertInfo.setPltPrivateCert(serverCertStoreByte); // 保存平台证书库到数据库
        orgCertInfo.setPltPublicKey(serverCertPublicByte); // 保存平台公钥证书
        orgCertInfo.setPltPrivateKeyPass(serverStorePass);
        orgCertInfo.setPltPrivateKeyStorePass(serverStorePass);
        
        // 定义证书/证书库名
        String certSeq = sequenceService.getCertSeq();
        String clientCertName = clientPrefix + orgNo + "_" + certSeq + certExt; // 客户端公钥证书名
        String clientCertStoreName = clientPrefix + orgNo + "_" + certSeq + certStoreExt; // 客户端私钥库名
        String serverCertName = serverPrefix + orgNo + "_" + certSeq + certExt; // 平台公钥证书名
        String serverCertStoreName = serverPrefix + orgNo + "_" + certSeq + certStoreExt; // 平台私钥库名
        
        // 保存信息到数据库
        BuzzResultVO<String> encRet = sysSecretService.encrypt(clientStorePass);
        if (!encRet.getOk()) {
            return ret.setOk(false).setMessage("加密密钥出错");
        }
        orgCertInfo.setCltPrivateKeyPass(encRet.getAttach());
        orgCertInfo.setCltPrivateKeyStorePass(encRet.getAttach());
        encRet = sysSecretService.encrypt(serverStorePass);
        if (!encRet.getOk()) {
            return ret.setOk(false).setMessage("加密密钥出错");
        }
        orgCertInfo.setPltPrivateKeyPass(encRet.getAttach());
        orgCertInfo.setPltPrivateKeyStorePass(encRet.getAttach());
        
        orgCertInfo.setCreateTime(new Date());
        orgCertInfo.setCltPublicKeyName(clientCertName);
        orgCertInfo.setCltPrivateCertName(clientCertStoreName);
        orgCertInfo.setPltPublicKeyName(serverCertName);
        orgCertInfo.setPltPrivateCertName(serverCertStoreName);
        orgCertInfo.setStatus(1);
        orgCertInfo.setVersion(certVersion);
        orgCertInfo.setId(sequenceService.getCommonID());
        // 将其他证书记录更新为不可用
        ApiOrgCertExample ocEx = new ApiOrgCertExample();
        ocEx.createCriteria().andOrgIdEqualTo(orgNo).andStatusEqualTo(1);
        ApiOrgCertWithBLOBs up = new ApiOrgCertWithBLOBs();
        up.setStatus(2);
        mapper.updateByExampleSelective(up, ocEx);
        int it = mapper.insertSelective(orgCertInfo);
        if (it != 1) {
            return ret.setOk(false).setMessage("保存证书失败");
        }
        return ret.setOk(true).setAttach(orgCertInfo);
    }
	
}
