package com.trevorjd.personalnullifier;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("PersonalNullifier.MODID")
public final class PersonalNullifier
{
    public static final String MODID = "personalnullifier";

    private static final Logger LOGGER = LogManager.getLogger();

    public PersonalNullifier() {
        LOGGER.debug("Hello from PersonalNullifier!");
    }

    @EventBusSubscriber(modid = PersonalNullifier.MODID, bus=EventBusSubscriber.Bus.MOD)
    public final class ModEventSubscriber
    {
    }

    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(
                setup(new Item(new Item.Properties()), "example_ingot")
        );
    }

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
        return setup(entry, new ResourceLocation(PersonalNullifier.MODID, name));
    }

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
        entry.setRegistryName(registryName);
        return entry;
    }

}
