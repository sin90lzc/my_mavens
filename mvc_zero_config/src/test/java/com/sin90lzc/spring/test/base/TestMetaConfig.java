/**
 *
 * 
 * @author Tim Leung
 */
package com.sin90lzc.spring.test.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sin90lzc.spring.GlobalConfig;

/**
 * copyright 
 * 
 * all right reserved.
 * 
 * 
 * @author Tim Leung
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(classes={GlobalConfig.class})
@ActiveProfiles("test")
@WebAppConfiguration
public @interface TestMetaConfig {

}
