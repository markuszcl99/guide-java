package com.markus.serialize.pb.domain;

import io.protostuff.Tag;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author: markus
 * @date: 2024/5/2 9:36 AM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Data
@Builder
@ToString
public class User {
    @Tag(1)
    private Long id;
    @Tag(2)
    private String username;
    @Tag(3)
    private String company;
    @Tag(4)
    private Double salary;

}
