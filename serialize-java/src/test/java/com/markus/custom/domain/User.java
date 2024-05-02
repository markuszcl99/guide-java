package com.markus.custom.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

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
    private Long id;
    private String username;
    private String company;
    private Double salary;
    private List<Long> poiIds;
}
