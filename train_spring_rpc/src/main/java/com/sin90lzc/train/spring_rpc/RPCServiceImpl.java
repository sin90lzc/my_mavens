package com.sin90lzc.train.spring_rpc;

import org.springframework.stereotype.Service;

@Service("rpcService")
public class RPCServiceImpl implements RPCService {

	@Override
	public String service(String param) {
		return param;
	}

}
