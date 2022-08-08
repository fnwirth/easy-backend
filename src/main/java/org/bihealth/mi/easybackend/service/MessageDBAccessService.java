/* 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.bihealth.mi.easybackend.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.bihealth.mi.easybackend.jooq.generated.tables.daos.MessageDao;
import org.bihealth.mi.easybackend.jooq.generated.tables.pojos.Message;
import static org.bihealth.mi.easybackend.jooq.generated.Tables.MESSAGE;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.TransactionalRunnable;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service to access the message database
 * 
 * @author Felix Wirth
 *
 */
@Service
public class MessageDBAccessService {
    
    /** Logger */
    private static Logger LOGGER = LoggerFactory.getLogger(MessageDBAccessService.class);
    
    /** References a jOOQ configuration */
    @Autowired
    private DSLContext dslCtx;
    
    /** The data access object */
    private MessageDao messageDao;
    
    /**
     * Represents an erroneous insertion of a record into the database.
     */
    public static final String INSERTION_ERROR = "error";

    /**
     * Represents a successful insertion of a record into the database.
     */
    public static final String INSERTION_SUCCESS = "success";
    
    /**
     * Method to retrieve the domain data access object
     * 
     * @return the domain DAO
     */
    private MessageDao getMessageDao() {
        // Create if necessary
        if (this.messageDao == null) {
            this.messageDao = new MessageDao(this.dslCtx.configuration());
        }
        
        // Return
        return this.messageDao;
    }

    /**
     * Retrieves a message
     * 
     * @param messageId
     * @return the retrieved message as a jOOQ object, or {@code null} if nothing was found
     */
    public Message getMessageById(int messageId){
        return this.getMessageDao().fetchOneById(messageId);
    }
    
    
    /**
     * Method to insert a message into the database.
     *
     * @param message the message object that should be inserted
     * @return {@code INSERTION_SUCCESS} when the insertion was successful, {@code INSERTION_DUPLICATE}
     *      when the record was already in the database, {@code INSERTION_ERROR} otherwise
     */
    public boolean insertMessage(Message message) {
        
        // Execute query
        try {
            dslCtx.transaction(new TransactionalRunnable() {

                @Override
                public void run(Configuration configuration) throws Throwable {
                    // Insert into table
                    int insertedRecords = DSL.using(configuration)
                            .insertInto(MESSAGE, MESSAGE.RECEIVER, MESSAGE.SCOPE, MESSAGE.CONTENT)
                            .values(message.getReceiver(),message.getScope(), message.getContent()).execute();
                    
                    // Determine insertion success
                    if (insertedRecords != 1) {
                        // An unexpected number of records was affected. Log it and abort by throwing an exception (which will rollback everything from the transaction).
                        LOGGER.error("Couldn't insert the record into the database.");
                        throw new IOException();
                    }

                    // Implicit transaction commit here
                }
            });

            // Log success and return
            LOGGER.debug("Successfully inserted the pseudonym into the database");
            return true;
        } catch (Exception e) {
            // Log error and return
            LOGGER.error("Couldn't insert the record into the database: " + e.getMessage() + "\n");
            return false;
        }
    }
    
    /**
     * Retrieves all messages for a user and scope
     *
     * @param domainName the name of the domain to search in
     * @param identifier the identifier to search for
     * @param idType     the type of the identifier
     * @return the data element referring to the given identifier, or {@code null} when nothing is found or an error occurs
     */
    public List<Message> getRecordFromIdentifier(String receiver, String scope) {
        // Prepare
        List<Message> messages = new ArrayList<>();
        
        // Execute query
        try {
            dslCtx.transaction(new TransactionalRunnable() {

                @Override
                public void run(Configuration configuration) throws Throwable {

                    // Build and execute the query
                    messages.addAll(DSL.using(configuration)
                                       .selectFrom(MESSAGE)
                                       .where(MESSAGE.RECEIVER.equal(receiver))
                                       .and(MESSAGE.SCOPE.equal(scope))
                                       .fetchInto(Message.class));
                    // Return
                    return;
                }
            });

            // Return
            return messages.size() > 0 ? messages : null;
        } catch (Exception e) {
            // Handle error
            LOGGER.error("Couldn't query the database: " + e.getMessage() + "\n");
            return null;
        }
    }
    
    /**
     * Delete message
     *
     * @param messageId
     * @return deletion successful
     */
    public boolean deleteMessage(int messageId) {
        
        // Execute query
        try {
            dslCtx.transaction(new TransactionalRunnable() {

                @Override
                public void run(Configuration configuration) throws Throwable {

                    // Delete message
                    int deletedDomains = DSL.using(configuration).deleteFrom(MESSAGE)
                            .where(MESSAGE.ID.equal(messageId))
                            .execute();
                    
                    // Determine deletion success
                    if (deletedDomains != 1) {
                        // An unexpected number of records was affected. Log it and abort by throwing  an exception (which will rollback everything from the transaction).
                        LOGGER.error("Couldn't delete the message \"" + messageId + "\" from the database.");
                        throw new IOException();
                    }
                }
            });

            // Return
            return true;
        } catch (Exception e) {
            // Handle error
            LOGGER.error("Couldn't query the database: " + e.getMessage() + "\n");
            return false;
        }
    }
}