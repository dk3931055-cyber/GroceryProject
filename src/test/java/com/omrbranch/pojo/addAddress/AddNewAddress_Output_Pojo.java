package com.omrbranch.pojo.addAddress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddNewAddress_Output_Pojo {
	private int status;
	private String message;
	private int address_id;

}
