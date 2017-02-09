package org.mariotaku.twidere.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.hannesdorfmann.parcelableplease.annotation.ParcelableNoThanks;

import org.mariotaku.commons.objectcursor.LoganSquareCursorFieldConverter;
import org.mariotaku.library.objectcursor.annotation.CursorField;
import org.mariotaku.library.objectcursor.annotation.CursorObject;
import org.mariotaku.twidere.model.message.MessageExtras;
import org.mariotaku.twidere.model.util.MessageExtrasConverter;
import org.mariotaku.twidere.model.util.UserKeyCursorFieldConverter;
import org.mariotaku.twidere.provider.TwidereDataStore;
import org.mariotaku.twidere.provider.TwidereDataStore.Messages.Conversations;

import java.util.Arrays;

/**
 * Created by mariotaku on 16/6/6.
 */
@JsonObject
@CursorObject(tableInfo = true, valuesCreator = true)
public class ParcelableMessageConversation {
    @CursorField(value = Conversations._ID, type = TwidereDataStore.TYPE_PRIMARY_KEY, excludeWrite = true)
    public long _id;

    @JsonField(name = "account_key")
    @CursorField(value = Conversations.ACCOUNT_KEY, converter = UserKeyCursorFieldConverter.class)
    public UserKey account_key;

    @JsonField(name = "conversation_id")
    @CursorField(Conversations.CONVERSATION_ID)
    public String id;

    @JsonField(name = "type")
    @CursorField(Conversations.MESSAGE_TYPE)
    public String message_type;

    @JsonField(name = "timestamp")
    @CursorField(value = Conversations.MESSAGE_TIMESTAMP)
    public long message_timestamp;

    @JsonField(name = "local_timestamp")
    @CursorField(value = Conversations.LOCAL_TIMESTAMP)
    public long local_timestamp;

    @JsonField(name = "text_unescaped")
    @CursorField(Conversations.TEXT_UNESCAPED)
    public String text_unescaped;

    @JsonField(name = "media")
    @CursorField(value = Conversations.MEDIA, converter = LoganSquareCursorFieldConverter.class)
    public ParcelableMedia[] media;

    @JsonField(name = "spans")
    @CursorField(value = Conversations.SPANS, converter = LoganSquareCursorFieldConverter.class)
    public SpanItem[] spans;

    @JsonField(name = "extras")
    @CursorField(value = Conversations.EXTRAS, converter = MessageExtrasConverter.class)
    public MessageExtras extras;

    @JsonField(name = "extras")
    @ParcelableNoThanks
    ParcelableMessage.InternalExtras internalExtras;

    @JsonField(name = "participants")
    @CursorField(value = Conversations.PARTICIPANTS, converter = LoganSquareCursorFieldConverter.class)
    public ParcelableUser[] participants;

    @JsonField(name = "sender_key")
    @CursorField(value = Conversations.SENDER_KEY, converter = UserKeyCursorFieldConverter.class)
    public UserKey sender_key;

    @JsonField(name = "recipient_key")
    @CursorField(value = Conversations.RECIPIENT_KEY, converter = UserKeyCursorFieldConverter.class)
    public UserKey recipient_key;

    @JsonField(name = "is_outgoing")
    @CursorField(Conversations.IS_OUTGOING)
    public boolean is_outgoing;

    @JsonField(name = "request_cursor")
    @CursorField(value = Conversations.REQUEST_CURSOR)
    public String request_cursor;

    @Override
    public String toString() {
        return "ParcelableMessageConversation{" +
                "_id=" + _id +
                ", account_key=" + account_key +
                ", id='" + id + '\'' +
                ", message_type='" + message_type + '\'' +
                ", message_timestamp=" + message_timestamp +
                ", text_unescaped='" + text_unescaped + '\'' +
                ", media=" + Arrays.toString(media) +
                ", spans=" + Arrays.toString(spans) +
                ", participants=" + Arrays.toString(participants) +
                ", sender_key=" + sender_key +
                ", recipient_key=" + recipient_key +
                ", request_cursor='" + request_cursor + '\'' +
                '}';
    }
}
