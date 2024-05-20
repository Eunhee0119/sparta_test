package com.example.post.controller;

import com.example.post.ApiResponse;
import com.example.post.domain.dto.PostRequestDto;
import com.example.post.domain.dto.PostResponseDto;
import com.example.post.domain.dto.PostSummaryResponseDto;
import com.example.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/post")
    public List<PostSummaryResponseDto> getPosts(){
        return postService.getPosts();
    }

    @PostMapping("/post")
    public PostResponseDto newPosts(@RequestBody PostRequestDto postRequestDto){
        return postService.createPosts(PostRequestDto.toItems(postRequestDto));
    }

    @PutMapping("/post/{id}")
    public PostResponseDto updatePosts(@RequestBody PostRequestDto postRequestDto
            , @PathVariable(value="id") Long id){
        return postService.updatePosts(id,postRequestDto);
    }

    @DeleteMapping("/post/{id}")
    public ApiResponse deletePosts(@PathVariable(value="id") Long id){
        postService.deletePosts(id);
        return new ApiResponse("삭제완료");
    }


}
