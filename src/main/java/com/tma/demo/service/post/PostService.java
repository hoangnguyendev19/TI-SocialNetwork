package com.tma.demo.service.post;

import com.tma.demo.dto.request.ReportPostRequest;
import com.tma.demo.dto.response.PostDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;

@Service
public interface PostService {
    PostDto createPost(String content, MultipartFile[] mediaFiles);

    PostDto updatePost(String postId, MultipartFile[] files, String content, String[] deleteFiles);

    Page<PostDto> getNews(int page);

    void report(ReportPostRequest reportPostRequest);
}
