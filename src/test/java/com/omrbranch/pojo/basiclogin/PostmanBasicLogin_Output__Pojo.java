package com.omrbranch.pojo.basiclogin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostmanBasicLogin_Output__Pojo {
	private int status;
    private String message;
    private Datas data;
    private String refer_msg;
    private int cart_count;
    private String role;

}
