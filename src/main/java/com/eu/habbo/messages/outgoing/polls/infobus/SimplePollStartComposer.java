package com.eu.habbo.messages.outgoing.polls.infobus;

import com.eu.habbo.messages.ServerMessage;
import com.eu.habbo.messages.outgoing.MessageComposer;
import com.eu.habbo.messages.outgoing.Outgoing;

public class SimplePollStartComposer extends MessageComposer
{
    public final int duration;
    public final String question;

    public SimplePollStartComposer(int duration, String question)
    {
        this.duration = duration;
        this.question = question;
    }
    //:test 3047 s:a i:10 i:20 i:10000 i:1 i:1 i:3 s:abcdefghijklmnopqrstuvwxyz12345678901234? i:1 s:a s:b

    @Override
    public ServerMessage compose()
    {
        this.response.init(Outgoing.SimplePollStartComposer);
        this.response.appendString(this.question);
        this.response.appendInt32(0);
        this.response.appendInt32(0);
        this.response.appendInt32(this.duration); //duration
        this.response.appendInt32(-1); //Id
        this.response.appendInt32(0); //Number
        this.response.appendInt32(3); //Type
        this.response.appendString(this.question);
        return this.response;
    }
}
