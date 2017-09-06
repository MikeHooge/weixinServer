package com.biaoche.server.service.wchart.impl;

import java.util.HashMap;
import java.util.Map;

import com.biaoche.server.commons.WebResult;
import com.biaoche.server.service.wchart.TokenService;
import com.biaoche.server.util.UrlConstants;
import com.biaoche.server.util.http.HttpClientUtil;

public class TokenServiceImpl implements TokenService {

	@Override
	public WebResult getAccessToken() {
		Map<String, Object> params = new HashMap<>();
		params.put("grant_type", "client_credential");
		params.put("appid", "wx0acdc62d5e945ca8");
		params.put("secret", "e9c4b9458cd42ac1510e43b136f11a66");
		HttpClientUtil.httpGet(UrlConstants.WECHART_GET_TOKEN, params, null);
		return WebResult.getSuccessResult();
	}

}
