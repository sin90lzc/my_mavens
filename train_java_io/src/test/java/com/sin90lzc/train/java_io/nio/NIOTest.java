package com.sin90lzc.train.java_io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import junit.framework.Assert;
import junit.framework.TestCase;

public class NIOTest extends TestCase {
	private static final String WRITEDATA="abc";
	private static final File ioDir;
	private static final String FILENAME="dest.txt";
	static{
		ioDir=new File("target/io");
		if(!ioDir.exists()){
			ioDir.mkdirs();
		}
	}
	public void testWrite() throws Exception {
		FileChannel ch = new FileOutputStream(new File(ioDir,FILENAME)).getChannel();
		ByteBuffer bb=ByteBuffer.wrap(WRITEDATA.getBytes("UTF-8"));
		ch.write(bb);
		System.out.println(bb.position());
		ch.close();
	}
	public void testRead() throws Exception{
		FileChannel ch=new FileInputStream(new File(ioDir,FILENAME)).getChannel();
		ByteBuffer bb=ByteBuffer.allocate(10);
		ch.position(1);
		ch.read(bb);
		bb.flip();
		System.out.println(bb.position());
		Assert.assertEquals("bc", Charset.forName("UTF-8").decode(bb).toString());
		System.out.println(bb.position());
	}
}
