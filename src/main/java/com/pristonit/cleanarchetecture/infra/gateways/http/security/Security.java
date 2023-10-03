package com.pristonit.cleanarchetecture.infra.gateways.http.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Security {


	public static final Integer HASH_LENGTH = 10;
	public static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder(HASH_LENGTH);

}
