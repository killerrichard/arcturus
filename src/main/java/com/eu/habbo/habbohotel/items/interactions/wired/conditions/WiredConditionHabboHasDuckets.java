package com.eu.habbo.habbohotel.items.interactions.wired.conditions;

import com.eu.habbo.habbohotel.items.Item;
import com.eu.habbo.habbohotel.rooms.Room;
import com.eu.habbo.habbohotel.rooms.RoomUnit;
import com.eu.habbo.habbohotel.users.Habbo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WiredConditionHabboHasDuckets extends WiredConditionHabboWearsBadge
{
    public WiredConditionHabboHasDuckets(ResultSet set, Item baseItem) throws SQLException
    {
        super(set, baseItem);
    }

    public WiredConditionHabboHasDuckets(int id, int userId, Item item, String extradata, int limitedStack, int limitedSells)
    {
        super(id, userId, item, extradata, limitedStack, limitedSells);
    }

    @Override
    public boolean execute(RoomUnit roomUnit, Room room, Object[] stuff)
    {
        try
        {
            Habbo habbo = room.getHabbo(roomUnit);

            if (habbo != null)
            {
                return habbo.getHabboInfo().getPixels() >= Integer.valueOf(this.badge);
            }
        } catch (Exception e)
        {

        } finally
        {
            return false;
        }
    }
}