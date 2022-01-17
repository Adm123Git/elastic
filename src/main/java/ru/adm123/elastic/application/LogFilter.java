package ru.adm123.elastic.application;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import ch.qos.logback.classic.Level;
import lombok.Setter;

/**
 * @author Dmitry Ushakov at 17.01.2022
 */
public class LogFilter extends Filter<ILoggingEvent> {

    public static final String APPLICATION_LOG = "Application";
    @Setter
    private Level level;

    @Override
    public FilterReply decide(ILoggingEvent event) {



        return isStarted() && event.getLoggerName().equals(APPLICATION_LOG)
                ? FilterReply.ACCEPT
                : FilterReply.DENY;
    }

}
