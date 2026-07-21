package com.easyfarming.locations.special;

import com.easyfarming.EasyFarmingConfig;
import com.easyfarming.ItemRequirement;
import com.easyfarming.core.Location;
import com.easyfarming.core.Teleport;
import com.easyfarming.utils.Constants;
import java.util.Collections;

public final class FossilIslandHardwoodLocationData {

    private FossilIslandHardwoodLocationData() {
    }

    public static Location create(EasyFarmingConfig config) {
        Location location = new Location(null, config, "Fossil Island", false);
        location.addTeleportOption(new Teleport(
                "Digsite_pendant", Teleport.Category.ITEM,
                "Teleport to the House on the Hill with a Digsite pendant, use the mushtree to Mushroom Meadow, then travel to the three hardwood patches.",
                Constants.BASE_DIGSITE_PENDANT_ID, "", 0, 0,
                Constants.FOSSIL_ISLAND_HARDWOOD_EAST_PATCH_POINT.getRegionID(),
                Constants.FOSSIL_ISLAND_HARDWOOD_EAST_PATCH_POINT,
                Collections.singletonList(new ItemRequirement(Constants.BASE_DIGSITE_PENDANT_ID, 1))));
        location.addTeleportOption(Teleport.none("Fossil Island hardwood patches",
                Constants.FOSSIL_ISLAND_HARDWOOD_EAST_PATCH_POINT.getRegionID(),
                Constants.FOSSIL_ISLAND_HARDWOOD_EAST_PATCH_POINT));
        return location;
    }
}
