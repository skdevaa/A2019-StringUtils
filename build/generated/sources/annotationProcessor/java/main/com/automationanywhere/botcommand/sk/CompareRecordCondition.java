package com.automationanywhere.botcommand.sk;

import com.automationanywhere.bot.service.GlobalSessionContext;
import com.automationanywhere.botcommand.Condition;
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.model.record.Record;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import java.lang.Boolean;
import java.lang.ClassCastException;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class CompareRecordCondition implements Condition {
  private static final Logger logger = LogManager.getLogger(CompareRecordCondition.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  public boolean test(Map<String, Value> parameters) {
    return test(null, parameters, null);
  }

  public boolean test(GlobalSessionContext globalSessionContext, Map<String, Value> parameters,
      Map<String, Object> sessionMap) {
    logger.traceEntry(() -> parameters != null ? parameters.toString() : null, ()-> sessionMap != null ?sessionMap.toString() : null);
    CompareRecord command = new CompareRecord();
    if(parameters.get("record") == null || parameters.get("record").get() == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","record"));
    }

    if(parameters.get("index") == null || parameters.get("index").get() == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","index"));
    }

    if(parameters.get("isName") == null || parameters.get("isName").get() == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","isName"));
    }
    if(parameters.get("isName") != null && parameters.get("isName").get() != null && !(parameters.get("isName").get() instanceof Boolean)) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","isName", "Boolean", parameters.get("isName").get().getClass().getSimpleName()));
    }
    if(parameters.get("isName") != null && ((Boolean)parameters.get("isName").get()) == true) {
    }

    if(parameters.get("compare") == null || parameters.get("compare").get() == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","compare"));
    }

    if(parameters.get("record") != null && parameters.get("record").get() != null && !(parameters.get("record").get() instanceof Record)) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","record", "Record", parameters.get("record").get().getClass().getSimpleName()));
    }
    if(parameters.get("index") != null && parameters.get("index").get() != null && !(parameters.get("index").get() instanceof String)) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","index", "String", parameters.get("index").get().getClass().getSimpleName()));
    }
    if(parameters.get("isName") != null && parameters.get("isName").get() != null && !(parameters.get("isName").get() instanceof Boolean)) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","isName", "Boolean", parameters.get("isName").get().getClass().getSimpleName()));
    }
    if(parameters.get("compare") != null && parameters.get("compare").get() != null && !(parameters.get("compare").get() instanceof String)) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","compare", "String", parameters.get("compare").get().getClass().getSimpleName()));
    }
    try {
      boolean result = command.test(parameters.get("record") != null ? (Record)parameters.get("record").get() : (Record)null ,parameters.get("index") != null ? (String)parameters.get("index").get() : (String)null ,parameters.get("isName") != null ? (Boolean)parameters.get("isName").get() : (Boolean)null ,parameters.get("compare") != null ? (String)parameters.get("compare").get() : (String)null );
      logger.traceExit(result);
      return result;
    }
    catch (ClassCastException e) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.IllegalParameters","test"));
    }
    catch (BotCommandException e) {
      logger.fatal(e.getMessage(),e);
      throw e;
    }
    catch (Throwable e) {
      logger.fatal(e.getMessage(),e);
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.NotBotCommandException",e.getMessage()),e);
    }
  }
}
