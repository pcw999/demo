package com.example.demo.Controller;

import com.example.demo.Repository.ImageRepository;
import com.example.demo.entity.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Repository.UserRepository;

// for sample_post
import com.example.demo.Repository.post_repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path="demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private post_repository post_repo;

    private static final String SECRET_KEY = "31415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days


    @PostMapping(path="add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestBody UserDTO userDTO) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        userRepository.save(userDTO);
        return "Saved";
    }

    @GetMapping(path="all")
    public @ResponseBody Iterable<UserDTO> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @PostMapping(path="upload")
    @ResponseBody
    public String postImage(@RequestBody ImageDTO imageDTO) {
        imageRepository.save(imageDTO);
        return "Saved";
    }

    @PostMapping(path="add_sample")
    public @ResponseBody String addNewPost (@RequestParam String text) {
        sample_post sample = new sample_post();
        sample.set_text(text);
        post_repo.save(sample);
        return "Saved";
    }

    @GetMapping(path="sample_post")
    public @ResponseBody sample_post get_sample_post() {
        Integer id = 52;
        Optional<sample_post> postOptional = post_repo.findById(id);

        if (postOptional.isPresent()) {
            return postOptional.get(); // Get the User if it exists
        } else {
            // Handle the case where the User is not found
            sample_post sample = new sample_post();
            sample.set_text("ERROR");
            return sample;
        }
    }

    @PostMapping(path="login")
    @ResponseBody
    public AuthResponse login(@RequestBody LoginDTO loginDTO) {
        List<UserDTO> result = userRepository.findById(loginDTO.getId());
        if(result.isEmpty()) { // 유저 존재 x
            return new AuthResponse("404", "Not Found", null, null);
        } else {
            UserDTO now_user = result.get(0);
            if(now_user.getPassword().equals(loginDTO.getPassword())) { // 비번 일치 x
                String token = Jwts.builder()
                        .setSubject(now_user.getId())
                        .setIssuedAt(new Date(System.currentTimeMillis()))
                        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                        .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                        .compact();

                return new AuthResponse("201", "token_created", token, now_user);
            } else {
                return new AuthResponse("404", "inconsistency", null, null);
            }
        }
    }

    public String User_parsing(String token) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(SECRET_KEY.getBytes()).build().parseClaimsJws(token.substring(7));
            return claims.getBody().get("sub", String.class);
        } catch (Exception e) {
            // 토큰 파싱 오류 처리
            e.printStackTrace();
            return null;
        }
    }

}