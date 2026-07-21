package com.easyfarming.locations.special;

import com.easyfarming.EasyFarmingConfig;
import com.easyfarming.ItemRequirement;
import com.easyfarming.core.Location;
import com.easyfarming.core.Teleport;
import com.easyfarming.utils.Constants;
import java.util.Collections;
import net.runelite.api.gameval.ItemID;

public final class AnglersRetreatHardwoodLocationData {

    private AnglersRetreatHardwoodLocationData() {
    }

    public static Location create(EasyFarmingConfig config) {
        Location location = new Location(null, config, "Anglers' Retreat", false);
        location.addTeleportOption(new Teleport(
                "Sailors_amulet", Teleport.Category.ITEM,
                "Teleport to the Corsair Cove dock with Sailor's amulet, then take the rowboat and Sailing route to Anglers' Retreat hardwood patch.",
                ItemID.SAILORS_AMULET, "", 0, 0,
                Constants.ANGLERS_RETREAT_HARDWOOD_PATCH_POINT.getRegionID(), Constants.ANGLERS_RETREAT_HARDWOOD_PATCH_POINT,
                Collections.singletonList(new ItemRequirement(ItemID.SAILORS_AMULET, 1))));
        location.addTeleportOption(new Teleport(
                "Mythical_cape", Teleport.Category.ITEM,
                "Teleport to the Myths' Guild with a mythical cape, then travel via Corsair Cove rowboat and Sailing to Anglers' Retreat hardwood patch.",
                ItemID.MYTHICAL_CAPE, "", 0, 0,
                Constants.ANGLERS_RETREAT_HARDWOOD_PATCH_POINT.getRegionID(), Constants.ANGLERS_RETREAT_HARDWOOD_PATCH_POINT,
                Collections.singletonList(new ItemRequirement(ItemID.MYTHICAL_CAPE, 1))));
        location.addTeleportOption(Teleport.none("Anglers' Retreat hardwood patch",
                Constants.ANGLERS_RETREAT_HARDWOOD_PATCH_POINT.getRegionID(), Constants.ANGLERS_RETREAT_HARDWOOD_PATCH_POINT));
        return location;
    }
}
