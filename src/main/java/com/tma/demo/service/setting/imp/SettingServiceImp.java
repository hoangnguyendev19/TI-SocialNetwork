package com.tma.demo.service.setting.imp;

import com.tma.demo.common.ErrorCode;
import com.tma.demo.common.SettingKey;
import com.tma.demo.dto.SettingDto;
import com.tma.demo.entity.Setting;
import com.tma.demo.exception.BaseException;
import com.tma.demo.repository.ISettingRepository;
import com.tma.demo.repository.SettingRepository;
import com.tma.demo.service.setting.SettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * SettingServiceImp
 * Version 1.0
 * Date: 16/10/2024
 * Copyright
 * Modification Logs
 * DATE          AUTHOR          DESCRIPTION
 * ------------------------------------------------
 * 16/10/2024        NGUYEN             create
 */
@Service
@RequiredArgsConstructor
public class SettingServiceImp implements SettingService {
    private final ISettingRepository iSettingRepository;
    private final SettingRepository settingRepository;

    @Override
    public SettingDto createSetting(SettingDto settingRequest) {
        if(isSettingKeyExist(SettingKey.valueOf(settingRequest.getKey()))){
            throw new BaseException(ErrorCode.SETTING_KEY_ALREADY_EXISTS);
        }
        Setting setting = Setting.builder()
                .key(SettingKey.valueOf(settingRequest.getKey()))
                .value(settingRequest.getValue())
                .build();
        setting = iSettingRepository.saveAndFlush(setting);
        return new SettingDto(setting.getKey().toString(), setting.getValue());
    }

    @Override
    public SettingDto updateSetting(SettingDto settingRequest) {
        SettingKey key = SettingKey.valueOf(settingRequest.getKey());
        Setting setting = getSetting(key);
        setting.setValue(settingRequest.getValue());
        setting = iSettingRepository.saveAndFlush(setting);
        return new SettingDto(setting.getKey().toString(), setting.getValue());
    }

    @Override
    public int getMaxReport() {
        return Integer.parseInt(getSetting(SettingKey.MAX_REPORTS).getValue());
    }

    @Override
    public String getValue(SettingKey settingKey) {
        return getSetting(settingKey).getValue();
    }

    private Boolean isSettingKeyExist(SettingKey key) {
            return settingRepository.findByKey(key).isPresent();
    }

    private Setting getSetting(SettingKey key) {
        return settingRepository.findByKey(key)
                .orElseThrow(() -> new BaseException(ErrorCode.SETTING_KEY_DOES_NOT_EXIST));
    }
}
