package com.tma.demo.controller;

import com.tma.demo.common.SuccessMessage;
import com.tma.demo.dto.ApiResponse;
import com.tma.demo.dto.request.CreatePostRequest;
import com.tma.demo.dto.request.PagingRequest;
import com.tma.demo.dto.request.ReportPostRequest;
import com.tma.demo.dto.request.UpdatePostRequest;
import com.tma.demo.dto.response.UserResponse;
import com.tma.demo.dto.response.PostDto;
import com.tma.demo.filter.PostFilter;
import com.tma.demo.repository.PostRepository;
import com.tma.demo.service.post.PostService;
import com.tma.demo.service.report.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.tma.demo.common.APIConstant.*;

/**
 * PostController
 * Version 1.0
 * Date: 11/10/2024
 * Copyright
 * Modification Logs
 * DATE          AUTHOR          DESCRIPTION
 * ------------------------------------------------
 * 11/10/2024        NGUYEN             create
 */
@RestController
@RequestMapping(value = POSTS)
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final PostRepository postRepository;
    private final ReportService reportService;

    @PostMapping
    public ResponseEntity<ApiResponse<PostDto>> createPost(@RequestBody CreatePostRequest createPostRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.<PostDto>builder()
                        .code(HttpStatus.CREATED.value())
                        .message(SuccessMessage.CREATED_POST_SUCCESS.getMessage())
                        .data(postService.createPost(createPostRequest))
                        .build());
    }

    @PutMapping
    public ResponseEntity<ApiResponse<PostDto>> updatePost(@RequestBody UpdatePostRequest updatePostRequest) {
        PostDto postDto = postService.updatePost(updatePostRequest);
        return ResponseEntity.ok(ApiResponse.<PostDto>builder()
                .code(HttpStatus.OK.value())
                .message(SuccessMessage.UPDATE_POST_SUCCESS.getMessage())
                .data(postDto)
                .build());
    }

    @DeleteMapping(value = POST_ID)
    public ResponseEntity<ApiResponse<String>> deletePost(@PathVariable("postId") String postId) {
        postService.deletePost(postId);
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .code(HttpStatus.OK.value())
                .message(SuccessMessage.DELETE_POST_SUCCESS.getMessage())
                .data(null)
                .build());
    }

    @GetMapping(value = POST_ID)
    public ResponseEntity<ApiResponse<PostDto>> getPost(@PathVariable("postId") String postId) {
        return ResponseEntity.ok(ApiResponse.<PostDto>builder()
                .code(HttpStatus.OK.value())
                .message(SuccessMessage.GET_POST_SUCCESS.getMessage())
                .data(postService.getPostDto(postId))
                .build());
    }

    @PostMapping(value = GET_POST_NEWS)
    public ResponseEntity<ApiResponse<Page<PostDto>>> getNews(@RequestBody PagingRequest pagingRequest) {
        Page<PostDto> postsDto = postService.getNews(pagingRequest);
        return ResponseEntity.ok(
                ApiResponse.<Page<PostDto>>builder()
                        .code(HttpStatus.OK.value())
                        .message(SuccessMessage.GET_NEWS_SUCCESS.getMessage())
                        .data(postsDto)
                        .build()
        );
    }

    @PostMapping(value = REPORT_POST)
    public ResponseEntity<ApiResponse<Object>> getNews(@RequestBody ReportPostRequest reportPostRequest) {
        reportService.report(reportPostRequest);
        return ResponseEntity.ok(ApiResponse.<Object>builder()
                .code(HttpStatus.OK.value())
                .message(SuccessMessage.REPORT_POST_SUCCESS.getMessage())
                .data(null)
                .build());
    }

    @PostMapping(value = SHARE)
    public ResponseEntity<ApiResponse<Page<UserResponse>>> getNews(@RequestBody PagingRequest<PostFilter> pagingRequest) {

        return ResponseEntity.ok(ApiResponse.<Page<UserResponse>>builder()
                .code(HttpStatus.OK.value())
                .message(SuccessMessage.GET_DATA_SUCCESS.getMessage())
                .data(postService.getSharedList(pagingRequest))
                .build());
    }


}
