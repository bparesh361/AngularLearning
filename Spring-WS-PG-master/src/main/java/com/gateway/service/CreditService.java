package com.gateway.service;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.gateway.util.CommonConstants;
import com.gateway.ws.AuthRequest;
import com.gateway.ws.AuthResponse;
import com.gateway.ws.GetTransactionDetailRequest;
import com.gateway.ws.GetTransactionDetailResponse;
import com.gateway.ws.RespType;
import com.gateway.ws.TerminalRegRequest;
import com.gateway.ws.TerminalRegResponse;
import com.gateway.ws.TransactionDetailType;
import com.gateway.ws.TransactionRequest;
import com.gateway.ws.TransactionResponse;
import com.gateway.ws.TransactionType;

@Endpoint
public class CreditService {
	
	@PayloadRoot(namespace=CommonConstants.NAMESPACE_URI,localPart="AuthRequest")
	@ResponsePayload
	public AuthResponse authenticate(@RequestPayload AuthRequest authRequest) throws Exception {
		System.out.println("---- UserName -- " + authRequest.getUserId());
		System.out.println("---- Password -- " + authRequest.getPassword());
		AuthResponse response = new AuthResponse();
		RespType resp = new RespType();
		resp.setRespCode(new Short("1"));
		resp.setRespMessage("message");
		response.setResp(resp);
		return response;		
	}	
	
	@PayloadRoot(namespace=CommonConstants.NAMESPACE_URI,localPart="TerminalRegRequest")
	@ResponsePayload
	public TerminalRegResponse terminalRegistration(@RequestPayload TerminalRegRequest request){
		System.out.println(" --- Terminal Registration Request Received ---- ");
		System.out.println("---- Registering Terminal Id --- " + request.getTerminal().getTerminalId());
		TerminalRegResponse response = new TerminalRegResponse();
		RespType respType = new RespType();
		respType.setRespCode(new Short("0"));
		respType.setRespMessage("Terminal Registered Successfully.");
		response.setTerminal(request.getTerminal());
		response.setSessionId(UUID.randomUUID().toString());
		return response;
	}
	
	@PayloadRoot(namespace=CommonConstants.NAMESPACE_URI,localPart="TransactionRequest")
	@ResponsePayload
	public TransactionResponse transaction(@RequestPayload TransactionRequest request){
		System.out.println(" --- Transaction Request Received ---- ");
		System.out.println(" --- Credit Card No. --- " + request.getCard());
		System.out.println(" --- Session Id --- " + request.getSessionId());
		System.out.println(" ---- Amount Associated With Transaction --- " + request.getAmount());		
		System.out.println("---- Registering Terminal Id --- " + request.getTransaction());
		TransactionResponse response = new TransactionResponse();
		RespType respType = new RespType();
		respType.setRespCode(new Short("0"));
		respType.setRespMessage("Transcation Completed Successfully.");
		response.setResp(respType);
		response.setTranscationId(UUID.randomUUID().toString());
		return response;
	}
	
	@PayloadRoot(namespace=CommonConstants.NAMESPACE_URI,localPart="GetTransactionDetailRequest")
	@ResponsePayload
	public GetTransactionDetailResponse getTransactions(@RequestPayload GetTransactionDetailRequest request){
		System.out.println(" --- Get Transaction Request Received ---- ");
		System.out.println(" --- Credit Card No. --- " + request.getCardNo());
		GetTransactionDetailResponse response = new GetTransactionDetailResponse();
		RespType respType = new RespType();
		respType.setRespCode(new Short("0"));
		respType.setRespMessage("Transcation Completed Successfully.");
		response.setResp(respType);
		TransactionDetailType transactionDetail = new TransactionDetailType();
		transactionDetail.setAmount(new Double("123.32"));
		transactionDetail.setTransaction(TransactionType.DEBIT);
		transactionDetail.setTranscationId(UUID.randomUUID().toString());
		
		TransactionDetailType transactionDetail1 = new TransactionDetailType();
		transactionDetail1.setAmount(new Double("123.32"));
		transactionDetail1.setTransaction(TransactionType.DEBIT);
		transactionDetail1.setTranscationId(UUID.randomUUID().toString());
		
		
		response.getTransactionDetails().add(transactionDetail);
		response.getTransactionDetails().add(transactionDetail1);
		return response;
	}
	
	
	
}
