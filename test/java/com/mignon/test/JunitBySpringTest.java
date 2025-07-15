package com.mignon.test;


import com.mignon.spring.config.SpringConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {
         SpringConfiguration.class
        }
)
public class JunitBySpringTest {
        
}
