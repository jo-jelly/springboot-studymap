package com.studymap.service.posts;


import com.studymap.domain.posts.Posts;
import com.studymap.domain.posts.PostsRepository;
import com.studymap.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {

        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        // 영속성 컨텍스트에 데이터가 있는지 조회
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
         /*
          Spring Data Jpa를 쓴다면 기본 옵션으로 EntityManager가 활성화되어 영속성 컨텍스트가 유지된 상태다. (영속성 컨텍스트에 엔티티 객체가 들어있는 상태)
          업데이트로 값만 바꿔주면 트랜잭션 끝나는 시점에 DB반영
          따라서 업데이트 쿼리 날리는 부분이 없다.
        */
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true) //readOnly = true는 트랜젝션 범위는 유지하되 조회기능만 남겨 조회속도가 개선된다.
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }


    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        postsRepository.delete(posts);
    }
    //상세 글 페이지
    @Transactional(readOnly = true)
    public PostsViewResponseDto findByIdView(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        Integer views = postsRepository.findByIdView(id);
        System.out.println(views);
        return new PostsViewResponseDto(entity);
    }

}
