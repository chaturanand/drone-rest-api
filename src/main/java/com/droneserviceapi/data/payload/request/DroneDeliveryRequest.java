package com.droneserviceapi.data.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * 
 * @author chaturanand Yadav
 * @since 2023-03-21
 *
 */

public class DroneDeliveryRequest {
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
