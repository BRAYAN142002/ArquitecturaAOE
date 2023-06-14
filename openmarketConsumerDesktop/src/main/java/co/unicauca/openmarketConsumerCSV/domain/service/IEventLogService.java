package co.unicauca.openmarketConsumerCSV.domain.service;

public interface IEventLogService {
    String[]  parseMessage(String message);
    void appendRow(String[] processedMessage);
}
