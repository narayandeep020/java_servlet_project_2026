package com.deep;

import java.util.ListResourceBundle;

public class Message extends ListResourceBundle{

	public Object[][] getContents() {  
        return contents;  
    }  
//	Using for <fmt:setBundle/> Tag and <fmt:message/> tag
	
static final Object[][] contents = { { "vegetable.Potato", "Potato" },  
            { "vegetable.Tomato", "Tomato" }, { "vegetable.Carrot", "Carrot" }, };
}
