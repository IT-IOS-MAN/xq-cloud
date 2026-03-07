package com.share.message.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.benmanes.caffeine.cache.Cache;
import com.share.common.domain.dto.PageDTO;
import com.share.common.domain.so.PageSO;
import com.share.common.utils.BeanUtils;
import com.share.common.utils.StringUtils;
import com.share.message.domain.dto.SmsThirdPlatformDTO;
import com.share.message.domain.dto.SmsThirdPlatformFormDTO;
import com.share.message.domain.po.SmsThirdPlatform;
import com.share.message.domain.so.SmsThirdPlatformPageSO;
import com.share.message.mapper.SmsThirdPlatformMapper;
import com.share.message.service.ISmsThirdPlatformService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description: 第三方云通讯平台 服务实现类
 * @date 2026/3/7 23:54
 */
@Service
public class SmsThirdPlatformServiceImpl extends ServiceImpl<SmsThirdPlatformMapper, SmsThirdPlatform> implements ISmsThirdPlatformService {

    @Resource
    private Cache<String, List<SmsThirdPlatform>> platformCache;

    @Override
    public List<SmsThirdPlatform> queryAllPlatform(){
        return platformCache.get("PLATFORM", key -> lambdaQuery().orderByAsc(SmsThirdPlatform::getPriority).list());
    }

    @Override
    public Long saveSmsThirdPlatform(SmsThirdPlatformFormDTO thirdPlatformDTO) {
        SmsThirdPlatform thirdPlatform = BeanUtils.copyBean(thirdPlatformDTO, SmsThirdPlatform.class);
        save(thirdPlatform);
        return thirdPlatform.getId();
    }

    @Override
    public void updateSmsThirdPlatform(SmsThirdPlatformFormDTO thirdPlatformDTO) {
        updateById(BeanUtils.copyBean(thirdPlatformDTO, SmsThirdPlatform.class));
    }

    @Override
    public PageDTO<SmsThirdPlatformDTO> querySmsThirdPlatforms(PageSO<SmsThirdPlatformPageSO> querySO) {
        // 1.分页条件
        Page<SmsThirdPlatform> page = querySO.toMpPage();

        SmsThirdPlatformPageSO so = querySO.getCondition();
        // 2.过滤条件
        page = lambdaQuery()
                .eq(so.getStatus() != null, SmsThirdPlatform::getStatus, so.getStatus())
                .like(StringUtils.isNotBlank(so.getKeyword()), SmsThirdPlatform::getName, so.getKeyword())
                .page(page);
        // 3.数据转换
        return PageDTO.of(page, SmsThirdPlatformDTO.class);
    }

    @Override
    public SmsThirdPlatformDTO querySmsThirdPlatform(Long id) {
        return BeanUtils.copyProperties(getById(id), SmsThirdPlatformDTO.class);
    }
}
