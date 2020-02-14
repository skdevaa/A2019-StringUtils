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

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.automationanywhere.commandsdk.model.DataType.BOOLEAN;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.DateTimeValue;
import com.automationanywhere.botcommand.data.impl.NumberValue;
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
@CommandPkg(label = "Converts String to Number ", name = "stringtonumber",
        description = "Convert a String to a Number",
        node_label = "Converts String to Number", icon = "",
        return_type=DataType.NUMBER, return_label="Assign the output to variable", return_required=true)
public class FormatNumber {
	   
	@Execute
    public NumberValue action(@Idx(index = "1", type = TEXT)  @Pkg(label = "Number String" , default_value_type = STRING) @NotEmpty String numberstring,
                                        @Idx(index = "2", type = TEXT) @Pkg(label = "Format Locale"  , default_value_type = STRING ) @NotEmpty String formatlocale) throws Exception
     {

		NumberValue value = new NumberValue();
		Locale locale = new Locale(formatlocale);
		Number number = NumberFormat.getNumberInstance(locale).parse(numberstring.trim());
		value.set(number.doubleValue());
		return value; 
     
     }
		
	
}