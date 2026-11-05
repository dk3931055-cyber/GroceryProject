package com.omrbranch.pojo.getsearchresult;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSearchList_Output_Pojo {
	private int status;
	private String message;
	private String currency;
	private ArrayList<GetSearchListData> data;
	private String banner;
	private int cart_count;
}
