package com.gnine.stocks_share.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gnine.stocks_share.misc.GlobalStringVariables;

@RestController
public class RestControllerClass {
	@GetMapping("/hello")
	public String hello(HttpServletRequest request) {
		System.out.println(LocalDateTime.now() + " server hit with browser ");
		return GlobalStringVariables.stringAsHtml;
	}
}
