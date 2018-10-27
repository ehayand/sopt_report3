package org.sopt.report3.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.report3.model.User;
import org.sopt.report3.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * Created by ehay@naver.com on 2018-10-27
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

@Slf4j
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String getTime() {
        LocalDateTime time = LocalDateTime.now();
        return time.getHour() + "시 " + time.getMinute() + "분 " + time.getSecond() + "초";
    }

    @GetMapping("/users")
    public ResponseEntity getUserList() {
        log.info("get User List");
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/users/{user_idx}")
    public ResponseEntity getUser(@PathVariable(value = "user_idx") final int userIdx) {
        log.info("get User");
        return new ResponseEntity<>(userService.findByUserIdx(userIdx), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity saveUser(@RequestBody final User user) {
        log.info("save User");
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    @PutMapping("/users/{user_idx}")
    public ResponseEntity updateUser(
            @PathVariable(value = "user_idx") final int userIdx,
            @RequestBody final User user) {
        log.info("update User");
        return new ResponseEntity<>(userService.update(userIdx, user), HttpStatus.OK);
    }

    @DeleteMapping("/users/{user_idx}")
    public ResponseEntity deleteUser(@PathVariable(value = "user_idx") final int userIdx) {
        log.info("delete User");
        return new ResponseEntity<>(userService.deleteByUserIdx(userIdx), HttpStatus.OK);
    }
}
