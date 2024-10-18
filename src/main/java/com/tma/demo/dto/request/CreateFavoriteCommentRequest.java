package com.tma.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFavoriteCommentRequest {
    @JsonProperty("comment_id")
    private String commentId;
    @JsonProperty("user_id")
    private String userId;
}
