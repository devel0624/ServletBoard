package com.nhnacademey.board.domain.repository;

import com.nhnacademey.board.domain.post.Post;

import java.util.Map;

public interface PostRepository {
    long register(Post post);
    void modify(Post post);
    void remove(long id);

    Post getPost(long id);
    Map<Long , Post> getPosts();
}
