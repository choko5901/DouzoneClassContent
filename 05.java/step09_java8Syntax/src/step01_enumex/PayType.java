package step01_enumex;

import java.util.Arrays;
import java.util.List;

public enum PayType {
	CASH("현금", Arrays.asList("계좌이체", "무통장입금")),
	CARD,
	ETC;
	
	private String typeCategory;
	private List<String> typeList;
	
	PayType(){};
	
	PayType(String typeCategory, List<String> typeList ){
		this.typeCategory = typeCategory;
		this.typeList = typeList;
	}

	public String getTypeCategory() {
		return typeCategory;
	}

	public void setTypeCategory(String typeCategory) {
		this.typeCategory = typeCategory;
	}

	public List<String> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<String> typeList) {
		this.typeList = typeList;
	}
	
}
