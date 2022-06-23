package com.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SungJukDTO {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
}
