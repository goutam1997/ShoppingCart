package com.example.demo.strategy;

import org.springframework.stereotype.Service;

@Service
public class IdCreatorStrategyImpl implements IdCreatorStrategy {

	@Override
	public long createId(String name, long mobile) {
		// TODO Auto-generated method stub
		return mobile;
	}

}
