package com.droneserviceapi.data.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



/**
 * 
 * @author chaturanand Yadav
 * @since 2023-03-21
 *
 */

public class DroneGetBatteryRequest {

	public DroneGetBatteryRequest() {
		
	}
	
	public DroneGetBatteryRequest(@NotBlank @NotNull String serialNumber) {
		super();
		this.serialNumber = serialNumber;
	}

	@NotBlank
	@NotNull
	private String serialNumber;
	

	
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
}
