package me.ljseokd.springboot.web;

import lombok.RequiredArgsConstructor;
import me.ljseokd.springboot.service.posts.PostsService;
import me.ljseokd.springboot.web.dto.PostsSaveRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id,
            @RequestBody PostsSaveRequestDto requestDto){
        return postsService.update(id,requestDto);
    }

    @GetMapping("/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Long delete (@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

}
