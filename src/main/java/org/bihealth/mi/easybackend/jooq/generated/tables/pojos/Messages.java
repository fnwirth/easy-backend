/*
 * This file is generated by jOOQ.
 */
package org.bihealth.mi.easybackend.jooq.generated.tables.pojos;


import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.bihealth.mi.easybackend.jooq.generated.tables.interfaces.IMessages;


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
@Entity
@Table(
    name = "messages",
    schema = "public",
    indexes = {
        @Index(name = "userscopeidx", columnList = "receiver ASC, scope ASC")
    }
)
public class Messages implements IMessages {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String  receiver;
    private String  scope;
    private String  content;

    public Messages() {}

    public Messages(IMessages value) {
        this.id = value.getId();
        this.receiver = value.getReceiver();
        this.scope = value.getScope();
        this.content = value.getContent();
    }

    public Messages(
        Integer id,
        String  receiver,
        String  scope,
        String  content
    ) {
        this.id = id;
        this.receiver = receiver;
        this.scope = scope;
        this.content = content;
    }

    /**
     * Getter for <code>public.messages.id</code>.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, precision = 32)
    @Override
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.messages.id</code>.
     */
    @Override
    public Messages setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.messages.receiver</code>.
     */
    @Column(name = "receiver", nullable = false)
    @Override
    public String getReceiver() {
        return this.receiver;
    }

    /**
     * Setter for <code>public.messages.receiver</code>.
     */
    @Override
    public Messages setReceiver(String receiver) {
        this.receiver = receiver;
        return this;
    }

    /**
     * Getter for <code>public.messages.scope</code>.
     */
    @Column(name = "scope", nullable = false)
    @Override
    public String getScope() {
        return this.scope;
    }

    /**
     * Setter for <code>public.messages.scope</code>.
     */
    @Override
    public Messages setScope(String scope) {
        this.scope = scope;
        return this;
    }

    /**
     * Getter for <code>public.messages.content</code>.
     */
    @Column(name = "content", nullable = false)
    @Override
    public String getContent() {
        return this.content;
    }

    /**
     * Setter for <code>public.messages.content</code>.
     */
    @Override
    public Messages setContent(String content) {
        this.content = content;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Messages other = (Messages) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.receiver == null) {
            if (other.receiver != null)
                return false;
        }
        else if (!this.receiver.equals(other.receiver))
            return false;
        if (this.scope == null) {
            if (other.scope != null)
                return false;
        }
        else if (!this.scope.equals(other.scope))
            return false;
        if (this.content == null) {
            if (other.content != null)
                return false;
        }
        else if (!this.content.equals(other.content))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.receiver == null) ? 0 : this.receiver.hashCode());
        result = prime * result + ((this.scope == null) ? 0 : this.scope.hashCode());
        result = prime * result + ((this.content == null) ? 0 : this.content.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Messages (");

        sb.append(id);
        sb.append(", ").append(receiver);
        sb.append(", ").append(scope);
        sb.append(", ").append(content);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IMessages from) {
        setId(from.getId());
        setReceiver(from.getReceiver());
        setScope(from.getScope());
        setContent(from.getContent());
    }

    @Override
    public <E extends IMessages> E into(E into) {
        into.from(this);
        return into;
    }
}
