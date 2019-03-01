package com.richy.spring.namespacehandler.handler;


import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

import com.richy.spring.namespacehandler.parser.UserDefinitionParser;

public class UserNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("user", new UserDefinitionParser());
    }
    
}
