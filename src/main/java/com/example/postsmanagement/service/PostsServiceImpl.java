package com.example.postsmanagement.service;

import com.example.postsmanagement.exception.EntityAlreadyExistsException;
import com.example.postsmanagement.exception.EntityNotFoundException;
import com.example.postsmanagement.model.Post;
import com.example.postsmanagement.model.dto.PostDto;
import com.example.postsmanagement.repo.PostsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
/*
    This service ensures no two Posts have the same title(En/Ar)
 */
@Service
@Transactional
public class PostsServiceImpl implements PostsService {
    private PostsRepository postsRepository;

    public PostsServiceImpl(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    private List<String> checkDuplication(String titleEn, String titleAr) {
        List<String> duplicatedTitles = new ArrayList<>();
        if(postsRepository.existsByTitleEn(titleEn)) {
            duplicatedTitles.add("titleEn");
        }
        if(postsRepository.existsByTitleAr(titleAr)) {
            duplicatedTitles.add("titleAr");
        }
        return duplicatedTitles;
    }
    public Post create(Post post) {
        List<String> duplicatedTitles = checkDuplication(post.getTitleEn(), post.getTitleAr());
        if(!duplicatedTitles.isEmpty()) {
            throw new EntityAlreadyExistsException(duplicatedTitles);
        }
        return postsRepository.save(post);
    }

    public void delete(Integer postId) {
        if(postsRepository.existsByPostId(postId)) {
            postsRepository.deleteByPostId(postId);
            return;
        }
        throw new EntityNotFoundException(Post.class, "postId", Integer.toString(postId));
    }

    public List<Post> readAll(Integer pageNumber, Integer pageLimit) {
        Pageable paging = PageRequest.of(pageNumber, pageLimit);
        Page<Post> pagedPosts = postsRepository.findAll(paging);
        if(pagedPosts.hasContent()) {
            return pagedPosts.getContent();
        }
        else {
            return new ArrayList<Post>();
        }
    }

    public Long countAll() {
        // used to return number of entities in Get Request with Pagination
        return postsRepository.count();
    }

    public Post readById(Integer postId) {
        Post post = postsRepository.findFirstByPostId(postId);
        if (post != null) {
            return post;
        }
        throw new EntityNotFoundException(Post.class, "postId", Integer.toString(postId));
    }

    private Post replaceNonNull(Post post, PostDto dto) {

        if(dto.getTitleEn() != null) {
            post.setTitleEn(dto.getTitleEn());
        }
        if(dto.getTitleAr() != null) {
            post.setTitleAr(dto.getTitleAr());
        }
        if(dto.getBodyEn() != null) {
            post.setBodyEn(dto.getBodyEn());
        }
        if(dto.getBodyAr() != null) {
            post.setBodyAr(dto.getBodyAr());
        }
        if(dto.getImageUrl() != null) {
            post.setImageUrl(dto.getImageUrl());
        }
        if(dto.getUrl() != null) {
            post.setUrl(dto.getUrl());
        }
        if(dto.getInterestId() != null) {
            post.setInterestId(dto.getInterestId());
        }

        return post;
    }

    private List<String> getTitleValuesToCompare(List<String> postTitles, List<String> dtoTitles) {
        List<String> titleValuesToCompare = dtoTitles;
        if(dtoTitles.get(0) != null && dtoTitles.get(0).equals(postTitles.get(0))) {
            titleValuesToCompare.set(0, null);
        }
        if(dtoTitles.get(1) != null && dtoTitles.get(1).equals(postTitles.get(1))) {
            titleValuesToCompare.set(1, null);
        }
        return titleValuesToCompare;
    }

    public void update(Integer postId, PostDto dto) {
        Post post = postsRepository.findFirstByPostId(postId);

        if(post == null) {
            throw new EntityNotFoundException(Post.class, "postId", Integer.toString(postId));
        }

        List<String> postTitles = new ArrayList<String>(){{add(post.getTitleEn()); add(post.getTitleAr());}};
        List<String> dtoTitles = new ArrayList<String>(){{add(dto.getTitleEn()); add(dto.getTitleAr());}};

        List<String> titlesToCompare = getTitleValuesToCompare(postTitles, dtoTitles);

        List<String> duplicatedTitles = checkDuplication(titlesToCompare.get(0), titlesToCompare.get(1));

        if(!duplicatedTitles.isEmpty()) {
            throw new EntityAlreadyExistsException(duplicatedTitles);
        }
        postsRepository.save(post);
    }
}
