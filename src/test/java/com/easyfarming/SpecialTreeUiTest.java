package com.easyfarming;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.easyfarming.customrun.PatchTypes;
import com.easyfarming.customrun.RunLocation;
import com.easyfarming.ui.CustomRunFilterBar;
import com.easyfarming.ui.CustomRunLocationSubPanel;
import com.easyfarming.ui.components.WrapLayout;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import javax.swing.JPanel;
import net.runelite.api.gameval.ItemID;
import org.junit.Test;

public class SpecialTreeUiTest {

    @Test
    public void farmingGuildPatchIconsUseAWrappingLayout() throws Exception {
        CustomRunLocationSubPanel panel = new CustomRunLocationSubPanel(
                new TestPlugin(), null, "Farming Guild",
                new RunLocation("Farming Guild", "Spirit_Tree", Collections.emptyList()), null);
        Field field = CustomRunLocationSubPanel.class.getDeclaredField("patchIconsPanel");
        field.setAccessible(true);
        JPanel icons = (JPanel) field.get(panel);

        assertEquals(7, icons.getComponentCount());
        assertTrue(icons.getLayout() instanceof WrapLayout);
    }

    @Test
    public void crystalTreeUsesTheShardPileIconInBothSelectors() throws Exception {
        assertEquals(ItemID.PRIF_CRYSTAL_SHARD_25,
                patchIcon(CustomRunFilterBar.class, PatchTypes.CRYSTAL_TREE));
        assertEquals(ItemID.PRIF_CRYSTAL_SHARD_25,
                patchIcon(CustomRunLocationSubPanel.class, PatchTypes.CRYSTAL_TREE));
    }

    private static int patchIcon(Class<?> owner, String patchType) throws Exception {
        Method method = owner.getDeclaredMethod("itemIdForPatchType", String.class);
        method.setAccessible(true);
        return (int) method.invoke(null, patchType);
    }

    private static class TestPlugin extends EasyFarmingPlugin {
        private final EasyFarmingConfig config = new EasyFarmingConfig() { };

        @Override
        public EasyFarmingConfig getConfig() {
            return config;
        }
    }
}
