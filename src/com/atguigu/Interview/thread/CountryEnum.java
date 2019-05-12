package com.atguigu.Interview.thread;

public enum CountryEnum {
	ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"赵"),FIVE(5,"魏"),SIX(6,"韩");
	
	private Integer code;
	private String message;
	public Integer getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	CountryEnum(Integer code, String message){
		this.code = code;
		this.message = message;
		
	}
	
	public static CountryEnum foreach_countryEnum(int index){
		CountryEnum[] countryEnums = CountryEnum.values();
		for (CountryEnum countryEnum : countryEnums) {
			if(countryEnum.getCode() == index){
				return countryEnum;
			}
		}
		return null;
	}
	
}
