package me.ljseokd.springboot.domain.posts;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    void posts_save() throws Exception {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("ljseokd@gmail.com")
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertEquals(title, posts.getTitle());
        assertEquals(content, posts.getContent());
    }
}