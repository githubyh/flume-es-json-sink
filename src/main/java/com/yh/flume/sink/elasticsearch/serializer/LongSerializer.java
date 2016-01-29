/*
 * Copyright(c) 2015 gvtv.com.cn All rights reserved.
 * distributed with this file and available online at
 * http://www.gvtv.com.cn/
 */
package com.yh.flume.sink.elasticsearch.serializer;

import java.io.IOException;

import org.apache.flume.Context;
import org.elasticsearch.common.xcontent.XContentBuilder;

/**
 * @version 1.0
 * @author Fish
 */
public class LongSerializer implements Serializer {
	private String FIELD;

	public void initialize(Context context, String field) {
		this.FIELD = field;
	}

	public void serializer(XContentBuilder builder, String data) throws IOException {
		// TODO Auto-generated method stub
		builder.field(FIELD, Long.parseLong(data));
	}

	public void configure(Context context) {
		// TODO Auto-generated method stub
		System.out.println("----------------");
	}

}