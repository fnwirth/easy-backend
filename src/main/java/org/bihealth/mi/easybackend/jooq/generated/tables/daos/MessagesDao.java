/*
 * This file is generated by jOOQ.
 */
package org.bihealth.mi.easybackend.jooq.generated.tables.daos;


import java.util.List;

import javax.annotation.processing.Generated;

import org.bihealth.mi.easybackend.jooq.generated.tables.Messages;
import org.bihealth.mi.easybackend.jooq.generated.tables.records.MessagesRecord;
import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.15.10"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MessagesDao extends DAOImpl<MessagesRecord, org.bihealth.mi.easybackend.jooq.generated.tables.pojos.Messages, Integer> {

    /**
     * Create a new MessagesDao without any configuration
     */
    public MessagesDao() {
        super(Messages.MESSAGES, org.bihealth.mi.easybackend.jooq.generated.tables.pojos.Messages.class);
    }

    /**
     * Create a new MessagesDao with an attached configuration
     */
    public MessagesDao(Configuration configuration) {
        super(Messages.MESSAGES, org.bihealth.mi.easybackend.jooq.generated.tables.pojos.Messages.class, configuration);
    }

    @Override
    public Integer getId(org.bihealth.mi.easybackend.jooq.generated.tables.pojos.Messages object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.bihealth.mi.easybackend.jooq.generated.tables.pojos.Messages> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Messages.MESSAGES.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<org.bihealth.mi.easybackend.jooq.generated.tables.pojos.Messages> fetchById(Integer... values) {
        return fetch(Messages.MESSAGES.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public org.bihealth.mi.easybackend.jooq.generated.tables.pojos.Messages fetchOneById(Integer value) {
        return fetchOne(Messages.MESSAGES.ID, value);
    }

    /**
     * Fetch records that have <code>receiver BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.bihealth.mi.easybackend.jooq.generated.tables.pojos.Messages> fetchRangeOfReceiver(String lowerInclusive, String upperInclusive) {
        return fetchRange(Messages.MESSAGES.RECEIVER, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>receiver IN (values)</code>
     */
    public List<org.bihealth.mi.easybackend.jooq.generated.tables.pojos.Messages> fetchByReceiver(String... values) {
        return fetch(Messages.MESSAGES.RECEIVER, values);
    }

    /**
     * Fetch records that have <code>scope BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.bihealth.mi.easybackend.jooq.generated.tables.pojos.Messages> fetchRangeOfScope(String lowerInclusive, String upperInclusive) {
        return fetchRange(Messages.MESSAGES.SCOPE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>scope IN (values)</code>
     */
    public List<org.bihealth.mi.easybackend.jooq.generated.tables.pojos.Messages> fetchByScope(String... values) {
        return fetch(Messages.MESSAGES.SCOPE, values);
    }

    /**
     * Fetch records that have <code>content BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<org.bihealth.mi.easybackend.jooq.generated.tables.pojos.Messages> fetchRangeOfContent(String lowerInclusive, String upperInclusive) {
        return fetchRange(Messages.MESSAGES.CONTENT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>content IN (values)</code>
     */
    public List<org.bihealth.mi.easybackend.jooq.generated.tables.pojos.Messages> fetchByContent(String... values) {
        return fetch(Messages.MESSAGES.CONTENT, values);
    }
}
