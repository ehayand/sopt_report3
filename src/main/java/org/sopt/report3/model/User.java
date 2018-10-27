package org.sopt.report3.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by ehay@naver.com on 2018-10-27
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

@Data
@AllArgsConstructor
public class User {
    private int userIdx;
    private String name;
    private String part;

    public User(String name, String part) {
        this.name = name;
        this.part = part;
    }
}
