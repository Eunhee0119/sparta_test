package com.example.post.service;

import com.example.post.domain.Item;
import com.example.post.domain.dto.PostRequestDto;
import com.example.post.domain.dto.PostResponseDto;
import com.example.post.domain.dto.PostSummaryResponseDto;
import com.example.post.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final ItemRepository itemRepository;


    @Transactional
    public PostResponseDto createPosts(Item newItem) {
        Item savedItem = itemRepository.save(newItem);
        return PostResponseDto.of(savedItem);
    }

    public List<PostSummaryResponseDto> getPosts() {
        List<Item> findPosts = itemRepository.findAll();
        return findPosts.stream().map(PostSummaryResponseDto::of).toList();
    }

    @Transactional
    public PostResponseDto updatePosts(Long id, PostRequestDto requestDto) {
        try {
            Item oldItem = itemRepository.findById(id).orElseThrow(() -> new BadRequestException("존재하지 않는 글입니다."));
            oldItem.changeTitle(requestDto.getTitle());
            oldItem.changeContent(requestDto.getContent());
            oldItem.changePrice(requestDto.getPrice());
            oldItem.changeUsername(requestDto.getUsername());
            return PostResponseDto.of(oldItem);
        } catch (BadRequestException e) { //요구사항에 자세한 내용 없음.
            throw new RuntimeException(e);
        }
    }


    @Transactional
    public void deletePosts(Long postId) {
        try {
            itemRepository.findById(postId).orElseThrow(()-> new BadRequestException("존재하지 않는 글 입니다."));
            itemRepository.deleteById(postId);
        } catch (BadRequestException e) {//요구사항에 자세한 내용 없음.
            throw new RuntimeException(e);
        }
    }
}
