package com.nhnacademey.board.domain.repository;

import com.nhnacademey.board.domain.post.Post;

import java.util.HashMap;
import java.util.Map;

public class PostList implements PostRepository{

    Map<Long, Post> posts;

    public PostList() {
        this.posts = new HashMap<>();
    }

    private long id = 0;

    @Override
    public long register(Post post) {
        posts.put(++id,post);
        return id;
    }

    @Override
    public void modify(Post post) {
    }

    @Override
    public void remove(long id) {

        if (id == posts.size()) { // 게시물 id 가 가장 마지막이라면
            posts.remove(id);
        }else {
            posts.forEach( (key,post) ->{
                if(key > id){
                    post.setId(key-1);
                    posts.put(key-1,post);
                }
            });
            posts.remove((long)posts.size());
        }
        this.id--;
    }

    @Override
    public Post getPost(long id) {
        return posts.get(id);
    }

    @Override
    public Map<Long, Post> getPosts() {
        return posts;
    }
}
