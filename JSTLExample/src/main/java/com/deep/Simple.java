package com.deep;

import java.util.ListResourceBundle;

public class Simple extends ListResourceBundle{

	public Object[][] getContents(){
		return contents;
	}
	
//	Using for <fmt:bundle/> Tag
	static final Object[][] contents =  { { "colour.Violet", "Violet" },  
            { "colour.Indigo", "Indigo" }, { "colour.Blue", "Blue" }, };  
}
