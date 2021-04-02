/*****************************************************************c******************o*******v******id********
 * File: TestSuiteBase.java
 * Course materials (20F) CST 8277
 * (Original Author) Mike Norman
 * 
 * (Modified) @author Sangeun Baek 040953608
 */
package com.algonquincollege.cst8277;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;

public class TestSuiteBase {
    public static final String ECLIPSELINK_LOGGING_SQL = "eclipselink.logging.sql";
    public static final String PERSISTENCE_UNIT = "assignment3-orderSystem-PU";
    
    public static EntityManagerFactory buildEMF() {
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    }
    
    public static ListAppender<ILoggingEvent> attachListAppender(ch.qos.logback.classic.Logger theLogger, String listAppenderName) {
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        listAppender.setName(listAppenderName);
        listAppender.start();
        theLogger.addAppender(listAppender);
        listAppender.setContext(theLogger.getLoggerContext());
        return listAppender;
    }
    
   
    public static void detachListAppender(ch.qos.logback.classic.Logger theLogger, ListAppender<ILoggingEvent> listAppender) {
        theLogger.detachAppender(listAppender);
    }

}