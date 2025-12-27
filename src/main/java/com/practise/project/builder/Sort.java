package com.practise.project.builder;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Slf4j
public class Sort implements Serializable {
	
	private static final long serialVersionUID = 6660702712842552093L;
    public static final String DIRECTION_ASC = "asc";
    public static final String DIRECTION_DESC = "desc";
    private String property;
    private String direction;

}
