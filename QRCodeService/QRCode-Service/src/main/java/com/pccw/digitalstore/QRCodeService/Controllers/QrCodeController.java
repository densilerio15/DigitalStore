package com.pccw.digitalstore.QRCodeService.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pccw.digitalstore.QRCodeService.DTO.ResponseDTO;
import com.pccw.digitalstore.QRCodeService.Services.QrCodeService;

@RestController
@RequestMapping("/QRCode")
public class QrCodeController{
	
	@Autowired
	QrCodeService qrCodeService;
	
	@GetMapping("/{deviceId}/{qrCodeNo}")
	public ResponseDTO getQrCode(@PathVariable("deviceId") String deviceId,
			@PathVariable("qrCodeNo") String qrCodeNo) {
		String message = "Qr Code retrieved successfully  ";
		return new ResponseDTO(qrCodeService.getQrCode(deviceId , qrCodeNo), message);
	}
	
}