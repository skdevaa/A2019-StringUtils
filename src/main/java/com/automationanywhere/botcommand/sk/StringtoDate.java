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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import static com.automationanywhere.commandsdk.model.DataType.BOOLEAN;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.DateTimeValue;
import com.automationanywhere.botcommand.data.model.Schema;
import com.automationanywhere.botcommand.data.model.record.Record;

import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;

import com.automationanywhere.commandsdk.annotations.Idx;
import com.automationanywhere.commandsdk.annotations.Pkg;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;

import com.automationanywhere.commandsdk.model.DataType;
import com.automationanywhere.commandsdk.annotations.ConditionTest;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.annotations.BotCommand.CommandType;

/**
 * @author Stefan Karsten
 *
 */

@BotCommand
@CommandPkg(label = "Converts String to Date ", name = "stringtodate",
        description = "Convert a String to a Date",
        node_label = "Converts String to Date", icon = "",
        return_type=DataType.DATETIME, return_label="Assign the output to variable", return_required=true)
public class StringtoDate {
	   
	@Execute
    public DateTimeValue  action(@Idx(index = "1", type = TEXT)  @Pkg(label = "Date String" , default_value_type = STRING) @NotEmpty String datestring,
                                        @Idx(index = "2", type = TEXT) @Pkg(label = "Format"  , default_value_type = STRING ) @NotEmpty String format) throws Exception
     {

		DateTimeValue datevalue = new DateTimeValue();
		
		SimpleDateFormat dt = new SimpleDateFormat(format); 
		Date date = dt.parse(datestring); 
		ZoneId systemDefault = ZoneId.systemDefault();
		ZonedDateTime datetimevalue = ZonedDateTime.ofInstant(date.toInstant(), systemDefault);
		datevalue.set(datetimevalue);
		return datevalue; 
     
     }
		
	
}