package com.share.message.controller;

import com.share.common.domain.dto.PageDTO;
import com.share.common.domain.so.PageSO;
import com.share.message.domain.dto.MessageTemplateDTO;
import com.share.message.domain.dto.MessageTemplateFormDTO;
import com.share.message.domain.so.MessageTemplatePageSO;
import com.share.message.service.IMessageTemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author xq-cloud
 * @version 1.0
 * @description: 第三方短信平台模板信息管理 前端控制器
 * @date 2026/3/7 20:54
 */
@Api(tags = "短信模板管理接口")
@RestController
@RequestMapping("/message-templates")
@RequiredArgsConstructor
public class MessageTemplateController {

    private final IMessageTemplateService messageTemplateService;

    @PostMapping
    @ApiOperation("新增短信模板")
    public Long saveMessageTemplate(@RequestBody MessageTemplateFormDTO messageTemplateDTO){
        return messageTemplateService.saveMessageTemplate(messageTemplateDTO);
    }

    @PutMapping("/{id}")
    @ApiOperation("更新短信模板")
    public void updateMessageTemplate(
            @RequestBody MessageTemplateFormDTO messageTemplateDTO,
            @ApiParam(value = "短信模板id", example = "1") @PathVariable("id") Long id){
        messageTemplateDTO.setId(id);
        messageTemplateService.updateMessageTemplate(messageTemplateDTO);
    }

    @GetMapping
    @ApiOperation("分页查询短信模板")
    public PageDTO<MessageTemplateDTO> queryMessageTemplates(PageSO<MessageTemplatePageSO> pageSO){
        return messageTemplateService.queryMessageTemplates(pageSO);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询短信模板")
    public MessageTemplateDTO queryMessageTemplate(@ApiParam(value = "模板id", example = "1") @PathVariable("id") Long id){
        return messageTemplateService.queryMessageTemplate(id);
    }
}
