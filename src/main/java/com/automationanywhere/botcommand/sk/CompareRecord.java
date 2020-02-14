/*
 * Copyright (c) 2019 Automation Anywhere.
 * All rights reserved.
 *
 * This software is the proprietary information of Automation Anywhere.
 * You shall use it only in accordance with the terms of the license agreement
 * you entered into with Automation Anywhere.
 */
/**
 * 
 */
package com.automationanywhere.botcommand.sk;



import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.AttributeType.VARIABLE;
import static com.automationanywhere.commandsdk.model.AttributeType.CHECKBOX;

import static com.automationanywhere.commandsdk.model.DataType.RECORD;
import static com.automationanywhere.commandsdk.model.DataType.STRING;

import java.util.List;
import static com.automationanywhere.commandsdk.model.DataType.BOOLEAN;

import com.automationanywhere.botcommand.data.model.Schema;
import com.automationanywhere.botcommand.data.model.record.Record;

import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;

import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;

import com.automationanywhere.commandsdk.model.DataType;
import com.automationanywhere.commandsdk.annotations.ConditionTest;
import com.automationanywhere.commandsdk.annotations.BotCommand.CommandType;

/**
 * @author Stefan Karsten
 *
 */

@BotCommand(commandType = CommandType.Condition)
@CommandPkg(label = "Record Compare by Index ", name = "recordcompare",
        description = "Compare record value at a certain index",
        node_label = "Compare record {{record}} at index {{index}} with {{compare}} ", icon = "")
public class CompareRecord  {
	
	   
    @ConditionTest
    public boolean test(@Idx(index = "1", type = VARIABLE)  @Pkg(label = "Record" , default_value_type = RECORD) @NotEmpty Record record,
                        @Idx(index = "2", type = TEXT) @Pkg(label = "Index"  , default_value_type = DataType.STRING ) @NotEmpty String index,
                        @Idx(index = "3", type = CHECKBOX) @Pkg(label = "is Name" , default_value_type = BOOLEAN) @NotEmpty Boolean isName,
                        @Idx(index = "4", type = TEXT) @Pkg(label = "Compare" , default_value_type = STRING) @NotEmpty String compare)
     {
    	   int foundindex = -1 ;
    	   


    	   if (isName)
    	   {
    		   List<Schema> schema = record.getSchema();
    		   for (int i = 0; i < schema.size(); i++) {

    			   if (schema.get(i).getName().equals((index)))
    			   {
    				   foundindex = i;
    				   break;
    			   }
    		   }
			}
    	   else
    	   {
    		   foundindex = Integer.parseInt(index); 
				
    	   }
           return ((foundindex==-1) ? false : record.getValues().get(foundindex).get().equals(compare));
    }   
}
	
