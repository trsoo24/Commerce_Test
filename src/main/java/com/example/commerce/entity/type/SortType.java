package com.example.commerce.entity.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SortType {
    REGISTERED("REGISTERED"), NAME("NAME");
    private final String sortType;
}
