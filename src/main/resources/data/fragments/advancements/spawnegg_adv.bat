@echo off

set mobs=allay axolotl bat camel cat chicken cod cow donkey frog glow_squid horse mooshroom mule ocelot parrot pig pufferfish rabbit salmon sheep skeleton_horse sniffer snow_golem squid strider tadpole tropical_fish turtle villager wandering_trader bee cave_spider dolphin drowned enderman fox goat iron_golem llama panda piglin polar_bear spider trader_llama wolf zombified_piglin blaze creeper elder_guardian endermite evoker ghast guardian hoglin husk magma_cube phantom piglin_brute pillager ravager shulker silverfish skeleton slime stray vex vindicator warden witch wither_skeleton zoglin zombie zombie_villager
echo { > "spawn_egg.json"
echo   "display": { >> "spawn_egg.json"
echo     "icon": { >> "spawn_egg.json"
echo       "item": "minecraft:sheep_spawn_egg" >> "spawn_egg.json"
echo     }, >> "spawn_egg.json"
echo     "title": { >> "spawn_egg.json"
echo       "translate": "advancements.fragments.spawn_egg.title" >> "spawn_egg.json"
echo     }, >> "spawn_egg.json"
echo     "description": { >> "spawn_egg.json"
echo       "translate": "advancements.fragments.spawn_egg.description" >> "spawn_egg.json"
echo     }, >> "spawn_egg.json"
echo     "frame": "task", >> "spawn_egg.json"
echo     "show_toast": true, >> "spawn_egg.json"
echo     "announce_to_chat": true, >> "spawn_egg.json"
echo     "hidden": false >> "spawn_egg.json"
echo   }, >> "spawn_egg.json"
echo   "parent": "fragments:soul", >> "spawn_egg.json"
echo   "criteria": { >> "spawn_egg.json"
echo     "diamond": { >> "spawn_egg.json"
echo       "trigger": "minecraft:inventory_changed", >> "spawn_egg.json"
echo       "conditions": { >> "spawn_egg.json"
echo         "items": [ >> "spawn_egg.json"
echo           { >> "spawn_egg.json"
echo             "items": [ >> "spawn_egg.json"

for %%i in (%mobs%) do (
    echo              "minecraft:%%i_spawn_egg", >> "spawn_egg.json"
)

echo             ] >> "spawn_egg.json"
echo           } >> "spawn_egg.json"
echo         ] >> "spawn_egg.json"
echo       } >> "spawn_egg.json"
echo     } >> "spawn_egg.json"
echo   } >> "spawn_egg.json"
echo } >> "spawn_egg.json"
