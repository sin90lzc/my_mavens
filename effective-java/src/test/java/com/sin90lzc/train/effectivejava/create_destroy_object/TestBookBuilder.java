package com.sin90lzc.train.effectivejava.create_destroy_object;

import junit.framework.TestCase;

/**
 * ²âÊÔ¹¹½¨Æ÷
 * @author Tim
 *
 */
public class TestBookBuilder extends TestCase {
	
	private static final String BOOKNAME="Effecitive Java";
	private static final int BOOKPAGES=301;
	private static final int BOOKVERSION=2;
	private static final String BOOKLANGUAGE="Chinese";
	
	public void testbuilder() {
		Book book = Book.getBuilder(BOOKNAME, BOOKPAGES).version(BOOKVERSION)
				.language(BOOKLANGUAGE).build();
		assertEquals(book.getName(), BOOKNAME);
		assertEquals(book.getPages(), BOOKPAGES);
		assertEquals(book.getVersion(), BOOKVERSION);
		assertEquals(book.getLanguage(), BOOKLANGUAGE);
	}
}
