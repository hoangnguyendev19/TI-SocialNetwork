package com.tma.demo.service.report.imp;

import com.tma.demo.common.ErrorCode;
import com.tma.demo.common.SettingKey;
import com.tma.demo.dto.request.ReportPostRequest;
import com.tma.demo.entity.Post;
import com.tma.demo.entity.PostReport;
import com.tma.demo.entity.User;
import com.tma.demo.exception.BaseException;
import com.tma.demo.repository.PostReportRepository;
import com.tma.demo.repository.SettingRepository;
import com.tma.demo.service.post.PostService;
import com.tma.demo.service.report.ReportService;
import com.tma.demo.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ReportServiceImp
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
public class ReportServiceImp implements ReportService {
    private final UserService userService;
    private final PostService postService;
    private final PostReportRepository postReportRepository;
    private final SettingRepository settingRepository;

    @Override
    public void report(ReportPostRequest reportPostRequest) {
        User user = userService.getUserDetails();
        Optional<PostReport> postReport = postReportRepository.findByUser(user);
        if (postReport.isPresent()) {
            postReport.get().setReason(reportPostRequest.getReason());
            postReportRepository.save(postReport.get());
        } else {
            Post post = postService.getPost(reportPostRequest.getPostId());
            PostReport report = PostReport.builder()
                    .post(post)
                    .user(user)
                    .reason(reportPostRequest.getReason())
                    .build();
            postReportRepository.save(report);
            int totalReport = postReportRepository.findTotalReport(post.getId());
            int maxReport = Integer.parseInt(settingRepository.findByKey(SettingKey.MAX_REPORTS)
                    .orElseThrow(() -> new BaseException(ErrorCode.SETTING_KEY_DOES_NOT_EXIST))
                    .getValue());
            if (totalReport >= maxReport) {
                postService.deletePost(post.getId().toString());
            }

        }

    }
}
