/*
 * This file is generated by jOOQ.
 */
package org.bihealth.mi.easybackend.jooq.generated;


import javax.annotation.processing.Generated;

import org.jooq.Sequence;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * Convenience access to all sequences in public.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.15.10"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>public.message_id_seq</code>
     */
    public static final Sequence<Integer> MESSAGE_ID_SEQ = Internal.createSequence("message_id_seq", Public.PUBLIC, SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);
}
